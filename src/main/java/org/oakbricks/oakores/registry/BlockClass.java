package org.oakbricks.oakores.registry;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.MapColor;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.tag.ItemTags;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import org.oakbricks.oakores.blocks.LeadOre;
import org.oakbricks.oakores.blocks.PurpiOre;

//import static org.oakbricks.oakores.OakOres.CONFIG;
import static org.oakbricks.oakores.OakOres.MOD_ID;

public class BlockClass {

    public static final Block PURPI_BLOCK = new Block(FabricBlockSettings.of(Material.METAL, MapColor.PURPLE).breakByTool(FabricToolTags.PICKAXES).strength(6.5f, 20.5f).breakByTool(FabricToolTags.PICKAXES, 3).requiresTool().sounds(BlockSoundGroup.METAL));

    public static final Block PURPI_ORE = new PurpiOre(FabricBlockSettings.of(Material.STONE, MapColor.STONE_GRAY).strength(3.5f, 10.25f).breakByTool(FabricToolTags.PICKAXES, 3).requiresTool().sounds(BlockSoundGroup.STONE));

    public static final Block LEAD_ORE = new LeadOre(FabricBlockSettings.of(Material.STONE, MapColor.STONE_GRAY).strength(4.2f, 8.3f).breakByTool(FabricToolTags.PICKAXES, 2).requiresTool().sounds(BlockSoundGroup.STONE));

    public static final Block DEEPSLATE_LEAD_ORE = new LeadOre(FabricBlockSettings.of(Material.STONE, MapColor.DEEPSLATE_GRAY).strength(8.2f, 10.5f).breakByTool(FabricToolTags.PICKAXES, 2).requiresTool().sounds(BlockSoundGroup.DEEPSLATE));

    public static final Block LEAD_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).breakByTool(FabricToolTags.PICKAXES).strength(8.5f, 17.5f).breakByTool(FabricToolTags.PICKAXES, 2).requiresTool().sounds(BlockSoundGroup.METAL));

    //public static final Block PURPI_ORE = new Block(FabricBlockSettings.of(Material.STONE).breakByTool(FabricToolTags.PICKAXES).strength(2.5f, 10.5f).requiresTool().sounds(BlockSoundGroup.STONE));

    //public static final Block PURPI_ORE = PurpiOre(FabricBlockSettings.copyOf(Blocks.DIAMOND_ORE).requiresTool().breakByTool(FabricToolTags.PICKAXES).sounds(BlockSoundGroup.STONE).strength(3.0f, 3.0f));

    public static void registerBlocks() {

        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "purpi_block"), PURPI_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "purpi_ore"), PURPI_ORE);
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "lead_ore"), LEAD_ORE);
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "deepslate_lead_ore"), DEEPSLATE_LEAD_ORE);
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "lead_block"), LEAD_BLOCK);
    }


}
