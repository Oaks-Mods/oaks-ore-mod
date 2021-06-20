package org.oakbricks.oakores;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import org.oakbricks.oakores.registry.BlockClass;

public class OakOresClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> 0x444f53, BlockClass.LEAD_BLOCK);

    }

}
