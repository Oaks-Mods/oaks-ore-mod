package org.oakbricks.oakores.mixin;

// this was and is very painful to code for
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.PlayerManager;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.Difficulty;
import net.minecraft.world.GameMode;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import org.oakbricks.oakores.registry.ItemClass;
import org.oakbricks.oakores.util.TickUtil;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static java.lang.Thread.sleep;

@Mixin(LivingEntity.class)
public abstract class PlayerEntityMixin {

    @Shadow
    public abstract ItemStack getMainHandStack();

    @Shadow
    public abstract ItemStack getOffHandStack();

    public Entity entity;

    public World world;

    public abstract int maxLeadTimeAllowed();

    public int ticks;
    //cursed code!

    public void leadPoisonCounterIncrement() {
        this.ticks++;
    }

    @Inject(at = @At("HEAD"), method = "tick")
    public void leadOnTick(CallbackInfo ci) {

        if (this.getMainHandStack().isOf(ItemClass.LEAD_ROCK) || getOffHandStack().isOf(ItemClass.LEAD_ROCK) && this.ticks == this.maxLeadTimeAllowed() && world.getDifficulty() != Difficulty.PEACEFUL) {


            if (this.ticks > this.maxLeadTimeAllowed()) {
                LivingEntity livingEntity = (LivingEntity)entity;
                if (entity instanceof LivingEntity) {
                    livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 50));
                }
            }

        }
    }
}
