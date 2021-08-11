package org.oakbricks.oakores.mixin;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.world.Difficulty;
import org.oakbricks.oakores.OakOres;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


@SuppressWarnings("deprecation")
@Mixin(LivingEntity.class)
public abstract class PlayerEntityMixin implements EntityAccessor {

    @Shadow public abstract ItemStack getMainHandStack();

    @Shadow public abstract ItemStack getOffHandStack();

    @Shadow public abstract boolean addStatusEffect(StatusEffectInstance effect);

    public int maxLeadTimeAllowed() {
        return 400;
    }

//    public int maxLeadBlockTimeAllowed() {
//        return 300;
//    }

    public int ticks;

    public void leadPoisonCounterIncrement() {
        this.ticks++;
    }

    @Inject(at = @At("HEAD"), method = "tick")
    public void leadOnTick(CallbackInfo ci) {

        //Allows the timer to work
        leadPoisonCounterIncrement();

        if (this.getMainHandStack().isIn(OakOres.LEAD_POISONING_ITEMS) || this.getOffHandStack().isIn(OakOres.LEAD_POISONING_ITEMS) && this.ticks == this.maxLeadTimeAllowed() && this.getWorld().getDifficulty() != Difficulty.PEACEFUL) {
            if (this.ticks > this.maxLeadTimeAllowed()) {
                Thread poisonThread = new Thread(() -> {
                    try {
                        Thread.sleep(7000);
                        if(this.getMainHandStack().isIn(OakOres.LEAD_POISONING_ITEMS) || this.getOffHandStack().isIn(OakOres.LEAD_POISONING_ITEMS) && this.ticks == this.maxLeadTimeAllowed() && this.getWorld().getDifficulty() != Difficulty.PEACEFUL) {
                            this.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 70, 3));
                            this.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 70, 2));
                            this.addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 70, 1));
                            this.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 70, 2));
                            this.addStatusEffect(new StatusEffectInstance(StatusEffects.MINING_FATIGUE, 70, 1));
                            this.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 70, 1));
                        } /* else if (!(this.getMainHandStack().isIn(OakOres.LEAD_POISONING_ITEMS) || this.getOffHandStack().isIn(OakOres.LEAD_POISONING_ITEMS))) {
                            Thread.currentThread().stop();
                        } */

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                });
                poisonThread.start();
            }
        }
        //lead block
//        if (this.getMainHandStack().isOf(Item.fromBlock(ModBlocks.LEAD_BLOCK)) || this.getOffHandStack().isOf(Item.fromBlock(ModBlocks.LEAD_BLOCK)) && this.ticks == this.maxLeadTimeAllowed() && this.getWorld().getDifficulty() != Difficulty.PEACEFUL) {
//            if (this.ticks > this.maxLeadBlockTimeAllowed()) {
//                Thread poisonThread = new Thread(() -> {
//                    try { /* This delays it by seven seconds ( i might change it in a later release */
//                        Thread.sleep(3000);
//                        this.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 70, 4));
//                        this.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 70, 3));
//                        this.addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 70, 2));
//                        this.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 70, 3));
//                        this.addStatusEffect(new StatusEffectInstance(StatusEffects.MINING_FATIGUE, 70, 2));
//                        this.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 70, 2));
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                });
//                poisonThread.start();
//            }
//        }
    }
}
