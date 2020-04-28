package com.zsj.tool.apps.holiday.web;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CopyImage {
    public static void main(String[] args) {
        List<String> faliure = getFaliure();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("C:\\Users\\Administrator\\Desktop\\faliure.txt")),"UTF-8"));
            String lineText = null;
            while ((lineText = reader.readLine())!= null){
                String url = lineText.substring(lineText.lastIndexOf("faceDatabase"), lineText.lastIndexOf("\t"));
                String uri = "D://fangkeji/images/"+url;
                String destPath = "D://fangkeji/face/"+url;
                copyFile(uri, destPath);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void copyFile(String oldPath, String newPath) {
        try {
            int bytesum = 0;
            int byteread = 0;
            File oldfile = new File(oldPath);
            String parent = new File(newPath).getParent();
            if (!new File(parent).exists()){
                new File(parent).mkdirs();
            }
            if (oldfile.exists()) { //文件存在时
                InputStream inStream = new FileInputStream(oldPath); //读入原文件
                FileOutputStream fs = new FileOutputStream(newPath);
                byte[] buffer = new byte[1444];
                int length;
                while ( (byteread = inStream.read(buffer)) != -1) {
                    bytesum += byteread; //字节数 文件大小
                    fs.write(buffer, 0, byteread);
                }
                inStream.close();
            }
        }
        catch (Exception e) {
            System.out.println("复制单个文件操作出错");
            e.printStackTrace();
        }
    }

    private static List<String> getFaliure() {
        List<String> list = new ArrayList<>();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("C:\\Users\\Administrator\\Desktop\\faliure.txt")), "UTF-8"));
            String lineText = null;
            while ((lineText = reader.readLine()) != null) {
                String url = lineText.substring(lineText.lastIndexOf("faceDatabase"), lineText.lastIndexOf("\t"));
                list.add(url);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}
