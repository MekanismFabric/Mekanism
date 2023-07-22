package mekanism.tools.event;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.entity.mob.MobEntity;

public class EntitySpawnedEvent {
    public static Event<EntitySpawned> EVENT = EventFactory.createArrayBacked(EntitySpawned.class,
        (listeners) -> (entity) -> {
            for (EntitySpawned callback : listeners) {
                callback.onEntitySpawned(entity);
            }
        }
    );

    @FunctionalInterface
    public interface EntitySpawned {
        void onEntitySpawned(MobEntity entity);
    }
}
