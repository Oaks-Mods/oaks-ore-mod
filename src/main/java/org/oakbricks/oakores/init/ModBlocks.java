package org.oakbricks.oakores.init;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.oakbricks.oakores.blocks.LeadOre;
import org.oakbricks.oakores.blocks.PurpiOre;

import static org.oakbricks.oakores.OakOres.MOD_ID;

public class ModBlocks {

    public static final Block PURPI_BLOCK = new Block(FabricBlockSettings.of(Material.METAL, MapColor.PURPLE).breakByTool(FabricToolTags.PICKAXES).strength(6.5f, 10.5f).breakByTool(FabricToolTags.PICKAXES, 3).requiresTool().sounds(BlockSoundGroup.METAL));

    public static final Block PURPI_ORE = new PurpiOre(FabricBlockSettings.of(Material.STONE, MapColor.STONE_GRAY).strength(3.5f, 10.25f).breakByTool(FabricToolTags.PICKAXES, 3).requiresTool().sounds(BlockSoundGroup.STONE));

    public static final Block LEAD_ORE = new LeadOre(FabricBlockSettings.of(Material.STONE, MapColor.STONE_GRAY).strength(4.2f, 8.3f).breakByTool(FabricToolTags.PICKAXES, 2).requiresTool().sounds(BlockSoundGroup.STONE));

    public static final Block DEEPSLATE_LEAD_ORE = new LeadOre(FabricBlockSettings.of(Material.STONE, MapColor.DEEPSLATE_GRAY).strength(8.2f, 10.5f).breakByTool(FabricToolTags.PICKAXES, 2).requiresTool().sounds(BlockSoundGroup.DEEPSLATE));

    public static final Block LEAD_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).breakByTool(FabricToolTags.PICKAXES).strength(8.5f, 17.5f).breakByTool(FabricToolTags.PICKAXES, 2).requiresTool().sounds(BlockSoundGroup.METAL));

    public static void registerBlocks() {

        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "purpi_block"), PURPI_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "purpi_ore"), PURPI_ORE);
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "lead_ore"), LEAD_ORE);
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "deepslate_lead_ore"), DEEPSLATE_LEAD_ORE);
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "lead_block"), LEAD_BLOCK);

    }


}
