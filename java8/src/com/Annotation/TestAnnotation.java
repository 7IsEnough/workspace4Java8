package com.Annotation;

import org.junit.Test;

import java.lang.reflect.Method;

/**
 * @author promise
 * @date 2020/9/1 - 22:30
 * 重复注解与类型注解
 */
public class TestAnnotation {

    //check framework
    private /*@NonNull*/ Object obj = null;

    @MyAnnotation("Hello")
    @MyAnnotation("World")
    public void show(@MyAnnotation("abc") String str){

    }

    @Test
    public void test1() throws NoSuchMethodException {
        Class<TestAnnotation> clazz = TestAnnotation.class;
        Method m1 = clazz.getMethod("show");

        MyAnnotation[] ma = m1.getAnnotationsByType(MyAnnotation.class);

        for (MyAnnotation myAnnotation : ma) {
            System.out.println(myAnnotation.value());
        }
    }
}
