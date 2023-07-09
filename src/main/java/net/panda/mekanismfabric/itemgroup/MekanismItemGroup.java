package net.panda.mekanismfabric.itemgroup;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.function.Supplier;

public class MekanismItemGroup {

    private final ItemGroup itemGroup;
    private final RegistryKey<ItemGroup> registryKey;
    private final Identifier identifier;

    public MekanismItemGroup(Supplier<Item> icon, Identifier identifier, String translationKey) {
        this.itemGroup = FabricItemGroup.builder()
                .icon(() -> new ItemStack(icon.get()))
                .displayName(Text.translatable(translationKey))
                .build();
        this.registryKey = RegistryKey.of(Registries.ITEM_GROUP.getKey(), identifier);
        this.identifier = identifier;
    }

    public void register() {
        Registry.register(Registries.ITEM_GROUP, identifier, itemGroup);
    }

    public void addItemToGroup(ItemStack stack) {
        ItemGroupEvents.modifyEntriesEvent(registryKey).register(content -> content.add(stack));
    }
}
