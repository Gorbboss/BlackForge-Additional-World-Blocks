
package net.mcreator.evenbetternether.block;

import org.checkerframework.checker.units.qual.s;

import net.minecraftforge.common.PlantType;

import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.Block;

import net.mcreator.evenbetternether.init.EvenbetternetherModBlocks;

public class FeatherFernBlock extends FlowerBlock implements BonemealableBlock {
	public static final IntegerProperty AGE = IntegerProperty.create("age", 0, 3);
	public FeatherFernBlock() {
		super(() -> MobEffects.MOVEMENT_SPEED, 0, BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).sound(SoundType.NETHER_SPROUTS).instabreak().randomTicks().hasPostProcess((bs, br, bp) -> true).emissiveRendering((bs, br, bp) -> true).lightLevel(s -> 8)
				.noCollission().offsetType(BlockBehaviour.OffsetType.XZ).pushReaction(PushReaction.DESTROY));
		registerDefaultState(stateDefinition.any().setValue(AGE, 0));
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		super.createBlockStateDefinition(builder);
		builder.add(AGE);
	}

	@Override public boolean isValidBonemealTarget(LevelReader level, BlockPos pos, BlockState state, boolean client) { return state.getValue(AGE) < 3; }
	@Override public boolean isBonemealSuccess(Level level, RandomSource random, BlockPos pos, BlockState state) { return state.getValue(AGE) < 3 && random.nextBoolean(); }
	@Override public void performBonemeal(ServerLevel level, RandomSource random, BlockPos pos, BlockState state) { int age=state.getValue(AGE); if(age<3) level.setBlock(pos,state.setValue(AGE,age+1),Block.UPDATE_ALL); }
	@Override public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) { if(state.getValue(AGE)<3 && random.nextInt(16)==0) performBonemeal(level,random,pos,state); }

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		Vec3 offset = state.getOffset(world, pos);
		return box(4, 0, 4, 12, 12, 12).move(offset.x, offset.y, offset.z);
	}

	@Override
	public boolean mayPlaceOn(BlockState groundState, BlockGetter worldIn, BlockPos pos) {
		return groundState.is(EvenbetternetherModBlocks.VERDANT_NYLIUM.get()) || groundState.is(Blocks.WARPED_NYLIUM) || groundState.is(Blocks.CRIMSON_NYLIUM) || groundState.is(Blocks.NETHERRACK) || groundState.is(Blocks.GRAVEL)
				|| groundState.is(EvenbetternetherModBlocks.NYCELIUM.get()) || groundState.is(EvenbetternetherModBlocks.WITHERED_NYLIUM.get());
	}

	@Override
	public boolean canSurvive(BlockState blockstate, LevelReader worldIn, BlockPos pos) {
		BlockPos blockpos = pos.below();
		BlockState groundState = worldIn.getBlockState(blockpos);
		return this.mayPlaceOn(groundState, worldIn, blockpos);
	}

	@Override
	public PlantType getPlantType(BlockGetter world, BlockPos pos) {
		return PlantType.NETHER;
	}
}
