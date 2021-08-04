package org.oakbricks.oakores.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import org.oakbricks.oakores.OakOres;

@Config(name = OakOres.MOD_ID + "_config")
@Config.Gui.Background("minecraft:textures/block/oak_planks.png")
public class ModConfig implements ConfigData {

    @ConfigEntry.Gui.RequiresRestart
    public boolean enableEnderite = true;

    @ConfigEntry.Gui.RequiresRestart
    public boolean enableNetherOres = true;

    @ConfigEntry.Gui.RequiresRestart
    public int purpiOreGenRetries = 10;

    @ConfigEntry.Gui.RequiresRestart
    public int maxPurpiGenHeight = 28;

    @ConfigEntry.Gui.RequiresRestart
    public int purpiMinHeight = 5;

    @ConfigEntry.Gui.RequiresRestart
    public int leadOreGenRetries = 25;

    @ConfigEntry.Gui.RequiresRestart
    public int maxLeadGenHeight = 256;

    //@ConfigEntry.Gui.Excluded
    @ConfigEntry.Gui.RequiresRestart
    public int minLeadGenHeight = 0;

    @ConfigEntry.Gui.Excluded
    @ConfigEntry.Gui.RequiresRestart
    public boolean enableDebugFeatures = false;



    @ConfigEntry.Gui.Excluded
    @ConfigEntry.Gui.RequiresRestart
    public boolean enableUnsupportedFeatures = false;

}
