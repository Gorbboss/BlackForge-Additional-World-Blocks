package net.mcreator.evenbetternether.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.Mth;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

/** One placeable hanging-mycelium vine with three tips and two connected segments. */
public class CombinedHangingMyceliumBlock extends Block {
    public static final BooleanProperty BOTTOM=BooleanProperty.create("bottom");
    public static final IntegerProperty VARIANT=IntegerProperty.create("variant",0,2);
    public CombinedHangingMyceliumBlock(){super(BlockBehaviour.Properties.copy(Blocks.WEEPING_VINES).noCollission().noOcclusion());registerDefaultState(stateDefinition.any().setValue(BOTTOM,true).setValue(VARIANT,0));}
    @Override protected void createBlockStateDefinition(StateDefinition.Builder<Block,BlockState>b){b.add(BOTTOM,VARIANT);}
    private int variant(BlockPos p,int count){return Math.floorMod((int)Mth.getSeed(p),count);}
    @Override public BlockState getStateForPlacement(BlockPlaceContext c){return defaultBlockState().setValue(VARIANT,variant(c.getClickedPos(),3));}
    @Override public boolean canSurvive(BlockState s,LevelReader l,BlockPos p){BlockState a=l.getBlockState(p.above());return a.is(this)||a.isFaceSturdy(l,p.above(),Direction.DOWN);}
    @Override public BlockState updateShape(BlockState s,Direction d,BlockState n,LevelAccessor l,BlockPos p,BlockPos np){
        if(!canSurvive(s,l,p))return Blocks.AIR.defaultBlockState();
        boolean bottom=!l.getBlockState(p.below()).is(this);
        return s.setValue(BOTTOM,bottom).setValue(VARIANT,variant(p,bottom?3:2));
    }
}
