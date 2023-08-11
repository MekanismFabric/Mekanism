package mekanism.tools.config.tools;

import com.electronwill.nightconfig.core.conversion.Path;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Comment;
import mekanism.tools.material.impl.*;

@Config(name = "tools")
public class Tools implements ConfigData {

    @Path(BronzeMaterialDefaults.name)
    @ConfigEntry.Gui.CollapsibleObject
    @Comment("Material Settings for " + BronzeMaterialDefaults.name)
    public Bronze bronzeMaterialStats = new Bronze();

    @Path(LapisLazuliMaterialDefaults.name)
    @ConfigEntry.Gui.CollapsibleObject
    @Comment("Material Settings for " + LapisLazuliMaterialDefaults.name)
    public LapisLazuli lapisLazuliMaterialStats = new LapisLazuli();

    @Path(OsmiumMaterialDefaults.name)
    @ConfigEntry.Gui.CollapsibleObject
    @Comment("Material Settings for " + OsmiumMaterialDefaults.name)
    public Osmium osmiumMaterialStats = new Osmium();

    @Path(RefinedGlowstoneMaterialDefaults.name)
    @ConfigEntry.Gui.CollapsibleObject
    @Comment("Material Settings for " + RefinedGlowstoneMaterialDefaults.name)
    public RefinedGlowstone refinedGlowstoneMaterialStats = new RefinedGlowstone();

    @Path(RefinedObsidianMaterialDefaults.name)
    @ConfigEntry.Gui.CollapsibleObject
    @Comment("Material Settings for " + RefinedObsidianMaterialDefaults.name)
    public RefinedObsidian refinedObsidianMaterialStats = new RefinedObsidian();

    @Path(SteelMaterialDefaults.name)
    @ConfigEntry.Gui.CollapsibleObject
    @Comment("Material Settings for " + SteelMaterialDefaults.name)
    public Steel steelMaterialStats = new Steel();
}
