import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Author: fg
 * @Date: 2020/5/22 11:39
 */
public class SubwayDemo {
    public static void main(String[] args) throws Exception{
        // 问题2.提示用户输入工号和姓名,进行登录,登录成功,继续运行,登录失败,结束程序
        //  2.1.运行程序,将managers.txt文件中的管理人员信息读取到集合中
        ArrayList<Manager> managerList = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader("day02\\managers.txt"));
        String line;
        while ((line = br.readLine())!=null){
            // 2.1.1. 将读取到的一行数据切割成字符串数组
            String[] arr = line.split(",");
            // 2.1.2. 将数组中的元素封装到Manager对象中
            Manager manager = new Manager(arr[0],arr[1],arr[2],arr[3]);
            // 2.1.3. 将Manager对象添加到集合中
            managerList.add(manager);
        }
        br.close();
        // 2.2.将subways文件中的地铁站信息读取到另一个集合中
        ArrayList<Subway> subwayList = new ArrayList<>();
        BufferedReader subwayBr = new BufferedReader(new FileReader("day02\\subways.txt"));
        String subwayLine;
        while ((subwayLine=subwayBr.readLine())!=null){
            String[] subwayArr = subwayLine.split(",");
            Subway subway = new Subway(subwayArr[0],subwayArr[1],subwayArr[2]);
            subwayList.add(subway);
        }
        subwayBr.close();
        // 2.3. 给出提示,获取管理人员输入的工号和姓名
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入您的工号:");
        String id = sc.next();
        System.out.println("请输入您的姓名:");
        String name = sc.next();
        // 2.4. 判断管理人员信息集合中是否包含管理人员输入的工号和姓名,给出对应的登录结果
        boolean flag = false;
        for (Manager manager : managerList) {
            if (manager.getId().equals(id) && manager.getName().equals(name)){
                flag=true;
            }
        }
        // 判断是否登录成功,给出登录结果提示
        if (flag){
            System.out.println(name + "你好,欢迎进入本系统");
        }else{
            System.out.println("您的信息有误,请稍后重试");
            System.exit(0); // 终止程序
        }
        //问题3. 当管理人员登录成功后,给出选项提示,根据管理人员的选择,执行后续的操作
        // 3.1. 给出提示: 1.查看地铁站 2.添加地铁站
        System.out.println("请输入您的选择: 1.查看地铁站  2.添加地铁站");
        // 3.2. 获取管理人员输入的选择
        String choice = sc.next();
        // 3.3. 根据管理人员的选择,执行对应的操作
        switch (choice){
            // 问题4.当管理人员选择1时,执行对应的查看地铁站操作
            case "1":
                // 4.1. 判断地铁站集合中是否有地铁站信息
                if (subwayList.size() == 0){
                    // 4.2. 如果没有地铁站信息,给出提示
                    System.out.println("系统中暂无地铁站信息");
                }else {
                    // 4.3. 如果有地铁站信息,遍历集合,打印每个地体站信息
                    System.out.println("地铁站编号\t地铁站名称\t地铁站所属路线");
                    for (Subway subway : subwayList) {
                        System.out.println(subway.getId() + "\t\t" + subway.getName() + "\t\t\t" + subway.getRoute());
                    }
                }
                break;

            // 问题5.当管理人员选择2时,执行对应的添加地铁站操作
            case "2":
                // 5.1.依次给出提示,获取管理人员输入的地铁站信息,包括地铁站编号，地铁站名称，所属路线
                System.out.println("请输入要添加的地铁站编号:");
                String sid = sc.next();
                System.out.println("请输入要添加的地铁站名称:");
                String sname = sc.next();
                System.out.println("请输入要添加的地铁站所属路线:");
                String sroute = sc.next();
                // 5.2. 将管理人员输入的地铁站信息封装成对象,存储到集合中
                Subway subway= new Subway(sid,sname,sroute);
                subwayList.add(subway);
                //  5.3. 将集合中的地铁站信息更新到文件中,在次打开文件时,应该包含管理人员刚才录入进去的地铁站信息,程序结束
                BufferedWriter bw = new BufferedWriter(new FileWriter("day02\\subways.txt"));
                for (Subway sw : subwayList) {
                    bw.write(sw.getId()+","+sw.getName()+","+sw.getRoute());
                    bw.newLine();
                }
                bw.close();
                System.out.println(sname + "地铁站的信息已经添加成功");
                break;
            default:
                System.out.println("您输入的选择有误,请稍后重试");

            // 修改和删除功能,如感兴趣可自行拓展
        }
    }
}
