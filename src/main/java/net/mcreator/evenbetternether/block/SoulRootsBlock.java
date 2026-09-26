/*
 * Decompiled with CFR 0.153-local.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.world.effect.MobEffects
 *  net.minecraft.world.level.BlockGetter
 *  net.minecraft.world.level.LevelReader
 *  net.minecraft.world.level.block.Blocks
 *  net.minecraft.world.level.block.FlowerBlock
 *  net.minecraft.world.level.block.SoundType
 *  net.minecraft.world.level.block.state.BlockBehaviour$OffsetType
 *  net.minecraft.world.level.block.state.BlockBehaviour$Properties
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.material.MapColor
 *  net.minecraft.world.level.material.PushReaction
 *  net.minecraft.world.phys.Vec3
 *  net.minecraft.world.phys.shapes.CollisionContext
 *  net.minecraft.world.phys.shapes.VoxelShape
 *  net.minecraftforge.common.PlantType
 */
package net.mcreator.evenbetternether.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.common.PlantType;

public class SoulRootsBlock
extends FlowerBlock {
    public SoulRootsBlock() {
        super(() -> MobEffects.f_19596_, 0, BlockBehaviour.Properties.m_284310_().m_284180_(MapColor.f_283915_).m_60918_(SoundType.f_56712_).m_60966_().m_60910_().m_280170_().m_222979_(BlockBehaviour.OffsetType.XZ).m_278166_(PushReaction.DESTROY));
    }

    public VoxelShape m_5940_(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        Vec3 offset = state.m_60824_(world, pos);
        return SoulRootsBlock.m_49796_((double)4.0, (double)0.0, (double)4.0, (double)12.0, (double)12.0, (double)12.0).m_83216_(offset.f_82479_, offset.f_82480_, offset.f_82481_);
    }

    public boolean m_6266_(BlockState groundState, BlockGetter worldIn, BlockPos pos) {
        return groundState.m_60713_(Blocks.f_50135_) || groundState.m_60713_(Blocks.f_50136_);
    }

    public boolean m_7898_(BlockState blockstate, LevelReader worldIn, BlockPos pos) {
        BlockPos blockpos = pos.m_7495_();
        BlockState groundState = worldIn.m_8055_(blockpos);
        return this.m_6266_(groundState, (BlockGetter)worldIn, blockpos);
    }

    public PlantType getPlantType(BlockGetter world, BlockPos pos) {
        return PlantType.NETHER;
    }
}

