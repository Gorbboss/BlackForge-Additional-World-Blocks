/*
 * Decompiled with CFR 0.153-local.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.registries.Registries
 *  net.minecraft.data.worldgen.features.FeatureUtils
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.WorldGenLevel
 *  net.minecraft.world.level.block.Blocks
 *  net.minecraft.world.level.levelgen.feature.ConfiguredFeature
 */
package net.mcreator.evenbetternether.procedures;

import net.mcreator.evenbetternether.init.EvenbetternetherModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

public class TallNethershroomOnBoneMealSuccessProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z) {
        if (Math.random() < 0.3) {
            ServerLevel _level;
            world.m_7731_(BlockPos.m_274561_((double)x, (double)y, (double)z), Blocks.f_50016_.m_49966_(), 3);
            if (world.m_8055_(BlockPos.m_274561_((double)x, (double)(y + 1.0), (double)z)).m_60734_() == EvenbetternetherModBlocks.TALL_NETHERSHROOM.get()) {
                world.m_7731_(BlockPos.m_274561_((double)x, (double)(y + 1.0), (double)z), Blocks.f_50016_.m_49966_(), 3);
                if (world instanceof ServerLevel) {
                    _level = (ServerLevel)world;
                    ((ConfiguredFeature)_level.m_9598_().m_175515_(Registries.f_256911_).m_246971_(FeatureUtils.m_255087_((String)"evenbetternether:nether_mushroom_tree")).m_203334_()).m_224953_((WorldGenLevel)_level, _level.m_7726_().m_8481_(), _level.m_213780_(), BlockPos.m_274561_((double)x, (double)y, (double)z));
                }
            }
            if (world.m_8055_(BlockPos.m_274561_((double)x, (double)(y - 1.0), (double)z)).m_60734_() == EvenbetternetherModBlocks.TALL_NETHERSHROOM.get()) {
                world.m_7731_(BlockPos.m_274561_((double)x, (double)(y - 1.0), (double)z), Blocks.f_50016_.m_49966_(), 3);
                if (world instanceof ServerLevel) {
                    _level = (ServerLevel)world;
                    ((ConfiguredFeature)_level.m_9598_().m_175515_(Registries.f_256911_).m_246971_(FeatureUtils.m_255087_((String)"evenbetternether:nether_mushroom_tree")).m_203334_()).m_224953_((WorldGenLevel)_level, _level.m_7726_().m_8481_(), _level.m_213780_(), BlockPos.m_274561_((double)x, (double)(y - 1.0), (double)z));
                }
            }
        }
    }
}

