package com.djyy.gptvillager4.common.gui.screens.inventory;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.EditBox;

import java.util.function.Supplier;




public class MainGuiScreen extends Screen {
    Button bt1;

    ResourceLocation Back=new ResourceLocation("textures/gui/gui1.png");

    public MainGuiScreen(Component p_96550_) {
        super(p_96550_);
    }
    protected void init(){
        this.bt1=new Button(0,0,30,10, new TextComponent("测试对话"),(button)->{
            Minecraft.getInstance().setScreen(new GptScreen(new TextComponent("gptTest")));
        });
        this.addWidget(bt1);
        super.init();
    }
    public void render(PoseStack poseStack,int mousex, int mousey, float partialTicks)
    {
        poseStack.pushPose();
        poseStack.scale(1F,1F,1F);
        this.blit(poseStack,this.width/2-100,this.height/2-75,0,0,200,150,200,150);
        this.minecraft.getTextureManager().bindForSetup(Back);
        this.renderBackground(poseStack);
        drawString(poseStack,this.font,new TextComponent("感谢您下载”AI聊天村民“模组v1.0！"),this.width/2-85,this.height/2-60,0xD700FF);
        drawString(poseStack,this.font,new TextComponent("反馈/建议："),this.width/2-85,this.height/2-55+(this.font.lineHeight+3),0xFFFFFF);
        drawString(poseStack,this.font,new TextComponent("    哔哩哔哩：@对江邀月Yu_"),this.width/2-85,height/2-55+(this.font.lineHeight+3)*2,0xFFFFFF);
        drawString(poseStack,this.font,new TextComponent("    微    博：@对江邀月24"),this.width/2-85,height/2-55+(this.font.lineHeight+3)*3,0xFFFFFF);
        drawString(poseStack,this.font,new TextComponent("    邮    箱：3078581376@qq.com"),this.width/2-85,height/2-55+(this.font.lineHeight+3)*4,0xFFFFFF);
        drawString(poseStack,this.font,new TextComponent("原创设计Mod"),this.width/2-85,height/2-55+(this.font.lineHeight+3)*5,0xAB2915);
        drawString(poseStack,this.font,new TextComponent("    Copyright © 2023 Djyy,HylWiki"),this.width/2-85,height/2-55+(this.font.lineHeight+3)*6,0xFFFFFF);
        drawString(poseStack,this.font,new TextComponent("    All rights reserved."),this.width/2-85,height/2-55+(this.font.lineHeight+3)*7,0xFFFFFF);
        this.bt1.render(poseStack,mousex,mousey,partialTicks);
        poseStack.popPose();
        super.render(poseStack, mousex, mousey, partialTicks);
    }
}
