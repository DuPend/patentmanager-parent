package com.xinghuo.common.utils;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Calendar;

public class FileUtil {
    private static  final String filePath = "E:/file";
    /*
    创建文件
     */

    public static void appendMethod(String fileName, String content) {
        try {
            // 打开一个随机访问文件流，按读写方式
            RandomAccessFile randomFile = new RandomAccessFile(fileName, "rw");
            // 文件长度，字节数
            long fileLength = randomFile.length();
            //将写文件指针移到文件尾。
            randomFile.seek(fileLength);
            randomFile.writeBytes(content);
            randomFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String getFileName() {
        String fileName = "";
        Calendar calendar  = Calendar.getInstance();
        fileName = calendar.get(Calendar.YEAR) + "" + (calendar.get(Calendar.MONTH) + 1) + "" + calendar.get(Calendar.DATE) + ".log";
        return fileName;
    }

    public static File createFile(String filename) throws IOException {
        File file = new File(filePath +  "/" + getFileName());
        if (file == null) {
            file.createNewFile();
        }
        return  file;

    }
}
