/*
 * Decompiled with CFR 0.153-local.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.item.Items
 *  net.minecraft.world.item.alchemy.Potion
 *  net.minecraft.world.item.alchemy.PotionUtils
 *  net.minecraft.world.item.alchemy.Potions
 *  net.minecraft.world.item.crafting.Ingredient
 *  net.minecraft.world.level.ItemLike
 *  net.minecraftforge.common.brewing.BrewingRecipeRegistry
 *  net.minecraftforge.common.brewing.IBrewingRecipe
 *  net.minecraftforge.eventbus.api.SubscribeEvent
 *  net.minecraftforge.fml.common.Mod$EventBusSubscriber
 *  net.minecraftforge.fml.common.Mod$EventBusSubscriber$Bus
 *  net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent
 */
package net.mcreator.evenbetternether.recipes.brewing;

import net.mcreator.evenbetternether.init.EvenbetternetherModBlocks;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.common.brewing.IBrewingRecipe;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
public class WaterFromBarrelCactusBrewingRecipe
implements IBrewingRecipe {
    @SubscribeEvent
    public static void init(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> BrewingRecipeRegistry.addRecipe((IBrewingRecipe)new WaterFromBarrelCactusBrewingRecipe()));
    }

    public boolean isInput(ItemStack input) {
        return Ingredient.m_43927_((ItemStack[])new ItemStack[]{new ItemStack((ItemLike)Items.f_42590_)}).test(input);
    }

    public boolean isIngredient(ItemStack ingredient) {
        return Ingredient.m_43927_((ItemStack[])new ItemStack[]{new ItemStack((ItemLike)EvenbetternetherModBlocks.BARREL_CACTUS.get())}).test(ingredient);
    }

    public ItemStack getOutput(ItemStack input, ItemStack ingredient) {
        if (this.isInput(input) && this.isIngredient(ingredient)) {
            return PotionUtils.m_43549_((ItemStack)new ItemStack((ItemLike)Items.f_42589_), (Potion)Potions.f_43599_);
        }
        return ItemStack.f_41583_;
    }
}

