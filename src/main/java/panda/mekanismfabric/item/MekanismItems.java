package panda.mekanismfabric.item;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;
import panda.mekanismfabric.MekanismFabric;
import panda.mekanismfabric.resource.IResource;
import panda.mekanismfabric.resource.MiscResource;
import panda.mekanismfabric.resource.PrimaryResource;
import panda.mekanismfabric.resource.ResourceType;

import java.util.HashMap;
import java.util.Map;

public class MekanismItems {

    public static final Map<String, Item> ALL_ITEMS = new HashMap<>();
    public static final Table<ResourceType, PrimaryResource, Item> PROCESSED_RESOURCES = HashBasedTable.create();

    static {
        for (ResourceType type : ResourceType.values()) {
            for (PrimaryResource resource : PrimaryResource.values()) {
                if (resource.has(type)) {
                    PROCESSED_RESOURCES.put(type, resource, registerItem(type.getPathPrefix() + "_" + resource.getName()));
                }
            }
        }

        PROCESSED_RESOURCES.put(ResourceType.NUGGET, PrimaryResource.COPPER,
                registerItem(ResourceType.NUGGET.getPathPrefix() + "_" + PrimaryResource.COPPER.getName()));
    }

    public static final Item SAWDUST = registerItem("sawdust");
    public static final Item SALT = registerItem("salt");
    public static final Item SUBSTRATE = registerItem("substrate");
    public static final Item BIO_FUEL = registerItem("bio_fuel");
    public static final Item DYE_BASE = registerItem("dye_base");
    public static final Item FLUORITE_GEM = registerItem("fluorite_gem");
    public static final Item YELLOW_CAKE_URANIUM = registerItem("yellow_cake_uranium", Rarity.UNCOMMON);
    public static final Item DIRTY_NETHERITE_SCRAP = registerItem("dirty_netherite_scrap");

    public static final Item BRONZE_DUST = registerResource(ResourceType.DUST, MiscResource.BRONZE);
    public static final Item LAPIS_LAZULI_DUST = registerResource(ResourceType.DUST, MiscResource.LAPIS_LAZULI);
    public static final Item COAL_DUST = registerResource(ResourceType.DUST, MiscResource.COAL);
    public static final Item CHARCOAL_DUST = registerResource(ResourceType.DUST, MiscResource.CHARCOAL);
    public static final Item QUARTZ_DUST = registerResource(ResourceType.DUST, MiscResource.QUARTZ);
    public static final Item EMERALD_DUST = registerResource(ResourceType.DUST, MiscResource.EMERALD);
    public static final Item DIAMOND_DUST = registerResource(ResourceType.DUST, MiscResource.DIAMOND);
    public static final Item NETHERITE_DUST = registerResource(ResourceType.DUST, MiscResource.NETHERITE);
    public static final Item STEEL_DUST = registerResource(ResourceType.DUST, MiscResource.STEEL);
    public static final Item SULFUR_DUST = registerResource(ResourceType.DUST, MiscResource.SULFUR);
    public static final Item LITHIUM_DUST = registerResource(ResourceType.DUST, MiscResource.LITHIUM);
    public static final Item REFINED_OBSIDIAN_DUST = registerResource(ResourceType.DUST, MiscResource.REFINED_OBSIDIAN);
    public static final Item OBSIDIAN_DUST = registerResource(ResourceType.DUST, MiscResource.OBSIDIAN);
    public static final Item FLUORITE_DUST = registerResource(ResourceType.DUST, MiscResource.FLUORITE);

    public static final Item BRONZE_INGOT = registerResource(ResourceType.INGOT, MiscResource.BRONZE);
    public static final Item REFINED_OBSIDIAN_INGOT = registerResource(ResourceType.INGOT, MiscResource.REFINED_OBSIDIAN);
    public static final Item REFINED_GLOWSTONE_INGOT = registerResource(ResourceType.INGOT, MiscResource.REFINED_GLOWSTONE);
    public static final Item STEEL_INGOT = registerResource(ResourceType.INGOT, MiscResource.STEEL);

    public static final Item BRONZE_NUGGET = registerResource(ResourceType.NUGGET, MiscResource.BRONZE);
    public static final Item REFINED_OBSIDIAN_NUGGET = registerResource(ResourceType.NUGGET, MiscResource.REFINED_OBSIDIAN);
    public static final Item REFINED_GLOWSTONE_NUGGET = registerResource(ResourceType.NUGGET, MiscResource.REFINED_GLOWSTONE);
    public static final Item STEEL_NUGGET = registerResource(ResourceType.NUGGET, MiscResource.STEEL);

    private static Item registerResource(ResourceType type, IResource resource) {
        return registerItem(type.getPathPrefix() + "_" + resource.getName());
    }

    private static Item registerItem(String name) {
        return registerItem(name, Rarity.COMMON);
    }

    private static Item registerItem(String name, Rarity rarity) {
        Item newItem = Registry.register(
                Registry.ITEM,
                MekanismFabric.id(name),
                new Item(new FabricItemSettings().group(MekanismItemGroup.MEKANISM).rarity(rarity)));
        ALL_ITEMS.put(name, newItem);
        return newItem;
    }

    public static void registerMekanismItems() {
        MekanismFabric.LOGGER.info("Registering blocks for " + MekanismFabric.MODID);
    }
}
