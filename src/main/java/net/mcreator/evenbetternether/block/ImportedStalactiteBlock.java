package net.mcreator.evenbetternether.block;

import javax.annotation.Nullable;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LiquidBlockContainer;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

/** Dependency-free port of BetterNether's connectable, lava-loggable stalactite. */
public class ImportedStalactiteBlock extends Block implements LiquidBlockContainer {
    public static final IntegerProperty SIZE = IntegerProperty.create("size", 0, 7);
    public static final IntegerProperty LAVA_LEVEL = IntegerProperty.create("lava_level", 0, 8);
    public static final BooleanProperty LAVA_FALLING = BooleanProperty.create("lava_falling");
    private static final VoxelShape[] SHAPES = new VoxelShape[8];

    public ImportedStalactiteBlock(Block source) {
        super(BlockBehaviour.Properties.copy(source).noOcclusion());
        registerDefaultState(stateDefinition.any()
                .setValue(SIZE, 0)
                .setValue(LAVA_LEVEL, 0)
                .setValue(LAVA_FALLING, false));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(SIZE, LAVA_LEVEL, LAVA_FALLING);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPES[state.getValue(SIZE)];
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        FluidState fluid = context.getLevel().getFluidState(context.getClickedPos());
        return defaultBlockState()
                .setValue(LAVA_LEVEL, isLava(fluid) ? Math.min(8, fluid.getAmount()) : 0)
                .setValue(LAVA_FALLING, isLavaFalling(fluid));
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        int amount = state.getValue(LAVA_LEVEL);
        if (amount >= 8) {
            return state.getValue(LAVA_FALLING) ? Fluids.LAVA.getFlowing(8, true) : Fluids.LAVA.getSource(false);
        }
        return amount > 0 ? Fluids.LAVA.getFlowing(amount, state.getValue(LAVA_FALLING)) : super.getFluidState(state);
    }

    @Override
    public boolean canPlaceLiquid(BlockGetter level, BlockPos pos, BlockState state, Fluid fluid) {
        return fluid.isSame(Fluids.LAVA);
    }

    @Override
    public boolean placeLiquid(LevelAccessor level, BlockPos pos, BlockState state, FluidState fluid) {
        if (!isLava(fluid)) return false;
        if (!level.isClientSide()) {
            level.setBlock(pos, state
                    .setValue(LAVA_LEVEL, Math.min(8, fluid.getAmount()))
                    .setValue(LAVA_FALLING, isLavaFalling(fluid)), Block.UPDATE_ALL);
            level.scheduleTick(pos, Fluids.LAVA, Fluids.LAVA.getTickDelay(level));
        }
        return true;
    }

    @Override
    public BlockState updateShape(BlockState state, Direction direction, BlockState neighbor, LevelAccessor level,
                                  BlockPos pos, BlockPos neighborPos) {
        if (state.getValue(LAVA_LEVEL) > 0) {
            level.scheduleTick(pos, Fluids.LAVA, Fluids.LAVA.getTickDelay(level));
        }
        return super.updateShape(state, direction, neighbor, level, pos, neighborPos);
    }

    @Override
    public void setPlacedBy(Level level, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack stack) {
        resizeChain(level, pos, Direction.DOWN);
        resizeChain(level, pos, Direction.UP);
    }

    private static void resizeChain(Level level, BlockPos origin, Direction direction) {
        for (int distance = 1; distance < 8; distance++) {
            BlockPos cursor = origin.relative(direction, distance);
            BlockState other = level.getBlockState(cursor);
            if (!(other.getBlock() instanceof ImportedStalactiteBlock)) break;
            if (other.getValue(SIZE) >= distance) break;
            level.setBlockAndUpdate(cursor, other.setValue(SIZE, distance));
        }
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        return supported(level, pos, Direction.UP) || supported(level, pos, Direction.DOWN);
    }

    private static boolean supported(LevelReader level, BlockPos pos, Direction direction) {
        BlockState support = level.getBlockState(pos.relative(direction));
        return support.getBlock() instanceof ImportedStalactiteBlock
                || support.isFaceSturdy(level, pos.relative(direction), direction.getOpposite());
    }

    private static boolean isLava(FluidState state) {
        return state.getType().isSame(Fluids.LAVA);
    }

    private static boolean isLavaFalling(FluidState state) {
        return state.getType() instanceof FlowingFluid && state.hasProperty(FlowingFluid.FALLING)
                && state.getValue(FlowingFluid.FALLING);
    }

    static {
        for (int i = 0; i < SHAPES.length; i++) {
            SHAPES[i] = Block.box(7 - i, 0, 7 - i, 9 + i, 16, 9 + i);
        }
    }
}
