package net.mcreator.evenbetternether.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

/** Dependency-free BetterNether Egg Plant behavior, renamed Fragile Wart. */
public class ImportedFragileWartBlock extends Block implements BonemealableBlock {
    public static final BooleanProperty DESTRUCTED = BooleanProperty.create("destructed");
    private static final VoxelShape SHAPE = box(0, 0, 0, 16, 8, 16);

    public ImportedFragileWartBlock() {
        super(BlockBehaviour.Properties.copy(Blocks.NETHER_WART).instabreak().randomTicks().noCollission().noOcclusion());
        registerDefaultState(stateDefinition.any().setValue(DESTRUCTED, false));
    }

    @Override protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) { builder.add(DESTRUCTED); }
    @Override public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) { return SHAPE; }
    @Override public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        BlockState floor = level.getBlockState(pos.below());
        return floor.is(Blocks.NETHERRACK) || floor.is(Blocks.SOUL_SAND) || floor.is(Blocks.SOUL_SOIL)
                || floor.is(Blocks.CRIMSON_NYLIUM) || floor.is(Blocks.WARPED_NYLIUM);
    }
    @Override public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockState state = defaultBlockState();
        return state.canSurvive(context.getLevel(), context.getClickedPos()) ? state : null;
    }
    @Override public void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
        if (state.getValue(DESTRUCTED) || !(entity instanceof LivingEntity living)) return;
        living.addEffect(new MobEffectInstance(MobEffects.POISON, 100, 3));
        if (level instanceof ServerLevel server) {
            server.sendParticles(new BlockParticleOption(ParticleTypes.BLOCK, state), pos.getX() + .5, pos.getY() + .2,
                    pos.getZ() + .5, 24, .2, .2, .2, .1);
        }
        level.setBlock(pos, state.setValue(DESTRUCTED, true), UPDATE_ALL);
    }
    @Override public boolean isValidBonemealTarget(LevelReader level, BlockPos pos, BlockState state, boolean client) { return state.getValue(DESTRUCTED); }
    @Override public boolean isBonemealSuccess(Level level, RandomSource random, BlockPos pos, BlockState state) { return true; }
    @Override public void performBonemeal(ServerLevel level, RandomSource random, BlockPos pos, BlockState state) {
        level.setBlock(pos, defaultBlockState(), UPDATE_ALL);
    }
}
