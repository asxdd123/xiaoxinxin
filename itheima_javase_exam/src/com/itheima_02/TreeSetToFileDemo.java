package com.itheima_02;

import java.io.*;
import java.nio.Buffer;
import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

public class TreeSetToFileDemo {
    public static void main(String[] args) throws IOException {
        //创建TreeSet集合，通过比较器排序进行排序
        TreeSet<Student> ts = new TreeSet<Student>(new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                //成绩总分从高到低
                int num = s2.getSum() - s1.getSum();
                //次要条件
                int num2 = num == 0 ? s1.getChinese() - s2.getChinese() : num;
                int num3 = num2 == 0 ? s1.getMath() - s2.getMath() : num2;
                int num4 = num3 == 0 ? s1.getName().compareTo(s2.getName()) : num3;
                return num4;
            }
        });

        //键盘录入学生数据
        for (int i = 0; i < 3; i++) {
            Scanner sc = new Scanner(System.in);
            System.out.println("请录入第" + (i + 1) + "个学生信息：");
            System.out.println("姓名：");
            String name = sc.nextLine();
            System.out.println("语文成绩：");
            int chinese = sc.nextInt();
            System.out.println("数学成绩：");
            int math = sc.nextInt();
            System.out.println("英语成绩：");
            int english = sc.nextInt();

            //创建学生对象，把键盘录入的数据对应赋值给学生对象的成员变量
            Student s = new Student();
            s.setName(name);
            s.setChinese(chinese);
            s.setMath(math);
            s.setEnglish(english);

            //把学生对象添加到TreeSet集合
            ts.add(s);
        }

        //创建字符缓冲输出流对象
        BufferedWriter bw = new BufferedWriter(new FileWriter("itheima_javase_exam\\ts.txt"));

        //遍历集合，得到每一个学生对象
        for (Student s : ts) {
            //把学生对象的数据拼接成指定格式的字符串
            //格式：姓名,语文成绩,数学成绩,英语成绩
            StringBuilder sb = new StringBuilder();
            sb.append(s.getName()).append(",").append(s.getChinese()).append(",").append(s.getMath()).append(",").append(s.getEnglish()).append(",").append(s.getSum());

//            调用字符缓冲输出流对象的方法写数据
            bw.write(sb.toString());
            bw.newLine();
            bw.flush();
        }

        //释放资源
        bw.close();
        System.out.println("数据写入文件完毕");
        System.out.println("文件中的数据展示如下：");
        //读取文件数据，显示在控制台
        BufferedReader br = new BufferedReader(new FileReader("itheima_javase_exam\\ts.txt"));

        System.out.println("姓名\t语文成绩\t数学成绩\t英语成绩");
        String line;
        while ((line=br.readLine())!=null) {
            String[] strArray = line.split(",");
            System.out.println(strArray[0]+"\t\t"+strArray[1]+"\t\t"+strArray[2]+"\t\t"+strArray[3]);
        }
        br.close();
    }
}
