package net.panda.mekanismfabric.registries;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.panda.mekanismfabric.resource.MiscResources;
import net.panda.mekanismfabric.resource.PrimaryResources;
import net.panda.mekanismfabric.resource.ResourceTypes;

import static net.panda.mekanismfabric.Mekanism.*;
import static net.panda.mekanismfabric.registries.MekanismItemGroups.MEKANISM_ITEMS;

public class MekanismItems {

    public static final Table<ResourceTypes, PrimaryResources, Item> PROCESSED_RESOURCES = HashBasedTable.create();

    static {
        for (ResourceTypes type : ResourceTypes.values()) {
            for (PrimaryResources resource : PrimaryResources.values()) {
                if (resource.has(type)) {
                    PROCESSED_RESOURCES.put(type, resource, registerItem(type.getPathPrefix() + "_" + resource.getName()));
                }
            }
        }
    }

    public static final Item SAWDUST = registerItem("sawdust");
    public static final Item SALT = registerItem("salt");
    public static final Item SUBSTRATE = registerItem("substrate");
    public static final Item BIO_FUEL = registerItem("bio_fuel");
    public static final Item DYE_BASE = registerItem("dye_base");
    public static final Item FLUORITE_GEM = registerItem("fluorite_gem");
    public static final Item YELLOW_CAKE_URANIUM = registerItem("yellow_cake_uranium", Rarity.UNCOMMON);
    public static final Item DIRTY_NETHERITE_SCRAP = registerItem("dirty_netherite_scrap");

    public static final Item BRONZE_DUST = registerResource(ResourceTypes.DUST, MiscResources.BRONZE);
    public static final Item LAPIS_LAZULI_DUST = registerResource(ResourceTypes.DUST, MiscResources.LAPIS_LAZULI);
    public static final Item COAL_DUST = registerResource(ResourceTypes.DUST, MiscResources.COAL);
    public static final Item CHARCOAL_DUST = registerResource(ResourceTypes.DUST, MiscResources.CHARCOAL);
    public static final Item QUARTZ_DUST = registerResource(ResourceTypes.DUST, MiscResources.QUARTZ);
    public static final Item EMERALD_DUST = registerResource(ResourceTypes.DUST, MiscResources.EMERALD);
    public static final Item DIAMOND_DUST = registerResource(ResourceTypes.DUST, MiscResources.DIAMOND);
    public static final Item NETHERITE_DUST = registerResource(ResourceTypes.DUST, MiscResources.NETHERITE);
    public static final Item STEEL_DUST = registerResource(ResourceTypes.DUST, MiscResources.STEEL);
    public static final Item SULFUR_DUST = registerResource(ResourceTypes.DUST, MiscResources.SULFUR);
    public static final Item LITHIUM_DUST = registerResource(ResourceTypes.DUST, MiscResources.LITHIUM);
    public static final Item REFINED_OBSIDIAN_DUST = registerResource(ResourceTypes.DUST, MiscResources.REFINED_OBSIDIAN);
    public static final Item OBSIDIAN_DUST = registerResource(ResourceTypes.DUST, MiscResources.OBSIDIAN);
    public static final Item FLUORITE_DUST = registerResource(ResourceTypes.DUST, MiscResources.FLUORITE);

    public static final Item BRONZE_INGOT = registerResource(ResourceTypes.INGOT, MiscResources.BRONZE);
    public static final Item REFINED_OBSIDIAN_INGOT = registerResource(ResourceTypes.INGOT, MiscResources.REFINED_OBSIDIAN);
    public static final Item REFINED_GLOWSTONE_INGOT = registerResource(ResourceTypes.INGOT, MiscResources.REFINED_GLOWSTONE);
    public static final Item STEEL_INGOT = registerResource(ResourceTypes.INGOT, MiscResources.STEEL);

    public static final Item BRONZE_NUGGET = registerResource(ResourceTypes.NUGGET, MiscResources.BRONZE);
    public static final Item REFINED_OBSIDIAN_NUGGET = registerResource(ResourceTypes.NUGGET, MiscResources.REFINED_OBSIDIAN);
    public static final Item REFINED_GLOWSTONE_NUGGET = registerResource(ResourceTypes.NUGGET, MiscResources.REFINED_GLOWSTONE);
    public static final Item STEEL_NUGGET = registerResource(ResourceTypes.NUGGET, MiscResources.STEEL);

    public static void registerItems() {
        LOGGER.info("Loading items for {}", MODID);
    }

    private static Item registerResource(ResourceTypes type, MiscResources resource) {
        return registerItem(type.getPathPrefix() + "_" + resource.getName());
    }

    private static Item registerItem(String identifier) {
        return registerItem(id(identifier), new Item(new FabricItemSettings()));
    }

    private static Item registerItem(String identifier, Rarity rarity) {
        return registerItem(id(identifier), new Item(new FabricItemSettings().rarity(rarity)));
    }

    private static <T extends Item> T registerItem(Identifier identifier, T item) {
        MEKANISM_ITEMS.addItemToGroup(item.getDefaultStack());
        return Registry.register(Registries.ITEM, identifier, item);
    }
}
