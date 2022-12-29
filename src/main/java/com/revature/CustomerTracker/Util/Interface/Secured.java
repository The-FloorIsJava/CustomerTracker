package com.revature.CustomerTracker.Util.Interface;

import java.lang.annotation.*;

@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Secured {
    boolean isPlatnium() default false;
}
