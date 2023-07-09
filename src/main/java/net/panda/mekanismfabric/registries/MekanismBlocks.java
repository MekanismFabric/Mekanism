package net.panda.mekanismfabric.registries;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.block.enums.Instrument;
import net.minecraft.item.BlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.panda.mekanismfabric.resource.BlockResourceInfo;
import net.panda.mekanismfabric.resource.IResource;
import net.panda.mekanismfabric.resource.PrimaryResources;

import java.util.LinkedHashMap;
import java.util.Map;

import static net.panda.mekanismfabric.Mekanism.LOGGER;
import static net.panda.mekanismfabric.Mekanism.MODID;
import static net.panda.mekanismfabric.registries.MekanismItemGroups.MEKANISM_BLOCKS;

public class MekanismBlocks {

    public static final Map<IResource, Block> PROCESSED_RESOURCE_BLOCKS = new LinkedHashMap<>();

    static {
        for (PrimaryResources resource : PrimaryResources.values()) {
            if (resource.getResourceBlockInfo() != null) {
                PROCESSED_RESOURCE_BLOCKS.put(resource, registerResourceBlock(resource.getResourceBlockInfo()));
            }
            BlockResourceInfo rawResource = resource.getRawResourceBlockInfo();
            if (rawResource != null) {
                PROCESSED_RESOURCE_BLOCKS.put(rawResource, registerResourceBlock(rawResource));
            }
        }
    }

    public static final Block OSMIUM_ORE = registerBlock(new Identifier(MODID, "osmium_ore"), new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.IRON_ORE)));
    public static final Block DEEPSLATE_OSMIUM_ORE = registerBlock(new Identifier(MODID, "deepslate_osmium_ore"), new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.IRON_ORE)));
    public static final Block TIN_ORE = registerBlock(new Identifier(MODID, "tin_ore"), new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.IRON_ORE)));
    public static final Block DEEPSLATE_TIN_ORE = registerBlock(new Identifier(MODID, "deepslate_tin_ore"), new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.IRON_ORE)));
    public static final Block LEAD_ORE = registerBlock(new Identifier(MODID, "lead_ore"), new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.IRON_ORE)));
    public static final Block DEEPSLATE_LEAD_ORE = registerBlock(new Identifier(MODID, "deepslate_lead_ore"), new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.IRON_ORE)));
    public static final Block URANIUM_ORE = registerBlock(new Identifier(MODID, "uranium_ore"), new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.IRON_ORE)));
    public static final Block DEEPSLATE_URANIUM_ORE = registerBlock(new Identifier(MODID, "deepslate_uranium_ore"), new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.IRON_ORE)));
    public static final Block FLUORITE_ORE = registerBlock(new Identifier(MODID, "fluorite_ore"), new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.IRON_ORE)));
    public static final Block DEEPSLATE_FLUORITE_ORE = registerBlock(new Identifier(MODID, "deepslate_fluorite_ore"), new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.IRON_ORE)));

    public static final Block BRONZE_BLOCK = registerResourceBlock(BlockResourceInfo.BRONZE);
    public static final Block REFINED_OBSIDIAN_BLOCK = registerResourceBlock(BlockResourceInfo.REFINED_OBSIDIAN);
    public static final Block CHARCOAL_BLOCK = registerResourceBlock(BlockResourceInfo.CHARCOAL);
    public static final Block REFINED_GLOWSTONE_BLOCK = registerResourceBlock(BlockResourceInfo.REFINED_GLOWSTONE);
    public static final Block STEEL_BLOCK = registerResourceBlock(BlockResourceInfo.STEEL);
    public static final Block FLUORITE_BLOCK = registerResourceBlock(BlockResourceInfo.FLUORITE);
    public static final Block SALT_BLOCK = registerBlock("block_salt", FabricBlockSettings.create().strength(0.5f).sounds(BlockSoundGroup.SAND).instrument(Instrument.SNARE));

    public static void registerBlocks() {
        LOGGER.info("Loading blocks for {}", MODID);
    }

    private static Block registerResourceBlock(BlockResourceInfo resourceInfo) {
        return registerBlock(new Identifier(MODID, "block_" + resourceInfo.getName()), new Block(resourceInfo.modifyProperties(FabricBlockSettings.create())));
    }

    private static Block registerBlock(String identifier, AbstractBlock.Settings settings) {
        return registerBlock(new Identifier(MODID, identifier), new Block(settings));
    }

    private static <T extends Block> T registerBlock(Identifier identifier, T block) {
        BlockItem blockItem = registerBlockItem(identifier, new BlockItem(block, new FabricItemSettings()));
        MEKANISM_BLOCKS.addItemToGroup(blockItem.getDefaultStack());
        return Registry.register(Registries.BLOCK, identifier, block);
    }

    private static BlockItem registerBlockItem(Identifier identifier, BlockItem blockItem) {
        return Registry.register(Registries.ITEM, identifier, blockItem);
    }
}
