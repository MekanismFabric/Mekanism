package mekanism.api.text;

import net.minecraft.text.MutableText;
import net.minecraft.text.Text;

public interface ILangEntry extends IHasTranslationKey {

    /**
     * Translates this {@link ILangEntry} using a "smart" replacement scheme to allow for automatic replacements, and coloring to take place.
     */
    default MutableText translate(Object... args) {
        return TextComponentUtil.smartTranslate(getTranslationKey(), args);
    }

    /**
     * Translates this {@link ILangEntry} and applies the {@link net.minecraft.text.TextColor} of the given {@link EnumColor} to the {@link Text}.
     */
    default MutableText translateColored(EnumColor color, Object... args) {
        return TextComponentUtil.build(color, translate(args));
    }
}
