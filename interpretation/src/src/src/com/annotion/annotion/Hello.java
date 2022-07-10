package src.src.com.annotion.annotion;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.ANNOTATION_TYPE,ElementType.METHOD})
public @interface Hello {
    public String value() default "你好";
}
