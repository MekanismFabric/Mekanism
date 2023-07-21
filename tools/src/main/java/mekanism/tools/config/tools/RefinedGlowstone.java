package mekanism.tools.config.tools;

import com.electronwill.nightconfig.core.conversion.Path;
import com.electronwill.nightconfig.core.conversion.SpecFloatInRange;
import com.electronwill.nightconfig.core.conversion.SpecIntInRange;
import lombok.Getter;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Comment;
import mekanism.tools.material.impl.RefinedGlowstoneMaterialDefaults;
import net.minecraft.block.Block;
import net.minecraft.item.ArmorItem;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.TagKey;
import org.jetbrains.annotations.Nullable;

public class RefinedGlowstone extends AbstractMaterialConfig implements ConfigData {

    @Getter
    @Path(RefinedGlowstoneMaterialDefaults.name + "AttackDamage")
    @SpecFloatInRange(min = 0.0F, max = Float.MAX_VALUE)
    @Comment("Base attack damage of " + RefinedGlowstoneMaterialDefaults.name + " items.")
    public float attackDamage = DEFAULT.getAttackDamage();

    @Getter
    @Path(RefinedGlowstoneMaterialDefaults.name + "ShieldDurability")
    @SpecIntInRange(min = 0, max = Integer.MAX_VALUE)
    @Comment("Maximum durability of " + RefinedGlowstoneMaterialDefaults.name + " shields.")
    public int shieldDurability = DEFAULT.getShieldDurability();

    @Path(RefinedGlowstoneMaterialDefaults.name + "SwordDamage")
    @Comment("Attack damage modifier of " + RefinedGlowstoneMaterialDefaults.name + " swords.")
    public float swordDamage = DEFAULT.getSwordDamage();

    @Path(RefinedGlowstoneMaterialDefaults.name + "SwordAtkSpeed")
    @Comment("Attack speed of " + RefinedGlowstoneMaterialDefaults.name + " swords.")
    public float swordAtkSpeed = DEFAULT.getSwordAtkSpeed();

    @Path(RefinedGlowstoneMaterialDefaults.name + "ShovelDamage")
    @Comment("Attack damage modifier of " + RefinedGlowstoneMaterialDefaults.name + " shovels.")
    public float shovelDamage = DEFAULT.getShovelDamage();

    @Path(RefinedGlowstoneMaterialDefaults.name + "ShovelAtkSpeed")
    @Comment("Attack speed of " + RefinedGlowstoneMaterialDefaults.name + " shovels.")
    public float shovelAtkSpeed = DEFAULT.getShovelAtkSpeed();

    @Getter
    @Path(RefinedGlowstoneMaterialDefaults.name + "AxeDamage")
    @Comment("Attack damage modifier of " + RefinedGlowstoneMaterialDefaults.name + " axes.")
    public float axeDamage = DEFAULT.getAxeDamage();

    @Getter
    @Path(RefinedGlowstoneMaterialDefaults.name + "AxeAtkSpeed")
    @Comment("Attack speed of " + RefinedGlowstoneMaterialDefaults.name + " axes.")
    public float axeAtkSpeed = DEFAULT.getAxeAtkSpeed();

    @Path(RefinedGlowstoneMaterialDefaults.name + "PickaxeDamage")
    @Comment("Attack damage modifier of " + RefinedGlowstoneMaterialDefaults.name + " pickaxes.")
    public float pickaxeDamage = DEFAULT.getPickaxeDamage();

    @Path(RefinedGlowstoneMaterialDefaults.name + "PickaxeAtkSpeed")
    @Comment("Attack speed of " + RefinedGlowstoneMaterialDefaults.name + " pickaxes.")
    public float pickaxeAtkSpeed = DEFAULT.getPickaxeAtkSpeed();

    @Path(RefinedGlowstoneMaterialDefaults.name + "HoeDamage")
    @Comment("Attack damage modifier of " + RefinedGlowstoneMaterialDefaults.name + " hoes.")
    public float hoeDamage = DEFAULT.getPickaxeAtkSpeed();

