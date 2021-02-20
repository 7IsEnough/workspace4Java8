package com.lambdaTest;

import com.lambda.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TestLambda {

    List<Employee> employees = Arrays.asList(
            new Employee("张三",18,9999.99),
            new Employee("李四",38,5555.99),
            new Employee("王五",50,6666.66),
            new Employee("赵六",16,3333.33),
            new Employee("田七",8,7777.77)
    );

    @Test
    public void test1(){
        Collections.sort(employees,(e1,e2) -> {
            if(e1.getAge() == e2.getAge()){
                return e1.getName().compareTo(e2.getName());
            }else {
                return -Integer.compare(e1.getAge(),e2.getAge());
            }
        });

        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    @Test
    public void test2(){
        String trimStr = strHandler("\t\t\t 湖人总冠军", str -> str.trim());
        System.out.println(trimStr);

        System.out.println(strHandler("abcdef",str -> str.toUpperCase()));

        System.out.println(strHandler("湖人总冠军",str -> str.substring(0,2)));


    }

    @Test
    public void test3(){
        op(100L,200L,(x,y) -> x+y);

        op(100L,200L,(x,y) -> x*y);
    }

    //需求：用于处理字符串
    public String strHandler(String str, MyFunction mf){
        return mf.getValue(str);
    }

    //需求：对于2个Long型数据进行处理
    public void op(Long l1,Long l2,MyFunction2<Long,Long> mf){
        System.out.println(mf.getValue(l1,l2));
    }
}
