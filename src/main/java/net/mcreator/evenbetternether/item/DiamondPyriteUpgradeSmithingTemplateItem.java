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
        super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
    }

    public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
        super.appendHoverText(itemstack, level, list, flag);
        list.add((Component)Component.literal((String)"\u00a77Diamond Pyrite Upgrade"));
        list.add((Component)Component.literal((String)""));
        list.add((Component)Component.literal((String)"\u00a77Applies to:"));
        list.add((Component)Component.literal((String)" \u00a79Pyrite Equipment"));
        list.add((Component)Component.literal((String)"\u00a77Ingredients:"));
        list.add((Component)Component.literal((String)" \u00a79Diamond"));
    }
}

