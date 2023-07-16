package mekanism.tools.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.ModelIds;
import net.minecraft.data.client.Models;
import net.minecraft.data.client.TextureMap;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;

public abstract class BaseItemModelProvider extends FabricModelProvider {

    public BaseItemModelProvider(FabricDataOutput output) {
        super(output);
    }

    protected void handheld(ItemModelGenerator itemModelGenerator, Item item, Identifier texture) {
        Models.HANDHELD.upload(ModelIds.getItemModelId(item), TextureMap.layer0(texture), itemModelGenerator.writer);
    }

    protected void armorWithTrim(ItemModelGenerator itemModelGenerator, Item item, Identifier texture) {
        Models.GENERATED.upload(ModelIds.getItemModelId(item), TextureMap.layer0(texture), itemModelGenerator.writer);
    }
}
