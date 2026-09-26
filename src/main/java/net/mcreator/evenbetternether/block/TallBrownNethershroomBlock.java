/*
 * Decompiled with CFR 0.153-local.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.level.BlockGetter
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.LevelReader
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.Blocks
 *  net.minecraft.world.level.block.BonemealableBlock
 *  net.minecraft.world.level.block.DoublePlantBlock
 *  net.minecraft.world.level.block.SoundType
 *  net.minecraft.world.level.block.state.BlockBehaviour$OffsetType
 *  net.minecraft.world.level.block.state.BlockBehaviour$Properties
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.block.state.properties.DoubleBlockHalf
 *  net.minecraft.world.level.block.state.properties.Property
 *  net.minecraft.world.level.material.MapColor
 *  net.minecraft.world.level.material.PushReaction
 *  net.minecraft.world.level.pathfinder.BlockPathTypes
 *  net.minecraft.world.phys.Vec3
 *  net.minecraft.world.phys.shapes.CollisionContext
 *  net.minecraft.world.phys.shapes.VoxelShape
 *  net.minecraftforge.common.PlantType
 */
package net.mcreator.evenbetternether.block;

import net.mcreator.evenbetternether.init.EvenbetternetherModBlocks;
import net.mcreator.evenbetternether.procedures.TallBrownNethershroomOnBoneMealSuccessProcedure;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.common.PlantType;

public class TallBrownNethershroomBlock
extends DoublePlantBlock
implements BonemealableBlock {
    public TallBrownNethershroomBlock() {
        super(BlockBehaviour.Properties.m_284310_().m_284180_(MapColor.f_283915_).m_60918_(SoundType.f_56711_).m_60913_(0.1f, 0.0f).m_60910_().m_222979_(BlockBehaviour.OffsetType.XZ).m_278166_(PushReaction.DESTROY));
    }

    public VoxelShape m_5940_(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        Vec3 offset = state.m_60824_(world, pos);
        return TallBrownNethershroomBlock.m_49796_((double)4.0, (double)0.0, (double)4.0, (double)12.0, (double)16.0, (double)12.0).m_83216_(offset.f_82479_, offset.f_82480_, offset.f_82481_);
    }

    public BlockPathTypes getBlockPathType(BlockState state, BlockGetter world, BlockPos pos, Mob entity) {
        return BlockPathTypes.DAMAGE_OTHER;
    }

    public boolean m_6266_(BlockState groundState, BlockGetter worldIn, BlockPos pos) {
        return groundState.m_60713_((Block)EvenbetternetherModBlocks.NYCELIUM.get()) || groundState.m_60713_(Blocks.f_50195_);
    }

    public boolean m_7898_(BlockState blockstate, LevelReader worldIn, BlockPos pos) {
        BlockPos blockpos = pos.m_7495_();
        BlockState groundState = worldIn.m_8055_(blockpos);
        if (blockstate.m_61143_((Property)f_52858_) == DoubleBlockHalf.UPPER) {
            return groundState.m_60713_((Block)this) && groundState.m_61143_((Property)f_52858_) == DoubleBlockHalf.LOWER;
        }
        return this.m_6266_(groundState, (BlockGetter)worldIn, blockpos);
    }

    public PlantType getPlantType(BlockGetter world, BlockPos pos) {
        return PlantType.CAVE;
    }

    public boolean m_7370_(LevelReader worldIn, BlockPos pos, BlockState blockstate, boolean clientSide) {
        return true;
    }

    public boolean m_214167_(Level world, RandomSource random, BlockPos pos, BlockState blockstate) {
        return true;
    }

    public void m_214148_(ServerLevel world, RandomSource random, BlockPos pos, BlockState blockstate) {
        TallBrownNethershroomOnBoneMealSuccessProcedure.execute((LevelAccessor)world, pos.m_123341_(), pos.m_123342_(), pos.m_123343_());
    }
}

