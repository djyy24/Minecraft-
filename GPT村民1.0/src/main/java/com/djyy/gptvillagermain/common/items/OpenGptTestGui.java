package com.djyy.gptvillagermain.common.items;

import com.djyy.gptvillagermain.common.gui.screens.inventory.GptScreen;
import com.djyy.gptvillagermain.common.gui.screens.inventory.MainGuiScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.TextComponent;

public class OpenGptTestGui {
    public OpenGptTestGui()
    {
        Minecraft.getInstance().setScreen(new GptScreen(new TextComponent("gptTest"),"普通"));
    }
}
