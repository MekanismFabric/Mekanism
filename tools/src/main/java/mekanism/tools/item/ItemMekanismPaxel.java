package mekanism.tools.item;

import mekanism.tools.IHasRepairType;
import mekanism.tools.material.IPaxelMaterial;
import mekanism.tools.material.MaterialCreator;
import mekanism.tools.material.VanillaPaxelMaterialCreator;
import net.minecraft.block.BlockState;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.*;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import static mekanism.tools.MekanismTools.id;

public class ItemMekanismPaxel extends MiningToolItem implements IHasRepairType {

    private static final Item[] VALID_TOOLS = {
            Items.NETHERITE_AXE,
            Items.NETHERITE_SHOVEL,
            Items.NETHERITE_PICKAXE
    };

    private final IPaxelMaterial material;

    public ItemMekanismPaxel(MaterialCreator material, Item.Settings settings) {
        super(material.getPaxelDamage(), material.getPaxelAtkSpeed(), material, TagKey.of(RegistryKeys.BLOCK, id("mineable/paxel")), settings);
        this.material = material;
    }

    public ItemMekanismPaxel(VanillaPaxelMaterialCreator material, Item.Settings properties) {
        super(material.getPaxelDamage(), material.getPaxelAtkSpeed(), material.getVanillaMaterial(), TagKey.of(RegistryKeys.BLOCK, id("mineable/paxel")), properties);
        this.material = material;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        super.appendTooltip(stack, world, tooltip, context);
    }

    @Override
    public float getAttackDamage() {
        return material.getPaxelDamage() + getMaterial().getAttackDamage();
    }

    @Override
    public float getMiningSpeedMultiplier(ItemStack stack, BlockState state) {
        return super.getMiningSpeedMultiplier(stack, state) == 1 ? 1 : material.getPaxelEfficiency();
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        ActionResult result = ActionResult.PASS;

        for (Item validTool : VALID_TOOLS) {
            result = validTool.useOnBlock(context);
            if (ActionResult.PASS != result) break;
        }

        if (ActionResult.PASS != result) return result;
        return super.useOnBlock(context);
    }

    @Override
    public int getEnchantability() {
        return material.getPaxelEnchantability();
    }

    @Override
    public @NotNull Ingredient getRepairMaterial() {
        return getMaterial().getRepairIngredient();
    }

    @Override
    public boolean isDamageable() {
        return material.getPaxelMaxUses() > 0;
    }
}
