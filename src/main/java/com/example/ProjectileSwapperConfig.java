package com.example;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ConfigSection;

@ConfigGroup("ProjectileSwapper")
public interface ProjectileSwapperConfig extends Config
{

	@ConfigSection(
			name = "Projectile Set 1",
			description = "Specification of projectiles to swap (Set 1)",
			position = 0
	)
	String configSection1 = "ConfigSection1";

	@ConfigItem(
			keyName = "Section1_Toggle",
			name = "Enable",
			description = "Toggles projectile swapping for this section",
			position = 0,
			section = configSection1
	)
	default boolean Section1_Toggle() { return false; }

	@ConfigItem(
			keyName = "Section1_TaggedProjectiles",
			name = "Projectiles To Swap:",
			description = "A list of ProjectileIDs to be swapped. Separate ids with commas (,)",
			position = 1,
			section = configSection1
	)
	default String Section1_TaggedProjectiles(){
		return "";
	}

	@ConfigItem(
			keyName = "Section1_TargetProjectile",
			name = "Swap To:",
			description = "The target ProjectileID to be swapped to",
			position = 2,
			section = configSection1
	)
	default int Section1_TargetProjectile()	{
		return 0;
	}



	@ConfigSection(
			name = "Projectile Set 2",
			description = "Specification of projectiles to swap (Set 2)",
			position = 0,
			closedByDefault = true
	)
	String configSection2 = "ConfigSection2";

	@ConfigItem(
			keyName = "Section2_Toggle",
			name = "Enable",
			description = "Toggles projectile swapping for this section",
			position = 0,
			section = configSection2
	)
	default boolean Section2_Toggle() { return false; }

	@ConfigItem(
			keyName = "Section2_TaggedProjectiles",
			name = "Projectiles To Swap:",
			description = "A list of ProjectileIDs to be swapped. Separate ids with commas (,)",
			position = 1,
			section = configSection2
	)
	default String Section2_TaggedProjectiles(){
		return "";
	}

	@ConfigItem(
			keyName = "Section2_TargetProjectile",
			name = "Swap To:",
			description = "The target ProjectileID to be swapped to",
			position = 2,
			section = configSection2
	)
	default int Section2_TargetProjectile()	{
		return 0;
	}



	@ConfigSection(
			name = "Projectile Set 3",
			description = "Specification of projectiles to swap (Set 3)",
			position = 0,
			closedByDefault = true
	)
	String configSection3 = "ConfigSection3";

	@ConfigItem(
			keyName = "Section3_Toggle",
			name = "Enable",
			description = "Toggles projectile swapping for this section",
			position = 0,
			section = configSection3
	)
	default boolean Section3_Toggle() { return false; }

	@ConfigItem(
			keyName = "Section3_TaggedProjectiles",
			name = "Projectiles To Swap:",
			description = "A list of ProjectileIDs to be swapped. Separate ids with commas (,)",
			position = 1,
			section = configSection3
	)
	default String Section3_TaggedProjectiles(){
		return "";
	}

	@ConfigItem(
			keyName = "Section3_TargetProjectile",
			name = "Swap To:",
			description = "The target ProjectileID to be swapped to",
			position = 2,
			section = configSection3
	)
	default int Section3_TargetProjectile()	{
		return 0;
	}



	@ConfigSection(
			name = "Projectile Set 4",
			description = "Specification of projectiles to swap (Set 4)",
			position = 0,
			closedByDefault = true
	)
	String configSection4 = "ConfigSection4";

	@ConfigItem(
			keyName = "Section4_Toggle",
			name = "Enable",
			description = "Toggles projectile swapping for this section",
			position = 0,
			section = configSection4
	)
	default boolean Section4_Toggle() { return false; }

	@ConfigItem(
			keyName = "Section3_TaggedProjectiles",
			name = "Projectiles To Swap:",
			description = "A list of ProjectileIDs to be swapped. Separate ids with commas (,)",
			position = 1,
			section = configSection4
	)
	default String Section4_TaggedProjectiles(){
		return "";
	}

	@ConfigItem(
			keyName = "Section4_TargetProjectile",
			name = "Swap To:",
			description = "The target ProjectileID to be swapped to",
			position = 2,
			section = configSection4
	)
	default int Section4_TargetProjectile()	{
		return 0;
	}



	@ConfigSection(
			name = "Projectile Set 5",
			description = "Specification of projectiles to swap (Set 5)",
			position = 0,
			closedByDefault = true
	)
	String configSection5 = "ConfigSection5";

	@ConfigItem(
			keyName = "Section5_Toggle",
			name = "Enable",
			description = "Toggles projectile swapping for this section",
			position = 0,
			section = configSection5
	)
	default boolean Section5_Toggle() { return false; }

	@ConfigItem(
			keyName = "Section5_TaggedProjectiles",
			name = "Projectiles To Swap:",
			description = "A list of ProjectileIDs to be swapped. Separate ids with commas (,)",
			position = 1,
			section = configSection5
	)
	default String Section5_TaggedProjectiles(){
		return "";
	}

	@ConfigItem(
			keyName = "Section5_TargetProjectile",
			name = "Swap To:",
			description = "The target ProjectileID to be swapped to",
			position = 2,
			section = configSection5
	)
	default int Section5_TargetProjectile()	{
		return 0;
	}

}
