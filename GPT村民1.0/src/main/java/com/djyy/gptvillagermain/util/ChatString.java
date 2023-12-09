package com.djyy.gptvillagermain.util;

public class ChatString{
    private int lines=1;
    String rawString;
    String[] StringLine;

    public boolean isRoleIsPlayer() {
        return roleIsPlayer;
    }


    private boolean roleIsPlayer;
    public ChatString(String raw,Boolean roleIsPlayer)
    {
        this.roleIsPlayer=roleIsPlayer;
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