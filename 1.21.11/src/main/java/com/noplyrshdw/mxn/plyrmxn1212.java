package com.noplyrshdw.mxn;

import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.state.EntityRenderState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import com.noplyrshdw.cfg;

@Mixin(EntityRenderer.class)
public class plyrmxn1212 {
    @Inject(method = "getShadowRadius", at = @At("HEAD"), cancellable = true)
    private void hideShadow(EntityRenderState state, CallbackInfoReturnable<Float> cir) {
        if (cfg.noAllShdw) {
            cir.setReturnValue(0.0F);
        }
        // player-specific checks require the entity itself, but state doesn't have the entity in base EntityRenderState.
        // For a universal "no all shadows" mod, just this is enough for now!
    }
}
