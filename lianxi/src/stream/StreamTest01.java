package stream;

import entry.Actor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author: 就不告诉你
 * @CreateTime: 2023-01-13 15:35
 */
public class StreamTest01 {
    public static void main(String[] args) {

        Stream<String> stream = Stream.of("黄药师", "冯蘅", "郭靖", "黄蓉", "郭芙", "郭襄", "郭破虏");
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("陈玄风");
        arrayList.add("梅超风");
        arrayList.add("陆乘风");
        arrayList.add("曲灵风");
        arrayList.add("武眠风");
        arrayList.add("冯默风");
        arrayList.add("罗玉风");


        List<String> list = stream.filter(a -> a.startsWith("郭")).collect(Collectors.toList());
        System.out.println("使用Stream将以郭字开头的元素存入新数组: " + list);

        List<String> list1 = arrayList.stream().limit(2).collect(Collectors.toList());
        System.out.println("取出前2个元素并在控制台打印输出: " + list1);

        List<String> list2 = arrayList.stream().skip(arrayList.size() - 2).collect(Collectors.toList());
        System.out.println("取出后2个元素并在控制台打印输出: " + list2);

        List<Integer> list3 = numbers.stream().map(a -> a * a).collect(Collectors.toList());
        System.out.println("遍历数组: " + list3);


        ArrayList<String> manArray = new ArrayList<>();
        manArray.add("刘德华");
        manArray.add("成龙");
        manArray.add("吴彦祖");
        manArray.add("周润发");
        manArray.add("周星驰");
        manArray.add("吴京");

        ArrayList<String> womanList = new ArrayList<>();
        womanList.add("林心如");
        womanList.add("孙俪");
        womanList.add("柳岩");
        womanList.add("林青霞");
        womanList.add("王祖贤");
        womanList.add("张曼玉");


        //男演员只要名字为3个字的前三人
        List<String> list4 = manArray.stream().filter(a -> a.length() == 3).collect(Collectors.toList());
        System.out.println("男演员只要名字为3个字的前三人: " + list4);

        //女演员只要姓林的，并且不要第一个
        List<String> list5 = womanList.stream().filter(a -> a.startsWith("林")).skip(1).collect(Collectors.toList());
        System.out.println("女演员只要姓林的，并且不要第一个: " + list5);

        //把过滤后的男演员姓名和女演员姓名合并到一起
        List<String> list6 = Stream.concat(manArray.stream().filter(a -> a.length() == 3), womanList.stream().filter(a -> a.startsWith("林")).skip(1)).collect(Collectors.toList());
        System.out.println("把过滤后的男演员姓名和女演员姓名合并到一起: " + list6);

        //把上一步操作后的元素作为构造方法的参数创建演员对象（实例化一个Actor类，此处尝试使用map），遍历数组
        List<Actor> list7 = list6.stream().map(Actor::new).collect(Collectors.toList());
        System.out.println("遍历数组: " + list7);


    }
}
