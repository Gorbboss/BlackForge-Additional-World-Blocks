package net.mcreator.evenbetternether.block;

import java.util.function.Supplier;
import javax.annotation.Nullable;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ToolAction;
import net.minecraftforge.common.ToolActions;

/** Forge axe-stripping behavior for the imported Dragon Tree logs. */
public class ImportedStrippableLogBlock extends RotatedPillarBlock {
    private final Supplier<? extends Block> stripped;
    public ImportedStrippableLogBlock(BlockBehaviour.Properties properties, Supplier<? extends Block> stripped) {
        super(properties);
        this.stripped = stripped;
    }
    @Nullable
    @Override
    public BlockState getToolModifiedState(BlockState state, UseOnContext context, ToolAction action, boolean simulate) {
        if (action != ToolActions.AXE_STRIP) return super.getToolModifiedState(state, context, action, simulate);
        return stripped.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
    }
}
