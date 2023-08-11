package mekanism.advancements.triggers;

import com.google.gson.JsonObject;
import net.minecraft.advancement.criterion.AbstractCriterion;
import net.minecraft.advancement.criterion.AbstractCriterionConditions;
import net.minecraft.predicate.entity.AdvancementEntityPredicateDeserializer;
import net.minecraft.predicate.entity.LootContextPredicate;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;

import java.util.function.Predicate;

import static mekanism.Mekanism.id;

public class LoggedInCriterion extends AbstractCriterion<LoggedInCriterion.Condition> {

    public static final Identifier ID = id("logged_in");

    @Override
    public Identifier getId() {
        return ID;
    }

    @Override
    public void trigger(ServerPlayerEntity player, Predicate predicate) {
        super.trigger(player, predicate);
    }

    @Override
    public Condition conditionsFromJson(JsonObject obj, LootContextPredicate playerPredicate, AdvancementEntityPredicateDeserializer predicateDeserializer) {
        return new Condition();
    }

    public static class Condition extends AbstractCriterionConditions {
        public Condition() {
            super(ID, LootContextPredicate.EMPTY);
        }
    }
}
