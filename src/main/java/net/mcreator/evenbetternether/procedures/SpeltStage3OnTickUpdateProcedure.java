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

public class SpeltStage3OnTickUpdateProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z) {
        if (Math.random() < 0.35) {
            BlockPos _bp = BlockPos.containing((double)x, (double)y, (double)z);
            BlockState _bs = ((Block)EvenbetternetherModBlocks.SPELT_STAGE_4.get()).defaultBlockState();
            BlockState _bso = world.getBlockState(_bp);
            for (Map.Entry entry : _bso.C().entrySet()) {
                Property _property = _bs.getBlock().getStateDefinition().getProperty(((Property)entry.getKey()).getName());
                if (_property == null || _bs.getValue(_property) == null) continue;
                try {
                    _bs = (BlockState)_bs.setValue(_property, (Comparable)entry.getValue());
                } catch (Exception exception) {}
            }
            world.setBlock(_bp, _bs, 3);
        }
    }
}

