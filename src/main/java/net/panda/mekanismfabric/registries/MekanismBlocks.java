package net.panda.mekanismfabric.registries;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static net.panda.mekanismfabric.Mekanism.LOGGER;
import static net.panda.mekanismfabric.Mekanism.MODID;
import static net.panda.mekanismfabric.registries.MekanismItemGroups.MEKANISM_BLOCKS;

public class MekanismBlocks {

    public static void registerBlocks() {
        LOGGER.info("Loading blocks for {}", MODID);
        // TODO: Remove placeholder
        MEKANISM_BLOCKS.addItemToGroup(Blocks.BAMBOO_BLOCK.asItem().getDefaultStack());
    }

    private static <T extends Block> T registerBlock(Identifier identifier, T block) {
        MEKANISM_BLOCKS.addItemToGroup(block.asItem().getDefaultStack());
        return Registry.register(Registries.BLOCK, identifier, block);
    }
}