    @Path(RefinedGlowstoneMaterialDefaults.name + "HoeAtkSpeed")
    @Comment("Attack speed of " + RefinedGlowstoneMaterialDefaults.name + " hoes.")
    public float hoeAtkSpeed = DEFAULT.getHoeAtkSpeed();

    @Getter
    @Path(RefinedGlowstoneMaterialDefaults.name + "ToolMaxUses")
    @SpecIntInRange(min = 1, max = Integer.MAX_VALUE)
    @Comment("Maximum durability of " + RefinedGlowstoneMaterialDefaults.name + " tools.")
    public int durability = DEFAULT.getDurability();

    @Getter
    @Path(RefinedGlowstoneMaterialDefaults.name + "Efficiency")
    @Comment("Efficiency of " + RefinedGlowstoneMaterialDefaults.name + " tools.")
    public float miningSpeedMultiplier = DEFAULT.getMiningSpeedMultiplier();

    @Getter
    @Path(RefinedGlowstoneMaterialDefaults.name + "PaxelHarvestLevel")
    @SpecIntInRange(min = 0, max = Integer.MAX_VALUE)
    @Comment("Harvest level of " + RefinedGlowstoneMaterialDefaults.name + " paxels.")
    public int paxelHarvestLevel = DEFAULT.getMiningLevel();

    @Getter
    @Path(RefinedGlowstoneMaterialDefaults.name + "PaxelDamage")
    @Comment("Attack damage modifier of " + RefinedGlowstoneMaterialDefaults.name + " paxels.")
    public float paxelDamage = DEFAULT.getPaxelDamage();

    @Path(RefinedGlowstoneMaterialDefaults.name + "PaxelAtkSpeed")
    @Comment("Attack speed of " + RefinedGlowstoneMaterialDefaults.name + " paxels.")
    public float paxelAtkSpeed = DEFAULT.getPaxelAtkSpeed();

    @Getter
    @Path(RefinedGlowstoneMaterialDefaults.name + "PaxelEfficiency")
    @Comment("Efficiency of " + RefinedGlowstoneMaterialDefaults.name + " paxels.")
    public float paxelEfficiency = DEFAULT.getPaxelEfficiency();

    @Getter
    @Path(RefinedGlowstoneMaterialDefaults.name + "PaxelEnchantability")
    @SpecIntInRange(min = 0, max = Integer.MAX_VALUE)
    @Comment("Natural enchantability factor of " + RefinedGlowstoneMaterialDefaults.name + " paxels.")
    public int paxelEnchantability = DEFAULT.getPaxelEnchantability();

    @Getter
    @Path(RefinedGlowstoneMaterialDefaults.name + "PaxelMaxUses")
    @SpecIntInRange(min = 1, max = Integer.MAX_VALUE)
    @Comment("Maximum durability of " + RefinedGlowstoneMaterialDefaults.name + " paxels.")
    public int paxelMaxUses = DEFAULT.getPaxelMaxUses();

    @Getter
    @Path(RefinedGlowstoneMaterialDefaults.name + "HarvestLevel")
    @SpecIntInRange(min = 0, max = Integer.MAX_VALUE)
    @Comment("Harvest level of " + RefinedGlowstoneMaterialDefaults.name + " tools.")
    public int miningLevel = DEFAULT.getMiningLevel();

    @Getter
    @Path(RefinedGlowstoneMaterialDefaults.name + "Enchantability")
    @SpecIntInRange(min = 0, max = Integer.MAX_VALUE)
    @Comment("Natural enchantability factor of " + RefinedGlowstoneMaterialDefaults.name + " items.")
    public int enchantability = DEFAULT.getEnchantability();

    @Getter
    @Path(RefinedGlowstoneMaterialDefaults.name + "Toughness")
    @SpecFloatInRange(min = 0.0F, max = Float.MAX_VALUE)
    @Comment("Base armor toughness value of " + RefinedGlowstoneMaterialDefaults.name + " armor.")
    public float toughness = DEFAULT.getToughness();

