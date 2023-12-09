package com.djyy.gptvillagermain.common.items;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;

public class GptTest extends Item {

    public GptTest(Properties p_41383_) {
        super(p_41383_);
    }



    @Override
    public InteractionResultHolder<ItemStack> use(Level l, Player p, InteractionHand ih) {
        if(l.isClientSide)
        {
            DistExecutor.safeCallWhenOn(Dist.CLIENT,()->OpenGptTestGui::new);
        }
        return super.use(l, p, ih);
    }
}
