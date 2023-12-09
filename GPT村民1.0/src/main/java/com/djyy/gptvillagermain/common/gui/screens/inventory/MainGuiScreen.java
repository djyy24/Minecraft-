package com.djyy.gptvillagermain.common.gui.screens.inventory;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.world.item.ItemStack;

import java.util.function.Supplier;




public class MainGuiScreen extends Screen {


    ResourceLocation Back=new ResourceLocation("textures/gui/gui1.png");

    public MainGuiScreen(Component p_96550_) {
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



        drawString(poseStack,this.font,new TextComponent("感谢您下载”AI智能对话村民“模组v1.0！"),this.width/2-85,this.height/2-60,0xD700FF);
        drawString(poseStack,this.font,new TextComponent("反馈/建议："),this.width/2-85,this.height/2-55+(this.font.lineHeight+3),0xFFFFFF);
        drawString(poseStack,this.font,new TextComponent("   哔哩哔哩：@对江邀月Yu_"),this.width/2-85,height/2-55+(this.font.lineHeight+3)*2,0xFFFFFF);
        drawString(poseStack,this.font,new TextComponent("   邮    箱：3078581376@qq.com"),this.width/2-85,height/2-55+(this.font.lineHeight+3)*3,0xFFFFFF);
        drawString(poseStack,this.font,new TextComponent("AI对话基于讯飞星火认知模型V2.0"),this.width/2-85,height/2-55+(this.font.lineHeight+3)*4,0x00FF7F);
        drawString(poseStack,this.font,new TextComponent("   原创设计Mod  序号：03"),this.width/2-85,height/2-55+(this.font.lineHeight+3)*5,0xf0f8ff);
        drawString(poseStack,this.font,new TextComponent("   Copyright © 对江邀月 2023年12月 "),this.width/2-85,height/2-55+(this.font.lineHeight+3)*6,0xFFFFFF);
        drawString(poseStack,this.font,new TextComponent("   欢迎访问：https://djyy24.top"),this.width/2-85,height/2-55+(this.font.lineHeight+3)*7,0xFFFFFF);


        Button bt1;
        bt1=new Button(this.width/2-30,height/2-55+(this.font.lineHeight+3)*8,60,18, new TextComponent("模组问题QA"),(button)->{
            Minecraft.getInstance().setScreen(new QaGuiScreen(new TextComponent("gptTest")));
        });
        this.addWidget(bt1);
        bt1.render(poseStack,mousex,mousey,partialTicks);
        poseStack.popPose();
        super.render(poseStack, mousex, mousey, partialTicks);
    }
}
