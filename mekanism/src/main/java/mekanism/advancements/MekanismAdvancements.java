package mekanism.advancements;

import org.jetbrains.annotations.Nullable;

import static mekanism.Mekanism.id;

public class MekanismAdvancements {

    private static MekanismAdvancement advancement(@Nullable MekanismAdvancement parent, String name) {
        return new MekanismAdvancement(parent, id(name));
    }

    public static final MekanismAdvancement ROOT = advancement(null, "root");
    public static final MekanismAdvancement MATERIALS = advancement(ROOT, "materials");
}
