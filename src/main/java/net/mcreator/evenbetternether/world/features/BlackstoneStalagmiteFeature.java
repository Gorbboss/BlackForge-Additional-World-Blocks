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

public class BlackstoneStalagmiteFeature
extends RandomPatchFeature {
    public BlackstoneStalagmiteFeature() {
        super(RandomPatchConfiguration.CODEC);
    }

    public boolean place(FeaturePlaceContext<RandomPatchConfiguration> context) {
        WorldGenLevel world = context.level();
        int x = context.origin().getX();
        int y = context.origin().getY();
        int z = context.origin().getZ();
        if (!NetherrackStalagmiteAdditionalGenerationConditionProcedure.execute()) {
            return false;
        }
        return super.place(context);
    }
}

