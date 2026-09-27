package net.mcreator.evenbetternether.block;

import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.AttachFace;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

/** Collision for the lower two sections of a three-high vanilla-style pointed dripstone. */
final class SpeleothemShapes {
    private SpeleothemShapes() {}

    private static final VoxelShape FLOOR=Shapes.or(Block.box(2,0,2,14,16,14),Block.box(4,16,4,12,32,12));
    private static final VoxelShape CEILING=Shapes.or(Block.box(2,0,2,14,16,14),Block.box(4,-16,4,12,0,12));
    private static final VoxelShape NORTH=Shapes.or(Block.box(2,2,0,14,14,16),Block.box(4,4,-16,12,12,0));
    private static final VoxelShape SOUTH=Shapes.or(Block.box(2,2,0,14,14,16),Block.box(4,4,16,12,12,32));
    private static final VoxelShape WEST=Shapes.or(Block.box(0,2,2,16,14,14),Block.box(-16,4,4,0,12,12));
    private static final VoxelShape EAST=Shapes.or(Block.box(0,2,2,16,14,14),Block.box(16,4,4,32,12,12));

    static VoxelShape get(AttachFace face,Direction facing){
        if(face==AttachFace.FLOOR)return FLOOR;
        if(face==AttachFace.CEILING)return CEILING;
        return switch(facing){case NORTH->NORTH;case SOUTH->SOUTH;case WEST->WEST;case EAST->EAST;default->SOUTH;};
    }
}
