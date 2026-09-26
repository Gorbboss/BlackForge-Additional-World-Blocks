/*
 * Decompiled with CFR 0.153-local.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.item.Item$Properties
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.item.PickaxeItem
 *  net.minecraft.world.item.Tier
 *  net.minecraft.world.item.crafting.Ingredient
 *  net.minecraft.world.level.ItemLike
 */
package net.mcreator.evenbetternether.item;

import net.mcreator.evenbetternether.init.EvenbetternetherModItems;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;

public class PyritePickaxeItem
extends PickaxeItem {
    public PyritePickaxeItem() {
        super(new Tier(){

            public int getUses() {
                return 512;
            }

            public float getSpeed() {
                return 7.0f;
            }

            public float getAttackDamageBonus() {
                return 2.0f;
            }

            public int getLevel() {
                return 2;
            }

            public int getEnchantmentValue() {
                return 17;
            }

            public Ingredient getRepairIngredient() {
                return Ingredient.of((ItemStack[])new ItemStack[]{new ItemStack((ItemLike)EvenbetternetherModItems.PYRITE_INGOT.get())});
            }
        }, 1, -2.8f, new Item.Properties());
    }
}

