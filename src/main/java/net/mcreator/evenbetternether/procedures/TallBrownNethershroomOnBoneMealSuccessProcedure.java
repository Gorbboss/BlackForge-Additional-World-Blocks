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

public class TallBrownNethershroomOnBoneMealSuccessProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z) {
        if (Math.random() < 0.3) {
            ServerLevel _level;
            world.setBlock(BlockPos.containing((double)x, (double)y, (double)z), Blocks.AIR.defaultBlockState(), 3);
            if (world.getBlockState(BlockPos.containing((double)x, (double)(y + 1.0), (double)z)).getBlock() == EvenbetternetherModBlocks.TALL_BROWN_NETHERSHROOM.get()) {
                world.setBlock(BlockPos.containing((double)x, (double)(y + 1.0), (double)z), Blocks.AIR.defaultBlockState(), 3);
                if (world instanceof ServerLevel) {
                    _level = (ServerLevel)world;
                    ((ConfiguredFeature)_level.registryAccess().registryOrThrow(Registries.CONFIGURED_FEATURE).getHolderOrThrow(FeatureUtils.createKey((String)"evenbetternether:nether_mushroom_tree_brown")).value()).place((WorldGenLevel)_level, _level.getChunkSource().getGenerator(), _level.getRandom(), BlockPos.containing((double)x, (double)y, (double)z));
                }
            }
            if (world.getBlockState(BlockPos.containing((double)x, (double)(y - 1.0), (double)z)).getBlock() == EvenbetternetherModBlocks.TALL_BROWN_NETHERSHROOM.get()) {
                world.setBlock(BlockPos.containing((double)x, (double)(y - 1.0), (double)z), Blocks.AIR.defaultBlockState(), 3);
                if (world instanceof ServerLevel) {
                    _level = (ServerLevel)world;
                    ((ConfiguredFeature)_level.registryAccess().registryOrThrow(Registries.CONFIGURED_FEATURE).getHolderOrThrow(FeatureUtils.createKey((String)"evenbetternether:nether_mushroom_tree_brown")).value()).place((WorldGenLevel)_level, _level.getChunkSource().getGenerator(), _level.getRandom(), BlockPos.containing((double)x, (double)(y - 1.0), (double)z));
                }
            }
        }
    }
}

