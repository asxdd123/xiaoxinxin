package src.src.com.word.pojo;


import src.src.com.word.annotation.Address;
import src.src.com.word.annotation.Clazz;
import src.src.com.word.annotation.Xingbie;
import src.src.com.word.annotation.Xinxi;

import java.lang.reflect.Field;

public class TestuUtils {
    public static void main(String[] args) throws Exception {
        String cls = "";
        String address = "";
        String xinxi = "";
        String xingbir = "";
        Class<?> clazz = Class.forName("src.src.com.word.pojo.XiaoHong");
        Field[] fields = clazz.getDeclaredFields();    // getDeclaredFields()返回Class中所有的字段，包括私有字段
        for (Field field : fields) {
            if (field.isAnnotationPresent(Clazz.class)){     //查看字段中是否被 @Clazz 注释
                Clazz annotation = field.getAnnotation(Clazz.class);   //获取 @Clazz 对象
                cls = annotation.value();   // 赋值
                System.out.println("班级: " + cls);  // 打印
            }

            if(field.isAnnotationPresent(Address.class)){
                Address annotation = field.getAnnotation(Address.class);
                address = annotation.value();
                System.out.println("家庭地址: " + address);
            }

            if(field.isAnnotationPresent(Xinxi.class)){
                Xinxi annotation = field.getAnnotation(Xinxi.class);
                xinxi = "[" + annotation.name() + "," + annotation.age() + "]";
                System.out.println("人员信息: " + xinxi);
            }

           if(field.isAnnotationPresent(Xingbie.class)){
               Xingbie annotation = field.getAnnotation(Xingbie.class);
               xingbir = annotation.gender().toString();
               System.out.println("性别: " + xingbir);
           }
        }
    }
}
