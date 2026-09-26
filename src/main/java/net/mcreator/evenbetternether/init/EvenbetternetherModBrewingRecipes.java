/*
 * Decompiled with CFR 0.153-local.
 * 
 * Could not load the following classes:
 *  mezz.jei.api.IModPlugin
 *  mezz.jei.api.JeiPlugin
 *  mezz.jei.api.constants.RecipeTypes
 *  mezz.jei.api.recipe.vanilla.IJeiBrewingRecipe
 *  mezz.jei.api.recipe.vanilla.IVanillaRecipeFactory
 *  mezz.jei.api.registration.IRecipeRegistration
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.item.Items
 *  net.minecraft.world.item.alchemy.Potion
 *  net.minecraft.world.item.alchemy.PotionUtils
 *  net.minecraft.world.item.alchemy.Potions
 *  net.minecraft.world.level.ItemLike
 */
package net.mcreator.evenbetternether.init;

import java.util.ArrayList;
import java.util.List;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.RecipeTypes;
import mezz.jei.api.recipe.vanilla.IJeiBrewingRecipe;
import mezz.jei.api.recipe.vanilla.IVanillaRecipeFactory;
import mezz.jei.api.registration.IRecipeRegistration;
import net.mcreator.evenbetternether.init.EvenbetternetherModBlocks;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.ItemLike;

@JeiPlugin
public class EvenbetternetherModBrewingRecipes
implements IModPlugin {
    public ResourceLocation getPluginUid() {
        return new ResourceLocation("evenbetternether:brewing_recipes");
    }

    public void registerRecipes(IRecipeRegistration registration) {
        IVanillaRecipeFactory factory = registration.getVanillaRecipeFactory();
        ArrayList<IJeiBrewingRecipe> brewingRecipes = new ArrayList<IJeiBrewingRecipe>();
        ItemStack potion = new ItemStack((ItemLike)Items.POTION);
        ItemStack potion2 = new ItemStack((ItemLike)Items.POTION);
        ArrayList<ItemStack> ingredientStack = new ArrayList<ItemStack>();
        ArrayList<ItemStack> inputStack = new ArrayList<ItemStack>();
        ingredientStack.add(new ItemStack((ItemLike)EvenbetternetherModBlocks.BARREL_CACTUS.get()));
        inputStack.add(new ItemStack((ItemLike)Items.GLASS_BOTTLE));
        PotionUtils.setPotion((ItemStack)potion, (Potion)Potions.WATER);
        brewingRecipes.add(factory.createBrewingRecipe(List.copyOf(ingredientStack), List.copyOf(inputStack), potion.copy()));
        ingredientStack.clear();
        inputStack.clear();
        registration.addRecipes(RecipeTypes.BREWING, brewingRecipes);
    }
}

