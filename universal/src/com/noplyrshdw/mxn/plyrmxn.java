/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_310
 *  net.minecraft.class_4587
 *  net.minecraft.class_4597
 *  net.minecraft.class_742
 *  net.minecraft.class_897
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package com.noplyrshdw.mxn;

import com.noplyrshdw.cfg;
import net.minecraft.class_1297;
import net.minecraft.class_310;
import net.minecraft.class_4587;
import net.minecraft.class_4597;
import net.minecraft.class_742;
import net.minecraft.class_897;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={class_897.class})
public abstract class plyrmxn {
    @Shadow
    public float field_4673;
    private float oldShadowRadius;

    @Inject(method={"render"}, at={@At(value="HEAD")})
    private void beforeRender(class_1297 entity, float yaw, float tickDelta, class_4587 matrices, class_4597 vertexConsumers, int light, CallbackInfo ci) {
        boolean noShdw = cfg.noAllShdw;
        if (!noShdw && entity instanceof class_742) {
            boolean isSelf;
            boolean bl = isSelf = entity == class_310.method_1551().field_1724;
            if (isSelf && cfg.noSelfShdw || !isSelf && cfg.noPlyrShdw) {
                noShdw = true;
            }
        }
        if (noShdw) {
            this.oldShadowRadius = this.field_4673;
            this.field_4673 = 0.0f;
        }
    }

    @Inject(method={"render"}, at={@At(value="TAIL")})
    private void afterRender(class_1297 entity, float yaw, float tickDelta, class_4587 matrices, class_4597 vertexConsumers, int light, CallbackInfo ci) {
        boolean noShdw = cfg.noAllShdw;
        if (!noShdw && entity instanceof class_742) {
            boolean isSelf;
            boolean bl = isSelf = entity == class_310.method_1551().field_1724;
            if (isSelf && cfg.noSelfShdw || !isSelf && cfg.noPlyrShdw) {
                noShdw = true;
            }
        }
        if (noShdw) {
            this.field_4673 = this.oldShadowRadius;
        }
    }
}

