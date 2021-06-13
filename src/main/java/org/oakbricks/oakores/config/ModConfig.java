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

    @ConfigEntry.Gui.RequiresRestart
    public float maxPurpiGenHeight = 20.0f;

    @ConfigEntry.Gui.RequiresRestart
    public float minPurpiGenHeight = 5.0f;

    @ConfigEntry.Gui.RequiresRestart
    public boolean registerPurpiBlocks = true;
}
