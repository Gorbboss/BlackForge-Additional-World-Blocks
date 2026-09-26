/*
 * Decompiled with CFR 0.153-local.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.tags.BlockTags
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.item.ItemEntity
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.item.Items
 *  net.minecraft.world.level.ItemLike
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraftforge.event.level.BlockEvent$BreakEvent
 *  net.minecraftforge.eventbus.api.Event
 *  net.minecraftforge.eventbus.api.SubscribeEvent
 *  net.minecraftforge.fml.common.Mod$EventBusSubscriber
 */
package net.mcreator.evenbetternether.procedures;

import javax.annotation.Nullable;
import net.mcreator.evenbetternether.init.EvenbetternetherModItems;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class NetherGrassesLootProcedure {
    @SubscribeEvent
    public static void onBlockBreak(BlockEvent.BreakEvent event) {
        NetherGrassesLootProcedure.execute((Event)event, event.getLevel(), event.getPos().m_123341_(), event.getPos().m_123342_(), event.getPos().m_123343_(), event.getState(), (Entity)event.getPlayer());
    }

    public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate, Entity entity) {
        NetherGrassesLootProcedure.execute(null, world, x, y, z, blockstate, entity);
    }

    private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, BlockState blockstate, Entity entity) {
        if (entity == null) {
            return;
        }
        if (blockstate.m_204336_(BlockTags.create((ResourceLocation)new ResourceLocation("evenbetternether:nether_grasses"))) && (entity instanceof LivingEntity _livEnt && null != _livEnt ? _livEnt.m_21205_() : ItemStack.f_41583_).m_41720_() != Items.f_42574_ && Math.random() < 0.4 && world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            ItemEntity entityToSpawn = new ItemEntity((Level)_level, x, y, z, new ItemStack((ItemLike)EvenbetternetherModItems.SPELT_SEEDS.get()));
            entityToSpawn.m_32010_(10);
            _level.m_7967_((Entity)entityToSpawn);
        }
    }
}

