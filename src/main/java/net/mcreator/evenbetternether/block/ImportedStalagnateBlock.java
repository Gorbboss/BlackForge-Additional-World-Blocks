package net.mcreator.evenbetternether.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootParams;
import java.util.List;
import java.util.function.Supplier;

public class ImportedStalagnateBlock extends Block {
    public static final EnumProperty<ImportedTripleShape> SHAPE=EnumProperty.create("shape",ImportedTripleShape.class);
    private final Supplier<Block> stem;
    public ImportedStalagnateBlock(Supplier<Block> stem){super(BlockBehaviour.Properties.copy(Blocks.WARPED_STEM).noOcclusion());this.stem=stem;registerDefaultState(stateDefinition.any().setValue(SHAPE,ImportedTripleShape.MIDDLE));}
    @Override protected void createBlockStateDefinition(StateDefinition.Builder<Block,BlockState>b){b.add(SHAPE);}
    @Override public VoxelShape getShape(BlockState s,BlockGetter l,BlockPos p,CollisionContext c){return box(4,0,4,12,16,12);}
    @Override public VoxelShape getCollisionShape(BlockState s,BlockGetter l,BlockPos p,CollisionContext c){return box(5,0,5,11,16,11);}
    @Override public boolean isLadder(BlockState s,net.minecraft.world.level.LevelReader l,BlockPos p,net.minecraft.world.entity.LivingEntity e){return true;}
    @Override public List<ItemStack> getDrops(BlockState s,LootParams.Builder b){return List.of(new ItemStack(stem.get()));}
}
