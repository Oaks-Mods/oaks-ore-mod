package org.oakbricks.oakores;

import me.lortseam.completeconfig.api.ConfigContainer;
import me.lortseam.completeconfig.api.ConfigEntries;
import me.lortseam.completeconfig.data.Config;

public final class Settings extends Config implements ConfigContainer {

    Settings() {
        super(OakOres.MOD_ID);
    }
    @Transitive
    @ConfigEntries

}
