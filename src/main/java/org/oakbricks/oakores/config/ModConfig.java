package org.oakbricks.oakores.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import org.oakbricks.oakores.OakOres;

@Config(name = OakOres.MOD_ID)
@Config.Gui.Background("minecraft:textures/block/oak_planks.png")
public class ModConfig implements ConfigData {

    @ConfigEntry.Gui.RequiresRestart
    public boolean generatePurpi = true;

    @ConfigEntry.Gui.Excluded
    @ConfigEntry.Gui.RequiresRestart
    public int maxPurpiGenHeight = (int) 25.5;

    @ConfigEntry.Gui.Excluded
    @ConfigEntry.Gui.RequiresRestart
    public int minPurpiGenHeight = (int) 5.0;

    @ConfigEntry.Gui.RequiresRestart
    public boolean enableUnsupportedFeatures = true;
}
