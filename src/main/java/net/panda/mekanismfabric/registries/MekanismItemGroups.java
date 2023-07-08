package net.panda.mekanismfabric.registries;

import net.minecraft.block.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.panda.mekanismfabric.itemgroup.MekanismItemGroup;

import static net.panda.mekanismfabric.Mekanism.LOGGER;
import static net.panda.mekanismfabric.Mekanism.MODID;

public class MekanismItemGroups {

    public static final MekanismItemGroup MEKANISM_ITEMS = new MekanismItemGroup(new ItemStack(Items.ACACIA_BOAT),
            new Identifier(MODID, "mekanism_items"), String.format("itemgroup.%s.items", MODID));
    public static final MekanismItemGroup MEKANISM_BLOCKS = new MekanismItemGroup(new ItemStack(Blocks.BAMBOO),
            new Identifier(MODID, "mekanism_blocks"), String.format("itemgroup.%s.blocks", MODID));

    public static void registerItemGroups() {
        LOGGER.info("Loading itemgroups for {}", MODID);
        MEKANISM_ITEMS.register();
        MEKANISM_BLOCKS.register();
    }
}
