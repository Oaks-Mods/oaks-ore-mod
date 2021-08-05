package org.oakbricks.oakores.init;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.oakbricks.oakores.OakOres;
import org.oakbricks.oakores.init.custom.LeadRockItem;

import static org.oakbricks.oakores.OakOres.*;

public class ModItems {


    public static final ArmorMaterial PURPI_ARMOR_MATERIAL = new ModArmorTiers();
    public static final Item PURPI = new Item(new FabricItemSettings().group(OakOres.OAKORES_ITEM_GROUP));
    public static final Item LEAD_ROCK = new LeadRockItem(new FabricItemSettings().group(OakOres.OAKORES_ITEM_GROUP));
    public static final Item PURPI_HELMET = new ArmorItem(PURPI_ARMOR_MATERIAL, EquipmentSlot.HEAD, new Item.Settings().group(OakOres.OAKORES_ITEM_GROUP));
    public static final Item PURPI_CHESTPLATE = new ArmorItem(PURPI_ARMOR_MATERIAL, EquipmentSlot.CHEST, new Item.Settings().group(OakOres.OAKORES_ITEM_GROUP));
    public static final Item PURPI_LEGGINGS = new ArmorItem(PURPI_ARMOR_MATERIAL, EquipmentSlot.LEGS, new Item.Settings().group(OakOres.OAKORES_ITEM_GROUP));
    public static final Item PURPI_BOOTS = new ArmorItem(PURPI_ARMOR_MATERIAL, EquipmentSlot.FEET, new Item.Settings().group(OakOres.OAKORES_ITEM_GROUP));

    public static void registerItems() {

        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "purpi"), PURPI);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "lead_rock"), LEAD_ROCK);


    }


    public static void registerBlockItems() {

        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "purpi_block"), new BlockItem(ModBlocks.PURPI_BLOCK, new FabricItemSettings().group(OakOres.OAKORES_ITEM_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "purpi_ore"), new BlockItem(ModBlocks.PURPI_ORE, new FabricItemSettings().group(OakOres.OAKORES_ITEM_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "lead_ore"), new BlockItem(ModBlocks.LEAD_ORE, new FabricItemSettings().group(OakOres.OAKORES_ITEM_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "deepslate_lead_ore"), new BlockItem(ModBlocks.DEEPSLATE_LEAD_ORE, new FabricItemSettings().group(OakOres.OAKORES_ITEM_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "lead_block"), new BlockItem(ModBlocks.LEAD_BLOCK, new FabricItemSettings().group(OakOres.OAKORES_ITEM_GROUP)));

    }

    public static void registerArmorItems() {

        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "purpi_helmet"), PURPI_HELMET);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "purpi_chestplate"), PURPI_CHESTPLATE);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "purpi_leggings"), PURPI_LEGGINGS);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "purpi_boots"), PURPI_BOOTS);

    }

}
