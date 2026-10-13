/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.render.entity.EntityRenderer
 *  net.minecraft.client.render.entity.state.EntityRenderState
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package com.noplyrshdw.mxn;

import com.noplyrshdw.cfg;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.state.EntityRenderState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={EntityRenderer.class})
public class plyrmxn1212 {
    @Inject(method={"getShadowRadius"}, at={@At(value="HEAD")}, cancellable=true)
    private void hideShadow(EntityRenderState state, CallbackInfoReturnable<Float> cir) {
        if (cfg.noAllShdw) {
            cir.setReturnValue((Object)Float.valueOf(0.0f));
        }
    }
}

