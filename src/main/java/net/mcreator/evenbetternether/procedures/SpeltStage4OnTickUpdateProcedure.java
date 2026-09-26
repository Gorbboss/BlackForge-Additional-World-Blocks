/*
 * Decompiled with CFR 0.153-local.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.block.state.properties.Property
 */
package net.mcreator.evenbetternether.procedures;

import java.util.Map;
import net.mcreator.evenbetternether.init.EvenbetternetherModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;

public class SpeltStage4OnTickUpdateProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z) {
        if (Math.random() < 0.35) {
            BlockPos _bp = BlockPos.m_274561_((double)x, (double)y, (double)z);
            BlockState _bs = ((Block)EvenbetternetherModBlocks.SPELT_STAGE_5.get()).m_49966_();
            BlockState _bso = world.m_8055_(_bp);
            for (Map.Entry entry : _bso.m_61148_().entrySet()) {
                Property _property = _bs.m_60734_().m_49965_().m_61081_(((Property)entry.getKey()).m_61708_());
                if (_property == null || _bs.m_61143_(_property) == null) continue;
                try {
                    _bs = (BlockState)_bs.m_61124_(_property, (Comparable)entry.getValue());
                } catch (Exception exception) {}
            }
            world.m_7731_(_bp, _bs, 3);
        }
    }
}

