package org.oakbricks.oakores.init.custom;

//import net.minecraft.entity.effect.StatusEffectInstance;
//import net.minecraft.entity.effect.StatusEffects;
//import net.minecraft.entity.player.PlayerEntity;
//import net.minecraft.item.ItemStack;
//import net.minecraft.util.Hand;
//import net.minecraft.util.TypedActionResult;
//import net.minecraft.world.World;
import net.minecraft.item.Item;

public class LeadRockItem extends Item {
    public LeadRockItem(Settings settings) {
        super(settings);
    }

//    @Override
//    public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand){
//
//        playerEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 400, 3));
//        playerEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 400, 2));
//        playerEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 400, 3));
//
//        return TypedActionResult.success(playerEntity.getStackInHand(Hand.MAIN_HAND));
//
//    }
}
