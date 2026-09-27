package net.mcreator.evenbetternether.block;

import java.util.function.Supplier;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

/** BetterNether Willow silhouette with the requested conventional log trunk. */
public class ImportedWillowSaplingBlock extends BushBlock implements BonemealableBlock {
    private static final Direction[] HORIZONTAL={Direction.NORTH,Direction.SOUTH,Direction.WEST,Direction.EAST};
    private final Supplier<Block> log,leaves,branch;
    public ImportedWillowSaplingBlock(Supplier<Block> log,Supplier<Block> leaves,Supplier<Block> branch){super(BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING).noCollission());this.log=log;this.leaves=leaves;this.branch=branch;}
    @Override public boolean isValidBonemealTarget(LevelReader l,BlockPos p,BlockState s,boolean c){return true;}
    @Override public boolean isBonemealSuccess(Level l,RandomSource r,BlockPos p,BlockState s){return r.nextFloat()<0.45F;}
    @Override public void performBonemeal(ServerLevel l,RandomSource r,BlockPos p,BlockState s){grow(l,r,p);}
    private void grow(ServerLevel l,RandomSource r,BlockPos p){
        int height=5+r.nextInt(3); for(int y=1;y<=height+1;y++)if(!l.getBlockState(p.above(y)).canBeReplaced())return;
        BlockState trunk=log.get().defaultBlockState(); for(int y=0;y<=height;y++)l.setBlock(p.above(y),trunk,Block.UPDATE_ALL);
        BlockPos center=p.above(height); putLeaf(l,center.above(),Direction.UP);
        for(Direction d:HORIZONTAL){putLeaf(l,center.above().relative(d),d);branch(l,center.relative(d),3+r.nextInt(2),r,d,center,0);}
    }
    private void branch(ServerLevel l,BlockPos start,int length,RandomSource r,Direction direction,BlockPos center,int depth){
        if(depth>5)return; BlockPos.MutableBlockPos cursor=start.mutable();putLeaf(l,cursor,direction);hang(l,cursor.below(),1);Direction previous=direction;
        for(int i=0;i<length*length;i++){
            Direction d=r.nextInt(3)>0?previous:(r.nextBoolean()?previous.getClockWise():previous.getCounterClockWise());BlockPos next=cursor.relative(d);
            if(!l.getBlockState(next).canBeReplaced())continue;cursor.set(next);if(cursor.distManhattan(center)>length)break;putLeaf(l,cursor,d);
            if(r.nextBoolean())putLeaf(l,cursor.above(),Direction.UP);if(r.nextInt(3)==0)putLeaf(l,cursor.below(),Direction.DOWN);if(r.nextBoolean())hang(l,cursor.below(),1+r.nextInt(4));
            if(r.nextBoolean()){Direction side=d.getClockWise();BlockPos q=cursor.relative(side);if(l.getBlockState(q).canBeReplaced())branch(l,q,length,r,side,center,depth+1);side=side.getOpposite();q=cursor.relative(side);if(l.getBlockState(q).canBeReplaced())branch(l,q,length,r,side,center,depth+1);}
            Direction extra=HORIZONTAL[r.nextInt(4)];putLeaf(l,cursor.relative(extra),extra);previous=d;
        }
    }
    private void putLeaf(ServerLevel l,BlockPos p,Direction d){if(l.getBlockState(p).canBeReplaced())l.setBlock(p,leaves.get().defaultBlockState().setValue(ImportedWillowLeavesBlock.FACING,d).setValue(ImportedWillowLeavesBlock.NATURAL,true),Block.UPDATE_ALL);}
    private void hang(ServerLevel l,BlockPos p,int length){if(!l.isEmptyBlock(p))return;Block b=branch.get();for(int i=0;i<length;i++){BlockPos q=p.below(i);if(!l.isEmptyBlock(q))return;boolean end=i==length-1||!l.isEmptyBlock(q.below());l.setBlock(q,b.defaultBlockState().setValue(ImportedWillowBranchBlock.SHAPE,end?ImportedWillowBranchBlock.Shape.END:ImportedWillowBranchBlock.Shape.MIDDLE),Block.UPDATE_ALL);if(end)return;}}
}
