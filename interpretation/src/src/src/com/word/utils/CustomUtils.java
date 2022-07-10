package src.src.com.word.utils;

import src.src.com.hello.annotation.Gender;
import src.src.com.hello.annotation.Name;
import src.src.com.hello.annotation.Profile;
import src.src.com.word.annotation.Address;
import src.src.com.word.annotation.Clazz;
import src.src.com.word.annotation.Xingbie;
import src.src.com.word.annotation.Xinxi;

import java.lang.reflect.Field;

/**
 * Created by mingwei on 12/2/16.
 */
public class CustomUtils {

    public static void getInfo(Class<?> clazz) {
        String address = "";
        String clazz2 = "";
        String xingbie = "";
        String xinxi0 = "";

        Field fields[] = clazz.getDeclaredFields();   // getDeclaredFields()返回Class中所有的字段，包括私有字段
        for (Field field : fields) {
            if (field.isAnnotationPresent(Address.class)) {  //查看字段中是否被 @Name 注释
                Address arg0 = field.getAnnotation(Address.class);   //获取 @Name 对象
                address = address + arg0.value();   // 赋值
                System.out.println("address=" + address);
            }

            if (field.isAnnotationPresent(Clazz.class)) {
                Clazz clazz1 = field.getAnnotation(Clazz.class);
                clazz2 = clazz1.value() + clazz2;
                System.out.println("clazz = " + clazz2);
            }

            if (field.isAnnotationPresent(Xingbie.class)) {
                Xingbie annotation = field.getAnnotation(Xingbie.class);
                xingbie = xingbie + annotation.gender().toString();
                System.out.println("xingbie = " + xingbie);
            }

            if (field.isAnnotationPresent(Xinxi.class)) {
                Xinxi xinxi = field.getAnnotation(Xinxi.class);
                xinxi0 = xinxi0 + "[" + xinxi.name() + "," + xinxi.age() + "]";
                System.out.println("xinxi = " + xinxi0);
            }
        }
    }

}
