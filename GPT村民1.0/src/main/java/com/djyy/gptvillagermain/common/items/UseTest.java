package com.djyy.gptvillagermain.common.items;

import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;

import java.util.UUID;

public class UseTest extends Item {

    public UseTest(Properties p_41383_) {
        super(p_41383_);
    }
    @Override
    public InteractionResultHolder<ItemStack> use(Level l, Player p, InteractionHand ih) {
        if(l.isClientSide)
        {
            p.sendMessage(new TextComponent("右键点击使用测试通过。"),new UUID(114514,191981));
        }
        else p.sendMessage(new TextComponent("不是ClientSide。"),new UUID(114514,191981));
        return super.use(l, p, ih);
    }

}
