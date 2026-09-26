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

public class SparseLavaFloeEntityWalksOnTheBlockProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z) {
        if (world.dayTime() % 10L == 0L && Math.random() < 0.45) {
            EvenbetternetherMod.queueServerWork(5, () -> world.destroyBlock(BlockPos.containing((double)x, (double)y, (double)z), false));
        }
    }
}

