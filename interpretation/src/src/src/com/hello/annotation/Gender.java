package src.src.com.hello.annotation;

import java.lang.annotation.*;

/**
 * Created by mingwei on 12/2/16.
 * 性别注解
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Gender {

    public enum GenderType {

        Male("男"),
        Female("女"),
        Other("中性");

        private String gender;

        private GenderType(String arg0) {
            this.gender = arg0;
        }

        @Override
        public String toString() {
            return gender;
        }
    }

    GenderType gender() default GenderType.Other;

}
