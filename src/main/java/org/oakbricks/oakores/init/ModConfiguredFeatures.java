package org.oakbricks.oakores.init;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.block.Blocks;
import net.minecraft.client.util.GlfwUtil;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.heightprovider.UniformHeightProvider;
import org.oakbricks.oakores.OakOres;

import static org.oakbricks.oakores.OakOres.MOD_ID;

public class ModConfiguredFeatures {
//    public static ConfiguredFeature<?, ?> PURPI_ORE_OVERWORLD = Feature.ORE
//            .configure(new OreFeatureConfig(OreConfiguredFeatures.BASE_STONE_OVERWORLD, ModBlocks.PURPI_ORE.getDefaultState(), OakOres.CONFIG.purpiVeinSize))
//            .decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(UniformHeightProvider.create(YOffset.fixed(OakOres.CONFIG.purpiMinHeight), YOffset.fixed(OakOres.CONFIG.purpiMaxHeight))))) /* TODO: Make this configurable */
//            .spreadHorizontally()
//            .repeat(OakOres.CONFIG.purpiAmount);
    public static final ConfiguredFeature<?, ?> PURPI_ORE_OVERWORLD = Feature.ORE.configure(new OreFeatureConfig(OreConfiguredFeatures.BASE_STONE_OVERWORLD, ModBlocks.PURPI_ORE.getDefaultState(), 10));

    public static final ConfiguredFeature<?, ?> LEAD_ORE_OVERWORLD = Feature.ORE.configure(new OreFeatureConfig(OreConfiguredFeatures.BASE_STONE_OVERWORLD, ModBlocks.LEAD_ORE.getDefaultState(), 16));

//    //LEAD ORE WORLD GEN
//    public static ConfiguredFeature<?, ?> LEAD_ORE_OVERWORLD = Feature.ORE
//            .configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, ModBlocks.LEAD_ORE.getDefaultState(), OakOres.CONFIG.leadVeinSize))
//            .decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(UniformHeightProvider.create(YOffset.aboveBottom(0), YOffset.fixed(OakOres.CONFIG.leadMaxHeight)))))
//            .spreadHorizontally()
//            .repeat(OakOres.CONFIG.leadAmount);
//
//    //DEEPSLATE LEAD ORE
//    public static ConfiguredFeature<?, ?> LEAD_DEEPSLATE_ORE_OVERWORLD = Feature.ORE
//            .configure(new OreFeatureConfig(
//                    new BlockMatchRuleTest(Blocks.DEEPSLATE), // base block is endstone in the end biomes
//                    ModBlocks.DEEPSLATE_LEAD_ORE.getDefaultState(),
//                    OakOres.CONFIG.deepLeadVeinSize))
//            .decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(UniformHeightProvider.create(YOffset.aboveBottom(0), YOffset.belowTop(0))))
//                    .spreadHorizontally()
//                    .repeat(OakOres.CONFIG.deepLeadAmount));
//
//    public static ConfiguredFeature<?, ?> ENDERITE_ORE_END = Feature.ORE
//            .configure(new OreFeatureConfig(
//                    new BlockMatchRuleTest(Blocks.END_STONE), // Base block is end stone in The End biomes
//                    ModBlocks.ENDERITE_ORE.getDefaultState(),
//                    OakOres.CONFIG.enderiteVeinSize))
//            .range(new RangeDecoratorConfig(
//                    UniformHeightProvider.create(YOffset.aboveBottom(0), YOffset.belowTop(0))))
//            .spreadHorizontally()
//            .repeat(OakOres.CONFIG.enderiteAmount);

    public static void registerConfiguredFeatures() {
//        //Registers Purpi Ore world gen
//        RegistryKey<ConfiguredFeature<?, ?>> purpiOreOverworld = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier(MOD_ID, "purpi_ore_overworld"));
//        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, purpiOreOverworld.getValue(), PURPI_ORE_OVERWORLD);
//        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, purpiOreOverworld);
//
//        RegistryKey<ConfiguredFeature<?, ?>> leadOreOverworld = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier(MOD_ID, "lead_ore_overworld"));
//        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, leadOreOverworld.getValue(), LEAD_ORE_OVERWORLD);
//        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, leadOreOverworld);
//
//        RegistryKey<ConfiguredFeature<?, ?>> oreDeepslateLeadOverWorld = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY,
//                new Identifier(MOD_ID, "lead_ore_deepslate_overworld"));
//        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, oreDeepslateLeadOverWorld.getValue(), LEAD_DEEPSLATE_ORE_OVERWORLD);
//        BiomeModifications.addFeature(BiomeSelectors.foundInTheEnd(), GenerationStep.Feature.UNDERGROUND_ORES, oreDeepslateLeadOverWorld);
//
//        if (!(OakOres.CONFIG.enableEnderite == false || FabricLoader.getInstance().isModLoaded("enderitemod") == true && OakOres.CONFIG.forceEnableEnderite == false)) {
//            RegistryKey<ConfiguredFeature<?, ?>> enderiteOreEnd = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY,
//                    new Identifier(MOD_ID, "enderite_ore_end"));
//            Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, enderiteOreEnd.getValue(), ENDERITE_ORE_END);
//            BiomeModifications.addFeature(BiomeSelectors.foundInTheEnd(), GenerationStep.Feature.UNDERGROUND_ORES, enderiteOreEnd);
//        } else if (OakOres.CONFIG.enableEnderite == false || FabricLoader.getInstance().isModLoaded("enderitemod") == true && OakOres.CONFIG.forceEnableEnderite == false) {
//            OakOres.LOGGER.warn("Oak Ores has tried to enable enderite ores, this warning is here because other mods providing enderite have been found or enderite support has been disabled!");
//        } else {
//            OakOres.LOGGER.fatal("Oak's Ore Mod has encountered an error whilst loading enderite ore generation, please go to the Oak's Mods Discord Server at https://discord.com/invite/DHEQZqhEyf");
//            GlfwUtil.makeJvmCrash();
//        }
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(MOD_ID, "purpi_ore_overworld"), PURPI_ORE_OVERWORLD);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(MOD_ID, "lead_ore_overworld"), LEAD_ORE_OVERWORLD);

        Registry.register(BuiltinRegistries.PLACED_FEATURE, new Identifier(MOD_ID, "lead_ore_overworld"), LEAD_ORE_OVERWORLD.withPlacement());
    }
}
