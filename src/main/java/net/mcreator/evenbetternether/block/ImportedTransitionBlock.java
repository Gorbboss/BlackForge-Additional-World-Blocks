package net.mcreator.evenbetternether.block;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
public class ImportedTransitionBlock extends Block {
 public static final BooleanProperty TRANSITION=BooleanProperty.create("transition");
 public ImportedTransitionBlock(int light){super(BlockBehaviour.Properties.copy(Blocks.MUSHROOM_STEM).noOcclusion().lightLevel(s->light));registerDefaultState(stateDefinition.any().setValue(TRANSITION,false));}
 @Override protected void createBlockStateDefinition(StateDefinition.Builder<Block,BlockState>b){b.add(TRANSITION);}
}
