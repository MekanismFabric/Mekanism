package mekanism.tools.config.tools;

import com.electronwill.nightconfig.core.conversion.Path;
import com.electronwill.nightconfig.core.conversion.SpecFloatInRange;
import com.electronwill.nightconfig.core.conversion.SpecIntInRange;
import lombok.Getter;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Comment;
import mekanism.tools.material.impl.OsmiumMaterialDefaults;
import net.minecraft.block.Block;
import net.minecraft.item.ArmorItem;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.TagKey;
import org.jetbrains.annotations.Nullable;

public class Osmium extends AbstractMaterialConfig implements ConfigData {

    @Getter
    @Path(OsmiumMaterialDefaults.name + "AttackDamage")
    @SpecFloatInRange(min = 0.0F, max = Float.MAX_VALUE)
    @Comment("Base attack damage of " + OsmiumMaterialDefaults.name + " items.")
    public float attackDamage = DEFAULT.getAttackDamage();

    @Getter
    @Path(OsmiumMaterialDefaults.name + "ShieldDurability")
    @SpecIntInRange(min = 0, max = Integer.MAX_VALUE)
    @Comment("Maximum durability of " + OsmiumMaterialDefaults.name + " shields.")
    public int shieldDurability = DEFAULT.getShieldDurability();

    @Path(OsmiumMaterialDefaults.name + "SwordDamage")
    @Comment("Attack damage modifier of " + OsmiumMaterialDefaults.name + " swords.")
    public float swordDamage = DEFAULT.getSwordDamage();

    @Path(OsmiumMaterialDefaults.name + "SwordAtkSpeed")
    @Comment("Attack speed of " + OsmiumMaterialDefaults.name + " swords.")
    public float swordAtkSpeed = DEFAULT.getSwordAtkSpeed();

    @Path(OsmiumMaterialDefaults.name + "ShovelDamage")
    @Comment("Attack damage modifier of " + OsmiumMaterialDefaults.name + " shovels.")
    public float shovelDamage = DEFAULT.getShovelDamage();

    @Path(OsmiumMaterialDefaults.name + "ShovelAtkSpeed")
    @Comment("Attack speed of " + OsmiumMaterialDefaults.name + " shovels.")
    public float shovelAtkSpeed = DEFAULT.getShovelAtkSpeed();

    @Getter
    @Path(OsmiumMaterialDefaults.name + "AxeDamage")
    @Comment("Attack damage modifier of " + OsmiumMaterialDefaults.name + " axes.")
    public float axeDamage = DEFAULT.getAxeDamage();

    @Getter
    @Path(OsmiumMaterialDefaults.name + "AxeAtkSpeed")
    @Comment("Attack speed of " + OsmiumMaterialDefaults.name + " axes.")
    public float axeAtkSpeed = DEFAULT.getAxeAtkSpeed();

    @Path(OsmiumMaterialDefaults.name + "PickaxeDamage")
    @Comment("Attack damage modifier of " + OsmiumMaterialDefaults.name + " pickaxes.")
    public float pickaxeDamage = DEFAULT.getPickaxeDamage();

    @Path(OsmiumMaterialDefaults.name + "PickaxeAtkSpeed")
    @Comment("Attack speed of " + OsmiumMaterialDefaults.name + " pickaxes.")
    public float pickaxeAtkSpeed = DEFAULT.getPickaxeAtkSpeed();

    @Path(OsmiumMaterialDefaults.name + "HoeDamage")
    @Comment("Attack damage modifier of " + OsmiumMaterialDefaults.name + " hoes.")
    public float hoeDamage = DEFAULT.getPickaxeAtkSpeed();

    @Path(OsmiumMaterialDefaults.name + "HoeAtkSpeed")
    @Comment("Attack speed of " + OsmiumMaterialDefaults.name + " hoes.")
    public float hoeAtkSpeed = DEFAULT.getHoeAtkSpeed();

    @Getter
    @Path(OsmiumMaterialDefaults.name + "ToolMaxUses")
    @SpecIntInRange(min = 1, max = Integer.MAX_VALUE)
    @Comment("Maximum durability of " + OsmiumMaterialDefaults.name + " tools.")
    public int durability = DEFAULT.getDurability();

    @Getter
    @Path(OsmiumMaterialDefaults.name + "Efficiency")
    @Comment("Efficiency of " + OsmiumMaterialDefaults.name + " tools.")
    public float miningSpeedMultiplier = DEFAULT.getMiningSpeedMultiplier();

    @Getter
    @Path(OsmiumMaterialDefaults.name + "PaxelHarvestLevel")
    @SpecIntInRange(min = 0, max = Integer.MAX_VALUE)
    @Comment("Harvest level of " + OsmiumMaterialDefaults.name + " paxels.")
    public int paxelHarvestLevel = DEFAULT.getMiningLevel();

    @Getter
    @Path(OsmiumMaterialDefaults.name + "PaxelDamage")
    @Comment("Attack damage modifier of " + OsmiumMaterialDefaults.name + " paxels.")
    public float paxelDamage = DEFAULT.getPaxelDamage();

    @Path(OsmiumMaterialDefaults.name + "PaxelAtkSpeed")
    @Comment("Attack speed of " + OsmiumMaterialDefaults.name + " paxels.")
    public float paxelAtkSpeed = DEFAULT.getPaxelAtkSpeed();

