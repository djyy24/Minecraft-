package com.djyy.gptvillagermain.common.gui.screens.inventory;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.resources.ResourceLocation;


public class QaGuiScreen extends Screen {


    ResourceLocation Back=new ResourceLocation("textures/gui/gui1.png");

    public QaGuiScreen(Component p_96550_) {
        super(p_96550_);
    }
    protected void init(){
        super.init();
    }
    public void render(PoseStack poseStack,int mousex, int mousey, float partialTicks)
    {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderTexture(0,new ResourceLocation("textures/gui/gui1.png"));
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);

        poseStack.pushPose();
        poseStack.scale(1F,1F,1F);
        this.blit(poseStack,this.width/2-100,this.height/2-75,0,0,200,150,200,150);



        drawString(poseStack,this.font,new TextComponent("1.打开对话界面闪退"),this.width/2-85,this.height/2-60,0x00FF7F);
        drawString(poseStack,this.font,new TextComponent("在.minecraft目录中找到GPTSettings.dj这个文件"),this.width/2-85,height/2-55+(this.font.lineHeight+3),0xFFFFFF);
        drawString(poseStack,this.font,new TextComponent("使用记事本打开，添加三行：APP ID;API Secret;"),this.width/2-85,height/2-55+(this.font.lineHeight+3)*2,0xFFFFFF);
        drawString(poseStack,this.font,new TextComponent("API Key。然后保存文件，再次打开对话界面。"),this.width/2-85,height/2-55+(this.font.lineHeight+3)*3,0xFFFFFF);
        drawString(poseStack,this.font,new TextComponent("2.游戏启动报错"),this.width/2-85,height/2-55+(this.font.lineHeight+3)*4,0x00FF7F);
        drawString(poseStack,this.font,new TextComponent("可能此模组类库与其他Mod有重复，导致Mine"),this.width/2-85,height/2-55+(this.font.lineHeight+3)*5,0xFFFFFF);
        drawString(poseStack,this.font,new TextComponent("craft重复加载了某个类。找到报错日志并找"),this.width/2-85,height/2-55+(this.font.lineHeight+3)*6,0xFFFFFF);
        drawString(poseStack,this.font,new TextComponent("到冲突的类，删掉模组类库Jar包内部的依赖"),this.width/2-85,height/2-55+(this.font.lineHeight+3)*7,0xFFFFFF);
        drawString(poseStack,this.font,new TextComponent("Jar包以及删掉metadata.json中相应的"),this.width/2-85,height/2-55+(this.font.lineHeight+3)*8,0xFFFFFF);
        drawString(poseStack,this.font,new TextComponent("json对象再重启游戏。"),this.width/2-85,height/2-55+(this.font.lineHeight+3)*9,0xFFFFFF);

        poseStack.popPose();
        super.render(poseStack, mousex, mousey, partialTicks);
    }
}
