/*
 * Decompiled with CFR 0.153-local.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.level.ItemLike
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.ComposterBlock
 *  net.minecraftforge.eventbus.api.SubscribeEvent
 *  net.minecraftforge.fml.common.Mod$EventBusSubscriber
 *  net.minecraftforge.fml.common.Mod$EventBusSubscriber$Bus
 *  net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent
 */
package net.mcreator.evenbetternether.init;

import net.mcreator.evenbetternether.init.EvenbetternetherModBlocks;
import net.mcreator.evenbetternether.init.EvenbetternetherModItems;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
public class EvenbetternetherModCompostableItems {
    @SubscribeEvent
    public static void addComposterItems(FMLCommonSetupEvent event) {
        ComposterBlock.COMPOSTABLES.put(((Block)EvenbetternetherModBlocks.VERDANT_ROOTS.get()).asItem(), 0.3f);
        ComposterBlock.COMPOSTABLES.put(((Block)EvenbetternetherModBlocks.FEATHER_FERN.get()).asItem(), 0.3f);
        ComposterBlock.COMPOSTABLES.put(((Block)EvenbetternetherModBlocks.NETHER_AGAVE.get()).asItem(), 0.3f);
        ComposterBlock.COMPOSTABLES.put(((Block)EvenbetternetherModBlocks.VERDANT_SPROUTS.get()).asItem(), 0.3f);
        ComposterBlock.COMPOSTABLES.put(((Block)EvenbetternetherModBlocks.NETHER_SAGUARO.get()).asItem(), 0.5f);
        ComposterBlock.COMPOSTABLES.put(((Block)EvenbetternetherModBlocks.BARREL_CACTUS.get()).asItem(), 0.5f);
        ComposterBlock.COMPOSTABLES.put(((Block)EvenbetternetherModBlocks.SOUL_ROOTS.get()).asItem(), 0.3f);
        ComposterBlock.COMPOSTABLES.put(((Block)EvenbetternetherModBlocks.SOUL_SPROUTS.get()).asItem(), 0.3f);
        ComposterBlock.COMPOSTABLES.put(((Block)EvenbetternetherModBlocks.BURNING_ROOTS.get()).asItem(), 0.3f);
        ComposterBlock.COMPOSTABLES.put(((Block)EvenbetternetherModBlocks.BURNING_SPROUTS.get()).asItem(), 0.3f);
        ComposterBlock.COMPOSTABLES.put(((Block)EvenbetternetherModBlocks.CHARRED_SPROUTS.get()).asItem(), 0.3f);
        ComposterBlock.COMPOSTABLES.put(((Block)EvenbetternetherModBlocks.TALL_NETHERSHROOM.get()).asItem(), 0.3f);
        ComposterBlock.COMPOSTABLES.put(((Block)EvenbetternetherModBlocks.NETHERSHROOM.get()).asItem(), 0.3f);
        ComposterBlock.COMPOSTABLES.put(((Block)EvenbetternetherModBlocks.FUNGAL_ROOTS.get()).asItem(), 0.3f);
        ComposterBlock.COMPOSTABLES.put(((Block)EvenbetternetherModBlocks.FUNGAL_SPROUTS.get()).asItem(), 0.3f);
        ComposterBlock.COMPOSTABLES.put(((Block)EvenbetternetherModBlocks.HANGING_MYCELIUM.get()).asItem(), 0.3f);
        ComposterBlock.COMPOSTABLES.put(((Block)EvenbetternetherModBlocks.LONG_HANGING_MYCELIUM.get()).asItem(), 0.3f);
        ComposterBlock.COMPOSTABLES.put(((Block)EvenbetternetherModBlocks.BULBOUS_HANGING_MYCELIUM.get()).asItem(), 0.5f);
        ComposterBlock.COMPOSTABLES.put(((ItemLike)EvenbetternetherModItems.SPELT_SEEDS.get()), 0.25f);
        ComposterBlock.COMPOSTABLES.put(((ItemLike)EvenbetternetherModItems.SPELT_ITEM.get()), 0.65f);
        ComposterBlock.COMPOSTABLES.put(((Block)EvenbetternetherModBlocks.TALL_BROWN_NETHERSHROOM.get()).asItem(), 0.3f);
        ComposterBlock.COMPOSTABLES.put(((Block)EvenbetternetherModBlocks.BROWN_NETHERSHROOM.get()).asItem(), 0.3f);
    }
}

