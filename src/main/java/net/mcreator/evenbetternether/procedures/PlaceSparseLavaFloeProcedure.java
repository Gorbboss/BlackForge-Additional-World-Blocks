/*
 * Decompiled with CFR 0.153-local.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.client.Minecraft
 *  net.minecraft.core.BlockPos
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.sounds.SoundSource
 *  net.minecraft.world.InteractionHand
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.level.ClipContext
 *  net.minecraft.world.level.ClipContext$Block
 *  net.minecraft.world.level.ClipContext$Fluid
 *  net.minecraft.world.level.GameType
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.Blocks
 *  net.minecraft.world.phys.HitResult$Type
 *  net.minecraftforge.event.entity.player.PlayerInteractEvent$RightClickItem
 *  net.minecraftforge.eventbus.api.Event
 *  net.minecraftforge.eventbus.api.SubscribeEvent
 *  net.minecraftforge.fml.common.Mod$EventBusSubscriber
 *  net.minecraftforge.registries.ForgeRegistries
 */
package net.mcreator.evenbetternether.procedures;

import javax.annotation.Nullable;
import net.mcreator.evenbetternether.init.EvenbetternetherModBlocks;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.HitResult;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber
public class PlaceSparseLavaFloeProcedure {
    @SubscribeEvent
    public static void onRightClickItem(PlayerInteractEvent.RightClickItem event) {
        if (event.getHand() != event.getEntity().m_7655_()) {
            return;
        }
        PlaceSparseLavaFloeProcedure.execute((Event)event, (LevelAccessor)event.getLevel(), (Entity)event.getEntity());
    }

    public static void execute(LevelAccessor world, Entity entity) {
        PlaceSparseLavaFloeProcedure.execute(null, world, entity);
    }

