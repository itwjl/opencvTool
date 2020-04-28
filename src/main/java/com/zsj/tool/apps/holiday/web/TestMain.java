package com.zsj.tool.apps.holiday.web;

import org.opencv.core.Core;

import java.io.File;

public class TestMain {
    static int i = 0;

    public static void main(String[] args) {
        faceCrop();
//        testDeleteFile();
    }

    public static void testDeleteFile(){

        String path = "D:\\fangkeji\\face\\cutted";
        File[] files = new File(path).listFiles();
        for (File file : files) {
            if (FileSelect.getFileCount(file.getPath()) < 10){
                FileSelect.DeleteDir(file.getPath());
            }
            System.out.println(file.getPath()+":delete success");
        }
    }
    public static void faceCrop(){
//        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        String opencvDllName = "F:\\zax\\openTool\\lib\\opencv_java420.dll";
        System.load(opencvDllName);
        showDir(new File("D:\\fangkeji\\face\\faceDatabase"));
        System.out.println("Over");
    }
    public static void showDir(File dir){
        File[] files = dir.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                System.out.println("=================================i=" + i);
                i++;
                try {
                    showDir(file);
                } catch (Exception e) {
                    System.err.println(file + ":Access Deny!!");
                }
            }else{
                String[] s1 = file.toString().split("\\\\");
                String filename = s1[s1.length - 1];
                String fileNo = s1[s1.length - 2];
                File file_new = new File("D:\\\\fangkeji\\\\face\\\\cutted\\\\" + fileNo);
                if ((!file_new.exists())){
                    file_new.mkdirs();
                }
                FaceCrop.faceCrop(file.toString(), "D:\\fangkeji\\face\\cutted\\"+fileNo+"\\"+filename);
            }
        }
    }
}
