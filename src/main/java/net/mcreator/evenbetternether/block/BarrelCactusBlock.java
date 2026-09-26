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
        super(BlockBehaviour.Properties.of().ignitedByLava().mapColor(MapColor.COLOR_BLUE).sound(SoundType.FUNGUS).strength(0.1f, 3.0f).noOcclusion().isRedstoneConductor((bs, br, bp) -> false).dynamicShape().offsetType(BlockBehaviour.OffsetType.XZ));
    }

    public boolean propagatesSkylightDown(BlockState state, BlockGetter reader, BlockPos pos) {
        return true;
    }

    public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
        return 0;
    }

    public VoxelShape getVisualShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return Shapes.empty();
    }

    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        Vec3 offset = state.getOffset(world, pos);
        return Shapes.or((VoxelShape)BarrelCactusBlock.box((double)3.0, (double)0.0, (double)3.0, (double)13.0, (double)10.0, (double)13.0), (VoxelShape[])new VoxelShape[]{BarrelCactusBlock.box((double)2.0, (double)0.0, (double)3.0, (double)3.0, (double)9.0, (double)13.0), BarrelCactusBlock.box((double)13.0, (double)0.0, (double)3.0, (double)14.0, (double)9.0, (double)13.0), BarrelCactusBlock.box((double)3.0, (double)0.0, (double)13.0, (double)13.0, (double)9.0, (double)14.0), BarrelCactusBlock.box((double)3.0, (double)0.0, (double)2.0, (double)13.0, (double)9.0, (double)3.0)}).move(offset.x, offset.y, offset.z);
    }

    public boolean canSurvive(BlockState blockstate, LevelReader worldIn, BlockPos pos) {
        if (worldIn instanceof LevelAccessor world) {
            int x = pos.getX();
            int y = pos.getY();
            int z = pos.getZ();
            return BarrelCactusBlockValidPlacementConditionProcedure.execute(world, x, y, z);
        }
        return super.canSurvive(blockstate, worldIn, pos);
    }

    public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor world, BlockPos currentPos, BlockPos facingPos) {
        return !state.canSurvive((LevelReader)world, currentPos) ? Blocks.AIR.defaultBlockState() : super.updateShape(state, facing, facingState, world, currentPos, facingPos);
    }

    public BlockPathTypes getBlockPathType(BlockState state, BlockGetter world, BlockPos pos, Mob entity) {
        return BlockPathTypes.DAMAGE_OTHER;
    }

    public void entityInside(BlockState blockstate, Level world, BlockPos pos, Entity entity) {
        super.entityInside(blockstate, world, pos, entity);
        BarrelCactusEntityCollidesInTheBlockProcedure.execute((LevelAccessor)world, entity);
    }

    public boolean isValidBonemealTarget(LevelReader worldIn, BlockPos pos, BlockState blockstate, boolean clientSide) {
        return true;
    }

    public boolean isBonemealSuccess(Level world, RandomSource random, BlockPos pos, BlockState blockstate) {
        return true;
    }

    public void performBonemeal(ServerLevel world, RandomSource random, BlockPos pos, BlockState blockstate) {
        BarrelCactusOnBoneMealSuccessProcedure.execute((LevelAccessor)world, pos.getX(), pos.getY(), pos.getZ());
    }
}

