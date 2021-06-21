package org.oakbricks.oakores.mixin;

// this was and is very painful to code for
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import org.oakbricks.oakores.registry.ItemClass;
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

    //MEGA BODGE (lazy fix to a very complicated issue that will break in the future!)

    @Unique
    int timer;

    public int maxLeadTimeAllowed() {
        return 400;
    }

    @Inject(at = @At("HEAD"), method = "tick")
    private void tick(CallbackInfo info) {
        int i = this.maxLeadTimeAllowed();

        if (this.getMainHandStack().isOf(ItemClass.LEAD_ROCK) || getOffHandStack().isOf(ItemClass.LEAD_ROCK) && this.timer++ >= i) {
            System.out.println("HEY! THIS IS WORKING, IF ITS NOT DELAYED THEN DO SOMETHING!");
        };
    }
}
