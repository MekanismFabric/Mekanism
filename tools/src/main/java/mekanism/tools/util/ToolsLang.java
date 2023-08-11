package mekanism.tools.util;

import mekanism.api.text.ILangEntry;
import net.minecraft.util.Util;

import static mekanism.tools.MekanismTools.id;

public enum ToolsLang implements ILangEntry {
    MEKANISM_TOOLS("constants", "mod_name"),
    PACK_DESCRIPTION("constants", "pack_description"),
    HP("tooltip", "hp");

    private final String key;

    ToolsLang(String type, String path) {
        this(Util.createTranslationKey(type, id(path)));
    }

    ToolsLang(String key) {
        this.key = key;
    }

    @Override
    public String getTranslationKey() {
        return key;
    }
}