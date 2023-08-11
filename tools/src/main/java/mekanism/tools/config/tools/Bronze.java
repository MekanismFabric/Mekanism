package mekanism.tools.config.tools;

import com.electronwill.nightconfig.core.conversion.Path;
import com.electronwill.nightconfig.core.conversion.SpecFloatInRange;
import com.electronwill.nightconfig.core.conversion.SpecIntInRange;
import lombok.Getter;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Comment;
import mekanism.tools.material.impl.BronzeMaterialDefaults;
import net.minecraft.block.Block;
import net.minecraft.item.ArmorItem;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.TagKey;
import org.jetbrains.annotations.Nullable;

public class Bronze extends AbstractMaterialConfig implements ConfigData {

    @Getter
    @Path(BronzeMaterialDefaults.name + "AttackDamage")
    @SpecFloatInRange(min = 0.0F, max = Float.MAX_VALUE)
    @Comment("Base attack damage of " + BronzeMaterialDefaults.name + " items.")
    public float attackDamage = DEFAULT.getAttackDamage();

    @Getter
    @Path(BronzeMaterialDefaults.name + "ShieldDurability")
    @SpecIntInRange(min = 0, max = Integer.MAX_VALUE)
    @Comment("Maximum durability of " + BronzeMaterialDefaults.name + " shields.")
    public int shieldDurability = DEFAULT.getShieldDurability();

    @Path(BronzeMaterialDefaults.name + "SwordDamage")
    @Comment("Attack damage modifier of " + BronzeMaterialDefaults.name + " swords.")
    public float swordDamage = DEFAULT.getSwordDamage();

    @Path(BronzeMaterialDefaults.name + "SwordAtkSpeed")
    @Comment("Attack speed of " + BronzeMaterialDefaults.name + " swords.")
    public float swordAtkSpeed = DEFAULT.getSwordAtkSpeed();

    @Path(BronzeMaterialDefaults.name + "ShovelDamage")
    @Comment("Attack damage modifier of " + BronzeMaterialDefaults.name + " shovels.")
    public float shovelDamage = DEFAULT.getShovelDamage();

    @Path(BronzeMaterialDefaults.name + "ShovelAtkSpeed")
    @Comment("Attack speed of " + BronzeMaterialDefaults.name + " shovels.")
    public float shovelAtkSpeed = DEFAULT.getShovelAtkSpeed();

    @Getter
    @Path(BronzeMaterialDefaults.name + "AxeDamage")
    @Comment("Attack damage modifier of " + BronzeMaterialDefaults.name + " axes.")
    public float axeDamage = DEFAULT.getAxeDamage();

    @Getter
    @Path(BronzeMaterialDefaults.name + "AxeAtkSpeed")
    @Comment("Attack speed of " + BronzeMaterialDefaults.name + " axes.")
    public float axeAtkSpeed = DEFAULT.getAxeAtkSpeed();

    @Path(BronzeMaterialDefaults.name + "PickaxeDamage")
    @Comment("Attack damage modifier of " + BronzeMaterialDefaults.name + " pickaxes.")
    public float pickaxeDamage = DEFAULT.getPickaxeDamage();

    @Path(BronzeMaterialDefaults.name + "PickaxeAtkSpeed")
    @Comment("Attack speed of " + BronzeMaterialDefaults.name + " pickaxes.")
    public float pickaxeAtkSpeed = DEFAULT.getPickaxeAtkSpeed();

    @Path(BronzeMaterialDefaults.name + "HoeDamage")
    @Comment("Attack damage modifier of " + BronzeMaterialDefaults.name + " hoes.")
    public float hoeDamage = DEFAULT.getPickaxeAtkSpeed();

    @Path(BronzeMaterialDefaults.name + "HoeAtkSpeed")
    @Comment("Attack speed of " + BronzeMaterialDefaults.name + " hoes.")
    public float hoeAtkSpeed = DEFAULT.getHoeAtkSpeed();

    @Getter
    @Path(BronzeMaterialDefaults.name + "ToolMaxUses")
    @SpecIntInRange(min = 1, max = Integer.MAX_VALUE)
    @Comment("Maximum durability of " + BronzeMaterialDefaults.name + " tools.")
    public int durability = DEFAULT.getDurability();

    @Getter
    @Path(BronzeMaterialDefaults.name + "Efficiency")
    @Comment("Efficiency of " + BronzeMaterialDefaults.name + " tools.")
    public float miningSpeedMultiplier = DEFAULT.getMiningSpeedMultiplier();

    @Getter
    @Path(BronzeMaterialDefaults.name + "PaxelHarvestLevel")
    @SpecIntInRange(min = 0, max = Integer.MAX_VALUE)
    @Comment("Harvest level of " + BronzeMaterialDefaults.name + " paxels.")
    public int paxelHarvestLevel = DEFAULT.getMiningLevel();

    @Getter
    @Path(BronzeMaterialDefaults.name + "PaxelDamage")
    @Comment("Attack damage modifier of " + BronzeMaterialDefaults.name + " paxels.")
    public float paxelDamage = DEFAULT.getPaxelDamage();

    @Path(BronzeMaterialDefaults.name + "PaxelAtkSpeed")
    @Comment("Attack speed of " + BronzeMaterialDefaults.name + " paxels.")
    public float paxelAtkSpeed = DEFAULT.getPaxelAtkSpeed();

