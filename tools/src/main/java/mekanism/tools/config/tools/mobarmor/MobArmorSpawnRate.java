package mekanism.tools.config.tools.mobarmor;

import com.electronwill.nightconfig.core.conversion.Path;
import com.electronwill.nightconfig.core.conversion.SpecDoubleInRange;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Comment;

public class MobArmorSpawnRate implements ConfigData {
    @Path("general")
    @SpecDoubleInRange(min = 0.0D, max = 1.0D)
    @Comment("The chance that Mekanism Armor can spawn on mobs.")
    public double general = 0.03D;

    @Comment("Spawn chances for pieces of Bronze gear. Note: These values are after the general mobArmorSpawnRate has been checked, and after an even split between armor types has been done.")
    @ConfigEntry.Category("bronze")
    @ConfigEntry.Gui.CollapsibleObject
    public Bronze bronze = new Bronze();

    @Comment("Spawn chances for pieces of Lapis Lazuli gear. Note: These values are after the general mobArmorSpawnRate has been checked, and after an even split between armor types has been done.")
    @ConfigEntry.Category("lapis_lazuli")
    @ConfigEntry.Gui.CollapsibleObject
    public LapisLazuli lapisLazuli = new LapisLazuli();

    @Comment("Spawn chances for pieces of Osmium gear. Note: These values are after the general mobArmorSpawnRate has been checked, and after an even split between armor types has been done.")
    @ConfigEntry.Category("osmium")
    @ConfigEntry.Gui.CollapsibleObject
    public Osmium osmium = new Osmium();

    @Comment("Spawn chances for pieces of Refined Glowstone gear. Note: These values are after the general mobArmorSpawnRate has been checked, and after an even split between armor types has been done.")
    @ConfigEntry.Category("refined_glowstone")
    @ConfigEntry.Gui.CollapsibleObject
    public RefinedGlowstone refinedGlowstone = new RefinedGlowstone();

    @Comment("Spawn chances for pieces of Refined Obsidian gear. Note: These values are after the general mobArmorSpawnRate has been checked, and after an even split between armor types has been done.")
    @ConfigEntry.Category("refined_obsidian")
    @ConfigEntry.Gui.CollapsibleObject
    public RefinedObsidian refinedObsidian = new RefinedObsidian();

    @Comment("Spawn chances for Steel of Bronze gear. Note: These values are after the general mobArmorSpawnRate has been checked, and after an even split between armor types has been done.")
    @ConfigEntry.Category("steel")
    @ConfigEntry.Gui.CollapsibleObject
    public Steel steel = new Steel();
}
