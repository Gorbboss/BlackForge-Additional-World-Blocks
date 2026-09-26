/*
 * Decompiled with CFR 0.153-local.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Direction
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.tags.BlockTags
 *  net.minecraft.world.level.BlockGetter
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.block.Blocks
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.block.state.properties.Property
 */
package net.mcreator.evenbetternether.procedures;

import java.util.Map;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;

public class VerdantNyliumOnTickUpdateProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z) {
        if (Math.random() > 0.3 && (!world.getBlockState(BlockPos.containing((double)x, (double)(y + 1.0), (double)z)).canBeReplaced() || world.getBlockState(BlockPos.containing((double)x, (double)(y + 1.0), (double)z)).isFaceSturdy((BlockGetter)world, BlockPos.containing((double)x, (double)(y + 1.0), (double)z), Direction.DOWN)) && !world.getBlockState(BlockPos.containing((double)x, (double)(y + 1.0), (double)z)).is(BlockTags.create((ResourceLocation)new ResourceLocation("evenbetternether:groundcover")))) {
            BlockPos _bp = BlockPos.containing((double)x, (double)y, (double)z);
            BlockState _bs = Blocks.NETHERRACK.defaultBlockState();
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

