package net.mcreator.evenbetternether.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
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
    @Override public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return switch (state.getValue(FACING)) {
            case DOWN -> box(0, 12, 0, 16, 16, 16); case UP -> box(0, 0, 0, 16, 4, 16);
            case NORTH -> box(0, 0, 12, 16, 16, 16); case SOUTH -> box(0, 0, 0, 16, 16, 4);
            case WEST -> box(12, 0, 0, 16, 16, 16); case EAST -> box(0, 0, 0, 4, 16, 16);
        };
    }
}
