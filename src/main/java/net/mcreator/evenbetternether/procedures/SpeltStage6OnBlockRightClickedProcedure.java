/*
 * Decompiled with CFR 0.153-local.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.state.BlockState
 */
package net.mcreator.evenbetternether.procedures;

import net.mcreator.evenbetternether.init.EvenbetternetherModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class SpeltStage6OnBlockRightClickedProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z) {
        BlockPos _pos = BlockPos.containing((double)x, (double)y, (double)z);
        Block.dropResources((BlockState)world.getBlockState(_pos), (LevelAccessor)world, (BlockPos)BlockPos.containing((double)x, (double)y, (double)z), null);
        world.destroyBlock(_pos, false);
        world.setBlock(BlockPos.containing((double)x, (double)y, (double)z), ((Block)EvenbetternetherModBlocks.SPELT_STAGE_0.get()).defaultBlockState(), 3);
    }
}

