package main.java.com.eTmy.caterpillarIsland.annotations.animals;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ObjectBasicProperties {
    int maxCount() default 0;
    String printName();
}
