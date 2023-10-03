package panda.mekanismfabric.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.util.registry.Registry;
import panda.mekanismfabric.MekanismFabric;
import panda.mekanismfabric.item.MekanismItemGroup;
import panda.mekanismfabric.resource.BlockResourceInfo;
import panda.mekanismfabric.resource.IResource;
import panda.mekanismfabric.resource.PrimaryResource;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class MekanismBlocks {

    public static final Map<String, Block> ALL_BLOCKS = new HashMap<>();
    public static final Map<IResource, Block> PROCESSED_RESOURCE_BLOCKS = new LinkedHashMap<>();

    static {
        for (PrimaryResource resource : PrimaryResource.values()) {
            if (resource.getResourceInfo() != null) {
                PROCESSED_RESOURCE_BLOCKS.put(resource, registerResourceBlock(resource.getResourceInfo()));

                if (!resource.isVanilla()) {
                    registerOreBlock(resource.getResourceInfo());
                }
            }
            BlockResourceInfo rawResource = resource.getRawResourceInfo();
            if (rawResource != null) {
                PROCESSED_RESOURCE_BLOCKS.put(rawResource, registerResourceBlock(rawResource));
            }
        }

        registerOreBlock(BlockResourceInfo.FLUORITE);
        registerResourceBlock(BlockResourceInfo.FLUORITE);
        registerResourceBlock(BlockResourceInfo.BRONZE);
        registerResourceBlock(BlockResourceInfo.REFINED_OBSIDIAN);
        registerResourceBlock(BlockResourceInfo.CHARCOAL);
        registerResourceBlock(BlockResourceInfo.REFINED_GLOWSTONE);
        registerResourceBlock(BlockResourceInfo.STEEL);
        registerBlock("salt_block", new Block(FabricBlockSettings.copyOf(Blocks.BONE_BLOCK)));
    }

    private static void registerOreBlock(BlockResourceInfo blockResourceInfo) {
        registerBlock(
                blockResourceInfo.getName() + "_ore",
            new Block(blockResourceInfo.modifyProperties(FabricBlockSettings.copyOf(Blocks.IRON_ORE))));
        registerBlock(
                "deepslate_" + blockResourceInfo.getName() + "_ore",
                new Block(blockResourceInfo.modifyProperties(FabricBlockSettings.copyOf(Blocks.IRON_ORE))));
    }

    private static Block registerResourceBlock(BlockResourceInfo blockResourceInfo) {
        return registerBlock(blockResourceInfo.getName() + "_block", new Block(blockResourceInfo.modifyProperties(FabricBlockSettings.copyOf(Blocks.IRON_ORE))));
    }

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        Block newBlock = Registry.register(Registry.BLOCK, MekanismFabric.id(name), block);
        ALL_BLOCKS.put(name, newBlock);
        return newBlock;
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registry.ITEM, MekanismFabric.id(name),
                new BlockItem(block, new FabricItemSettings().group(MekanismItemGroup.MEKANISM)));
    }

    public static void registerMekanismBlocks() {
        MekanismFabric.LOGGER.info("Registering blocks for " + MekanismFabric.MODID);
    }
}
