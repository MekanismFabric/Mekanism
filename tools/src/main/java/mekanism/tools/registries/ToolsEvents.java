package mekanism.tools.registries;

import mekanism.tools.MekanismTools;
import mekanism.tools.config.tools.mobarmor.ISpawnChance;
import mekanism.tools.event.EntitySpawnedEvent;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.PiglinEntity;
import net.minecraft.entity.mob.SkeletonEntity;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.random.Random;

public class ToolsEvents {

    public static void register() {
        EntitySpawnedEvent.EVENT.register(ToolsEvents::onEntitySpawned);
    }

    private static void onEntitySpawned(MobEntity entity) {
        if (entity instanceof ZombieEntity || entity instanceof SkeletonEntity || entity instanceof PiglinEntity) {
            //Don't bother calculating random numbers unless the instanceof checks pass
            Random random = entity.getWorld().getRandom();
            double chance = random.nextDouble();
            if (chance < MekanismTools.config().mobArmorSpawnRate.general) {
                //We can only spawn refined glowstone armor on piglins
                int armorType = entity instanceof PiglinEntity ? 0 : random.nextInt(6);

                if (armorType == 0) {
                    setEntityArmorWithChance(random, entity, ToolsItems.REFINED_GLOWSTONE_SWORD, ToolsItems.REFINED_GLOWSTONE_HELMET, ToolsItems.REFINED_GLOWSTONE_CHESTPLATE,
                            ToolsItems.REFINED_GLOWSTONE_LEGGINGS, ToolsItems.REFINED_GLOWSTONE_BOOTS, MekanismTools.config().mobArmorSpawnRate.refinedGlowstone);
                } else if (armorType == 1) {
                    setEntityArmorWithChance(random, entity, ToolsItems.LAPIS_LAZULI_SWORD, ToolsItems.LAPIS_LAZULI_HELMET, ToolsItems.LAPIS_LAZULI_CHESTPLATE,
                            ToolsItems.LAPIS_LAZULI_LEGGINGS, ToolsItems.LAPIS_LAZULI_BOOTS, MekanismTools.config().mobArmorSpawnRate.lapisLazuli);
                } else if (armorType == 2) {
                    setEntityArmorWithChance(random, entity, ToolsItems.REFINED_OBSIDIAN_SWORD, ToolsItems.REFINED_OBSIDIAN_HELMET, ToolsItems.REFINED_OBSIDIAN_CHESTPLATE,
                            ToolsItems.REFINED_OBSIDIAN_LEGGINGS, ToolsItems.REFINED_OBSIDIAN_BOOTS, MekanismTools.config().mobArmorSpawnRate.refinedObsidian);
                } else if (armorType == 3) {
                    setEntityArmorWithChance(random, entity, ToolsItems.STEEL_SWORD, ToolsItems.STEEL_HELMET, ToolsItems.STEEL_CHESTPLATE, ToolsItems.STEEL_LEGGINGS,
                            ToolsItems.STEEL_BOOTS, MekanismTools.config().mobArmorSpawnRate.steel);
                } else if (armorType == 4) {
                    setEntityArmorWithChance(random, entity, ToolsItems.BRONZE_SWORD, ToolsItems.BRONZE_HELMET, ToolsItems.BRONZE_CHESTPLATE, ToolsItems.BRONZE_LEGGINGS,
                            ToolsItems.BRONZE_BOOTS, MekanismTools.config().mobArmorSpawnRate.bronze);
                } else {//armorType == 5
                    setEntityArmorWithChance(random, entity, ToolsItems.OSMIUM_SWORD, ToolsItems.OSMIUM_HELMET, ToolsItems.OSMIUM_CHESTPLATE, ToolsItems.OSMIUM_LEGGINGS,
                            ToolsItems.OSMIUM_BOOTS, MekanismTools.config().mobArmorSpawnRate.osmium);
                }
            }
        }
    }

    private static void setStackIfEmpty(LivingEntity entity, EquipmentSlot slot, ItemStack item) {
        if (entity.getEquippedStack(slot).isEmpty()) {
            entity.equipStack(slot, item);
        }
    }

    private static void setEntityArmorWithChance(Random random, LivingEntity entity, ItemConvertible sword, ItemConvertible helmet, ItemConvertible chestplate, ItemConvertible leggings, ItemConvertible boots, ISpawnChance chanceConfig) {
        if (entity instanceof ZombieEntity && random.nextDouble() < chanceConfig.getSwordChance()) {
            setStackIfEmpty(entity, EquipmentSlot.MAINHAND, new ItemStack(sword));
        }
        if (random.nextDouble() < chanceConfig.getHelmetChance()) {
            setStackIfEmpty(entity, EquipmentSlot.HEAD, new ItemStack(helmet));
        }
        if (random.nextDouble() < chanceConfig.getChestplateChance()) {
            setStackIfEmpty(entity, EquipmentSlot.CHEST, new ItemStack(chestplate));
        }
        if (random.nextDouble() < chanceConfig.getLeggingsChance()) {
            setStackIfEmpty(entity, EquipmentSlot.LEGS, new ItemStack(leggings));
        }
        if (random.nextDouble() < chanceConfig.getBootsChance()) {
            setStackIfEmpty(entity, EquipmentSlot.FEET, new ItemStack(boots));
        }
    }
}
