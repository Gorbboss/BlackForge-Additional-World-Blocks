package net.mcreator.evenbetternether.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootParams;
import java.util.List;

/** Narrow Stalagnate stem matching the 6x6 rendered model without culling neighbours. */
public class ImportedStalagnateStemBlock extends RotatedPillarBlock {
    private static final VoxelShape Y=box(5,0,5,11,16,11);
    private static final VoxelShape X=box(0,5,5,16,11,11);
    private static final VoxelShape Z=box(5,5,0,11,11,16);
    public ImportedStalagnateStemBlock(){super(BlockBehaviour.Properties.copy(Blocks.WARPED_STEM).noOcclusion());}
    @Override public VoxelShape getShape(BlockState s,BlockGetter l,BlockPos p,CollisionContext c){
        return switch(s.getValue(AXIS)){case X->X;case Z->Z;default->Y;};
    }
    @Override public VoxelShape getCollisionShape(BlockState s,BlockGetter l,BlockPos p,CollisionContext c){return getShape(s,l,p,c);}
    @Override public List<ItemStack> getDrops(BlockState s,LootParams.Builder b){return List.of(new ItemStack(this));}
}
