package net.panda.mekanismfabric.registries;

import net.minecraft.util.Identifier;
import net.panda.mekanismfabric.itemgroup.MekanismItemGroup;

import static net.panda.mekanismfabric.Mekanism.LOGGER;
import static net.panda.mekanismfabric.Mekanism.MODID;

public class MekanismItemGroups {

    public static final MekanismItemGroup MEKANISM_ITEMS = new MekanismItemGroup(() -> MekanismItems.YELLOW_CAKE_URANIUM,
            new Identifier(MODID, "mekanism_items"), String.format("itemgroup.%s.items", MODID));
    public static final MekanismItemGroup MEKANISM_BLOCKS = new MekanismItemGroup(() -> MekanismBlocks.OSMIUM_ORE.asItem(),
            new Identifier(MODID, "mekanism_blocks"), String.format("itemgroup.%s.blocks", MODID));

    public static void registerItemGroups() {
        LOGGER.info("Loading itemgroups for {}", MODID);
        MEKANISM_ITEMS.register();
        MEKANISM_BLOCKS.register();
    }
}
