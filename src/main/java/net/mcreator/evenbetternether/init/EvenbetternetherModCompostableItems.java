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
        ComposterBlock.f_51914_.put((Object)((Block)EvenbetternetherModBlocks.VERDANT_ROOTS.get()).m_5456_(), 0.3f);
        ComposterBlock.f_51914_.put((Object)((Block)EvenbetternetherModBlocks.FEATHER_FERN.get()).m_5456_(), 0.3f);
        ComposterBlock.f_51914_.put((Object)((Block)EvenbetternetherModBlocks.NETHER_AGAVE.get()).m_5456_(), 0.3f);
        ComposterBlock.f_51914_.put((Object)((Block)EvenbetternetherModBlocks.VERDANT_SPROUTS.get()).m_5456_(), 0.3f);
        ComposterBlock.f_51914_.put((Object)((Block)EvenbetternetherModBlocks.NETHER_SAGUARO.get()).m_5456_(), 0.5f);
        ComposterBlock.f_51914_.put((Object)((Block)EvenbetternetherModBlocks.BARREL_CACTUS.get()).m_5456_(), 0.5f);
        ComposterBlock.f_51914_.put((Object)((Block)EvenbetternetherModBlocks.SOUL_ROOTS.get()).m_5456_(), 0.3f);
        ComposterBlock.f_51914_.put((Object)((Block)EvenbetternetherModBlocks.SOUL_SPROUTS.get()).m_5456_(), 0.3f);
        ComposterBlock.f_51914_.put((Object)((Block)EvenbetternetherModBlocks.BURNING_ROOTS.get()).m_5456_(), 0.3f);
        ComposterBlock.f_51914_.put((Object)((Block)EvenbetternetherModBlocks.BURNING_SPROUTS.get()).m_5456_(), 0.3f);
        ComposterBlock.f_51914_.put((Object)((Block)EvenbetternetherModBlocks.CHARRED_SPROUTS.get()).m_5456_(), 0.3f);
        ComposterBlock.f_51914_.put((Object)((Block)EvenbetternetherModBlocks.TALL_NETHERSHROOM.get()).m_5456_(), 0.3f);
        ComposterBlock.f_51914_.put((Object)((Block)EvenbetternetherModBlocks.NETHERSHROOM.get()).m_5456_(), 0.3f);
        ComposterBlock.f_51914_.put((Object)((Block)EvenbetternetherModBlocks.FUNGAL_ROOTS.get()).m_5456_(), 0.3f);
        ComposterBlock.f_51914_.put((Object)((Block)EvenbetternetherModBlocks.FUNGAL_SPROUTS.get()).m_5456_(), 0.3f);
        ComposterBlock.f_51914_.put((Object)((Block)EvenbetternetherModBlocks.HANGING_MYCELIUM.get()).m_5456_(), 0.3f);
        ComposterBlock.f_51914_.put((Object)((Block)EvenbetternetherModBlocks.LONG_HANGING_MYCELIUM.get()).m_5456_(), 0.3f);
        ComposterBlock.f_51914_.put((Object)((Block)EvenbetternetherModBlocks.BULBOUS_HANGING_MYCELIUM.get()).m_5456_(), 0.5f);
        ComposterBlock.f_51914_.put((Object)((ItemLike)EvenbetternetherModItems.SPELT_SEEDS.get()), 0.25f);
        ComposterBlock.f_51914_.put((Object)((ItemLike)EvenbetternetherModItems.SPELT_ITEM.get()), 0.65f);
        ComposterBlock.f_51914_.put((Object)((Block)EvenbetternetherModBlocks.TALL_BROWN_NETHERSHROOM.get()).m_5456_(), 0.3f);
        ComposterBlock.f_51914_.put((Object)((Block)EvenbetternetherModBlocks.BROWN_NETHERSHROOM.get()).m_5456_(), 0.3f);
    }
}

