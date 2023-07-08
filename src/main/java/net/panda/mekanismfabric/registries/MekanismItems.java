package net.panda.mekanismfabric.registries;

import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static net.panda.mekanismfabric.Mekanism.LOGGER;
import static net.panda.mekanismfabric.Mekanism.MODID;
import static net.panda.mekanismfabric.registries.MekanismItemGroups.MEKANISM_ITEMS;

public class MekanismItems {

    public static void registerItems() {
        LOGGER.info("Loading items for {}", MODID);
        // TODO: Remove placeholder
        MEKANISM_ITEMS.addItemToGroup(Items.ACACIA_BOAT.getDefaultStack());
    }

    private static <T extends Item> T registerItem(Identifier identifier, T item) {
        MEKANISM_ITEMS.addItemToGroup(item.getDefaultStack());
        return Registry.register(Registries.ITEM, identifier, item);
    }
}
