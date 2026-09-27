package net.mcreator.evenbetternether.block;

import java.util.function.Supplier;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

public class ImportedLumabusSeedBlock extends BushBlock implements BonemealableBlock {
    private final Supplier<Block> vine; private final int mean,max;
    public ImportedLumabusSeedBlock(Supplier<Block> vine,int mean,int max){super(BlockBehaviour.Properties.copy(Blocks.WEEPING_VINES).noCollission().noOcclusion().randomTicks());this.vine=vine;this.mean=mean;this.max=max;}
    @Override public boolean canSurvive(BlockState s,LevelReader l,BlockPos p){return l.getBlockState(p.above()).isFaceSturdy(l,p.above(),Direction.DOWN);}
    @Override public boolean isValidBonemealTarget(LevelReader l,BlockPos p,BlockState s,boolean c){return l.isEmptyBlock(p.below());}
    @Override public boolean isBonemealSuccess(Level l,RandomSource r,BlockPos p,BlockState s){return r.nextInt(4)==0&&l.isEmptyBlock(p.below());}
    @Override public void performBonemeal(ServerLevel l,RandomSource r,BlockPos p,BlockState s){grow(l,r,p);}
    @Override public void randomTick(BlockState s,ServerLevel l,BlockPos p,RandomSource r){if(isBonemealSuccess(l,r,p,s))grow(l,r,p);}
    private void grow(ServerLevel l,RandomSource r,BlockPos p){int length=Mth.clamp((int)Math.round(mean+r.nextGaussian()*3),2,max);int actual=1;while(actual<length&&l.isEmptyBlock(p.below(actual)))actual++;if(actual<2)return;Block b=vine.get();for(int i=0;i<actual;i++){ImportedTripleShape shape=i==0?ImportedTripleShape.TOP:i==actual-1?ImportedTripleShape.BOTTOM:ImportedTripleShape.MIDDLE;l.setBlock(p.below(i),b.defaultBlockState().setValue(ImportedLumabusVineBlock.SHAPE,shape),Block.UPDATE_ALL);}}
}
