package mekanism.tools.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

@Config(name = "client")
public class ToolsClientConfig implements ConfigData {

    @ConfigEntry.Gui.TransitiveObject
    boolean displayDurabilityTooltips = false;

    public boolean getDisplayDurabilityTooltips() {
        return displayDurabilityTooltips;
    }
}
