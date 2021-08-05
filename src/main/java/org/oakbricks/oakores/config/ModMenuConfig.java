package org.oakbricks.oakores.config;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import me.shedaniel.autoconfig.AutoConfig;
import com.terraformersmc.modmenu.api.ModMenuApi;

public class ModMenuConfig implements ModMenuApi {

    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return parent -> AutoConfig.getConfigScreen(ModConfig.class, parent).get();
    }

}
