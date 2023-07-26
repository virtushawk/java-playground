package com.virtushawk.app.annotation;

public @interface SimpleAnnotation {
    String value() default "";

    String next();
}
