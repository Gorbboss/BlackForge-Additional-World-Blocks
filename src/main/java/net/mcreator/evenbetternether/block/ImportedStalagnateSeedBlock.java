package net.mcreator.evenbetternether.block;

import java.util.function.Supplier;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class ImportedStalagnateSeedBlock extends BushBlock implements BonemealableBlock {
    public static final BooleanProperty TOP=BooleanProperty.create("top"); private final Supplier<Block> trunk;
    public ImportedStalagnateSeedBlock(Supplier<Block> trunk){super(BlockBehaviour.Properties.copy(Blocks.WARPED_FUNGUS).noCollission());this.trunk=trunk;registerDefaultState(stateDefinition.any().setValue(TOP,true));}
    @Override protected void createBlockStateDefinition(StateDefinition.Builder<Block,BlockState>b){b.add(TOP);}
    @Override public BlockState getStateForPlacement(BlockPlaceContext c){return c.getClickedFace()==Direction.DOWN?defaultBlockState():c.getClickedFace()==Direction.UP?defaultBlockState().setValue(TOP,false):null;}
    @Override public VoxelShape getShape(BlockState s,BlockGetter l,BlockPos p,CollisionContext c){return s.getValue(TOP)?box(4,6,4,12,16,12):box(4,0,4,12,12,12);}
    @Override public boolean canSurvive(BlockState s,LevelReader l,BlockPos p){BlockPos q=s.getValue(TOP)?p.above():p.below();BlockState support=l.getBlockState(q);return support.is(Blocks.NETHERRACK)||support.is(Blocks.CRIMSON_NYLIUM)||support.is(Blocks.WARPED_NYLIUM);}
    @Override public boolean isValidBonemealTarget(LevelReader l,BlockPos p,BlockState s,boolean c){Direction d=s.getValue(TOP)?Direction.DOWN:Direction.UP;for(int i=1;i<=3;i++)if(!l.isEmptyBlock(p.relative(d,i)))return false;return true;}
    @Override public boolean isBonemealSuccess(Level l,RandomSource r,BlockPos p,BlockState s){return r.nextInt(8)==0&&isValidBonemealTarget(l,p,s,false);}
    @Override public void performBonemeal(ServerLevel l,RandomSource r,BlockPos p,BlockState s){
        Direction d=s.getValue(TOP)?Direction.DOWN:Direction.UP;
        int limit=d==Direction.UP?l.getMaxBuildHeight()-p.getY():p.getY()-l.getMinBuildHeight()+1;
        int distance=1;
        while(distance<limit&&l.isEmptyBlock(p.relative(d,distance)))distance++;
        // Only grow when a real opposite surface was found; fill the entire gap so long
        // Stalagnates can connect the Nether floor and ceiling in tall custom worlds.
        if(distance>=limit||distance<3)return;
        int length=distance;
        Block b=trunk.get();
        for(int i=0;i<length;i++){
            ImportedTripleShape shape=i==0?ImportedTripleShape.BOTTOM:i==length-1?ImportedTripleShape.TOP:ImportedTripleShape.MIDDLE;
            if(d==Direction.DOWN)shape=shape==ImportedTripleShape.TOP?ImportedTripleShape.BOTTOM:shape==ImportedTripleShape.BOTTOM?ImportedTripleShape.TOP:shape;
            l.setBlock(p.relative(d,i),b.defaultBlockState().setValue(ImportedStalagnateBlock.SHAPE,shape),Block.UPDATE_ALL);
        }
    }
}