    private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
        if (entity == null) {
            return;
        }
        boolean YourFirstCondition = false;
        boolean YourSecondCondition = false;
        String ShaderLocation = "";
        double raytrace_y = 0.0;
        double raytrace_x = 0.0;
        double raytrace_z = 0.0;
        if (entity instanceof LivingEntity _entity && _entity.m_21055_(((Block)EvenbetternetherModBlocks.SPARSE_LAVA_FLOE.get()).m_5456_()) && entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0f), entity.m_20299_(1.0f).m_82549_(entity.m_20252_(1.0f).m_82490_(5.0)), ClipContext.Block.OUTLINE, ClipContext.Fluid.SOURCE_ONLY, entity)).m_6662_() == HitResult.Type.BLOCK && !new Object(){

            public boolean checkGamemode(Entity _ent) {
                if (_ent instanceof ServerPlayer _serverPlayer) {
                    return _serverPlayer.f_8941_.m_9290_() == GameType.ADVENTURE;
                }
                if (_ent.m_9236_().m_5776_() && _ent instanceof Player) {
                    Player _player = (Player)_ent;
                    return Minecraft.m_91087_().m_91403_().m_104949_(_player.m_36316_().getId()) != null && Minecraft.m_91087_().m_91403_().m_104949_(_player.m_36316_().getId()).m_105325_() == GameType.ADVENTURE;
                }
                return false;
            }
        }.checkGamemode(entity) && world.m_6425_(BlockPos.m_274561_((double)(raytrace_x = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0f), entity.m_20299_(1.0f).m_82549_(entity.m_20252_(1.0f).m_82490_(5.0)), ClipContext.Block.OUTLINE, ClipContext.Fluid.SOURCE_ONLY, entity)).m_82425_().m_123341_()), (double)(raytrace_y = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0f), entity.m_20299_(1.0f).m_82549_(entity.m_20252_(1.0f).m_82490_(5.0)), ClipContext.Block.OUTLINE, ClipContext.Fluid.SOURCE_ONLY, entity)).m_82425_().m_123342_()), (double)(raytrace_z = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0f), entity.m_20299_(1.0f).m_82549_(entity.m_20252_(1.0f).m_82490_(5.0)), ClipContext.Block.OUTLINE, ClipContext.Fluid.SOURCE_ONLY, entity)).m_82425_().m_123343_()))).m_76188_().m_60734_() == Blocks.f_49991_ && world.m_46859_(BlockPos.m_274561_((double)raytrace_x, (double)(raytrace_y + 1.0), (double)raytrace_z))) {
            LivingEntity _livEnt;
            LivingEntity _livEnt2;
            world.m_7731_(BlockPos.m_274561_((double)raytrace_x, (double)(raytrace_y + 1.0), (double)raytrace_z), ((Block)EvenbetternetherModBlocks.SPARSE_LAVA_FLOE.get()).m_49966_(), 3);
            if ((entity instanceof LivingEntity && null != (_livEnt2 = (LivingEntity)entity) ? _livEnt2.m_21205_() : ItemStack.f_41583_).m_41720_() == ((Block)EvenbetternetherModBlocks.SPARSE_LAVA_FLOE.get()).m_5456_()) {
                if (!new Object(){

                    public boolean checkGamemode(Entity _ent) {
                        if (_ent instanceof ServerPlayer _serverPlayer) {
                            return _serverPlayer.f_8941_.m_9290_() == GameType.CREATIVE;
                        }
                        if (_ent.m_9236_().m_5776_() && _ent instanceof Player) {
                            Player _player = (Player)_ent;
                            return Minecraft.m_91087_().m_91403_().m_104949_(_player.m_36316_().getId()) != null && Minecraft.m_91087_().m_91403_().m_104949_(_player.m_36316_().getId()).m_105325_() == GameType.CREATIVE;
                        }
                        return false;
                    }
                }.checkGamemode(entity)) {
                    LivingEntity _livEnt3;
                    (entity instanceof LivingEntity && null != (_livEnt3 = (LivingEntity)entity) ? _livEnt3.m_21205_() : ItemStack.f_41583_).m_41774_(1);
                }
                if (entity instanceof LivingEntity _entity) {
                    _entity.m_21011_(InteractionHand.MAIN_HAND, true);
                }
            } else if ((entity instanceof LivingEntity && null != (_livEnt = (LivingEntity)entity) ? _livEnt.m_21206_() : ItemStack.f_41583_).m_41720_() == ((Block)EvenbetternetherModBlocks.SPARSE_LAVA_FLOE.get()).m_5456_()) {
                if (!new Object(){

                    public boolean checkGamemode(Entity _ent) {
                        if (_ent instanceof ServerPlayer _serverPlayer) {
                            return _serverPlayer.f_8941_.m_9290_() == GameType.CREATIVE;
                        }
                        if (_ent.m_9236_().m_5776_() && _ent instanceof Player) {
                            Player _player = (Player)_ent;
                            return Minecraft.m_91087_().m_91403_().m_104949_(_player.m_36316_().getId()) != null && Minecraft.m_91087_().m_91403_().m_104949_(_player.m_36316_().getId()).m_105325_() == GameType.CREATIVE;
                        }
                        return false;
                    }
                }.checkGamemode(entity)) {
                    LivingEntity _livEnt4;
                    (entity instanceof LivingEntity && null != (_livEnt4 = (LivingEntity)entity) ? _livEnt4.m_21206_() : ItemStack.f_41583_).m_41774_(1);
                }
                if (entity instanceof LivingEntity _entity) {
                    _entity.m_21011_(InteractionHand.OFF_HAND, true);
                }
            }
            if (world instanceof Level) {
                Level _level = (Level)world;
                if (!_level.m_5776_()) {
                    _level.m_5594_(null, BlockPos.m_274561_((double)raytrace_x, (double)(raytrace_y + 1.0), (double)raytrace_z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.basalt.place")), SoundSource.BLOCKS, 1.0f, 1.0f);
                } else {
                    _level.m_7785_(raytrace_x, raytrace_y + 1.0, raytrace_z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.basalt.place")), SoundSource.BLOCKS, 1.0f, 1.0f, false);
                }
            }
        }
    }
}

