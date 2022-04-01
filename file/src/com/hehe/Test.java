package com.hehe;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {

//        methods1()
//        methods2();
//        methods3();
//        methods4();
//        methods5();
//        methods6();
//        methods7();
//        methods8();
//        methods9();
//        methods10();
//        methods11();
//        methods12();
    }

    /**
     * 将对象写入文件中,并读取到内存中
     */
    private static void methods12() {
        User user1 = new User("张三", "123");
        User user2 = new User("李四", "123");
        User user3 = new User("王五", "123");
        ArrayList<User> list = new ArrayList<>();
        list.add(user1);
        list.add(user2);
        list.add(user3);
        try {
            //写对象
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("file/src/com/txt/qqq.txt"));
            outputStream.writeObject(list);
            outputStream.flush();
            outputStream.close();
            //读对象
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("file/src/com/txt/qqq.txt"));
            List<User> object = (List<User>) inputStream.readObject();
            for (User user : object) {
                System.out.println(user);
            }
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 对象输入流(也叫对象反序列化流) 读
     */
    private static void methods11() {
        try {
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("file/src/com/txt/qqq.txt"));
            User object = (User) inputStream.readObject();
            System.out.println(object);

            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 对象输出流 (也叫对象序列化流)  写
     */
    private static void methods10() {
        User user = new User("张三", "123");
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("file/src/com/txt/qqq.txt"));
            outputStream.writeObject(user);
            outputStream.flush();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 字符流读写数据2
     */
    private static void methods9() {
        try {
            FileReader reader = new FileReader("file/src/com/txt/bbb.txt");
            FileWriter fileWriter = new FileWriter("file/src/com/txt/eee.txt");
           /*
           一次读写一个字符
           int len = 0;
            while ((len = reader.read()) != -1){
                fileWriter.write(len);
            }*/


            // 一次读写多个字符
            char[] chars = new char[1024];
            int len = 0;
            while ((len = reader.read(chars)) != -1) {
                fileWriter.write(new String(chars, 0, len));
            }

            fileWriter.flush();
            fileWriter.close();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 字符流读写数据1
     */
    private static void methods8() {
        try {
            BufferedReader in = new BufferedReader(new FileReader("file/src/com/txt/bbb.txt"));
            BufferedWriter out = new BufferedWriter(new FileWriter("file/src/com/txt/ccc.txt"));
            String line = "";
            while ((line = in.readLine()) != null) {
                out.write(line);
            }
            out.flush();
            out.close();
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 字符流读数据
     */
    private static void methods7() {
        try {
            // BufferedReader  字符缓冲输入流    FileReader  字符输入流
            BufferedReader in = new BufferedReader(new FileReader("file/src/com/txt/bbb.txt"));
            //  readLine() 字符缓冲输入流的特有方法, 一次读取一行数据,如果为空返回null
            String line = in.readLine();
            System.out.println(line);

            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 字符流写数据
     */
    private static void methods6() {
        try {
            // BufferedWriter  字符缓冲输出流    FileWriter  字符输出流
            BufferedWriter out = new BufferedWriter(new FileWriter("file/src/com/txt/bbb.txt"));
            String name = "张三";
            out.write(name);

            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 字节流复制图片(字节流可以读写所有的格式,比如:文本,图片,视频)
     */
    private static void methods5() {
        try {
            BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream("C:\\Users\\就不告诉你\\Pictures\\Saved Pictures\\aaa.jpg"));
            BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream("file/src/com/txt/aaa.jpg"));
            //循环读写一个字节数组并写入,,效率快
            byte[] bytes = new byte[1024];
            int len = 0;    //读写数据的长度
            while ((len = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, len);
            }

            //循环读写一个字节,,效率慢
//            int len = 0;
//            while ((len = inputStream.read()) != -1){
//                outputStream.write(len);
//            }


            outputStream.flush();
            outputStream.close();
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 字节流写入数据换行(中文会乱码)
     */
    private static void methods4() {
        String username = "zhangsan";
        String password = "123";

        try {
            FileOutputStream outputStream = new FileOutputStream("file/src/com/txt/c.txt");

            outputStream.write(username.getBytes());
            outputStream.write("\r\n".getBytes());  //换行
            outputStream.write(password.getBytes());

            outputStream.flush();
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 字节流读数据
     * 读取一个字节
     */
    private static void methods3() {
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("file/src/com/txt/a.txt"));
            int num = 0;
            while ((num = bufferedInputStream.read()) != -1) {
                System.out.print((char) num);
            }
            bufferedInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 字节流写部分数据(中文会乱码)
     */
    private static void methods2() {
        /**
         * new FileOutputStream("file/src/com/txt/b.txt",true)
         *
         * 1.第二个true表示续写开关,默认false
         * 2.如果是false,创建对象的时候会清空文件
         * 3.如果是true,创建对象的时候会接着以前的内容往下写
         */
        try {
            BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream("file/src/com/txt/b.txt", true));
            String name = "张三,李四,王五,赵六";
            byte[] bytes = name.getBytes();
            //  void write(byte[]b, int off, int len)    = (byte数组名,从哪开始, 写多少)
            outputStream.write(bytes, 0, bytes.length);

            outputStream.flush();
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 字节流往文件里写数据(中文会乱码)
     *
     * @return
     */
    private static void methods1() {
        try {
            //new FileOutputStream   没有该文件会自动给你创建这么一个文件
            BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream("file/src/com/txt/a.txt"));
            String name = "张三,李四,王五,赵六";
            outputStream.write(name.getBytes());

            outputStream.flush();
            outputStream.close();

        } catch (Exception a) {
            a.printStackTrace();
        }
    }
}
