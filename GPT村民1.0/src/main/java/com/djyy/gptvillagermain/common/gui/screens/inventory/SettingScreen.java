package com.djyy.gptvillagermain.common.gui.screens.inventory;

import com.djyy.gptvillagermain.util.FileIO;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.resources.ResourceLocation;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;


public class SettingScreen extends Screen {
    AtomicReference<String> sstatus= new AtomicReference<>(" ");

    private Button bt1;
    private EditBox editBox1;
    private EditBox editBox2;
    private EditBox editBox3;
    ResourceLocation Back=new ResourceLocation("textures/gui/gui1.png");

    public SettingScreen(Component p_96550_) {
        super(p_96550_);
    }
    protected void init(){
        bt1=new Button(this.width/2-30,height/2-70+(this.font.lineHeight+5)*8,60,20, new TextComponent("保存设置"),(button)->{
            //Minecraft.getInstance().setScreen(new GptScreen(new TextComponent("gptTest"),"普通"));
            try {
                List<String> list=new ArrayList<>();
                list.add(editBox1.getValue());
                list.add(editBox2.getValue());
                list.add(editBox3.getValue());
                FileIO.saveFile(list,"GPTSettings.dj");
                sstatus.set("设置已保存，按Esc键退出");
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
        this.addWidget(bt1);
        editBox1=new EditBox(this.font,this.width/2,height/2-55+(this.font.lineHeight+5)*3,70,15,new TextComponent("设置1"));
        editBox2=new EditBox(this.font,this.width/2,height/2-55+(this.font.lineHeight+5)*4,70,15,new TextComponent("设置2"));
        editBox3=new EditBox(this.font,this.width/2,height/2-55+(this.font.lineHeight+5)*5,70,15,new TextComponent("设置3"));
        try {
            List<String> list=
                    FileIO.readFileLines("GPTSettings.dj");
            if(list.size()>=3) {
                editBox1.setValue(list.get(0));
                editBox2.setValue(list.get(1));
                editBox3.setValue(list.get(2));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        this.addWidget(editBox1);
        this.addWidget(editBox2);
        this.addWidget(editBox3);
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



        drawString(poseStack,this.font,new TextComponent("AI智能对话村民-模组设置"),this.width/2-85,this.height/2-60,0xD700FF);
        drawString(poseStack,this.font,new TextComponent(sstatus.get()),this.width/2-85,this.height/2-55+(this.font.lineHeight+3),0x00FF00);
        //EditBox editBox=new EditBox(this.font,this.width/2,this.height/2-55+(this.font.lineHeight+3),20,70,new TextComponent("响应时间设置"));
        drawString(poseStack,this.font,new TextComponent("API Key等设置项需要在讯飞开放平台注册"),this.width/2-85,height/2-55+(this.font.lineHeight+3)*2,0xFFFFFF);
        drawString(poseStack,this.font,new TextComponent("APP ID:"),this.width/2-85,height/2-55+(this.font.lineHeight+5)*3,0xf0f8ff);
        drawString(poseStack,this.font,new TextComponent("API Secret:"),this.width/2-85,height/2-55+(this.font.lineHeight+5)*4,0xFFFFFF);
        drawString(poseStack,this.font,new TextComponent("API Key:"),this.width/2-85,height/2-55+(this.font.lineHeight+5)*5,0xFFFFFF);


        //editBox.render(poseStack,mousex,mousey,partialTicks);




        bt1.render(poseStack,mousex,mousey,partialTicks);

        editBox1.render(poseStack,mousex,mousey,partialTicks);
        editBox2.render(poseStack,mousex,mousey,partialTicks);
        editBox3.render(poseStack,mousex,mousey,partialTicks);
        /*Button bt2;
        bt2=new Button(this.width/2-30,height/2+20+(this.font.lineHeight+3)*8,50,16, new TextComponent("保存Api Key设置"),(button)->{
            //Minecraft.getInstance().setScreen(new GptScreen(new TextComponent("gptTest"),"普通"));
        });
        this.addWidget(bt2);
        bt2.render(poseStack,mousex,mousey,partialTicks);*/
        poseStack.popPose();
        super.render(poseStack, mousex, mousey, partialTicks);

    }
    @Override
    public void onClose() {
        if(this.minecraft!=null && this.minecraft.player != null)
            this.minecraft.player.closeContainer();
        super.onClose();
    }
}