    @Getter
    @Path(OsmiumMaterialDefaults.name + "PaxelEfficiency")
    @Comment("Efficiency of " + OsmiumMaterialDefaults.name + " paxels.")
    public float paxelEfficiency = DEFAULT.getPaxelEfficiency();

    @Getter
    @Path(OsmiumMaterialDefaults.name + "PaxelEnchantability")
    @SpecIntInRange(min = 0, max = Integer.MAX_VALUE)
    @Comment("Natural enchantability factor of " + OsmiumMaterialDefaults.name + " paxels.")
    public int paxelEnchantability = DEFAULT.getPaxelEnchantability();

    @Getter
    @Path(OsmiumMaterialDefaults.name + "PaxelMaxUses")
    @SpecIntInRange(min = 1, max = Integer.MAX_VALUE)
    @Comment("Maximum durability of " + OsmiumMaterialDefaults.name + " paxels.")
    public int paxelMaxUses = DEFAULT.getPaxelMaxUses();

    @Getter
    @Path(OsmiumMaterialDefaults.name + "HarvestLevel")
    @SpecIntInRange(min = 0, max = Integer.MAX_VALUE)
    @Comment("Harvest level of " + OsmiumMaterialDefaults.name + " tools.")
    public int miningLevel = DEFAULT.getMiningLevel();

    @Getter
    @Path(OsmiumMaterialDefaults.name + "Enchantability")
    @SpecIntInRange(min = 0, max = Integer.MAX_VALUE)
    @Comment("Natural enchantability factor of " + OsmiumMaterialDefaults.name + " items.")
    public int enchantability = DEFAULT.getEnchantability();

    @Getter
    @Path(OsmiumMaterialDefaults.name + "Toughness")
    @SpecFloatInRange(min = 0.0F, max = Float.MAX_VALUE)
    @Comment("Base armor toughness value of " + OsmiumMaterialDefaults.name + " armor.")
    public float toughness = DEFAULT.getToughness();

    @Getter
    @Path(OsmiumMaterialDefaults.name + "KnockbackResistance")
    @SpecFloatInRange(min = 0.0F, max = Float.MAX_VALUE)
    @Comment("Base armor knockback resistance value of " + OsmiumMaterialDefaults.name + " armor.")
    public float knockbackResistance = DEFAULT.getKnockbackResistance();

    @Getter
    @Path(OsmiumMaterialDefaults.name + "BootDurability")
    @SpecIntInRange(min = 1, max = Integer.MAX_VALUE)
    @Comment("Maximum durability of " + OsmiumMaterialDefaults.name + " boots.")
    public int bootDurability = DEFAULT.getDurability(ArmorItem.Type.BOOTS);

    @Getter
    @Path(OsmiumMaterialDefaults.name + "LeggingDurability")
    @SpecIntInRange(min = 1, max = Integer.MAX_VALUE)
    @Comment("Maximum durability of " + OsmiumMaterialDefaults.name + " leggings.")
    public int leggingDurability = DEFAULT.getDurability(ArmorItem.Type.LEGGINGS);

    @Getter
    @Path(OsmiumMaterialDefaults.name + "ChestplateDurability")
    @SpecIntInRange(min = 1, max = Integer.MAX_VALUE)
    @Comment("Maximum durability of " + OsmiumMaterialDefaults.name + " chestplates.")
    public int chestplateDurability = DEFAULT.getDurability(ArmorItem.Type.CHESTPLATE);

    @Getter
    @Path(OsmiumMaterialDefaults.name + "HelmetDurability")
    @SpecIntInRange(min = 1, max = Integer.MAX_VALUE)
    @Comment("Maximum durability of " + OsmiumMaterialDefaults.name + " helmets.")
    public int helmetDurability = DEFAULT.getDurability(ArmorItem.Type.HELMET);

    @Getter
    @Path(OsmiumMaterialDefaults.name + "BootArmor")
    @SpecIntInRange(min = 0, max = Integer.MAX_VALUE)
    @Comment("Protection value of " + OsmiumMaterialDefaults.name + " boots.")
    public int bootArmor = DEFAULT.getProtection(ArmorItem.Type.BOOTS);

    @Getter
    @Path(OsmiumMaterialDefaults.name + "LeggingArmor")
    @SpecIntInRange(min = 0, max = Integer.MAX_VALUE)
    @Comment("Protection value of " + OsmiumMaterialDefaults.name + " leggings.")
    public int leggingArmor = DEFAULT.getProtection(ArmorItem.Type.LEGGINGS);

    @Getter
    @Path(OsmiumMaterialDefaults.name + "ChestplateArmor")
    @SpecIntInRange(min = 0, max = Integer.MAX_VALUE)
    @Comment("Protection value of " + OsmiumMaterialDefaults.name + " chestplates.")
    public int chestplateArmor = DEFAULT.getProtection(ArmorItem.Type.CHESTPLATE);

    @Getter
    @Path(OsmiumMaterialDefaults.name + "HelmetArmor")
    @SpecIntInRange(min = 0, max = Integer.MAX_VALUE)
    @Comment("Protection value of " + OsmiumMaterialDefaults.name + " helmets.")
    public int helmetArmor = DEFAULT.getProtection(ArmorItem.Type.HELMET);

    protected Osmium() { super(new OsmiumMaterialDefaults()); }

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
