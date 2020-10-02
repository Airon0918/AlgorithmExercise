package com.yangshm.io;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ChannelDemo {

    @Test
    public void fileChannelTest() {
        String srcPath = "";
        String destPath = "";

        nioCopyFile(srcPath, destPath);

    }

    private void nioCopyFile(String srcPath, String destPath) {
        File srcFile = new File(srcPath);
        File destFile = new File(destPath);

        try {
            if (!destFile.exists()) {
                destFile.createNewFile();
            }
            long startTime = System.currentTimeMillis();

            FileInputStream fis = null;
            FileOutputStream fos = null;
            FileChannel inChannel = null;
            FileChannel outChannel = null;
            try {
                fis = new FileInputStream(srcFile);
                fos = new FileOutputStream(destFile);
                inChannel = fis.getChannel();
                outChannel = fos.getChannel();
                int length = -1;
                //新建的ByteBuffer，默认是写入模式
                ByteBuffer buf = ByteBuffer.allocate(1024);
                while ((length = inChannel.read(buf)) != -1) {
                    //第一次切换：编程读取模式
                    buf.flip();

                    int outLength = 0;
                    while ((outLength = outChannel.write(buf)) != 0) {
                        System.out.println("写入字节数" + outLength);
                    }
                    //第二次切换
                    buf.clear();
                }
                outChannel.force(true);
            } finally {
                IOUtils.closeQuietly(outChannel);
                IOUtils.closeQuietly(fos);
                IOUtils.closeQuietly(inChannel);
                IOUtils.closeQuietly(fis);
            }
            long endTime = System.currentTimeMillis();
            System.out.println("复制时间：" + (endTime - startTime));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
