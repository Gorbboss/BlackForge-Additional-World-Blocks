package net.mcreator.evenbetternether.block;

import java.util.List;
import java.util.function.Supplier;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class ImportedBoneMushroomBlock extends Block {
    public static final DirectionProperty FACING=BlockStateProperties.FACING;
    public static final IntegerProperty AGE=IntegerProperty.create("age",0,2);
    private final Supplier<Block>[] supports;
    @SafeVarargs public ImportedBoneMushroomBlock(Supplier<Block>...supports){super(BlockBehaviour.Properties.copy(Blocks.CRIMSON_FUNGUS).randomTicks().noCollission().noOcclusion());this.supports=supports;registerDefaultState(stateDefinition.any().setValue(FACING,Direction.UP).setValue(AGE,0));}
    @Override protected void createBlockStateDefinition(StateDefinition.Builder<Block,BlockState>b){b.add(FACING,AGE);}
    private boolean valid(BlockState s){if(s.is(Blocks.BONE_BLOCK))return true;for(Supplier<Block> b:supports)if(s.is(b.get()))return true;return false;}
    @Override public boolean canSurvive(BlockState s,LevelReader l,BlockPos p){Direction d=s.getValue(FACING);return d!=Direction.DOWN&&valid(l.getBlockState(p.relative(d.getOpposite())));}
    @Override public BlockState getStateForPlacement(BlockPlaceContext c){for(Direction d:c.getNearestLookingDirections()){if(d==Direction.UP)continue;BlockState s=defaultBlockState().setValue(FACING,d.getOpposite());if(s.canSurvive(c.getLevel(),c.getClickedPos()))return s;}return null;}
    @Override public BlockState updateShape(BlockState s,Direction d,BlockState n,LevelAccessor l,BlockPos p,BlockPos np){return canSurvive(s,l,p)?s:Blocks.AIR.defaultBlockState();}
    @Override public void randomTick(BlockState s,ServerLevel l,BlockPos p,RandomSource r){if(s.getValue(AGE)<2&&r.nextInt(32)==0)l.setBlock(p,s.setValue(AGE,s.getValue(AGE)+1),UPDATE_CLIENTS);}
    @Override public VoxelShape getShape(BlockState s,BlockGetter l,BlockPos p,CollisionContext c){return switch(s.getValue(FACING)){case NORTH->box(1,1,8,15,15,16);case SOUTH->box(1,1,0,15,15,8);case WEST->box(8,1,1,16,15,15);case EAST->box(0,1,1,8,15,15);default->box(1,0,1,15,12,15);};}
    @Override public List<ItemStack> getDrops(BlockState s,LootParams.Builder b){if(s.getValue(AGE)==2)return List.of(new ItemStack(this,1+b.getLevel().random.nextInt(2)),new ItemStack(Items.BONE_MEAL,1+b.getLevel().random.nextInt(3)));return List.of(new ItemStack(this));}
}
