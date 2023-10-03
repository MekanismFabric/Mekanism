package panda.mekanismfabric.item;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import panda.mekanismfabric.MekanismFabric;

public class MekanismItemGroup {

    public static final ItemGroup MEKANISM = FabricItemGroupBuilder.build(MekanismFabric.id("mekanism"),
            () -> new ItemStack(MekanismItems.REFINED_GLOWSTONE_INGOT));
}