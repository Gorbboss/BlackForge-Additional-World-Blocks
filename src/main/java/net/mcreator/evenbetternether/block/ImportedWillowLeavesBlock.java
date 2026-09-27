package net.mcreator.evenbetternether.block;

import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraftforge.registries.ForgeRegistries;
import java.util.ArrayList;
import java.util.List;

public class ImportedWillowLeavesBlock extends Block {
    public static final DirectionProperty FACING=DirectionProperty.create("facing");
    public static final BooleanProperty NATURAL=BooleanProperty.create("natural");
    public ImportedWillowLeavesBlock(){super(BlockBehaviour.Properties.copy(Blocks.AZALEA_LEAVES).noOcclusion());registerDefaultState(stateDefinition.any().setValue(FACING,Direction.UP).setValue(NATURAL,false));}
    @Override protected void createBlockStateDefinition(StateDefinition.Builder<Block,BlockState>b){b.add(FACING,NATURAL);}
    @Override public List<ItemStack> getDrops(BlockState s,LootParams.Builder b){
        ItemStack tool=b.getOptionalParameter(LootContextParams.TOOL);
        if(tool!=null&&(tool.is(Items.SHEARS)||EnchantmentHelper.getItemEnchantmentLevel(Enchantments.SILK_TOUCH,tool)>0))return List.of(new ItemStack(this));
        List<ItemStack> out=new ArrayList<>();
        if(b.getLevel().random.nextFloat()<0.1F){var sapling=ForgeRegistries.ITEMS.getValue(new ResourceLocation("evenbetternether","willow_sapling"));if(sapling!=null)out.add(new ItemStack(sapling));}
        if(b.getLevel().random.nextFloat()<0.02F)out.add(new ItemStack(Items.STICK,1+b.getLevel().random.nextInt(2)));
        return out;
    }
}
