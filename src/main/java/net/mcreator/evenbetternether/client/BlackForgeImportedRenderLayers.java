package net.mcreator.evenbetternether.client;

import net.mcreator.evenbetternether.EvenbetternetherMod;
import net.mcreator.evenbetternether.init.BlackForgeImportedBlocks;
import net.mcreator.evenbetternether.init.BlackForgeBetterEndBlocks;
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
            ItemBlockRenderTypes.setRenderLayer(BlackForgeBetterEndBlocks.FRAGILE_WART.get(), cutout);
            ItemBlockRenderTypes.setRenderLayer(BlackForgeBetterEndBlocks.END_STONE_STALACTITE.get(), cutout);
            ItemBlockRenderTypes.setRenderLayer(BlackForgeBetterEndBlocks.THICK_ENDSTONE_STALACTITE.get(), cutout);
            ItemBlockRenderTypes.setRenderLayer(BlackForgeBetterEndBlocks.INFLEXIA.get(), cutout);
            ItemBlockRenderTypes.setRenderLayer(BlackForgeBetterEndBlocks.FLAMMALIX.get(), cutout);
            ItemBlockRenderTypes.setRenderLayer(BlackForgeBetterEndBlocks.PURPLE_POLYPORE.get(), cutout);
            ItemBlockRenderTypes.setRenderLayer(BlackForgeBetterEndBlocks.AURANT_POLYPORE.get(), cutout);
            ItemBlockRenderTypes.setRenderLayer(BlackForgeBetterEndBlocks.AMBER_GRASS.get(), cutout);
            ItemBlockRenderTypes.setRenderLayer(BlackForgeBetterEndBlocks.BUSHY_GRASS.get(), cutout);
            ItemBlockRenderTypes.setRenderLayer(BlackForgeBetterEndBlocks.CRYSTAL_MOSS_COVER.get(), cutout);
            ItemBlockRenderTypes.setRenderLayer(BlackForgeBetterEndBlocks.TAIL_MOSS.get(), cutout);
            ItemBlockRenderTypes.setRenderLayer(BlackForgeBetterEndBlocks.SHADOW_PLANT.get(), cutout);
            ItemBlockRenderTypes.setRenderLayer(BlackForgeBetterEndBlocks.MURKWEED.get(), cutout);
            ItemBlockRenderTypes.setRenderLayer(BlackForgeBetterEndBlocks.NEEDLEGRASS.get(), cutout);
            ItemBlockRenderTypes.setRenderLayer(BlackForgeBetterEndBlocks.CREEPING_MOSS.get(), cutout);
            ItemBlockRenderTypes.setRenderLayer(BlackForgeBetterEndBlocks.AERIDIUM.get(), cutout);
            ItemBlockRenderTypes.setRenderLayer(BlackForgeBetterEndBlocks.CHORUS_GRASS.get(), cutout);
            ItemBlockRenderTypes.setRenderLayer(BlackForgeBetterEndBlocks.SALTEAGO.get(), cutout);
            ItemBlockRenderTypes.setRenderLayer(BlackForgeBetterEndBlocks.BLOOMING_COOKSONIA.get(), cutout);
            ItemBlockRenderTypes.setRenderLayer(BlackForgeBetterEndBlocks.JUNGLE_GRASS.get(), cutout);
            ItemBlockRenderTypes.setRenderLayer(BlackForgeBetterEndBlocks.VAIOLUSH_FERN.get(), cutout);
            ItemBlockRenderTypes.setRenderLayer(BlackForgeBetterEndBlocks.FRACTURN.get(), cutout);
            ItemBlockRenderTypes.setRenderLayer(BlackForgeBetterEndBlocks.BLUE_CHARNIA.get(), cutout);
            ItemBlockRenderTypes.setRenderLayer(BlackForgeBetterEndBlocks.CYAN_MOSS.get(), cutout);
            ItemBlockRenderTypes.setRenderLayer(BlackForgeBetterEndBlocks.HYDRALUX_SAPLING.get(), cutout);
            ItemBlockRenderTypes.setRenderLayer(BlackForgeBetterEndBlocks.HYDRALUX.get(), cutout);
            ItemBlockRenderTypes.setRenderLayer(BlackForgeBetterEndBlocks.GLOWING_PILLAR_SEED.get(), cutout);
            ItemBlockRenderTypes.setRenderLayer(BlackForgeBetterEndBlocks.GLOWING_PILLAR_ROOTS.get(), cutout);
            ItemBlockRenderTypes.setRenderLayer(BlackForgeBetterEndBlocks.GLOWING_PILLAR_LEAVES.get(), cutout);
            ItemBlockRenderTypes.setRenderLayer(BlackForgeBetterEndBlocks.LANCELEAF_SEED.get(), cutout);
            ItemBlockRenderTypes.setRenderLayer(BlackForgeBetterEndBlocks.LANCELEAF.get(), cutout);
            ItemBlockRenderTypes.setRenderLayer(BlackForgeBetterEndBlocks.BLUE_VINE_SEED.get(), cutout);
            ItemBlockRenderTypes.setRenderLayer(BlackForgeBetterEndBlocks.BLUE_VINE.get(), cutout);
            ItemBlockRenderTypes.setRenderLayer(BlackForgeBetterEndBlocks.BLUE_VINE_FUR.get(), cutout);
            ItemBlockRenderTypes.setRenderLayer(BlackForgeBetterEndBlocks.AMARANITA_FUR.get(), cutout);
            ItemBlockRenderTypes.setRenderLayer(BlackForgeBetterEndBlocks.MOSSY_GLOWSHROOM_FUR.get(), cutout);
            ItemBlockRenderTypes.setRenderLayer(BlackForgeBetterEndBlocks.TWISTED_VINE.get(), cutout);
            ItemBlockRenderTypes.setRenderLayer(BlackForgeBetterEndBlocks.HELIX_TREE_LEAVES.get(), cutout);
            ItemBlockRenderTypes.setRenderLayer(BlackForgeBetterEndBlocks.HELIX_TREE_SAPLING.get(), cutout);
            ItemBlockRenderTypes.setRenderLayer(BlackForgeBetterEndBlocks.MOSSY_GLOWSHROOM_SAPLING.get(), cutout);
            ItemBlockRenderTypes.setRenderLayer(BlackForgeBetterEndBlocks.DRAGON_TREE_DOOR.get(), cutout);
            ItemBlockRenderTypes.setRenderLayer(BlackForgeBetterEndBlocks.DRAGON_TREE_TRAPDOOR.get(), cutout);
            ItemBlockRenderTypes.setRenderLayer(BlackForgeBetterEndBlocks.DRAGON_TREE_LEAVES.get(), cutout);
            ItemBlockRenderTypes.setRenderLayer(BlackForgeBetterEndBlocks.DRAGON_TREE_SAPLING.get(), cutout);
            ItemBlockRenderTypes.setRenderLayer(BlackForgeBetterEndBlocks.BARBED_SCULK_ROOT.get(), cutout);
            ItemBlockRenderTypes.setRenderLayer(BlackForgeBetterEndBlocks.BLOSSOM_BERRY_SEED.get(), cutout);
            ItemBlockRenderTypes.setRenderLayer(BlackForgeBetterEndBlocks.SHADOW_BERRY.get(), cutout);

            RenderType translucent = RenderType.translucent();
            ItemBlockRenderTypes.setRenderLayer(BlackForgeImportedBlocks.OBSIDIAN_GLASS.get(), translucent);
            ItemBlockRenderTypes.setRenderLayer(BlackForgeImportedBlocks.OBSIDIAN_GLASS_PANE.get(), translucent);
            ItemBlockRenderTypes.setRenderLayer(BlackForgeImportedBlocks.BLUE_OBSIDIAN_GLASS.get(), translucent);
            ItemBlockRenderTypes.setRenderLayer(BlackForgeImportedBlocks.BLUE_OBSIDIAN_GLASS_PANE.get(), translucent);
            ItemBlockRenderTypes.setRenderLayer(BlackForgeBetterEndBlocks.AURORA_CRYSTAL.get(), translucent);
        });
    }
}
