package org.oakbricks.oakores.init;

import net.minecraft.block.Blocks;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreConfiguredFeatures;
import net.minecraft.world.gen.feature.OreFeatureConfig;

import static org.oakbricks.oakores.OakOres.MOD_ID;

public class ModConfiguredFeatures {

    public static final ConfiguredFeature<?, ?> PURPI_ORE_OVERWORLD = Feature.ORE.configure(new OreFeatureConfig(OreConfiguredFeatures.BASE_STONE_OVERWORLD, ModBlocks.PURPI_ORE.getDefaultState(), 10));

    public static final ConfiguredFeature<?, ?> LEAD_ORE_OVERWORLD = Feature.ORE.configure(new OreFeatureConfig(OreConfiguredFeatures.BASE_STONE_OVERWORLD, ModBlocks.LEAD_ORE.getDefaultState(), 16));
    public static final ConfiguredFeature<?, ?> DEEPSLATE_LEAD_ORE_OVERWORLD = Feature.ORE.configure(new OreFeatureConfig(OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_LEAD_ORE.getDefaultState(), 9));
    public static final ConfiguredFeature<?, ?> ENDERITE_ORE_END = Feature.ORE.configure(new OreFeatureConfig(new BlockMatchRuleTest(Blocks.END_STONE), ModBlocks.ENDERITE_ORE.getDefaultState(), 5));

    public static void registerConfiguredFeatures() {
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(MOD_ID, "purpi_ore_overworld"), PURPI_ORE_OVERWORLD);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(MOD_ID, "lead_ore_overworld"), LEAD_ORE_OVERWORLD);
    }
}
