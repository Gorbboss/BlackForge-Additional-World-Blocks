package net.mcreator.evenbetternether.client;

import net.mcreator.evenbetternether.EvenbetternetherMod;
import net.mcreator.evenbetternether.init.BlackForgeImportedBlocks;
import net.mcreator.evenbetternether.init.EvenbetternetherModBlocks;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = EvenbetternetherMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public final class BlackForgeImportedRenderLayers {
    private BlackForgeImportedRenderLayers() {}

    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            RenderType cutout = RenderType.cutout();
            ItemBlockRenderTypes.setRenderLayer(EvenbetternetherModBlocks.FEATHER_FERN.get(), cutout);
            ItemBlockRenderTypes.setRenderLayer(EvenbetternetherModBlocks.BARREL_CACTUS.get(), cutout);
            ItemBlockRenderTypes.setRenderLayer(EvenbetternetherModBlocks.HANGING_MYCELIUM.get(), cutout);
            ItemBlockRenderTypes.setRenderLayer(BlackForgeImportedBlocks.NETHERRACK_STALACTITE.get(), cutout);
            ItemBlockRenderTypes.setRenderLayer(BlackForgeImportedBlocks.GLOWSTONE_STALACTITE.get(), cutout);
            ItemBlockRenderTypes.setRenderLayer(BlackForgeImportedBlocks.BLACKSTONE_STALACTITE.get(), cutout);
            ItemBlockRenderTypes.setRenderLayer(BlackForgeImportedBlocks.BASALT_STALACTITE.get(), cutout);
            ItemBlockRenderTypes.setRenderLayer(BlackForgeImportedBlocks.BONE_STALACTITE.get(), cutout);
            ItemBlockRenderTypes.setRenderLayer(BlackForgeImportedBlocks.END_STONE_STALACTITE.get(), cutout);
            ItemBlockRenderTypes.setRenderLayer(BlackForgeImportedBlocks.THICK_ENDSTONE_STALACTITE.get(), cutout);
            ItemBlockRenderTypes.setRenderLayer(BlackForgeImportedBlocks.HOOK_MUSHROOM.get(), cutout);
            ItemBlockRenderTypes.setRenderLayer(BlackForgeImportedBlocks.MOSS_COVER.get(), cutout);
            ItemBlockRenderTypes.setRenderLayer(BlackForgeImportedBlocks.JUNGLE_MOSS.get(), cutout);
            ItemBlockRenderTypes.setRenderLayer(BlackForgeImportedBlocks.SCULK_MOSS.get(), cutout);
            ItemBlockRenderTypes.setRenderLayer(BlackForgeImportedBlocks.WALL_MOSS.get(), cutout);
            ItemBlockRenderTypes.setRenderLayer(BlackForgeImportedBlocks.LUMINOUS_MOSS.get(), cutout);
            ItemBlockRenderTypes.setRenderLayer(BlackForgeImportedBlocks.ROTTEN_MUTATED_MOSS.get(), cutout);
            ItemBlockRenderTypes.setRenderLayer(BlackForgeImportedBlocks.NETHER_CACTUS.get(), cutout);
            ItemBlockRenderTypes.setRenderLayer(BlackForgeImportedBlocks.NETHER_GRASS.get(), cutout);
            ItemBlockRenderTypes.setRenderLayer(BlackForgeImportedBlocks.GLOOMGRASS.get(), cutout);
            ItemBlockRenderTypes.setRenderLayer(BlackForgeImportedBlocks.PALE_GLOOMGRASS.get(), cutout);
            ItemBlockRenderTypes.setRenderLayer(BlackForgeImportedBlocks.AGAVE.get(), cutout);
            ItemBlockRenderTypes.setRenderLayer(BlackForgeImportedBlocks.BETTER_NETHER_FEATHER_FERN.get(), cutout);
            ItemBlockRenderTypes.setRenderLayer(BlackForgeImportedBlocks.BONE_MUSHROOM.get(), cutout);
            ItemBlockRenderTypes.setRenderLayer(BlackForgeImportedBlocks.SEPIA_BONE_GRASS.get(), cutout);
            ItemBlockRenderTypes.setRenderLayer(BlackForgeImportedBlocks.GIANT_MOLD.get(), cutout);
            ItemBlockRenderTypes.setRenderLayer(BlackForgeImportedBlocks.GIANT_MOLD_SAPLING.get(), cutout);
            ItemBlockRenderTypes.setRenderLayer(BlackForgeImportedBlocks.STALAGNATE_SEED.get(), cutout);
            ItemBlockRenderTypes.setRenderLayer(BlackForgeImportedBlocks.STALAGNATE_STEM.get(), cutout);
            ItemBlockRenderTypes.setRenderLayer(BlackForgeImportedBlocks.STALAGNATE_TRUNK.get(), cutout);
            ItemBlockRenderTypes.setRenderLayer(BlackForgeImportedBlocks.WART_SEED.get(), cutout);
            ItemBlockRenderTypes.setRenderLayer(BlackForgeImportedBlocks.FRAGILE_WART.get(), cutout);
            ItemBlockRenderTypes.setRenderLayer(BlackForgeImportedBlocks.BLACK_VINE.get(), cutout);
            ItemBlockRenderTypes.setRenderLayer(BlackForgeImportedBlocks.BLOOMING_VINE.get(), cutout);
            ItemBlockRenderTypes.setRenderLayer(BlackForgeImportedBlocks.GOLDEN_VINE.get(), cutout);
            ItemBlockRenderTypes.setRenderLayer(BlackForgeImportedBlocks.GLOOMSCULK_VINE.get(), cutout);
            ItemBlockRenderTypes.setRenderLayer(BlackForgeImportedBlocks.LUMABUS_VINE.get(), cutout);
            ItemBlockRenderTypes.setRenderLayer(BlackForgeImportedBlocks.GOLDEN_LUMABUS_VINE.get(), cutout);
            ItemBlockRenderTypes.setRenderLayer(BlackForgeImportedBlocks.LUMABUS_SEED.get(), cutout);
            ItemBlockRenderTypes.setRenderLayer(BlackForgeImportedBlocks.GOLDEN_LUMABUS_SEED.get(), cutout);
            ItemBlockRenderTypes.setRenderLayer(BlackForgeImportedBlocks.WILLOW_DOOR.get(), cutout);
            ItemBlockRenderTypes.setRenderLayer(BlackForgeImportedBlocks.WILLOW_LEAVES.get(), cutout);
            ItemBlockRenderTypes.setRenderLayer(BlackForgeImportedBlocks.WILLOW_BRANCH.get(), cutout);
            ItemBlockRenderTypes.setRenderLayer(BlackForgeImportedBlocks.WILLOW_SAPLING.get(), cutout);
            ItemBlockRenderTypes.setRenderLayer(BlackForgeImportedBlocks.WILLOW_TORCH.get(), cutout);

            RenderType translucent = RenderType.translucent();
            ItemBlockRenderTypes.setRenderLayer(BlackForgeImportedBlocks.OBSIDIAN_GLASS.get(), translucent);
            ItemBlockRenderTypes.setRenderLayer(BlackForgeImportedBlocks.OBSIDIAN_GLASS_PANE.get(), translucent);
            ItemBlockRenderTypes.setRenderLayer(BlackForgeImportedBlocks.BLUE_OBSIDIAN_GLASS.get(), translucent);
            ItemBlockRenderTypes.setRenderLayer(BlackForgeImportedBlocks.BLUE_OBSIDIAN_GLASS_PANE.get(), translucent);
        });
    }
}
