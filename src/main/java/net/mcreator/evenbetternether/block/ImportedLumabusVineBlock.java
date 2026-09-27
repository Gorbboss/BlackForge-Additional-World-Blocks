package net.mcreator.evenbetternether.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class ImportedLumabusVineBlock extends Block {
    public static final EnumProperty<ImportedTripleShape> SHAPE=EnumProperty.create("shape",ImportedTripleShape.class);
    public ImportedLumabusVineBlock(){super(BlockBehaviour.Properties.copy(Blocks.WEEPING_VINES).noCollission().noOcclusion().lightLevel(s->s.getValue(SHAPE)==ImportedTripleShape.BOTTOM?15:0));registerDefaultState(stateDefinition.any().setValue(SHAPE,ImportedTripleShape.TOP));}
    @Override protected void createBlockStateDefinition(StateDefinition.Builder<Block,BlockState>b){b.add(SHAPE);}
    @Override public VoxelShape getShape(BlockState s,BlockGetter l,BlockPos p,CollisionContext c){return s.getValue(SHAPE)==ImportedTripleShape.BOTTOM?box(2,4,2,14,16,14):box(4,0,4,12,16,12);}
    @Override public boolean canSurvive(BlockState s,LevelReader l,BlockPos p){BlockState a=l.getBlockState(p.above());return a.is(this)||a.isFaceSturdy(l,p.above(),Direction.DOWN);}
    @Override public BlockState updateShape(BlockState s,Direction d,BlockState n,LevelAccessor l,BlockPos p,BlockPos np){return canSurvive(s,l,p)&&(l.getBlockState(p.below()).is(this)||s.getValue(SHAPE)==ImportedTripleShape.BOTTOM)?s:Blocks.AIR.defaultBlockState();}
    @Override public boolean isLadder(BlockState s,LevelReader l,BlockPos p,net.minecraft.world.entity.LivingEntity e){return true;}
}
