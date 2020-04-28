package com.zsj.tool.apps.holiday.web;

import java.io.File;

/**
 *
 * @author 王敬磊
 * @email it_wjl@163.com
 * @date 2020年4月16日
 */
public class FileSelect {
    public static int getFileCount(String path){
        System.out.println(path);
        File file = new File(path);
        File[] files = file.listFiles();
        System.out.println("       1       ");
        System.out.println(":"+files.length);
        return files.length;
    }
    public static void DeleteDir(String path){
        File file = new File(path);
        File[] files = file.listFiles();
        for (File f : files) {
            f.delete();
        }
        file.delete();
    }
    public static void getAllFileName(String path){
        File file = new File(path);
        File[] files = file.listFiles();
        for (File f : files) {
            System.out.println(f.getPath());
        }
    }
}
