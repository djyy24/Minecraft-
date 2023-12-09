package com.djyy.gptvillagermain.common.gui.screens.inventory;

import com.djyy.gptvillagermain.util.GPT;
import com.djyy.gptvillagermain.util.ChatString;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.Option;
import net.minecraft.client.Options;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.SliderButton;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.resources.ResourceLocation;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GptScreen extends Screen {
    EditBox editBox;
    private Button upLines;
    private List<String> EndStrList=new ArrayList<>();
    private Button downLines;
    private Button settings;
    private int chatNum=1;
    private String villagerRole="普通";
    private int top=0;
    private int chatLines=0;
    private List<ChatString> ChatRecord=new ArrayList<>();

    private List<ChatString> villagerChat=new ArrayList<>();
    private List<ChatString> playerChat=new ArrayList<>();

    EditBox ResBox;



    Button submit;
    private void resetChat() throws Exception {
        ChatRecord=new ArrayList<>();
        villagerChat=new ArrayList<>();
        playerChat=new ArrayList<>();

        //playerChat.add(new ChatString("欢迎使用GPT村民模组v1.0！(AI聊天功能使用讯飞星火API)",true));
        //villagerChat.add(new ChatString("————————————————————————————————————————————",false));
        String answer0;
        answer0= GPT.GPTMainInit("现在你的设定是Minecraft游戏中的"+villagerRole+"村民，请扮演村民这个NPC，并打招呼",2000);
        System.out.println("现在你的设定是Minecraft游戏中的村民，你的职业是"+villagerRole+"，请扮演这个NPC，并打招呼");
        playerChat.add(new ChatString("【系统】 Tips：在下面的输入框中输入话题，点击“确认”键发送。",false));
        villagerChat.add(new ChatString("【村民】 "+answer0,false));
        ChatRecord.add(new ChatString("现在你的设定是Minecraft游戏中的村民，你的职业是\"+villagerRole+\"，请扮演这个NPC，并打招呼",true));
        ChatRecord.add(new ChatString(answer0,true));
        //villagerChat.add(new ChatString("你是一位知识渊博的村民",false));a
        //String answer0= GPT.GPTMain("你是一位知识渊博的村民",2000,villagerChat);
        //villagerChat.add(new ChatString("Tips：在下面的输入框中输入话题，点击“确认”键发送。",false));
        chatNum=1;
    }

    @Override
    protected void init() {
        EndStrList.add("Have a nice day!");
        EndStrList.add("再见!");
        EndStrList.add("Let's say our good-byes!");
        EndStrList.add("Let's call it a day!");
        EndStrList.add("See you later!");
        EndStrList.add("Take care!");
        try {
            resetChat();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        this.settings=new Button(this.width/2+150,200,40,20,new TextComponent("设置"),(button)->{
            Minecraft.getInstance().setScreen(new SettingScreen(new TextComponent("设置")));
        });
        this.upLines=new Button(this.width/2+100,200,20,20,new TextComponent("↑"),(button)->{upLine();});
        this.downLines=new Button(this.width/2+120,200,20,20,new TextComponent("↓"),(button)->{downLine();});
        this.submit=new Button(this.width/2+60,200,40,20,new TextComponent("提交"),(button)->{
            String question=editBox.getValue();
            int chatLines_old=chatLines;
            String answer="Saving chunks for level 'ServerLevel[New World]'/minecraft:the_netherGathering id map for writing to world save New World";
            playerChat.add(new ChatString("【玩家】 "+question,true));
            try {
                answer= GPT.GPTMain(question,5500,ChatRecord);
                System.out.println("-----------------------------------------");
                System.out.println(answer);
                System.out.println("-----------------------------------------");
                villagerChat.add(new ChatString("【村民】 "+answer,false));

                ChatRecord.add(new ChatString(question,true));
                ChatRecord.add(new ChatString(answer,false));
                chatNum++;
            } catch (Exception e) {
            throw new RuntimeException(e);
        }
        });
        this.editBox=new EditBox(this.font,this.width/2-200,200,260,20, new TextComponent("输入"));
        this.addWidget(editBox);
        this.addWidget(submit);
        this.addWidget(upLines);
        this.addWidget(downLines);
        this.addWidget(settings);
        super.init();
    }
    public void render(PoseStack poseStack, int mousex, int mousey, float partialTicks) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0,new ResourceLocation("textures/gui/gui2.png"));
       // System.out.println("渲染");
        int aline=1;
        poseStack.pushPose();
        poseStack.scale(1F, 1F, 1F);
        this.blit(poseStack, this.width / 2 - 100, this.height / 2 - 75, 0, 0, 200, 150, 200, 150);
        //this.minecraft.getTextureManager().bindForSetup(Back);
        //this.renderBackground(poseStack);
        for(int i=0;i<chatNum;i++) {
            int aa=playerChat.get(i).getLines();
            int bb=villagerChat.get(i).getLines();
            for(int ii=0;ii<aa;ii++)
            {
                drawString(poseStack, this.font, playerChat.get(i).getLineStr(ii), this.width / 2 - 200, 14*aline+top, 0xFFFFFF);
                aline++;
                chatLines++;
            }
            for(int ii=0;ii<bb;ii++)
            {
                drawString(poseStack, this.font, villagerChat.get(i).getLineStr(ii), this.width / 2 - 200, 14*aline+top, 0x00FFFF);
                aline++;
                chatLines++;
            }
        }
        this.submit.render(poseStack,mousex,mousey,partialTicks);
        this.editBox.render(poseStack,mousex,mousey,partialTicks);
        this.downLines.render(poseStack,mousex,mousey,partialTicks);
        this.upLines.render(poseStack,mousex,mousey,partialTicks);
        this.settings.render(poseStack,mousex,mousey,partialTicks);
        poseStack.pushPose();
    }

    public GptScreen(Component p_96550_,String role) {
        super(p_96550_);
        this.villagerRole=role;
    }
    private void upLine()
    {
        top=top-14;
    }
    private void upLine(int n)
    {
        top=top-14*n;
    }
    private void downLine()
    {
        top=top+14;
    }

    @Override
    public void onClose() {
        if(this.minecraft!=null && this.minecraft.player != null)
            this.minecraft.player.closeContainer();
        /*
        Random random=new Random();
        int a= random.nextInt();
        sendStatMessage("【村民】 "+EndStrList.get(a%6));*/
        super.onClose();
    }
}
