/*
 * Decompiled with CFR 0.153-local.
 * 
 * Could not load the following classes:
 *  net.minecraft.network.chat.Component
 *  net.minecraft.world.item.Item
 *  net.minecraft.world.item.Item$Properties
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.item.Rarity
 *  net.minecraft.world.item.TooltipFlag
 *  net.minecraft.world.level.Level
 */
package net.mcreator.evenbetternether.item;

import java.util.List;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

public class DiamondPyriteUpgradeSmithingTemplateItem
extends Item {
    public DiamondPyriteUpgradeSmithingTemplateItem() {
        super(new Item.Properties().m_41487_(64).m_41497_(Rarity.COMMON));
    }

    public void m_7373_(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
        super.m_7373_(itemstack, level, list, flag);
        list.add((Component)Component.m_237113_((String)"\u00a77Diamond Pyrite Upgrade"));
        list.add((Component)Component.m_237113_((String)""));
        list.add((Component)Component.m_237113_((String)"\u00a77Applies to:"));
        list.add((Component)Component.m_237113_((String)" \u00a79Pyrite Equipment"));
        list.add((Component)Component.m_237113_((String)"\u00a77Ingredients:"));
        list.add((Component)Component.m_237113_((String)" \u00a79Diamond"));
    }
}

