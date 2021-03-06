package com.StreamTest;

import com.lambda.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @author promise
 * @date 2020/8/31 - 22:07
 *
 */
public class TestStreamAPI {

//      1.给定一个数字列表，如何返回一个由每个数的平方构成的列表
//              给定[1,2,3,4,5],应该返回[1,4,9,16,25]

    @Test
    public void test1(){
        Integer[] nums = new Integer[]{1,2,3,4,5};

        Arrays.stream(nums)
                .map((integer -> integer * integer))
                .forEach(System.out::println);
    }

    //2.怎么用map和reduce方法数一数流中有多少个Employee
    List<Employee> emps = Arrays.asList(
            new Employee(102,"李四",59,6666.66, Employee.Status.BUSY),
            new Employee(101,"张三",18,9999.99, Employee.Status.FREE),
            new Employee(103,"王五",28,3333.33, Employee.Status.VOCATION),
            new Employee(104,"赵六",8,7777.77, Employee.Status.BUSY),
            new Employee(104,"赵六",8,7777.77, Employee.Status.FREE),
            new Employee(104,"赵六",8,7777.77, Employee.Status.FREE),
            new Employee(105,"田七",38,5555.55, Employee.Status.BUSY)
    );
    @Test
    public void test2(){
        Optional<Integer> count = emps.stream()
                .map(employee -> 1)
                .reduce(Integer::sum);
        System.out.println(count.get());

    }
}
