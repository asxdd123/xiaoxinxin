package src.src.com.word.annotation;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Xinxi {
    public String name() default "";

    public int age() default 0;


}
