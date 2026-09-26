/*
 * Decompiled with CFR 0.153-local.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.util.Mth
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.LevelReader
 *  net.minecraft.world.level.block.Block
 */
package net.mcreator.evenbetternether.procedures;

import net.mcreator.evenbetternether.init.EvenbetternetherModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;

public class BarrelCactusOnBoneMealSuccessProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z) {
        double random = 0.0;
        random = Mth.nextInt((RandomSource)RandomSource.create(), (int)1, (int)4);
        if (((Block)EvenbetternetherModBlocks.BARREL_CACTUS.get()).defaultBlockState().canSurvive((LevelReader)world, BlockPos.containing((double)(x + 1.0), (double)y, (double)z)) && random == 1.0) {
            world.setBlock(BlockPos.containing((double)(x + 1.0), (double)y, (double)z), ((Block)EvenbetternetherModBlocks.BARREL_CACTUS.get()).defaultBlockState(), 3);
        }
        if (((Block)EvenbetternetherModBlocks.BARREL_CACTUS.get()).defaultBlockState().canSurvive((LevelReader)world, BlockPos.containing((double)(x - 1.0), (double)y, (double)z)) && random == 2.0) {
            world.setBlock(BlockPos.containing((double)(x - 1.0), (double)y, (double)z), ((Block)EvenbetternetherModBlocks.BARREL_CACTUS.get()).defaultBlockState(), 3);
        }
        if (((Block)EvenbetternetherModBlocks.BARREL_CACTUS.get()).defaultBlockState().canSurvive((LevelReader)world, BlockPos.containing((double)x, (double)y, (double)(z + 1.0))) && random == 3.0) {
            world.setBlock(BlockPos.containing((double)x, (double)y, (double)(z + 1.0)), ((Block)EvenbetternetherModBlocks.BARREL_CACTUS.get()).defaultBlockState(), 3);
        }
        if (((Block)EvenbetternetherModBlocks.BARREL_CACTUS.get()).defaultBlockState().canSurvive((LevelReader)world, BlockPos.containing((double)x, (double)y, (double)(z - 1.0))) && random == 4.0) {
            world.setBlock(BlockPos.containing((double)x, (double)y, (double)(z - 1.0)), ((Block)EvenbetternetherModBlocks.BARREL_CACTUS.get()).defaultBlockState(), 3);
        }
    }
}

