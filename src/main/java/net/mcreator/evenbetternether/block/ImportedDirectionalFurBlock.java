package net.mcreator.evenbetternether.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class ImportedDirectionalFurBlock extends Block {
    public static final DirectionProperty FACING = BlockStateProperties.FACING;
    public ImportedDirectionalFurBlock(int light) {
        super(BlockBehaviour.Properties.copy(Blocks.GLOW_LICHEN).noCollission().noOcclusion().lightLevel(state -> light));
        registerDefaultState(stateDefinition.any().setValue(FACING, Direction.UP));
    }
    @Override protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) { builder.add(FACING); }
    @Override public BlockState getStateForPlacement(BlockPlaceContext context) {
        for (Direction facing : context.getNearestLookingDirections()) {
            BlockState candidate = defaultBlockState().setValue(FACING, facing.getOpposite());
            if (candidate.canSurvive(context.getLevel(), context.getClickedPos())) return candidate;
        }
        return null;
    }
    @Override public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        Direction facing = state.getValue(FACING);
        BlockPos supportPos = pos.relative(facing.getOpposite());
        return level.getBlockState(supportPos).isFaceSturdy(level, supportPos, facing);
    }
    @Override public BlockState updateShape(BlockState state, Direction direction, BlockState neighbor,
            LevelAccessor level, BlockPos pos, BlockPos neighborPos) {
        return state.canSurvive(level, pos) ? state : Blocks.AIR.defaultBlockState();
    }
    @Override public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return switch (state.getValue(FACING)) {
            case DOWN -> box(0, 12, 0, 16, 16, 16); case UP -> box(0, 0, 0, 16, 4, 16);
            case NORTH -> box(0, 0, 12, 16, 16, 16); case SOUTH -> box(0, 0, 0, 16, 16, 4);
            case WEST -> box(12, 0, 0, 16, 16, 16); case EAST -> box(0, 0, 0, 4, 16, 16);
        };
    }
}
