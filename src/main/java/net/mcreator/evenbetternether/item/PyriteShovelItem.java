/*
 * Decompiled with CFR 0.153-local.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.item.Item$Properties
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.item.ShovelItem
 *  net.minecraft.world.item.Tier
 *  net.minecraft.world.item.crafting.Ingredient
 *  net.minecraft.world.level.ItemLike
 */
package net.mcreator.evenbetternether.item;

import net.mcreator.evenbetternether.init.EvenbetternetherModItems;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;

public class PyriteShovelItem
extends ShovelItem {
    public PyriteShovelItem() {
        super(new Tier(){

            public int m_6609_() {
                return 512;
            }

            public float m_6624_() {
                return 7.0f;
            }

            public float m_6631_() {
                return 2.5f;
            }

            public int m_6604_() {
                return 2;
            }

            public int m_6601_() {
                return 17;
            }

            public Ingredient m_6282_() {
                return Ingredient.m_43927_((ItemStack[])new ItemStack[]{new ItemStack((ItemLike)EvenbetternetherModItems.PYRITE_INGOT.get())});
            }
        }, 1.0f, -2.8f, new Item.Properties());
    }
}

