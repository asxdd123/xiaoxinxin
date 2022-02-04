package com.itheima;

import java.io.*;
import java.net.Socket;
import java.nio.Buffer;

public class UploadThread implements Runnable {
    private Socket s;

    public UploadThread(Socket s) {
        this.s = s;
    }

    @Override
    public void run() {
        try {
            //接收数据写到文件
            BufferedInputStream bis = new BufferedInputStream(s.getInputStream());

            //解决名称冲突问题
            int count = 0;
            File file = new File("itheima_javase_exam2\\Copy[" + count + "].jpg");

            while (file.exists()) {
                count++;
                file = new File("itheima_javase_exam2\\Copy[" + count + "].jpg");
            }

            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));

            byte[] bys = new byte[1024];
            int len;
            while ((len = bis.read(bys)) != -1) {
                bos.write(bys, 0, len);
                bos.flush();
            }

            //给出反馈
            BufferedWriter bwServer = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
            bwServer.write("文件上传成功");
            bwServer.newLine();
            bwServer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(s!=null) {
                try {
                    s.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
