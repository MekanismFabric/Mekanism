package net.panda.mekanismfabric.registries;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.PlacedFeature;

import static net.panda.mekanismfabric.Mekanism.id;

public class MekanismWorldGen {

    private static final RegistryKey<PlacedFeature> FLUORITE_ORE_BURIED_PLACED_KEY = RegistryKey.of(RegistryKeys.PLACED_FEATURE, id("fluorite_ore_buried"));
    private static final RegistryKey<PlacedFeature> FLUORITE_ORE_NORMAL_PLACED_KEY = RegistryKey.of(RegistryKeys.PLACED_FEATURE, id("fluorite_ore_normal"));
    private static final RegistryKey<PlacedFeature> LEAD_ORE_NORMAL_PLACED_KEY = RegistryKey.of(RegistryKeys.PLACED_FEATURE, id("lead_ore_normal"));
    private static final RegistryKey<PlacedFeature> OSMIUM_ORE_UPPER_PLACED_KEY = RegistryKey.of(RegistryKeys.PLACED_FEATURE, id("osmium_ore_upper"));
    private static final RegistryKey<PlacedFeature> OSMIUM_ORE_MIDDLE_PLACED_KEY = RegistryKey.of(RegistryKeys.PLACED_FEATURE, id("osmium_ore_middle"));
    private static final RegistryKey<PlacedFeature> OSMIUM_ORE_SMALL_PLACED_KEY = RegistryKey.of(RegistryKeys.PLACED_FEATURE, id("osmium_ore_small"));
    private static final RegistryKey<PlacedFeature> TIN_ORE_LARGE_PLACED_KEY = RegistryKey.of(RegistryKeys.PLACED_FEATURE, id("tin_ore_large"));
    private static final RegistryKey<PlacedFeature> TIN_ORE_SMALL_PLACED_KEY = RegistryKey.of(RegistryKeys.PLACED_FEATURE, id("tin_ore_small"));
    private static final RegistryKey<PlacedFeature> URANIUM_ORE_BURIED_PLACED_KEY = RegistryKey.of(RegistryKeys.PLACED_FEATURE, id("uranium_ore_buried"));
    private static final RegistryKey<PlacedFeature> URANIUM_ORE_SMALL_PLACED_KEY = RegistryKey.of(RegistryKeys.PLACED_FEATURE, id("uranium_ore_small"));

    public static void registerWorldGen() {
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, FLUORITE_ORE_BURIED_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, FLUORITE_ORE_NORMAL_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, LEAD_ORE_NORMAL_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, OSMIUM_ORE_UPPER_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, OSMIUM_ORE_MIDDLE_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, OSMIUM_ORE_SMALL_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, TIN_ORE_LARGE_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, TIN_ORE_SMALL_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, URANIUM_ORE_BURIED_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, URANIUM_ORE_SMALL_PLACED_KEY);
    }
}
