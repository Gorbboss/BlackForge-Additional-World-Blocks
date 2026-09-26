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

public class RubyShovelItem
extends ShovelItem {
    public RubyShovelItem() {
        super(new Tier(){

            public int m_6609_() {
                return 200;
            }

            public float m_6624_() {
                return 6.0f;
            }

            public float m_6631_() {
                return 2.0f;
            }

            public int m_6604_() {
                return 1;
            }

            public int m_6601_() {
                return 13;
            }

            public Ingredient m_6282_() {
                return Ingredient.m_43927_((ItemStack[])new ItemStack[]{new ItemStack((ItemLike)EvenbetternetherModItems.NETHER_RUBY.get())});
            }
        }, 1.0f, -3.0f, new Item.Properties());
    }
}

