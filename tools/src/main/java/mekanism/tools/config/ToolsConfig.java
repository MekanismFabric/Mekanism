package mekanism.tools.config;

import com.electronwill.nightconfig.core.conversion.Path;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Comment;
import mekanism.tools.config.tools.Tools;
import mekanism.tools.config.tools.mobarmor.MobArmorSpawnRate;

@Config(name = "tools")
@Path("Mekanism")
public class ToolsConfig implements ConfigData {

    @Path("mobArmorSpawnRate")
    @ConfigEntry.Gui.CollapsibleObject
    public MobArmorSpawnRate mobArmorSpawnRate = new MobArmorSpawnRate();

    @Path("tools")
    @ConfigEntry.Gui.CollapsibleObject
    @Comment("Mekanism Tools Config. This config is synced from server to client.")
    public Tools config = new Tools();
}
