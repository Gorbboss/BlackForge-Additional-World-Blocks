package net.mcreator.evenbetternether.block;

import java.util.function.Supplier;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;

/** Four-stage BetterEnd berry crop with right-click harvesting. */
public class ImportedEndCropBlock extends Block implements BonemealableBlock {
    public static final IntegerProperty AGE = IntegerProperty.create("age", 0, 3);
    private final Supplier<? extends Item> berry;

    public ImportedEndCropBlock(int light, Supplier<? extends Item> berry) {
        super(BlockBehaviour.Properties.copy(Blocks.SWEET_BERRY_BUSH).randomTicks().noCollission().noOcclusion().lightLevel(s -> light));
        this.berry = berry;
        registerDefaultState(stateDefinition.any().setValue(AGE, 0));
    }
    @Override protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> b) { b.add(AGE); }
    @Override public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) { return ImportedEndSoil.supports(level.getBlockState(pos.below())); }
    @Override public BlockState updateShape(BlockState state, Direction direction, BlockState neighbor, LevelAccessor level, BlockPos pos, BlockPos neighborPos) {
        return state.canSurvive(level, pos) ? state : Blocks.AIR.defaultBlockState();
    }
    @Override public boolean isValidBonemealTarget(LevelReader l, BlockPos p, BlockState s, boolean c) { return s.getValue(AGE) < 3; }
    @Override public boolean isBonemealSuccess(Level l, RandomSource r, BlockPos p, BlockState s) { return true; }
    @Override public void performBonemeal(ServerLevel l, RandomSource r, BlockPos p, BlockState s) { l.setBlock(p, s.setValue(AGE, Math.min(3, s.getValue(AGE) + 1)), UPDATE_ALL); }
    @Override public void randomTick(BlockState s, ServerLevel l, BlockPos p, RandomSource r) { if (r.nextInt(12) == 0 && s.getValue(AGE) < 3) performBonemeal(l, r, p, s); }
    @Override public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (state.getValue(AGE) < 3) return InteractionResult.PASS;
        popResource(level, pos, new ItemStack(berry.get(), 1 + level.random.nextInt(2)));
        level.setBlock(pos, state.setValue(AGE, 1), UPDATE_ALL);
        level.playSound(null, pos, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.BLOCKS, 1.0F, 0.8F + level.random.nextFloat() * 0.4F);
        return InteractionResult.sidedSuccess(level.isClientSide);
    }
}
