package net.mcreator.evenbetternether.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
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

/** Snow-covered bushes with optional VanillaBackport fireflies. */
public class ImportedSnowBushBlock extends BushBlock implements BonemealableBlock {
    private static final ResourceLocation FIREFLY = new ResourceLocation("minecraft", "firefly");
    private final boolean fireflies;

    public ImportedSnowBushBlock(boolean fireflies) {
        super(BlockBehaviour.Properties.copy(Blocks.GRASS));
        this.fireflies = fireflies;
    }

    @Override protected boolean mayPlaceOn(BlockState ground, BlockGetter level, BlockPos pos) {
        return ground.is(BlockTags.DIRT) || ground.is(Blocks.FARMLAND);
    }

    @Override public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
        if (!fireflies || !level.isClientSide || level.getMaxLocalRawBrightness(pos) > 13 || random.nextFloat() >= 0.7F) return;
        // Reuse the registered backport particle and its renderer; no dependency on its classes.
        if (BuiltInRegistries.PARTICLE_TYPE.getOptional(FIREFLY).orElse(null) instanceof SimpleParticleType particle) {
            level.addParticle(particle, pos.getX() + random.nextDouble() * 10.0 - 5.0,
                    pos.getY() + random.nextDouble() * 5.0,
                    pos.getZ() + random.nextDouble() * 10.0 - 5.0, 0.0, 0.0, 0.0);
        }
    }

    private BlockPos spreadPosition(LevelReader level, BlockPos pos, Direction direction) {
        BlockPos target = pos.relative(direction);
        if (level.isEmptyBlock(target) && defaultBlockState().canSurvive(level, target)) return target;
        return null;
    }
    @Override public boolean isValidBonemealTarget(LevelReader level, BlockPos pos, BlockState state, boolean client) {
        for (Direction direction : Direction.Plane.HORIZONTAL) if (spreadPosition(level, pos, direction) != null) return true;
        return false;
    }
    @Override public boolean isBonemealSuccess(Level level, RandomSource random, BlockPos pos, BlockState state) { return true; }
    @Override public void performBonemeal(ServerLevel level, RandomSource random, BlockPos pos, BlockState state) {
        Direction start = Direction.Plane.HORIZONTAL.getRandomDirection(random);
        for (int i = 0; i < 4; i++, start = start.getClockWise()) {
            BlockPos target = spreadPosition(level, pos, start);
            if (target != null) { level.setBlock(target, defaultBlockState(), Block.UPDATE_ALL); return; }
        }
    }
}
