package src.src.com.hello.utils;

import src.src.com.hello.annotation.Gender;
import src.src.com.hello.annotation.Name;
import src.src.com.hello.annotation.Profile;

import java.lang.reflect.Field;

/**
 * Created by mingwei on 12/2/16.
 */
public class CustomUtils {

    public static void getInfo(Class<?> clazz) {
        String name = "";
        String gender = "";
        String profile = "";
        Field fields[] = clazz.getDeclaredFields();   // getDeclaredFields()返回Class中所有的字段，包括私有字段
        for (Field field : fields) {
            if (field.isAnnotationPresent(Name.class)) {  //查看字段中是否被 @Name 注释
                Name arg0 = field.getAnnotation(Name.class);   //获取 @Name 对象
                name = name + arg0.value();   // 赋值
                System.out.println("name=" + name);
            }
            if (field.isAnnotationPresent(Gender.class)) {      //查看字段中是否被 @Gender 注释
                Gender arg0 = field.getAnnotation(Gender.class);   //获取 @Gender 对象
                gender = gender + arg0.gender().toString();    // 赋值
                System.out.println("gender=" + gender);
            }
            if (field.isAnnotationPresent(Profile.class)) {    //查看字段中是否被 @Profile 注释
                Profile arg0 = field.getAnnotation(Profile.class);      //获取 @Profile 对象
                profile = "[id=" + arg0.id() + ",height=" + arg0.height() + ",nativePlace=" + arg0.nativePlace() + "]"; //赋值
                System.out.println("profile=" + profile);
            }
        }
    }

}