    @Getter
    @Path(BronzeMaterialDefaults.name + "PaxelEfficiency")
    @Comment("Efficiency of " + BronzeMaterialDefaults.name + " paxels.")
    public float paxelEfficiency = DEFAULT.getPaxelEfficiency();

    @Getter
    @Path(BronzeMaterialDefaults.name + "PaxelEnchantability")
    @SpecIntInRange(min = 0, max = Integer.MAX_VALUE)
    @Comment("Natural enchantability factor of " + BronzeMaterialDefaults.name + " paxels.")
    public int paxelEnchantability = DEFAULT.getPaxelEnchantability();

    @Getter
    @Path(BronzeMaterialDefaults.name + "PaxelMaxUses")
    @SpecIntInRange(min = 1, max = Integer.MAX_VALUE)
    @Comment("Maximum durability of " + BronzeMaterialDefaults.name + " paxels.")
    public int paxelMaxUses = DEFAULT.getPaxelMaxUses();

    @Getter
    @Path(BronzeMaterialDefaults.name + "HarvestLevel")
    @SpecIntInRange(min = 0, max = Integer.MAX_VALUE)
    @Comment("Harvest level of " + BronzeMaterialDefaults.name + " tools.")
    public int miningLevel = DEFAULT.getMiningLevel();

    @Getter
    @Path(BronzeMaterialDefaults.name + "Enchantability")
    @SpecIntInRange(min = 0, max = Integer.MAX_VALUE)
    @Comment("Natural enchantability factor of " + BronzeMaterialDefaults.name + " items.")
    public int enchantability = DEFAULT.getEnchantability();

    @Getter
    @Path(BronzeMaterialDefaults.name + "Toughness")
    @SpecFloatInRange(min = 0.0F, max = Float.MAX_VALUE)
    @Comment("Base armor toughness value of " + BronzeMaterialDefaults.name + " armor.")
    public float toughness = DEFAULT.getToughness();

    @Getter
    @Path(BronzeMaterialDefaults.name + "KnockbackResistance")
    @SpecFloatInRange(min = 0.0F, max = Float.MAX_VALUE)
    @Comment("Base armor knockback resistance value of " + BronzeMaterialDefaults.name + " armor.")
    public float knockbackResistance = DEFAULT.getKnockbackResistance();

    @Getter
    @Path(BronzeMaterialDefaults.name + "BootDurability")
    @SpecIntInRange(min = 1, max = Integer.MAX_VALUE)
    @Comment("Maximum durability of " + BronzeMaterialDefaults.name + " boots.")
    public int bootDurability = DEFAULT.getDurability(ArmorItem.Type.BOOTS);

    @Getter
    @Path(BronzeMaterialDefaults.name + "LeggingDurability")
    @SpecIntInRange(min = 1, max = Integer.MAX_VALUE)
    @Comment("Maximum durability of " + BronzeMaterialDefaults.name + " leggings.")
    public int leggingDurability = DEFAULT.getDurability(ArmorItem.Type.LEGGINGS);

    @Getter
    @Path(BronzeMaterialDefaults.name + "ChestplateDurability")
    @SpecIntInRange(min = 1, max = Integer.MAX_VALUE)
    @Comment("Maximum durability of " + BronzeMaterialDefaults.name + " chestplates.")
    public int chestplateDurability = DEFAULT.getDurability(ArmorItem.Type.CHESTPLATE);

    @Getter
    @Path(BronzeMaterialDefaults.name + "HelmetDurability")
    @SpecIntInRange(min = 1, max = Integer.MAX_VALUE)
    @Comment("Maximum durability of " + BronzeMaterialDefaults.name + " helmets.")
    public int helmetDurability = DEFAULT.getDurability(ArmorItem.Type.HELMET);

    @Getter
    @Path(BronzeMaterialDefaults.name + "BootArmor")
    @SpecIntInRange(min = 0, max = Integer.MAX_VALUE)
    @Comment("Protection value of " + BronzeMaterialDefaults.name + " boots.")
    public int bootArmor = DEFAULT.getProtection(ArmorItem.Type.BOOTS);

    @Getter
    @Path(BronzeMaterialDefaults.name + "LeggingArmor")
    @SpecIntInRange(min = 0, max = Integer.MAX_VALUE)
    @Comment("Protection value of " + BronzeMaterialDefaults.name + " leggings.")
    public int leggingArmor = DEFAULT.getProtection(ArmorItem.Type.LEGGINGS);

    @Getter
    @Path(BronzeMaterialDefaults.name + "ChestplateArmor")
    @SpecIntInRange(min = 0, max = Integer.MAX_VALUE)
    @Comment("Protection value of " + BronzeMaterialDefaults.name + " chestplates.")
    public int chestplateArmor = DEFAULT.getProtection(ArmorItem.Type.CHESTPLATE);

    @Getter
    @Path(BronzeMaterialDefaults.name + "HelmetArmor")
    @SpecIntInRange(min = 0, max = Integer.MAX_VALUE)
    @Comment("Protection value of " + BronzeMaterialDefaults.name + " helmets.")
    public int helmetArmor = DEFAULT.getProtection(ArmorItem.Type.HELMET);

    protected Bronze() { super(new BronzeMaterialDefaults()); }

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
