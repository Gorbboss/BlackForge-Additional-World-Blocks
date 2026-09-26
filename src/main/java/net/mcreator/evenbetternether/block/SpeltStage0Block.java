/*
 * Decompiled with CFR 0.153-local.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Direction
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.level.BlockGetter
 *  net.minecraft.world.level.ItemLike
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.LevelReader
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.Blocks
 *  net.minecraft.world.level.block.BonemealableBlock
 *  net.minecraft.world.level.block.SoundType
 *  net.minecraft.world.level.block.state.BlockBehaviour$Properties
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.material.MapColor
 *  net.minecraft.world.phys.HitResult
 *  net.minecraft.world.phys.shapes.CollisionContext
 *  net.minecraft.world.phys.shapes.Shapes
 *  net.minecraft.world.phys.shapes.VoxelShape
 */
package net.mcreator.evenbetternether.block;

import net.mcreator.evenbetternether.init.EvenbetternetherModItems;
import net.mcreator.evenbetternether.procedures.SpeltBlockValidPlacementConditionProcedure;
import net.mcreator.evenbetternether.procedures.SpeltStage0OnBoneMealSuccessProcedure;
import net.mcreator.evenbetternether.procedures.SpeltStage0OnTickUpdateProcedure;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
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
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class SpeltStage0Block
extends Block
implements BonemealableBlock {
    public SpeltStage0Block() {
        super(BlockBehaviour.Properties.m_284310_().m_284180_(MapColor.f_283913_).m_60918_(SoundType.f_56758_).m_60966_().m_60910_().m_60955_().m_60977_().m_60924_((bs, br, bp) -> false));
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
        return SpeltStage0Block.m_49796_((double)0.0, (double)0.0, (double)0.0, (double)16.0, (double)3.0, (double)16.0);
    }

    public boolean m_7898_(BlockState blockstate, LevelReader worldIn, BlockPos pos) {
        if (worldIn instanceof LevelAccessor world) {
            int x = pos.m_123341_();
            int y = pos.m_123342_();
            int z = pos.m_123343_();
            return SpeltBlockValidPlacementConditionProcedure.execute(world, x, y, z);
        }
        return super.m_7898_(blockstate, worldIn, pos);
    }

    public BlockState m_7417_(BlockState state, Direction facing, BlockState facingState, LevelAccessor world, BlockPos currentPos, BlockPos facingPos) {
        return !state.m_60710_((LevelReader)world, currentPos) ? Blocks.f_50016_.m_49966_() : super.m_7417_(state, facing, facingState, world, currentPos, facingPos);
    }

    public ItemStack getCloneItemStack(BlockState state, HitResult target, BlockGetter world, BlockPos pos, Player player) {
        return new ItemStack((ItemLike)EvenbetternetherModItems.SPELT_SEEDS.get());
    }

    public void m_213897_(BlockState blockstate, ServerLevel world, BlockPos pos, RandomSource random) {
        super.m_213897_(blockstate, world, pos, random);
        int x = pos.m_123341_();
        int y = pos.m_123342_();
        int z = pos.m_123343_();
        SpeltStage0OnTickUpdateProcedure.execute((LevelAccessor)world, x, y, z);
    }

    public boolean m_7370_(LevelReader worldIn, BlockPos pos, BlockState blockstate, boolean clientSide) {
        return true;
    }

    public boolean m_214167_(Level world, RandomSource random, BlockPos pos, BlockState blockstate) {
        return true;
    }

    public void m_214148_(ServerLevel world, RandomSource random, BlockPos pos, BlockState blockstate) {
        SpeltStage0OnBoneMealSuccessProcedure.execute((LevelAccessor)world, pos.m_123341_(), pos.m_123342_(), pos.m_123343_());
    }
}

