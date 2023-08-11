package mekanism.advancements;

import net.minecraft.advancement.Advancement;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import org.jetbrains.annotations.Nullable;

public record MekanismAdvancement(Identifier name, String title, String description, @Nullable MekanismAdvancement parent) {

    public MekanismAdvancement(@Nullable MekanismAdvancement parent, Identifier name) {
        this(parent, name, getSubName(name.getPath()));
    }

    public MekanismAdvancement(@Nullable MekanismAdvancement parent, Identifier name, String subName) {
        this(name, subName, subName, parent);
    }

    public MekanismAdvancement {
        title = Util.createTranslationKey("advancements", new Identifier(name.getNamespace(), title + ".title"));
        description = Util.createTranslationKey("advancements", new Identifier(name.getNamespace(), description + ".description"));
    }

    public Advancement parentAsAdvancement() {
        if (null != parent) {
            return Advancement.Builder.create().build(parent.name);
        }
        return null;
    }

    private static String getSubName(String path) {
        int lastSeparator = path.lastIndexOf('/');
        if (lastSeparator == -1) {
            return path;
        } else if (lastSeparator + 1 == path.length()) {
            throw new IllegalArgumentException("Unexpected name portion.");
        }
        return path.substring(lastSeparator + 1);
    }
}