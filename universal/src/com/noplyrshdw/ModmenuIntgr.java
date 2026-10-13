/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.terraformersmc.modmenu.api.ConfigScreenFactory
 *  com.terraformersmc.modmenu.api.ModMenuApi
 *  me.shedaniel.clothconfig2.api.AbstractConfigListEntry
 *  me.shedaniel.clothconfig2.api.ConfigBuilder
 *  me.shedaniel.clothconfig2.api.ConfigCategory
 *  me.shedaniel.clothconfig2.api.ConfigEntryBuilder
 *  net.minecraft.class_2561
 */
package com.noplyrshdw;

import com.noplyrshdw.cfg;
import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import me.shedaniel.clothconfig2.api.AbstractConfigListEntry;
import me.shedaniel.clothconfig2.api.ConfigBuilder;
import me.shedaniel.clothconfig2.api.ConfigCategory;
import me.shedaniel.clothconfig2.api.ConfigEntryBuilder;
import net.minecraft.class_2561;

public class ModmenuIntgr
implements ModMenuApi {
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return prnt -> {
            ConfigBuilder b = ConfigBuilder.create().setParentScreen(prnt).setTitle((class_2561)class_2561.method_43470((String)"no plyr shdw cfg"));
            ConfigCategory configctgry = b.getOrCreateCategory((class_2561)class_2561.method_43470((String)"gen"));
            ConfigEntryBuilder configIn = b.entryBuilder();
            configctgry.addEntry((AbstractConfigListEntry)configIn.startBooleanToggle((class_2561)class_2561.method_43470((String)"no all shdw"), cfg.noAllShdw).setDefaultValue(true).setSaveConsumer(nv -> {
                cfg.noAllShdw = nv;
            }).build());
            configctgry.addEntry((AbstractConfigListEntry)configIn.startBooleanToggle((class_2561)class_2561.method_43470((String)"no plyr shdw"), cfg.noPlyrShdw).setDefaultValue(true).setSaveConsumer(nv -> {
                cfg.noPlyrShdw = nv;
            }).build());
            configctgry.addEntry((AbstractConfigListEntry)configIn.startBooleanToggle((class_2561)class_2561.method_43470((String)"no self shdw"), cfg.noSelfShdw).setDefaultValue(true).setSaveConsumer(nv -> {
                cfg.noSelfShdw = nv;
            }).build());
            return b.build();
        };
    }
}

