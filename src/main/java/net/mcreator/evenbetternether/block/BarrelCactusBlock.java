/*
 * Decompiled with CFR 0.153-local.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Direction
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.level.BlockGetter
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.LevelReader
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.Blocks
 *  net.minecraft.world.level.block.BonemealableBlock
 *  net.minecraft.world.level.block.SoundType
 *  net.minecraft.world.level.block.state.BlockBehaviour$OffsetType
 *  net.minecraft.world.level.block.state.BlockBehaviour$Properties
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.material.MapColor
 *  net.minecraft.world.level.pathfinder.BlockPathTypes
 *  net.minecraft.world.phys.Vec3
 *  net.minecraft.world.phys.shapes.CollisionContext
 *  net.minecraft.world.phys.shapes.Shapes
 *  net.minecraft.world.phys.shapes.VoxelShape
 */
package net.mcreator.evenbetternether.block;

import net.mcreator.evenbetternether.procedures.BarrelCactusBlockValidPlacementConditionProcedure;
import net.mcreator.evenbetternether.procedures.BarrelCactusEntityCollidesInTheBlockProcedure;
import net.mcreator.evenbetternether.procedures.BarrelCactusOnBoneMealSuccessProcedure;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class BarrelCactusBlock
extends Block
implements BonemealableBlock {
    public BarrelCactusBlock() {
        super(BlockBehaviour.Properties.m_284310_().m_278183_().m_284180_(MapColor.f_283743_).m_60918_(SoundType.f_56711_).m_60913_(0.1f, 3.0f).m_60955_().m_60924_((bs, br, bp) -> false).m_60988_().m_222979_(BlockBehaviour.OffsetType.XZ));
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
        return Shapes.m_83124_((VoxelShape)BarrelCactusBlock.m_49796_((double)3.0, (double)0.0, (double)3.0, (double)13.0, (double)10.0, (double)13.0), (VoxelShape[])new VoxelShape[]{BarrelCactusBlock.m_49796_((double)2.0, (double)0.0, (double)3.0, (double)3.0, (double)9.0, (double)13.0), BarrelCactusBlock.m_49796_((double)13.0, (double)0.0, (double)3.0, (double)14.0, (double)9.0, (double)13.0), BarrelCactusBlock.m_49796_((double)3.0, (double)0.0, (double)13.0, (double)13.0, (double)9.0, (double)14.0), BarrelCactusBlock.m_49796_((double)3.0, (double)0.0, (double)2.0, (double)13.0, (double)9.0, (double)3.0)}).m_83216_(offset.f_82479_, offset.f_82480_, offset.f_82481_);
    }

    public boolean m_7898_(BlockState blockstate, LevelReader worldIn, BlockPos pos) {
        if (worldIn instanceof LevelAccessor world) {
            int x = pos.m_123341_();
            int y = pos.m_123342_();
            int z = pos.m_123343_();
            return BarrelCactusBlockValidPlacementConditionProcedure.execute(world, x, y, z);
        }
        return super.m_7898_(blockstate, worldIn, pos);
    }

    public BlockState m_7417_(BlockState state, Direction facing, BlockState facingState, LevelAccessor world, BlockPos currentPos, BlockPos facingPos) {
        return !state.m_60710_((LevelReader)world, currentPos) ? Blocks.f_50016_.m_49966_() : super.m_7417_(state, facing, facingState, world, currentPos, facingPos);
    }

    public BlockPathTypes getBlockPathType(BlockState state, BlockGetter world, BlockPos pos, Mob entity) {
        return BlockPathTypes.DAMAGE_OTHER;
    }

    public void m_7892_(BlockState blockstate, Level world, BlockPos pos, Entity entity) {
        super.m_7892_(blockstate, world, pos, entity);
        BarrelCactusEntityCollidesInTheBlockProcedure.execute((LevelAccessor)world, entity);
    }

    public boolean m_7370_(LevelReader worldIn, BlockPos pos, BlockState blockstate, boolean clientSide) {
        return true;
    }

    public boolean m_214167_(Level world, RandomSource random, BlockPos pos, BlockState blockstate) {
        return true;
    }

    public void m_214148_(ServerLevel world, RandomSource random, BlockPos pos, BlockState blockstate) {
        BarrelCactusOnBoneMealSuccessProcedure.execute((LevelAccessor)world, pos.m_123341_(), pos.m_123342_(), pos.m_123343_());
    }
}

