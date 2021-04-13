package com.atguigu.fit.utlis;

import java.io.File;
import java.io.FileOutputStream;
import java.util.UUID;

/**
 * 文件工具类
 */
public class FileTool {

    //上传图片到本机地址
    public static void uploadFiles(byte[] file, String filePath, String fileName) throws Exception {
        File targetFile = new File(filePath);
        if (!targetFile.exists()) {
            targetFile.mkdirs();//创建父文件夹
        }
        FileOutputStream outputStream =new FileOutputStream(filePath+fileName);
        outputStream.write(file);
        outputStream.flush();
        outputStream.close();
    }

    //获取唯一文件名
    public static String renameToUUID(String fileName){
        return UUID.randomUUID()+"."+fileName.substring(fileName.lastIndexOf(".")+1);//最后一个代码的意思是取出文件名
    }

}
