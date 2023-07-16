package mekanism.tools.material;

import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;

public interface IArmorMaterialHelper extends ArmorMaterial {
    int getArmorEnchantability();
    Ingredient getArmorRepairMaterial();

    /**
     * Wrap the IArmorMaterial methods that have the same deobf name as IItemTier to regular variants so that they can both be resolved as implemented when
     * reobfuscating.
     *
     * @apiNote Both {@link #getArmorEnchantability()} and {@link IItemMaterialHelper#getItemEnchantability()} are wrapped back into a single method in
     * {@link BaseMekanismMaterial}
     */
    @Override
    default int getEnchantability() {
        return getArmorEnchantability();
    }

    /**
     * Wrap the IArmorMaterial methods that have the same deobf name as IItemTier to regular variants so that they can both be resolved as implemented when
     * reobfuscating.
     *
     * @apiNote Both {@link #getArmorEnchantability()} and {@link IItemMaterialHelper#getItemRepairMaterial()} are wrapped back into a single method in
     * {@link BaseMekanismMaterial}
     */
    @Override
    default Ingredient getRepairIngredient() {
        return getArmorRepairMaterial();
    }
}
