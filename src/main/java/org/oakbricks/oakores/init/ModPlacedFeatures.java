package org.oakbricks.oakores.init;

import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.decorator.CountPlacementModifier;

import net.minecraft.world.gen.decorator.HeightRangePlacementModifier;
import net.minecraft.world.gen.feature.PlacedFeature;

import static org.oakbricks.oakores.OakOres.MOD_ID;

public class ModPlacedFeatures {
    public static final PlacedFeature PURPI_ORE_OVERWORLD = ModConfiguredFeatures.PURPI_ORE_OVERWORLD.withPlacement(CountPlacementModifier.of(6), HeightRangePlacementModifier.uniform(YOffset.fixed(5), YOffset.fixed(32)));
    public static final PlacedFeature LEAD_ORE_OVERWORLD = ModConfiguredFeatures.LEAD_ORE_OVERWORLD.withPlacement(CountPlacementModifier.of(25), HeightRangePlacementModifier.uniform(YOffset.getTop(), YOffset.getBottom()));
    public static final PlacedFeature DEEPSLATE_LEAD_ORE_OVERWORLD = ModConfiguredFeatures.DEEPSLATE_LEAD_ORE_OVERWORLD.withPlacement(CountPlacementModifier.of(4), HeightRangePlacementModifier.uniform(YOffset.getTop(), YOffset.getBottom()));
    public static final PlacedFeature ENDERITE_ORE_END = ModConfiguredFeatures.ENDERITE_ORE_END.withPlacement(CountPlacementModifier.of(8), HeightRangePlacementModifier.uniform(YOffset.getTop(), YOffset.getBottom()));

    public static final void registerPlacedFeatures() {
        Registry.register(BuiltinRegistries.PLACED_FEATURE, new Identifier(MOD_ID, "purpi_ore_overworld"), PURPI_ORE_OVERWORLD);
        Registry.register(BuiltinRegistries.PLACED_FEATURE, new Identifier(MOD_ID, "lead_ore_overworld"), LEAD_ORE_OVERWORLD);
        Registry.register(BuiltinRegistries.PLACED_FEATURE, new Identifier(MOD_ID, "deepslate_lead_ore_overworld"), DEEPSLATE_LEAD_ORE_OVERWORLD);
        Registry.register(BuiltinRegistries.PLACED_FEATURE, new Identifier(MOD_ID, "enderite_ore_end"), ENDERITE_ORE_END);
    }
}
