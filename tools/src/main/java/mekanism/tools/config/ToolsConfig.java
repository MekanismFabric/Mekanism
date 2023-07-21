package mekanism.tools.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import mekanism.tools.material.MaterialCreator;
import mekanism.tools.material.VanillaPaxelMaterialCreator;
import mekanism.tools.material.impl.*;
import mekanism.tools.material.impl.vanilla.*;

@Config(name = "common")
public class ToolsConfig implements ConfigData {

    public final VanillaPaxelMaterialCreator wood;
    public final VanillaPaxelMaterialCreator stone;
    public final VanillaPaxelMaterialCreator iron;
    public final VanillaPaxelMaterialCreator diamond;
    public final VanillaPaxelMaterialCreator gold;
    public final VanillaPaxelMaterialCreator netherite;

    public final MaterialCreator bronze;
    public final MaterialCreator lapisLazuli;
    public final MaterialCreator osmium;
    public final MaterialCreator refinedGlowstone;
    public final MaterialCreator refinedObsidian;
    public final MaterialCreator steel;

    public ToolsConfig() {
        wood = new VanillaPaxelMaterialCreator(new WoodPaxelMaterialDefaults());
        stone = new VanillaPaxelMaterialCreator(new StonePaxelMaterialDefaults());
        iron = new VanillaPaxelMaterialCreator(new IronPaxelMaterialDefaults());
        diamond = new VanillaPaxelMaterialCreator(new DiamondPaxelMaterialDefaults());
        gold = new VanillaPaxelMaterialCreator(new GoldPaxelMaterialDefaults());
        netherite = new VanillaPaxelMaterialCreator(new NetheritePaxelMaterialDefaults());

        bronze = new MaterialCreator(new BronzeMaterialDefaults());
        lapisLazuli = new MaterialCreator(new LapisLazuliMaterialDefaults());
        osmium = new MaterialCreator(new OsmiumMaterialDefaults());
        refinedGlowstone = new MaterialCreator(new RefinedGlowstoneMaterialDefaults());
        refinedObsidian = new MaterialCreator(new RefinedObsidianMaterialDefaults());
        steel = new MaterialCreator(new SteelMaterialDefaults());
    }
}
