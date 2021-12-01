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


@Mixin(LivingEntity.class)
public abstract class PlayerEntityMixin implements EntityAccessor {

    @Shadow public abstract ItemStack getMainHandStack();

    @Shadow public abstract ItemStack getOffHandStack();

    @Shadow public abstract boolean addStatusEffect(StatusEffectInstance effect);

    public int maxLeadTimeAllowed() {
        return 400;
    }

    public int ticks;

    public void leadPoisonCounterIncrement() {
        this.ticks++;
    }

    @Inject(at = @At("HEAD"), method = "tick")
    public void leadOnTick(CallbackInfo ci) {

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
                        }

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                });
                poisonThread.start();
            }
        }
    }
}
