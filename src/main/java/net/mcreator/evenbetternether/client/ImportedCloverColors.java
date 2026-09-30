package net.mcreator.evenbetternether.client;

import net.mcreator.evenbetternether.EvenbetternetherMod;
import net.mcreator.evenbetternether.init.BlackForgeImportedBlocks;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.world.level.GrassColor;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = EvenbetternetherMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public final class ImportedCloverColors {
    private ImportedCloverColors() {}

    @SubscribeEvent public static void blockColors(RegisterColorHandlersEvent.Block event) {
        event.register((state, level, pos, tint) -> level != null && pos != null
                ? BiomeColors.getAverageGrassColor(level, pos) : GrassColor.get(0.5, 1.0),
                BlackForgeImportedBlocks.CLOVER.get());
        event.register((state, level, pos, tint) -> 0x208030,
                BlackForgeImportedBlocks.SMALL_LILY_PADS.get(), BlackForgeImportedBlocks.BIG_LILY_PAD.get());
    }
    @SubscribeEvent public static void itemColors(RegisterColorHandlersEvent.Item event) {
        event.register((stack, tint) -> 0x208030,
                BlackForgeImportedBlocks.SMALL_LILY_PADS.get(), BlackForgeImportedBlocks.BIG_LILY_PAD.get());
    }
}
