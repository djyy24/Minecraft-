package com.djyy.gptvillagermain.common.items;

import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.UUID;

public class EatingTest extends Item {

    public EatingTest(Properties p_41383_) {
        super(p_41383_.food(new FoodProperties.Builder().meat().build()));
    }

}
