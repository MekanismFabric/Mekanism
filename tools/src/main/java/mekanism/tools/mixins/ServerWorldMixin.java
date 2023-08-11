package mekanism.tools.mixins;

import mekanism.tools.event.EntitySpawnedEvent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.server.world.ServerWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(ServerWorld.class)
public abstract class ServerWorldMixin {
    @ModifyVariable(
        at = @At("LOAD"),
        method = "spawnEntity"
    )
    public Entity triggerSpawnMobEntityEvent(Entity entity) {
        if (entity instanceof MobEntity mobEntity) {
            EntitySpawnedEvent.EVENT.invoker().onEntitySpawned(mobEntity);
        }
        return entity;
    }
}