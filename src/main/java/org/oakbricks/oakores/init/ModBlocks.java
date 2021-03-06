package org.oakbricks.oakores.init;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.block.Material;
import net.minecraft.block.OreBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.oakbricks.oakores.OakOres;
import net.minecraft.util.math.intprovider.UniformIntProvider;

import static org.oakbricks.oakores.OakOres.CONFIG;
import static org.oakbricks.oakores.OakOres.MOD_ID;

public class ModBlocks {

    public static final Block PURPI_BLOCK = new Block(FabricBlockSettings.of(Material.METAL, MapColor.PURPLE).strength(6.5f, 10.5f).requiresTool().sounds(BlockSoundGroup.METAL));

    public static final Block PURPI_ORE = new OreBlock(FabricBlockSettings.of(Material.STONE, MapColor.STONE_GRAY).strength(3.0F, 3.0F).requiresTool().sounds(BlockSoundGroup.STONE));

    public static final Block ENDERITE_ORE = new OreBlock(FabricBlockSettings.of(Material.STONE, MapColor.PALE_YELLOW).strength(3.0F, 3.0F).requiresTool().sounds(BlockSoundGroup.STONE), UniformIntProvider.create(8, 16));

    public static final Block LEAD_ORE = new OreBlock(FabricBlockSettings.of(Material.STONE, MapColor.STONE_GRAY).strength(3.0F, 3.0F).breakByTool(FabricToolTags.PICKAXES, 2).requiresTool().sounds(BlockSoundGroup.STONE));

    public static final Block DEEPSLATE_LEAD_ORE = new OreBlock(FabricBlockSettings.of(Material.STONE, MapColor.DEEPSLATE_GRAY).strength(8.2f, 10.5f).breakByTool(FabricToolTags.PICKAXES, 2).requiresTool().sounds(BlockSoundGroup.DEEPSLATE));

    public static final Block LEAD_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).breakByTool(FabricToolTags.PICKAXES).strength(8.5f, 17.5f).breakByTool(FabricToolTags.PICKAXES, 2).requiresTool().sounds(BlockSoundGroup.METAL));

    public static final Block ENDERITE_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).strength(8.5f, 17.5f).requiresTool().sounds(BlockSoundGroup.METAL));

    public static final Block LITHIUM_ORE = new OreBlock(FabricBlockSettings.of(Material.STONE).strength(3.0F, 3.0F), UniformIntProvider.create(2, 2));

    public static void registerBlocks() {
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "purpi_block"), PURPI_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "purpi_ore"), PURPI_ORE);
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "lead_ore"), LEAD_ORE);
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "deepslate_lead_ore"), DEEPSLATE_LEAD_ORE);
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "lead_block"), LEAD_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "enderite_block"), ENDERITE_BLOCK);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "enderite_block"), new BlockItem(ENDERITE_BLOCK, new FabricItemSettings().group(OakOres.OAKORES_ITEM_GROUP)));
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "enderite_ore"), ENDERITE_ORE);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "enderite_ore"), new BlockItem(ENDERITE_ORE, new FabricItemSettings().group(OakOres.OAKORES_ITEM_GROUP)));
    }

}