    @Getter
    @Path(RefinedGlowstoneMaterialDefaults.name + "KnockbackResistance")
    @SpecFloatInRange(min = 0.0F, max = Float.MAX_VALUE)
    @Comment("Base armor knockback resistance value of " + RefinedGlowstoneMaterialDefaults.name + " armor.")
    public float knockbackResistance = DEFAULT.getKnockbackResistance();

    @Getter
    @Path(RefinedGlowstoneMaterialDefaults.name + "BootDurability")
    @SpecIntInRange(min = 1, max = Integer.MAX_VALUE)
    @Comment("Maximum durability of " + RefinedGlowstoneMaterialDefaults.name + " boots.")
    public int bootDurability = DEFAULT.getDurability(ArmorItem.Type.BOOTS);

    @Getter
    @Path(RefinedGlowstoneMaterialDefaults.name + "LeggingDurability")
    @SpecIntInRange(min = 1, max = Integer.MAX_VALUE)
    @Comment("Maximum durability of " + RefinedGlowstoneMaterialDefaults.name + " leggings.")
    public int leggingDurability = DEFAULT.getDurability(ArmorItem.Type.LEGGINGS);

    @Getter
    @Path(RefinedGlowstoneMaterialDefaults.name + "ChestplateDurability")
    @SpecIntInRange(min = 1, max = Integer.MAX_VALUE)
    @Comment("Maximum durability of " + RefinedGlowstoneMaterialDefaults.name + " chestplates.")
    public int chestplateDurability = DEFAULT.getDurability(ArmorItem.Type.CHESTPLATE);

    @Getter
    @Path(RefinedGlowstoneMaterialDefaults.name + "HelmetDurability")
    @SpecIntInRange(min = 1, max = Integer.MAX_VALUE)
    @Comment("Maximum durability of " + RefinedGlowstoneMaterialDefaults.name + " helmets.")
    public int helmetDurability = DEFAULT.getDurability(ArmorItem.Type.HELMET);

    @Getter
    @Path(RefinedGlowstoneMaterialDefaults.name + "BootArmor")
    @SpecIntInRange(min = 0, max = Integer.MAX_VALUE)
    @Comment("Protection value of " + RefinedGlowstoneMaterialDefaults.name + " boots.")
    public int bootArmor = DEFAULT.getProtection(ArmorItem.Type.BOOTS);

    @Getter
    @Path(RefinedGlowstoneMaterialDefaults.name + "LeggingArmor")
    @SpecIntInRange(min = 0, max = Integer.MAX_VALUE)
    @Comment("Protection value of " + RefinedGlowstoneMaterialDefaults.name + " leggings.")
    public int leggingArmor = DEFAULT.getProtection(ArmorItem.Type.LEGGINGS);

    @Getter
    @Path(RefinedGlowstoneMaterialDefaults.name + "ChestplateArmor")
    @SpecIntInRange(min = 0, max = Integer.MAX_VALUE)
    @Comment("Protection value of " + RefinedGlowstoneMaterialDefaults.name + " chestplates.")
    public int chestplateArmor = DEFAULT.getProtection(ArmorItem.Type.CHESTPLATE);

    @Getter
    @Path(RefinedGlowstoneMaterialDefaults.name + "HelmetArmor")
    @SpecIntInRange(min = 0, max = Integer.MAX_VALUE)
    @Comment("Protection value of " + RefinedGlowstoneMaterialDefaults.name + " helmets.")
    public int helmetArmor = DEFAULT.getProtection(ArmorItem.Type.HELMET);

    protected RefinedGlowstone() { super(new RefinedGlowstoneMaterialDefaults()); }

    @Override
    public @Nullable TagKey<Block> getTag() { return null; }

    @Override
    public int getPaxelMiningLevel() { return 0; }

    @Override
    public int getCommonEnchantability() { return 0; }

    @Override
    public Ingredient getCommonRepairMaterial() { return null; }

    @Override
    public String getConfigCommentName() { return null; }
}
