package net.mcreator.evenbetternether.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import java.util.List;

public class ImportedSepiaBoneGrassBlock extends BushBlock {
    public ImportedSepiaBoneGrassBlock(){super(BlockBehaviour.Properties.copy(Blocks.CRIMSON_ROOTS).noCollission().offsetType(BlockBehaviour.OffsetType.XZ));}
    @Override protected boolean mayPlaceOn(BlockState s,BlockGetter l,BlockPos p){return s.isFaceSturdy(l,p,net.minecraft.core.Direction.UP);}
    @Override public List<ItemStack> getDrops(BlockState s,LootParams.Builder b){ItemStack tool=b.getOptionalParameter(LootContextParams.TOOL);return tool!=null&&tool.is(Items.SHEARS)?List.of(new ItemStack(this)):List.of();}
}
