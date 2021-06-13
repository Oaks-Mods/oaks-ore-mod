package org.oakbricks.oakores.tools;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import org.oakbricks.oakores.registry.ItemClass;

public class PurpiToolMaterial implements ToolMaterial {

    public static final PurpiToolMaterial INSTANCE = new PurpiToolMaterial();

    @Override
    public int getDurability() {
        return 874;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 5.5f;
    }

    @Override
    public float getAttackDamage() {
        return 8.5f;
    }

    @Override
    public int getMiningLevel() {
        return 0;
    }

    @Override
    public int getEnchantability() {
        return 27;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(ItemClass.PURPI);
    }
}
