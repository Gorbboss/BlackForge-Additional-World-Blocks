package net.mcreator.evenbetternether.block;

import net.minecraft.util.StringRepresentable;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import java.util.List;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistries;

public class ImportedWillowBranchBlock extends Block {
    public enum Shape implements StringRepresentable { MIDDLE("middle"),END("end");private final String n;Shape(String n){this.n=n;}public String getSerializedName(){return n;}}
    public static final EnumProperty<Shape> SHAPE=EnumProperty.create("shape",Shape.class);
    public ImportedWillowBranchBlock(){super(BlockBehaviour.Properties.copy(Blocks.WEEPING_VINES).noCollission().noOcclusion().lightLevel(s->s.getValue(SHAPE)==Shape.END?15:0));registerDefaultState(stateDefinition.any().setValue(SHAPE,Shape.MIDDLE));}
    @Override protected void createBlockStateDefinition(StateDefinition.Builder<Block,BlockState>b){b.add(SHAPE);}
    @Override public VoxelShape getShape(BlockState s,BlockGetter l,BlockPos p,CollisionContext c){return box(4,0,4,12,16,12);}
    @Override public BlockState updateShape(BlockState s,Direction d,BlockState n,LevelAccessor l,BlockPos p,BlockPos np){
        if(l.isEmptyBlock(p.above()))return Blocks.AIR.defaultBlockState();
        return s;
    }
    private ItemStack torch(){var item=ForgeRegistries.ITEMS.getValue(new ResourceLocation("evenbetternether","willow_torch"));return item==null?ItemStack.EMPTY:new ItemStack(item);}
    @Override public ItemStack getCloneItemStack(BlockGetter l,BlockPos p,BlockState s){return s.getValue(SHAPE)==Shape.END?torch():new ItemStack(this);}
    @Override public List<ItemStack> getDrops(BlockState s,LootParams.Builder b){
        if(s.getValue(SHAPE)==Shape.END)return List.of(torch());
        ItemStack tool=b.getOptionalParameter(LootContextParams.TOOL);
        return tool!=null&&tool.is(Items.SHEARS)?List.of(new ItemStack(this)):List.of();
    }
}
