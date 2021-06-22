package org.oakbricks.oakores.mixin;

// this was and is very painful to code for

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.world.Difficulty;
import org.oakbricks.oakores.registry.ItemClass;
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
    //cursed code!

    public void leadPoisonCounterIncrement() {
        this.ticks++;
    }

    @Inject(at = @At("HEAD"), method = "tick")
    public void leadOnTick(CallbackInfo ci) {

        //Allows the timer to work
        leadPoisonCounterIncrement();

        if (this.getMainHandStack().isOf(ItemClass.LEAD_ROCK) || this.getOffHandStack().isOf(ItemClass.LEAD_ROCK) && this.ticks == this.maxLeadTimeAllowed() && this.getWorld().getDifficulty() != Difficulty.PEACEFUL) {
            if (this.ticks > this.maxLeadTimeAllowed()) {
                this.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 50));
            }
        }
    }
}
