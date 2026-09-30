package net.mcreator.evenbetternether.block;

import java.util.function.Supplier;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.TagKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

public class ImportedMushroomColonyBlock extends BushBlock implements BonemealableBlock {
    public static final TagKey<Block> GROUND = TagKey.create(Registries.BLOCK, new ResourceLocation("evenbetternether", "mushroom_colony_placeable"));
    private final Supplier<Block> tall;

    public ImportedMushroomColonyBlock(BlockBehaviour.Properties properties, Supplier<Block> tall) {
        super(properties);
        this.tall = tall;
    }

    @Override protected boolean mayPlaceOn(BlockState ground, BlockGetter level, BlockPos pos) { return ground.is(GROUND); }
    @Override public boolean isValidBonemealTarget(LevelReader level, BlockPos pos, BlockState state, boolean client) {
        return level.isEmptyBlock(pos.above()) && tall.get().defaultBlockState().canSurvive(level, pos);
    }
    @Override public boolean isBonemealSuccess(Level level, RandomSource random, BlockPos pos, BlockState state) { return true; }
    @Override public void performBonemeal(ServerLevel level, RandomSource random, BlockPos pos, BlockState state) {
        if (isValidBonemealTarget(level, pos, state, false)) DoublePlantBlock.placeAt(level, tall.get().defaultBlockState(), pos, Block.UPDATE_ALL);
    }
}
