package org.oakbricks.oakores;

import me.lortseam.completeconfig.gui.ConfigScreenBuilder;
import me.lortseam.completeconfig.gui.cloth.ClothConfigScreenBuilder;
import net.fabricmc.api.ClientModInitializer;

public class OakOresClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ConfigScreenBuilder.setMain(OakOres.MOD_ID, new ClothConfigScreenBuilder());
    }

}
