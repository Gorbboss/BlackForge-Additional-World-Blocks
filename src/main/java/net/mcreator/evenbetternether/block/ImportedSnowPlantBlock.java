package net.mcreator.evenbetternether.block;

import java.util.function.Supplier;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.TallGrassBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

/** Snow grass and fern that grow into their matching two-block forms. */
public class ImportedSnowPlantBlock extends TallGrassBlock {
    private final Supplier<Block> tall;

    public ImportedSnowPlantBlock(Supplier<Block> tall, boolean fern) {
        super(BlockBehaviour.Properties.copy(fern ? Blocks.FERN : Blocks.GRASS));
        this.tall = tall;
    }

    @Override public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        return level.getBlockState(pos.below()).is(BlockTags.DIRT) && level.getFluidState(pos).isEmpty();
    }

    @Override public boolean isValidBonemealTarget(LevelReader level, BlockPos pos, BlockState state, boolean client) {
        return level.isEmptyBlock(pos.above()) && tall.get().defaultBlockState().canSurvive(level, pos);
    }

    @Override public void performBonemeal(ServerLevel level, RandomSource random, BlockPos pos, BlockState state) {
        if (isValidBonemealTarget(level, pos, state, false)) {
            DoublePlantBlock.placeAt(level, tall.get().defaultBlockState(), pos, Block.UPDATE_ALL);
        }
    }
}
