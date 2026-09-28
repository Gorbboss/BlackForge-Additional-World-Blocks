package net.mcreator.evenbetternether.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import java.util.List;

/** BetterNether Egg Plant behavior, registered as Fragile Wart. */
public class ImportedFragileWartBlock extends BushBlock implements BonemealableBlock {
    public static final BooleanProperty DESTRUCTED = BooleanProperty.create("destructed");
    private static final VoxelShape SHAPE = Block.box(0, 0, 0, 16, 8, 16);

    public ImportedFragileWartBlock() {
        super(BlockBehaviour.Properties.copy(Blocks.NETHER_WART).noOcclusion().sound(SoundType.WART_BLOCK));
        registerDefaultState(stateDefinition.any().setValue(DESTRUCTED, false));
    }

    @Override protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(DESTRUCTED);
    }

    @Override protected boolean mayPlaceOn(BlockState ground, BlockGetter level, BlockPos pos) {
        return ground.is(Blocks.NETHERRACK) || ground.is(Blocks.SOUL_SAND)
                || ground.is(Blocks.SOUL_SOIL) || ground.is(Blocks.CRIMSON_NYLIUM)
                || ground.is(Blocks.WARPED_NYLIUM) || ground.isFaceSturdy(level, pos, Direction.UP);
    }

    @Override public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Override public void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
        if (!state.getValue(DESTRUCTED) && entity instanceof LivingEntity living) {
            if (!level.isClientSide) {
                if (!living.hasEffect(MobEffects.POISON))
                    living.addEffect(new MobEffectInstance(MobEffects.POISON, 100, 3));
                level.setBlock(pos, state.setValue(DESTRUCTED, true), Block.UPDATE_ALL);
                level.levelEvent(2001, pos, Block.getId(state));
            }
        }
    }

    @Override public boolean isValidBonemealTarget(LevelReader level, BlockPos pos, BlockState state, boolean client) {
        return state.getValue(DESTRUCTED);
    }

    @Override public boolean isBonemealSuccess(Level level, RandomSource random, BlockPos pos, BlockState state) {
        return true;
    }

    @Override public void performBonemeal(ServerLevel level, RandomSource random, BlockPos pos, BlockState state) {
        level.setBlock(pos, defaultBlockState(), Block.UPDATE_ALL);
    }

    @Override public List<ItemStack> getDrops(BlockState state, LootParams.Builder builder) {
        ItemStack tool = builder.getOptionalParameter(LootContextParams.TOOL);
        return tool != null && (tool.is(Items.SHEARS) || EnchantmentHelper.getItemEnchantmentLevel(Enchantments.SILK_TOUCH, tool) > 0)
                ? List.of(new ItemStack(this)) : List.of();
    }
}
