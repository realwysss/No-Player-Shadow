/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.objectweb.asm.tree.ClassNode
 *  org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin
 *  org.spongepowered.asm.mixin.extensibility.IMixinInfo
 */
package com.noplyrshdw.mxn;

import java.util.List;
import java.util.Set;
import org.objectweb.asm.tree.ClassNode;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;

public class MxnPlgn
implements IMixinConfigPlugin {
    private boolean is1212OrNewer = false;

    public void onLoad(String mixinPackage) {
        try {
            Class.forName("net.minecraft.class_10017", false, this.getClass().getClassLoader());
            this.is1212OrNewer = true;
            return;
        }
        catch (ClassNotFoundException classNotFoundException) {
            try {
                Class.forName("net.minecraft.client.render.entity.state.EntityRenderState", false, this.getClass().getClassLoader());
                this.is1212OrNewer = true;
                return;
            }
            catch (ClassNotFoundException classNotFoundException2) {
                this.is1212OrNewer = false;
                return;
            }
        }
    }

    public String getRefMapperConfig() {
        return null;
    }

    public boolean shouldApplyMixin(String targetClassName, String mixinClassName) {
        if (mixinClassName.endsWith("plyrmxn1212")) {
            return this.is1212OrNewer;
        }
        if (mixinClassName.endsWith("plyrmxn")) {
            return !this.is1212OrNewer;
        }
        return true;
    }

    public void acceptTargets(Set<String> myTargets, Set<String> otherTargets) {
    }

    public List<String> getMixins() {
        return null;
    }

    public void preApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {
    }

    public void postApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {
    }
}

