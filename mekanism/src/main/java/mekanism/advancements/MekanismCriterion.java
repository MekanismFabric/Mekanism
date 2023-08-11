package mekanism.advancements;

import mekanism.advancements.triggers.LoggedInCriterion;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.minecraft.advancement.criterion.Criteria;

public class MekanismCriterion {

    public static LoggedInCriterion LOGGED_IN = Criteria.register(new LoggedInCriterion());

    public static void init() {
        ServerPlayConnectionEvents.JOIN.register(((handler, sender, server) -> {
            if (handler.player != null) {
                LOGGED_IN.trigger(handler.player, o -> true);
            }
        }));
    }
}
