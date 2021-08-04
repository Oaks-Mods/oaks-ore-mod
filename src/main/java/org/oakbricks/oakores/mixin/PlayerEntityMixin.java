package org.oakbricks.oakores.mixin;

// this was and is very painful to code for

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.Difficulty;
import org.oakbricks.oakores.registry.ModBlocks;
import org.oakbricks.oakores.registry.ModItems;
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

    public int maxLeadBlockTimeAllowed() {
        return 300;
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

        if (this.getMainHandStack().isOf(ModItems.LEAD_ROCK) || this.getOffHandStack().isOf(ModItems.LEAD_ROCK) || this.getMainHandStack().isOf(Item.fromBlock(ModBlocks.LEAD_BLOCK)) || this.getOffHandStack().isOf(Item.fromBlock(ModBlocks.LEAD_BLOCK)) && this.ticks == this.maxLeadTimeAllowed() && this.getWorld().getDifficulty() != Difficulty.PEACEFUL) {
            if (this.ticks > this.maxLeadTimeAllowed()) {
                Thread thread = new Thread(() -> {
                    try { /* This delays it by seven seconds ( i might change it in a later release */
                        Thread.sleep(7000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    this.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 70, 3));
                    this.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 70, 2));
                    this.addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 70, 1));
                    this.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 70, 2));
                    this.addStatusEffect(new StatusEffectInstance(StatusEffects.MINING_FATIGUE, 70, 1));
                    this.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 70, 1));
                });
                thread.start();
            }
        } else {

        }
        //lead block
        if (this.getMainHandStack().isOf(Item.fromBlock(ModBlocks.LEAD_BLOCK)) || this.getOffHandStack().isOf(Item.fromBlock(ModBlocks.LEAD_BLOCK)) && this.ticks == this.maxLeadTimeAllowed() && this.getWorld().getDifficulty() != Difficulty.PEACEFUL) {
            if (this.ticks > this.maxLeadBlockTimeAllowed()) {
                Thread thread = new Thread(() -> {
                    try { /* This delays it by seven seconds ( i might change it in a later release */
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    this.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 70, 4));
                    this.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 70, 3));
                    this.addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 70, 2));
                    this.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 70, 3));
                    this.addStatusEffect(new StatusEffectInstance(StatusEffects.MINING_FATIGUE, 70, 2));
                    this.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 70, 2));
                });
                thread.start();
            }
        } else {

        }
    }
}
