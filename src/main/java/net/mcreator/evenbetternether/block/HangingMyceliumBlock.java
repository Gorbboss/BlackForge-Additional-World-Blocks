/*
 * Decompiled with CFR 0.153-local.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Direction
 *  net.minecraft.world.item.context.BlockPlaceContext
 *  net.minecraft.world.level.BlockGetter
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.LevelReader
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.Blocks
 *  net.minecraft.world.level.block.SoundType
 *  net.minecraft.world.level.block.state.BlockBehaviour$OffsetType
 *  net.minecraft.world.level.block.state.BlockBehaviour$Properties
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.block.state.properties.NoteBlockInstrument
 *  net.minecraft.world.phys.Vec3
 *  net.minecraft.world.phys.shapes.CollisionContext
 *  net.minecraft.world.phys.shapes.Shapes
 *  net.minecraft.world.phys.shapes.VoxelShape
 */
package net.mcreator.evenbetternether.block;

import net.mcreator.evenbetternether.procedures.HangingMyceliumBlockValidPlacementConditionProcedure;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class HangingMyceliumBlock
extends Block {
    public HangingMyceliumBlock() {
        super(BlockBehaviour.Properties.m_284310_().m_280658_(NoteBlockInstrument.BASEDRUM).m_60918_(SoundType.f_56759_).m_60913_(0.0f, 1.0f).m_60910_().m_60955_().m_60924_((bs, br, bp) -> false).m_60988_().m_222979_(BlockBehaviour.OffsetType.XZ));
    }

    public boolean m_7420_(BlockState state, BlockGetter reader, BlockPos pos) {
        return true;
    }

    public int m_7753_(BlockState state, BlockGetter worldIn, BlockPos pos) {
        return 0;
    }

    public VoxelShape m_5909_(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return Shapes.m_83040_();
    }

    public VoxelShape m_5940_(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        Vec3 offset = state.m_60824_(world, pos);
        return HangingMyceliumBlock.m_49796_((double)4.0, (double)4.0, (double)4.0, (double)12.0, (double)16.0, (double)12.0).m_83216_(offset.f_82479_, offset.f_82480_, offset.f_82481_);
    }

    public boolean m_7898_(BlockState blockstate, LevelReader worldIn, BlockPos pos) {
        if (worldIn instanceof LevelAccessor world) {
            int x = pos.m_123341_();
            int y = pos.m_123342_();
            int z = pos.m_123343_();
            return HangingMyceliumBlockValidPlacementConditionProcedure.execute(world, x, y, z);
        }
        return super.m_7898_(blockstate, worldIn, pos);
    }

    public BlockState m_7417_(BlockState state, Direction facing, BlockState facingState, LevelAccessor world, BlockPos currentPos, BlockPos facingPos) {
        return !state.m_60710_((LevelReader)world, currentPos) ? Blocks.f_50016_.m_49966_() : super.m_7417_(state, facing, facingState, world, currentPos, facingPos);
    }

    public boolean m_6864_(BlockState state, BlockPlaceContext context) {
        return context.m_43722_().m_41720_() != this.m_5456_();
    }
}

