package org.oakbricks.oakores.tools;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import org.oakbricks.oakores.init.ModItems;

public class PurpiToolMaterial implements ToolMaterial {

    public static final PurpiToolMaterial INSTANCE = new PurpiToolMaterial();

    @Override
    public int getDurability() {
        return 1750;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 9.5f;
    }

    @Override
    public float getAttackDamage() {
        return 3f;
    }

    @Override
    public int getMiningLevel() {
        return 3;
    }

    @Override
    public int getEnchantability() {
        return 22;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(ModItems.PURPI);
    }
}
