package com.itheima;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class UploadClient {
    public static void main(String[] args) {
        Socket s = null;
        BufferedInputStream bis = null;
        try {
            //创建客户端Socket对象
            s = new Socket("192.168.43.134", 10000);

            while (true) {
                Scanner sc = new Scanner(System.in);
                System.out.println("请输入上传文件的路径：");
                String filePath = sc.nextLine();

                File file = new File(filePath);
                if (!file.isFile() || !file.getName().endsWith(".jpg")) {
                    System.out.println("请输入正确的图片文件路径,请重新输入");
                } else {
                    //封装文件的数据
                    bis = new BufferedInputStream(new FileInputStream(file));
                    //封装输出流写数据
                    BufferedOutputStream bos = new BufferedOutputStream(s.getOutputStream());

                    byte[] bys = new byte[1024];
                    int len;
                    while ((len = bis.read(bys)) != -1) {
                        bos.write(bys, 0, len);
                        bos.flush();
                    }

                    s.shutdownOutput();

                    //接收反馈
                    BufferedReader brClient = new BufferedReader(new InputStreamReader(s.getInputStream()));
                    String data = brClient.readLine(); //等待读取数据
                    System.out.println("服务器的反馈：" + data);

                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (s != null) {
                try {
                    s.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
