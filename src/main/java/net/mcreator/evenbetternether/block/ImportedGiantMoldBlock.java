package net.mcreator.evenbetternether.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import java.util.List;
import java.util.function.Supplier;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraftforge.registries.ForgeRegistries;

public class ImportedGiantMoldBlock extends Block {
    public static final EnumProperty<ImportedTripleShape> SHAPE = EnumProperty.create("shape", ImportedTripleShape.class);
    private static final VoxelShape TOP_SHAPE = box(2, 2, 2, 14, 14, 14);
    private static final VoxelShape STEM_SHAPE = box(5, 0, 5, 11, 16, 11);
    private final Supplier<Block> stem;
    public ImportedGiantMoldBlock(Supplier<Block> stem) {
        super(BlockBehaviour.Properties.copy(Blocks.MUSHROOM_STEM).noOcclusion().strength(1));
        this.stem=stem;
        registerDefaultState(stateDefinition.any().setValue(SHAPE, ImportedTripleShape.BOTTOM));
    }
    @Override protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> b) { b.add(SHAPE); }
    @Override public VoxelShape getShape(BlockState s, BlockGetter l, BlockPos p, CollisionContext c) { return s.getValue(SHAPE) == ImportedTripleShape.TOP ? TOP_SHAPE : STEM_SHAPE; }
    @Override public BlockState updateShape(BlockState s, Direction d, BlockState n, LevelAccessor l, BlockPos p, BlockPos np) {
        return s.getValue(SHAPE) == ImportedTripleShape.BOTTOM || l.getBlockState(p.below()).is(this) ? s : Blocks.AIR.defaultBlockState();
    }
    private ItemStack drop(BlockState s){if(s.getValue(SHAPE)==ImportedTripleShape.TOP){var item=ForgeRegistries.ITEMS.getValue(new ResourceLocation("evenbetternether","giant_mold_sapling"));if(item!=null)return new ItemStack(item);}return new ItemStack(stem.get());}
    @Override public ItemStack getCloneItemStack(BlockGetter l,BlockPos p,BlockState s){return drop(s);}
    @Override public List<ItemStack> getDrops(BlockState s,LootParams.Builder b){return List.of(drop(s));}
}
