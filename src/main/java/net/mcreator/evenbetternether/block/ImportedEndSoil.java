package net.mcreator.evenbetternether.block;

import net.mcreator.evenbetternether.init.BlackForgeImportedBlocks;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

/** Ground shared by imported End seeds, trees, and berry crops. */
final class ImportedEndSoil {
    private ImportedEndSoil() {}

    static boolean supports(BlockState ground) {
        return ground.is(Blocks.END_STONE)
                || ground.is(Blocks.SCULK)
                || ground.is(BlackForgeImportedBlocks.AMBER_MOSS.get())
                || ground.is(BlackForgeImportedBlocks.UMBRALITH.get())
                || ground.is(BlackForgeImportedBlocks.FLAVOLITE.get())
                || ground.is(BlackForgeImportedBlocks.SULPHURIC_ROCK.get())
                || ground.is(BlackForgeImportedBlocks.PALLIDIUM_FULL.get())
                || ground.is(BlackForgeImportedBlocks.PALLIDIUM_HEAVY.get())
                || ground.is(BlackForgeImportedBlocks.PALLIDIUM_THIN.get())
                || ground.is(BlackForgeImportedBlocks.PALLIDIUM_TINY.get());
    }
}
