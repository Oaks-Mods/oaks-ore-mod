package org.oakbricks.oakores.init;

import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.decorator.CountPlacementModifier;
import net.minecraft.world.gen.decorator.HeightRangePlacementModifier;
import net.minecraft.world.gen.feature.PlacedFeature;

public class ModPlacedFeatures {
    public static final PlacedFeature PURPI_ORE_OVERWORLD = ModConfiguredFeatures.PURPI_ORE_OVERWORLD.withPlacement(CountPlacementModifier.of(10), HeightRangePlacementModifier.uniform(YOffset.fixed(5), YOffset.fixed(28)));
}
