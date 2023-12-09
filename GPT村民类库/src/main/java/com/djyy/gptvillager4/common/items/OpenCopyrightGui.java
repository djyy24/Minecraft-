package com.djyy.gptvillager4.common.items;

import com.djyy.gptvillager4.common.gui.screens.inventory.MainGuiScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.*;
import net.minecraft.util.FormattedCharSequence;
import net.minecraft.world.entity.vehicle.Minecart;

import java.util.List;

public class OpenCopyrightGui {
    public OpenCopyrightGui()
    {
        Minecraft.getInstance().setScreen(new MainGuiScreen(new TextComponent("copyRight")));
    }
}
