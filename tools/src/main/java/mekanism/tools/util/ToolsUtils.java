package mekanism.tools.util;

import me.shedaniel.autoconfig.AutoConfig;
import mekanism.tools.config.MekanismToolsConfig;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ToolsUtils {

    public static void addDurability(@NotNull List<Text> tooltip, @NotNull ItemStack stack) {
        MekanismToolsConfig config = AutoConfig.getConfigHolder(MekanismToolsConfig.class).getConfig();

        if (config.clientConfig.getDisplayDurabilityTooltips()) {
            tooltip.add(ToolsLang.HP.translate(stack.getMaxDamage() - stack.getDamage()));
        }
    }
}
