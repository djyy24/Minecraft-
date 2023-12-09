package com.djyy.gptvillagermain.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileIO {
    public static List<String> readFileLines(String fileUrl) throws FileNotFoundException {
        List<String> stringList=new ArrayList<>();
        try {
            File fp=new File(fileUrl);
            Scanner sc=new Scanner(fp);
            while (sc.hasNext())
                stringList.add(sc.next());
        }
        catch (FileNotFoundException e)
        {
            PrintWriter writer=new PrintWriter(fileUrl);
        }
        return stringList;
    }
    public static void saveFile(List<String> stringList,String fileUrl) throws FileNotFoundException {
        try{
            File fp=new File("");
            PrintWriter writer=new PrintWriter(fileUrl);
            for(String lines: stringList)
            {
                writer.println(lines);
            }
            writer.close();
        }
        catch (FileNotFoundException e)
        {
            PrintWriter writer=new PrintWriter(fileUrl);
        }
    }
    public static void testFileIO() throws FileNotFoundException {
        System.out.println("Hello world!");
        readFileLines("gptSetting.dy");
        List<String> list=new ArrayList<>();
        list.add("114514");
        list.add("abcd");
        saveFile(list,"gptSetting.dy");
    }
}