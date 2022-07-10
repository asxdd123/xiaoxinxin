package src.src.com.annotion.utils;

import src.src.com.annotion.annotion.Hello;

import java.lang.reflect.Field;

public class HelloUtils {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> aClass = Class.forName("src.src.com.annotion.pojo.User");
        Field[] fields = aClass.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(Hello.class)) {
                Hello annotation = field.getAnnotation(Hello.class);
                String value = annotation.value();
                System.out.println("sayHello: " + value);
            }
        }
    }
}
