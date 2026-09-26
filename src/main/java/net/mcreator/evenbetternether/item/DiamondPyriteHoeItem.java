/*
 * Decompiled with CFR 0.153-local.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.item.HoeItem
 *  net.minecraft.world.item.Item$Properties
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.item.Items
 *  net.minecraft.world.item.Tier
 *  net.minecraft.world.item.crafting.Ingredient
 *  net.minecraft.world.level.ItemLike
 */
package net.mcreator.evenbetternether.item;

import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;

public class DiamondPyriteHoeItem
extends HoeItem {
    public DiamondPyriteHoeItem() {
        super(new Tier(){

            public int m_6609_() {
                return 1024;
            }

            public float m_6624_() {
                return 9.0f;
            }

            public float m_6631_() {
                return 0.0f;
            }

            public int m_6604_() {
                return 3;
            }

            public int m_6601_() {
                return 17;
            }

            public Ingredient m_6282_() {
                return Ingredient.m_43927_((ItemStack[])new ItemStack[]{new ItemStack((ItemLike)Items.f_42415_)});
            }
        }, 0, -1.0f, new Item.Properties());
    }
}

