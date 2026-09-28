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
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

/** One stage of BetterEnd's four-step Pallidium ground sequence. */
public class ImportedPallidiumBlock extends Block implements BonemealableBlock {
    private final Supplier<Block> fullerStage;
    public ImportedPallidiumBlock(Supplier<Block> fullerStage) {
        super(BlockBehaviour.Properties.copy(Blocks.END_STONE));
        this.fullerStage = fullerStage;
    }
    @Override public boolean isValidBonemealTarget(LevelReader level, BlockPos pos, BlockState state, boolean client) { return fullerStage != null; }
    @Override public boolean isBonemealSuccess(Level level, RandomSource random, BlockPos pos, BlockState state) { return fullerStage != null; }
    @Override public void performBonemeal(ServerLevel level, RandomSource random, BlockPos pos, BlockState state) {
        if (fullerStage != null) level.setBlock(pos, fullerStage.get().defaultBlockState(), UPDATE_ALL);
    }
}
