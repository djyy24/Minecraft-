package com.djyy.gptvillager4.common.items;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;

public class Copyright extends Item {
    public Copyright(Properties properties)
    {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level l, Player p, InteractionHand ih) {
        if(l.isClientSide)
        {
            DistExecutor.safeCallWhenOn(Dist.CLIENT,()->OpenCopyrightGui::new);
        }
        return super.use(l, p, ih);
    }

}
