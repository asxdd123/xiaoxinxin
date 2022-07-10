package src.src.com.word.annotation;

import src.src.com.hello.annotation.Gender;

import java.lang.annotation.*;


@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Xingbie {


    public enum GenterType {

        Male("男"),
        Female("女"),
        Other("中性");

        private String gender;

        GenterType(String gender) {
            this.gender = gender;
        }

        @Override
        public String toString() {
            return gender;
        }
    }

    GenterType gender() default GenterType.Male;

}
