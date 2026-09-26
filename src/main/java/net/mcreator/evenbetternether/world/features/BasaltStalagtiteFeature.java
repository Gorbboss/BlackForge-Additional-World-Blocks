/*
 * Decompiled with CFR 0.153-local.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.level.WorldGenLevel
 *  net.minecraft.world.level.levelgen.feature.FeaturePlaceContext
 *  net.minecraft.world.level.levelgen.feature.RandomPatchFeature
 *  net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration
 */
package net.mcreator.evenbetternether.world.features;

import net.mcreator.evenbetternether.procedures.NetherrackStalagmiteAdditionalGenerationConditionProcedure;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.RandomPatchFeature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;

public class BasaltStalagtiteFeature
extends RandomPatchFeature {
    public BasaltStalagtiteFeature() {
        super(RandomPatchConfiguration.f_67902_);
    }

    public boolean m_142674_(FeaturePlaceContext<RandomPatchConfiguration> context) {
        WorldGenLevel world = context.m_159774_();
        int x = context.m_159777_().m_123341_();
        int y = context.m_159777_().m_123342_();
        int z = context.m_159777_().m_123343_();
        if (!NetherrackStalagmiteAdditionalGenerationConditionProcedure.execute()) {
            return false;
        }
        return super.m_142674_(context);
    }
}

