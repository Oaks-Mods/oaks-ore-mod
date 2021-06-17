/* Replaced by Lines 69 - 73 and Lines 89 - 91 in OakOres.java (Main Class) */
//
//TODO: REMOVE THIS CLASS
//
//package org.oakbricks.oakores.util;
//
//import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
//import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
//import net.fabricmc.fabric.impl.biome.modification.BiomeSelectionContextImpl;
//import net.minecraft.block.Blocks;
//import net.minecraft.util.Identifier;
//import net.minecraft.util.registry.BuiltinRegistries;
//import net.minecraft.util.registry.Registry;
//import net.minecraft.util.registry.RegistryKey;
//import net.minecraft.world.gen.GenerationStep;
//import net.minecraft.world.gen.YOffset;
//import net.minecraft.world.gen.decorator.Decorator;
//import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
//import net.minecraft.world.gen.feature.ConfiguredFeature;
//import net.minecraft.world.gen.feature.Feature;
//import net.minecraft.world.gen.feature.OreFeatureConfig;
//import net.minecraft.world.gen.heightprovider.UniformHeightProvider;
//import org.oakbricks.oakores.registry.BlockClass;
//
//import static org.oakbricks.oakores.OakOres.*;
//
//public class OreClass {
//    private static ConfiguredFeature<?, ?> PURPI_ORE_OVERWORLD = Feature.ORE
//            .configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, BlockClass.PURPI_ORE.getDefaultState(), 10))
//            .decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(UniformHeightProvider.create(YOffset.fixed("0"), YOffset.fixed("48")))))
//            .spreadHorizontally()
//            .repeat("50");
//    public static void initOres() {
//        RegistryKey<ConfiguredFeature<?, ?>> purpiOreOverworld = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier(MOD_ID, "purpi_ore_overworld"));
//        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, purpiOreOverworld.getValue(), PURPI_ORE_OVERWORLD);
//        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, purpiOreOverworld);
//    }
//}
