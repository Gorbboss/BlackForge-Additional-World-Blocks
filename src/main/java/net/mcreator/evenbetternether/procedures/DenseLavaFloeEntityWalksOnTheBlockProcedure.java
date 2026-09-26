/*
 * Decompiled with CFR 0.153-local.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.world.level.LevelAccessor
 */
package net.mcreator.evenbetternether.procedures;

import net.mcreator.evenbetternether.EvenbetternetherMod;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelAccessor;

public class DenseLavaFloeEntityWalksOnTheBlockProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z) {
        if (world.m_8044_() % 10L == 0L && Math.random() < 0.25) {
            EvenbetternetherMod.queueServerWork(7, () -> world.m_46961_(BlockPos.m_274561_((double)x, (double)y, (double)z), false));
        }
    }
}

