package net.mcreator.evenbetternether.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import java.util.function.Supplier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootParams;
import java.util.List;

public class ImportedAgaveBlock extends BushBlock implements BonemealableBlock {
    public static final IntegerProperty AGE=IntegerProperty.create("age",0,3);
    private Supplier<net.minecraft.world.item.Item> leaf;
    public ImportedAgaveBlock(){super(BlockBehaviour.Properties.copy(Blocks.CRIMSON_ROOTS).noCollission().randomTicks().offsetType(BlockBehaviour.OffsetType.XZ));registerDefaultState(stateDefinition.any().setValue(AGE,0));}
    @Override protected void createBlockStateDefinition(StateDefinition.Builder<Block,BlockState>b){b.add(AGE);}
    @Override protected boolean mayPlaceOn(BlockState s,net.minecraft.world.level.BlockGetter l,BlockPos p){return s.is(Blocks.GRAVEL)||s.is(Blocks.SOUL_SAND)||s.is(Blocks.NETHERRACK);}
    @Override public boolean isValidBonemealTarget(LevelReader l,BlockPos p,BlockState s,boolean c){return s.getValue(AGE)<3;}
    @Override public boolean isBonemealSuccess(Level l,RandomSource r,BlockPos p,BlockState s){return s.getValue(AGE)<3&&(r.nextInt(4)==0);}
    @Override public void performBonemeal(ServerLevel l,RandomSource r,BlockPos p,BlockState s){int age=s.getValue(AGE);if(age<3)l.setBlock(p,s.setValue(AGE,age+1),Block.UPDATE_ALL);}
    @Override public void randomTick(BlockState s,ServerLevel l,BlockPos p,RandomSource r){if(s.getValue(AGE)<3&&r.nextInt(16)==0)performBonemeal(l,r,p,s);}
    public ImportedAgaveBlock leaf(Supplier<net.minecraft.world.item.Item> leaf){this.leaf=leaf;return this;}
    @Override public List<ItemStack> getDrops(BlockState s,LootParams.Builder b){
        if(s.getValue(AGE)==3&&leaf!=null)return List.of(new ItemStack(this,1+b.getLevel().random.nextInt(2)),new ItemStack(leaf.get(),2+b.getLevel().random.nextInt(4)));
        return List.of(new ItemStack(this));
    }
}
