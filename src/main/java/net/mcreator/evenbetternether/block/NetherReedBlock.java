/*
 * Decompiled with CFR 0.153-local.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.level.BlockGetter
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.LevelReader
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.Blocks
 *  net.minecraft.world.level.block.SoundType
 *  net.minecraft.world.level.block.SugarCaneBlock
 *  net.minecraft.world.level.block.state.BlockBehaviour$OffsetType
 *  net.minecraft.world.level.block.state.BlockBehaviour$Properties
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.block.state.properties.Property
 *  net.minecraft.world.level.material.MapColor
 *  net.minecraft.world.level.material.PushReaction
 *  net.minecraft.world.phys.Vec3
 *  net.minecraft.world.phys.shapes.CollisionContext
 *  net.minecraft.world.phys.shapes.VoxelShape
 *  net.minecraftforge.common.ForgeHooks
 *  net.minecraftforge.common.PlantType
 */
package net.mcreator.evenbetternether.block;

import net.mcreator.evenbetternether.procedures.NetherReedAdditionalPlacinggrowthConditionProcedure;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.SugarCaneBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.PlantType;

public class NetherReedBlock
extends SugarCaneBlock {
    public NetherReedBlock() {
        super(BlockBehaviour.Properties.m_284310_().m_284180_(MapColor.f_283915_).m_60977_().m_60918_(SoundType.f_56754_).m_60966_().m_60910_().m_222979_(BlockBehaviour.OffsetType.XZ).m_278166_(PushReaction.DESTROY));
    }

    public VoxelShape m_5940_(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        Vec3 offset = state.m_60824_(world, pos);
        return NetherReedBlock.m_49796_((double)4.0, (double)0.0, (double)4.0, (double)12.0, (double)16.0, (double)12.0).m_83216_(offset.f_82479_, offset.f_82480_, offset.f_82481_);
    }

    public boolean m_7898_(BlockState blockstate, LevelReader worldIn, BlockPos pos) {
        BlockPos blockpos = pos.m_7495_();
        BlockState groundState = worldIn.m_8055_(blockpos);
        boolean additionalCondition = true;
        if (worldIn instanceof LevelAccessor world) {
            int x = pos.m_123341_();
            int y = pos.m_123342_();
            int z = pos.m_123343_();
            additionalCondition = NetherReedAdditionalPlacinggrowthConditionProcedure.execute(world, x, y, z);
        }
        return groundState.m_60713_((Block)this) || (groundState.m_60713_(Blocks.f_50135_) || groundState.m_60713_(Blocks.f_50136_) || groundState.m_60713_(Blocks.f_49994_) || groundState.m_60713_(Blocks.f_50450_) || groundState.m_60713_(Blocks.f_50134_)) && additionalCondition;
    }

    public PlantType getPlantType(BlockGetter world, BlockPos pos) {
        return PlantType.CAVE;
    }

    public void m_213898_(BlockState blockstate, ServerLevel world, BlockPos pos, RandomSource random) {
        if (world.m_46859_(pos.m_7494_())) {
            int i = 1;
            while (world.m_8055_(pos.m_6625_(i)).m_60713_((Block)this)) {
                ++i;
            }
            if (i < 6) {
                int j = (Integer)blockstate.m_61143_((Property)f_57164_);
                if (ForgeHooks.onCropsGrowPre((Level)world, (BlockPos)pos, (BlockState)blockstate, (boolean)true)) {
                    if (j == 15) {
                        world.m_46597_(pos.m_7494_(), this.m_49966_());
                        world.m_7731_(pos, (BlockState)blockstate.m_61124_((Property)f_57164_, (Comparable)Integer.valueOf(0)), 4);
                    } else {
                        world.m_7731_(pos, (BlockState)blockstate.m_61124_((Property)f_57164_, (Comparable)Integer.valueOf(j + 1)), 4);
                    }
                }
            }
        }
    }
}

