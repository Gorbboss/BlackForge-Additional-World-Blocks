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
        if (event.getHand() != event.getEntity().getUsedItemHand()) {
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
        if (entity instanceof LivingEntity _entity && _entity.isHolding(((Block)EvenbetternetherModBlocks.SPARSE_LAVA_FLOE.get()).asItem()) && entity.level().clip(new ClipContext(entity.getEyePosition(1.0f), entity.getEyePosition(1.0f).add(entity.getViewVector(1.0f).scale(5.0)), ClipContext.Block.OUTLINE, ClipContext.Fluid.SOURCE_ONLY, entity)).getType() == HitResult.Type.BLOCK && !new Object(){

            public boolean checkGamemode(Entity _ent) {
                if (_ent instanceof ServerPlayer _serverPlayer) {
                    return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.ADVENTURE;
                }
                if (_ent.level().isClientSide() && _ent instanceof Player) {
                    Player _player = (Player)_ent;
                    return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null && Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.ADVENTURE;
                }
                return false;
            }
        }.checkGamemode(entity) && world.getFluidState(BlockPos.containing((double)(raytrace_x = (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0f), entity.getEyePosition(1.0f).add(entity.getViewVector(1.0f).scale(5.0)), ClipContext.Block.OUTLINE, ClipContext.Fluid.SOURCE_ONLY, entity)).getBlockPos().getX()), (double)(raytrace_y = (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0f), entity.getEyePosition(1.0f).add(entity.getViewVector(1.0f).scale(5.0)), ClipContext.Block.OUTLINE, ClipContext.Fluid.SOURCE_ONLY, entity)).getBlockPos().getY()), (double)(raytrace_z = (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0f), entity.getEyePosition(1.0f).add(entity.getViewVector(1.0f).scale(5.0)), ClipContext.Block.OUTLINE, ClipContext.Fluid.SOURCE_ONLY, entity)).getBlockPos().getZ()))).createLegacyBlock().getBlock() == Blocks.LAVA && world.isEmptyBlock(BlockPos.containing((double)raytrace_x, (double)(raytrace_y + 1.0), (double)raytrace_z))) {
            LivingEntity _livEnt;
            LivingEntity _livEnt2;
            world.setBlock(BlockPos.containing((double)raytrace_x, (double)(raytrace_y + 1.0), (double)raytrace_z), ((Block)EvenbetternetherModBlocks.SPARSE_LAVA_FLOE.get()).defaultBlockState(), 3);
            if ((entity instanceof LivingEntity && null != (_livEnt2 = (LivingEntity)entity) ? _livEnt2.getMainHandItem() : ItemStack.EMPTY).getItem() == ((Block)EvenbetternetherModBlocks.SPARSE_LAVA_FLOE.get()).asItem()) {
                if (!new Object(){

                    public boolean checkGamemode(Entity _ent) {
                        if (_ent instanceof ServerPlayer _serverPlayer) {
                            return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.CREATIVE;
                        }
                        if (_ent.level().isClientSide() && _ent instanceof Player) {
                            Player _player = (Player)_ent;
                            return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null && Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.CREATIVE;
                        }
                        return false;
                    }
                }.checkGamemode(entity)) {
                    LivingEntity _livEnt3;
                    (entity instanceof LivingEntity && null != (_livEnt3 = (LivingEntity)entity) ? _livEnt3.getMainHandItem() : ItemStack.EMPTY).shrink(1);
                }
                if (entity instanceof LivingEntity _entity) {
                    _entity.swing(InteractionHand.MAIN_HAND, true);
                }
            } else if ((entity instanceof LivingEntity && null != (_livEnt = (LivingEntity)entity) ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == ((Block)EvenbetternetherModBlocks.SPARSE_LAVA_FLOE.get()).asItem()) {
                if (!new Object(){

                    public boolean checkGamemode(Entity _ent) {
                        if (_ent instanceof ServerPlayer _serverPlayer) {
                            return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.CREATIVE;
                        }
                        if (_ent.level().isClientSide() && _ent instanceof Player) {
                            Player _player = (Player)_ent;
                            return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null && Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.CREATIVE;
                        }
                        return false;
                    }
                }.checkGamemode(entity)) {
                    LivingEntity _livEnt4;
                    (entity instanceof LivingEntity && null != (_livEnt4 = (LivingEntity)entity) ? _livEnt4.getOffhandItem() : ItemStack.EMPTY).shrink(1);
                }
                if (entity instanceof LivingEntity _entity) {
                    _entity.swing(InteractionHand.OFF_HAND, true);
                }
            }
            if (world instanceof Level) {
                Level _level = (Level)world;
                if (!_level.isClientSide()) {
                    _level.playSound(null, BlockPos.containing((double)raytrace_x, (double)(raytrace_y + 1.0), (double)raytrace_z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.basalt.place")), SoundSource.BLOCKS, 1.0f, 1.0f);
                } else {
                    _level.playLocalSound(raytrace_x, raytrace_y + 1.0, raytrace_z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.basalt.place")), SoundSource.BLOCKS, 1.0f, 1.0f, false);
                }
            }
        }
    }
}

