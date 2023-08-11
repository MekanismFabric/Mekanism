package mekanism.itemgroup;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.function.Supplier;

public class MekanismItemGroup {

    private final ItemGroup itemGroup;
    private final Identifier identifier;

    public MekanismItemGroup(Supplier<Item> icon, Identifier identifier, String translationKey, List<ItemStack> items) {
        this.itemGroup = FabricItemGroup.builder()
                .icon(() -> new ItemStack(icon.get()))
                .displayName(Text.translatable(translationKey))
                .entries((displayContext, entries) -> entries.addAll(items))
                .build();
        this.identifier = identifier;
    }

    public void register() {
        Registry.register(Registries.ITEM_GROUP, identifier, itemGroup);
    }
}
