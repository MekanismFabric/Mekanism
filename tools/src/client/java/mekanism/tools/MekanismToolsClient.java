package mekanism.tools;

import mekanism.tools.item.ItemMekanismShield;
import mekanism.tools.rendering.RenderItemMekanismShield;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.client.model.FabricModelPredicateProviderRegistry;
import net.fabricmc.fabric.impl.client.rendering.BuiltinItemRendererRegistryImpl;

public class MekanismToolsClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        registerShieldHandlers();
    }

    public static void registerShieldHandlers() {
        for (ItemMekanismShield shieldItem : RenderItemMekanismShield.initShieldTextureMap()) {
            BuiltinItemRendererRegistryImpl.INSTANCE.register(shieldItem, RenderItemMekanismShield::render);
            FabricModelPredicateProviderRegistry.register(shieldItem, MekanismTools.id("blocking"), (stack, world, entity, seed) ->
                    entity != null && entity.isUsingItem() && entity.getActiveItem() == stack ? 1.0F : 0.0F
            );
        }
    }
}
