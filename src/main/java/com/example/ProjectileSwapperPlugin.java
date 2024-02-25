package com.example;

import com.google.inject.Provides;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.Projectile;
import net.runelite.api.events.ProjectileMoved;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.events.ConfigChanged;

import java.util.Set;
import java.util.Arrays;
import java.util.stream.Collectors;
import org.apache.commons.lang3.math.NumberUtils;
import java.util.HashMap;
import java.util.HashSet;

@Slf4j
@PluginDescriptor(
		name = "ProjectileSwapper"
)
public class ProjectileSwapperPlugin extends Plugin
{

	@Inject
	private Client client;

	@Inject
	private ProjectileSwapperConfig config;

	private Set<Integer> taggedProjectiles = new HashSet<>();
	private HashMap<Integer,Integer> projectileSwapMap = new HashMap<>();

	@Subscribe
	protected void onConfigChanged(ConfigChanged configChangedEvent) {
		this.reload();
	}

	private void reload() {
		/* Re-initialize variables */
		this.taggedProjectiles = new HashSet<>(); /* Set of all tagged ProjectileIDs */
		this.projectileSwapMap = new HashMap<>(); /* Map containing tagged ProjectileIDs : target ProjectileID */

		/* Populate the Set and Map, for toggled sections only */
		if (config.Section1_Toggle()) {
			addProjectiles(this.config.Section1_TaggedProjectiles(), this.config.Section1_TargetProjectile()); }
		if (config.Section2_Toggle()) {
 			addProjectiles(this.config.Section2_TaggedProjectiles(),this.config.Section2_TargetProjectile()); }
		if (config.Section3_Toggle()) {
			addProjectiles(this.config.Section3_TaggedProjectiles(),this.config.Section3_TargetProjectile()); }
		if (config.Section4_Toggle()) {
			addProjectiles(this.config.Section4_TaggedProjectiles(),this.config.Section4_TargetProjectile()); }
		if (config.Section5_Toggle()) {
			addProjectiles(this.config.Section5_TaggedProjectiles(),this.config.Section5_TargetProjectile()); }
	}

	private void addProjectiles(String source, Integer targetProjectileID) {
		Set<Integer> taggedProjectileIDs = getNumbersFromConfig(source);
		for (Integer taggedProjectileID : taggedProjectileIDs) {
			this.taggedProjectiles.add(taggedProjectileID);
			this.projectileSwapMap.put(taggedProjectileID,targetProjectileID);
		}
	}

	private static Set<Integer> getNumbersFromConfig(String source) {
		return Arrays.stream(source.split(","))
				.map(String::trim)
				.filter(NumberUtils::isParsable)
				.map(Integer::parseInt)
				.collect(Collectors.toSet());
	}

	@Subscribe
	public void onProjectileMoved(ProjectileMoved projectileMoved) 	{
		Projectile projectile = projectileMoved.getProjectile();
		Integer projectileID = projectile.getId();

		if (this.taggedProjectiles.contains(projectileID)) {
			replaceProjectile(projectile, this.projectileSwapMap.get(projectileID));
		}
	}

	private void replaceProjectile(Projectile projectile, int projectileId)	{
		try {
			Projectile p = client.createProjectile(projectileId,
					projectile.getFloor(),
					projectile.getX1(), projectile.getY1(),
					projectile.getHeight(),
					projectile.getStartCycle(), projectile.getEndCycle(),
					projectile.getSlope(),
					projectile.getStartHeight(), projectile.getEndHeight(),
					projectile.getInteracting(),
					projectile.getTarget().getX(), projectile.getTarget().getY());

			client.getProjectiles().addLast(p);
			projectile.setEndCycle(0);
		}
		catch(Exception e) {
			/* do nothing if a new projectileID cannot be created (original projectile will persist) */
		}
	}

	@Provides
	ProjectileSwapperConfig provideConfig(ConfigManager configManager) 	{
		return configManager.getConfig(ProjectileSwapperConfig.class);
	}

}