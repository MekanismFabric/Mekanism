package mekanism.registries;

import mekanism.itemgroup.MekanismItemGroup;

import static mekanism.Mekanism.*;

public class MekanismItemGroups {

    public static final MekanismItemGroup MEKANISM_ITEMS = new MekanismItemGroup(() -> MekanismItems.YELLOW_CAKE_URANIUM,
            id("mekanism_items"), String.format("itemgroup.%s.items", MODID), MekanismItems.ALL_ITEMS);
    public static final MekanismItemGroup MEKANISM_BLOCKS = new MekanismItemGroup(() -> MekanismBlocks.OSMIUM_ORE.asItem(),
            id("mekanism_blocks"), String.format("itemgroup.%s.blocks", MODID), MekanismBlocks.ALL_BLOCKS);

    public static void registerItemGroups() {
        LOGGER.info("Loading itemgroups for {}", MODID);
        MEKANISM_ITEMS.register();
        MEKANISM_BLOCKS.register();
    }
}
