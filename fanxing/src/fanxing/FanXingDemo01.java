package fanxing;

import entry.Cat;
import entry.Dog;

/**
 * @Author: 就不告诉你
 * @CreateTime: 2023-01-23 21:51
 */
public class FanXingDemo01<T> {
    public static void main(String[] args) {
        //泛型类的使用
        methods01();
        //泛型方法的使用
        methods02("小白", 3);
    }

    private static <T> void methods02(T t1, Integer t2) {
        Cat<T> cat = new Cat<>(t1, t2);
        System.out.println(cat);
    }

    private static void methods01() {
        Cat<String> cat = new Cat<>("小花", 10);
        Cat<Integer> cat1 = new Cat<>(13, 10);
        System.out.println(cat);
        System.out.println(cat1);

        Dog<String> dog = new Dog<>("骨头");
        System.out.println(dog);
        Dog<Integer> dog1 = new Dog<>(13);
        System.out.println(dog1);
    }
}
