package net.mcreator.evenbetternether.block;

import java.util.function.Supplier;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

/** Dependency-free willow grower. Its trunk is deliberately ordinary logs, never BetterNether's modeled trunk. */
public class ImportedWillowSaplingBlock extends BushBlock implements BonemealableBlock {
    private final Supplier<Block> log;
    private final Supplier<Block> leaves;

    public ImportedWillowSaplingBlock(Supplier<Block> log, Supplier<Block> leaves) {
        super(BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING).noCollission());
        this.log = log;
        this.leaves = leaves;
    }

    @Override public boolean isValidBonemealTarget(LevelReader level, BlockPos pos, BlockState state, boolean client) { return true; }
    @Override public boolean isBonemealSuccess(Level level, RandomSource random, BlockPos pos, BlockState state) { return random.nextFloat() < 0.65F; }

    @Override
    public void performBonemeal(ServerLevel level, RandomSource random, BlockPos pos, BlockState state) {
        int height = 6 + random.nextInt(4);
        for (int y = 1; y <= height + 2; y++) if (!level.getBlockState(pos.above(y)).canBeReplaced()) return;
        level.setBlock(pos, log.get().defaultBlockState(), Block.UPDATE_ALL);
        for (int y = 1; y < height; y++) level.setBlock(pos.above(y), log.get().defaultBlockState(), Block.UPDATE_ALL);
        BlockPos crown = pos.above(height);
        BlockState foliage = leaves.get().defaultBlockState();
        for (int y = -2; y <= 1; y++) {
            int radius = y == 1 ? 1 : 2;
            for (int x = -radius; x <= radius; x++) for (int z = -radius; z <= radius; z++) {
                if (Math.abs(x) == radius && Math.abs(z) == radius && random.nextBoolean()) continue;
                BlockPos target = crown.offset(x, y, z);
                if (level.getBlockState(target).canBeReplaced()) level.setBlock(target, foliage, Block.UPDATE_ALL);
            }
        }
        level.setBlock(crown.above(), foliage, Block.UPDATE_ALL);
    }
}
