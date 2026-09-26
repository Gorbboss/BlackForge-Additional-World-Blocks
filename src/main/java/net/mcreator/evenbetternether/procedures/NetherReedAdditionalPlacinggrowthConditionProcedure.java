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
        if (world.m_6425_(BlockPos.m_274561_((double)(x + 1.0), (double)(y - 1.0), (double)z)).m_76188_().m_60734_() == Blocks.f_49991_ || world.m_6425_(BlockPos.m_274561_((double)(x - 1.0), (double)(y - 1.0), (double)z)).m_76188_().m_60734_() == Blocks.f_49991_ || world.m_6425_(BlockPos.m_274561_((double)x, (double)(y - 1.0), (double)(z + 1.0))).m_76188_().m_60734_() == Blocks.f_49991_ || world.m_6425_(BlockPos.m_274561_((double)x, (double)(y - 1.0), (double)(z - 1.0))).m_76188_().m_60734_() == Blocks.f_49991_) {
            return true;
        }
        return world.m_8055_(BlockPos.m_274561_((double)x, (double)(y - 1.0), (double)z)).m_60734_() == EvenbetternetherModBlocks.NETHER_REED.get();
    }
}

