package CustomAnnotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Repeatable(Wheres.class)
public @interface Where {

    String group() default "";
    String name();
    String searchOperation();
    String value();
    String connector();
}
