package net.mcreator.evenbetternether.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

/** Small Nether plant with BetterNether-style permissive ground and bonemeal spreading. */
public class ImportedNetherPlantBlock extends BushBlock implements BonemealableBlock {
    private static final VoxelShape SHAPE = Block.box(2, 0, 2, 14, 13, 14);

    public ImportedNetherPlantBlock(int light) {
        super(BlockBehaviour.Properties.copy(Blocks.WARPED_ROOTS)
                .noCollission()
                .noOcclusion()
                .lightLevel(state -> light));
    }

    @Override
    protected boolean mayPlaceOn(BlockState ground, BlockGetter level, BlockPos pos) {
        return ground.is(Blocks.NETHERRACK)
                || ground.is(Blocks.SOUL_SAND)
                || ground.is(Blocks.SOUL_SOIL)
                || ground.is(Blocks.CRIMSON_NYLIUM)
                || ground.is(Blocks.WARPED_NYLIUM)
                || ground.is(Blocks.GRAVEL)
                || ground.isFaceSturdy(level, pos, Direction.UP);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Override
    public boolean isValidBonemealTarget(LevelReader level, BlockPos pos, BlockState state, boolean client) {
        return true;
    }

    @Override
    public boolean isBonemealSuccess(Level level, RandomSource random, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public void performBonemeal(ServerLevel level, RandomSource random, BlockPos pos, BlockState state) {
        for (int attempt = 0; attempt < 12; attempt++) {
            BlockPos target = pos.offset(random.nextInt(7) - 3, random.nextInt(3) - 1, random.nextInt(7) - 3);
            if (level.isEmptyBlock(target) && state.canSurvive(level, target)) {
                level.setBlock(target, state, Block.UPDATE_ALL);
            }
        }
    }
}
