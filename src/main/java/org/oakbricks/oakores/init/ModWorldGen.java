package org.oakbricks.oakores.init;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.block.Blocks;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.heightprovider.UniformHeightProvider;
import org.oakbricks.oakores.OakOres;

import static org.oakbricks.oakores.OakOres.MOD_ID;

public class ModWorldGen {
    public static ConfiguredFeature<?, ?> PURPI_ORE_OVERWORLD = Feature.ORE
            .configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, ModBlocks.PURPI_ORE.getDefaultState(), 6)) /* TODO: Make this configurable */
            .decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(UniformHeightProvider.create(YOffset.fixed(Integer.parseInt("5")), YOffset.fixed(Integer.parseInt("28")))))) /* TODO: Make this configurable */
            .spreadHorizontally()
            .repeat(Integer.parseInt("10")); //TODO: Make this configurable

    //LEAD ORE WORLD GEN
    public static ConfiguredFeature<?, ?> LEAD_ORE_OVERWORLD = Feature.ORE
            .configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, ModBlocks.LEAD_ORE.getDefaultState(), 6)) /* TODO: Make this configurable */
            .decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(UniformHeightProvider.create(YOffset.fixed(Integer.parseInt("0")), YOffset.fixed(Integer.parseInt("48")))))) /* TODO: Make this configurable */
            .spreadHorizontally()
            .repeat(Integer.parseInt("25")); //TODO: Make this configurable

    //DEEPSLATE LEAD ORE
    public static ConfiguredFeature<?, ?> LEAD_DEEPSLATE_ORE_OVERWORLD = Feature.ORE
            .configure(new OreFeatureConfig(
                    new BlockMatchRuleTest(Blocks.DEEPSLATE), // base block is endstone in the end biomes
                    ModBlocks.DEEPSLATE_LEAD_ORE.getDefaultState(),
                    OakOres.CONFIG.deepslateLeadAmount))
            .decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(UniformHeightProvider.create(YOffset.fixed(Integer.parseInt("0")), YOffset.fixed(Integer.parseInt("48")))))
                    .spreadHorizontally()
                    .repeat(OakOres.CONFIG.deepslateLeadAmount));

    public static void registerWorldGenFeatures() {
        //Registers Purpi Ore world gen
        RegistryKey<ConfiguredFeature<?, ?>> purpiOreOverworld = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier(MOD_ID, "purpi_ore_overworld"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, purpiOreOverworld.getValue(), PURPI_ORE_OVERWORLD);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, purpiOreOverworld);

        RegistryKey<ConfiguredFeature<?, ?>> leadOreOverworld = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier(MOD_ID, "lead_ore_overworld"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, leadOreOverworld.getValue(), LEAD_ORE_OVERWORLD);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, leadOreOverworld);

        RegistryKey<ConfiguredFeature<?, ?>> oreDeepslateLeadOverWorld = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY,
                new Identifier(MOD_ID, "lead_ore_deepslate_overworld"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, oreDeepslateLeadOverWorld.getValue(), LEAD_DEEPSLATE_ORE_OVERWORLD);
        BiomeModifications.addFeature(BiomeSelectors.foundInTheEnd(), GenerationStep.Feature.UNDERGROUND_ORES, oreDeepslateLeadOverWorld);
    }
}
