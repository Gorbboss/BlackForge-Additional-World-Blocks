/*
 * Decompiled with CFR 0.153-local.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.block.Blocks
 */
package net.mcreator.evenbetternether.procedures;

import net.mcreator.evenbetternether.init.EvenbetternetherModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;

public class NetherReedAdditionalPlacinggrowthConditionProcedure {
    public static boolean execute(LevelAccessor world, double x, double y, double z) {
        if (world.getFluidState(BlockPos.containing((double)(x + 1.0), (double)(y - 1.0), (double)z)).createLegacyBlock().getBlock() == Blocks.LAVA || world.getFluidState(BlockPos.containing((double)(x - 1.0), (double)(y - 1.0), (double)z)).createLegacyBlock().getBlock() == Blocks.LAVA || world.getFluidState(BlockPos.containing((double)x, (double)(y - 1.0), (double)(z + 1.0))).createLegacyBlock().getBlock() == Blocks.LAVA || world.getFluidState(BlockPos.containing((double)x, (double)(y - 1.0), (double)(z - 1.0))).createLegacyBlock().getBlock() == Blocks.LAVA) {
            return true;
        }
        return world.getBlockState(BlockPos.containing((double)x, (double)(y - 1.0), (double)z)).getBlock() == EvenbetternetherModBlocks.NETHER_REED.get();
    }
}

