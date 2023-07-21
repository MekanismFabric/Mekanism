package mekanism.tools.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Comment;
import mekanism.tools.material.MaterialCreator;
import mekanism.tools.material.VanillaPaxelMaterialCreator;
import mekanism.tools.material.impl.*;
import mekanism.tools.material.impl.vanilla.*;

@Config(name = "common")
public class ToolsConfigOld implements ConfigData {

    @ConfigEntry.Gui.TransitiveObject
    @Comment("The chance that Mekanism Armor can spawn on mobs. This is multiplied modified by the chunk's difficulty modifier. " +
            "Vanilla uses 0.15 for its armor spawns, we use 0.1 as default to lower chances of mobs getting some vanilla and some mek armor.")
    public final float armorSpawnChance;

    @ConfigEntry.Gui.TransitiveObject
    @Comment("The chance that Mekanism Weapons can spawn in a zombie's hand.")
    public final float weaponSpawnChance;

    @ConfigEntry.Gui.TransitiveObject
    @Comment("The chance that Mekanism Weapons can spawn in a zombie's hand when on hard difficulty.")
    public final float weaponSpawnChanceHard;

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

    public ToolsConfigOld() {
        armorSpawnChance = 0.1F;
        weaponSpawnChance = 0.1F;
        weaponSpawnChanceHard = 0.1F;

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
