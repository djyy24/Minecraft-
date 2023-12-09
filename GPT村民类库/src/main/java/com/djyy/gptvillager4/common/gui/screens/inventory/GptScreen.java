package com.djyy.gptvillager4.common.gui.screens.inventory;

import com.djyy.gptvillager4.util.GPT;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Option;
import net.minecraft.client.Options;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.SliderButton;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;

import java.util.ArrayList;
import java.util.List;

public class GptScreen extends Screen {
    EditBox editBox;
    private Button upLines;
    private Button downLines;
    private int chatNum=1;
    private int top=0;
    private int chatLines=0;
    private List<String> StringList=new ArrayList<>();
    private List<String> StringList2=new ArrayList<>();

    private List<ChatString> villagerChat=new ArrayList<>();
    private List<ChatString> playerChat=new ArrayList<>();

    EditBox ResBox;



    Button submit;
    private void resetChat()
    {
        villagerChat=new ArrayList<>();
        playerChat=new ArrayList<>();
        playerChat.add(new ChatString("欢迎使用GPT村民模组v1.0！(AI聊天功能使用讯飞星火API)"));
        villagerChat.add(new ChatString("————————————————————————————————————————————"));
        chatNum=1;
    }

    @Override
    protected void init() {
        resetChat();
        this.upLines=new Button(this.width/2+100,200,20,20,new TextComponent("↑"),(button)->{upLine();});
        this.downLines=new Button(this.width/2+120,200,20,20,new TextComponent("↓"),(button)->{downLine();});
        this.submit=new Button(this.width/2+60,200,40,20,new TextComponent("提交"),(button)->{
            String question=editBox.getValue();
            int chatLines_old=chatLines;
            String answer="Saving chunks for level 'ServerLevel[New World]'/minecraft:the_netherGathering id map for writing to world save New World";
            playerChat.add(new ChatString("【玩家】 "+question));
            try {
                answer= GPT.GPTMain(question);
                System.out.println("-----------------------------------------");
                System.out.println(answer);
                System.out.println("-----------------------------------------");
                villagerChat.add(new ChatString("【村民】 "+answer));
                //upLine(chatLines-chatLines_old);
                //int chatLines=0;
                //chatLines=new ChatString("【玩家】 "+question).getLines()+new ChatString("【村民】 "+answer).getLines()-2;
                //upLine(chatLines);
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
        super.init();
    }
    public void render(PoseStack poseStack, int mousex, int mousey, float partialTicks) {
        System.out.println("渲染");
        int aline=1;
        poseStack.pushPose();
        poseStack.scale(1F, 1F, 1F);
        this.blit(poseStack, this.width / 2 - 100, this.height / 2 - 75, 0, 0, 200, 150, 200, 150);
        //this.minecraft.getTextureManager().bindForSetup(Back);
        this.renderBackground(poseStack);
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
        poseStack.pushPose();
    }

    public GptScreen(Component p_96550_) {
        super(p_96550_);
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
}
class ChatString{
    private int lines=1;
    String rawString;
    String[] StringLine;
    public ChatString(String raw)
    {
        int len=raw.length();
        rawString=raw;
        lines=1+len/45;
        StringLine=new String[lines];
        for(int i=0;i<lines;i++)
        {
            try{
                if(len>i*45+45)
                    StringLine[i]=rawString.substring(i*45,i*45+45);
                else
                    StringLine[i]=rawString.substring(i*45,len);
            }
            catch (Exception e) {
                System.out.println("行数是："+lines);
                System.out.println("i:"+i);
                //StringLine[i] = rawString.substring(i * 30,len);
            }
        }
    }
    public int getLines()
    {
        return lines;
    }
    public String[] getStringList()
    {
        return StringLine;
    }
    public String getLineStr(int i)
    {
        return StringLine[i];
    }

}