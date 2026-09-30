package net.mcreator.evenbetternether.block;

import java.util.function.Supplier;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.TallGrassBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.tags.BlockTags;

/** Short dune grass and tiny cactus, with their matching tall bonemeal result. */
public class ImportedDesertPlantBlock extends TallGrassBlock {
    private final Supplier<Block> tall;
    private final boolean cactus;

    public ImportedDesertPlantBlock(Supplier<Block> tall, boolean cactus) {
        super(BlockBehaviour.Properties.copy(cactus ? Blocks.ALLIUM : Blocks.GRASS));
        this.tall = tall;
        this.cactus = cactus;
    }

    public static boolean supports(BlockState ground, boolean cactus) {
        return ground.is(BlockTags.DIRT) || ground.is(BlockTags.SAND)
                || (cactus && ground.is(BlockTags.TERRACOTTA));
    }

    @Override protected boolean mayPlaceOn(BlockState ground, BlockGetter level, BlockPos pos) {
        return supports(ground, cactus);
    }

    @Override public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        return super.canSurvive(state, level, pos) && level.getFluidState(pos).isEmpty()
                && level.getFluidState(pos.above()).isEmpty();
    }

    @Override public boolean isValidBonemealTarget(LevelReader level, BlockPos pos, BlockState state, boolean client) {
        return level.isEmptyBlock(pos.above()) && tall.get().defaultBlockState().canSurvive(level, pos);
    }

    @Override public void performBonemeal(ServerLevel level, RandomSource random, BlockPos pos, BlockState state) {
        if (isValidBonemealTarget(level, pos, state, false)) {
            DoublePlantBlock.placeAt(level, tall.get().defaultBlockState(), pos, Block.UPDATE_ALL);
        }
    }

    @Override public void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
        if (cactus && entity instanceof LivingEntity) entity.hurt(level.damageSources().cactus(), 1.0F);
    }
}
