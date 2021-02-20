package com.lambda;

import org.junit.Test;

import java.util.*;
import java.util.function.Consumer;

/***
 * Lambda表达式基础语法：Java8中引入了一个新的操作符 "->" 该操作符成为箭头操作符或Lambda操作符
 *                      箭头操作符将Lambda表达式拆分为
 *                      左侧：Lambda表达式的参数列表
 *                      右侧：Lambda表达式中所需执行的功能，即Lambda体
 *
 * 语法格式一：无参数，无返回值
 *      () -> System.out.println("Hello Lambda");
 *
 * 语法格式二：有一个参数，无返回值
 *      (x) -> System.out.println(x);
 *
 * 语法格式三：若只有一个参数，小括号可以省略不写
 *
 * 语法格式四：有两个以上的参数，有返回值，并且Lambda体中有多条语句
 *             Comparator<Integer> com = (x,y) -> {
 *             System.out.println("函数式接口");
 *             return Integer.compare(x,y);
 *         };
 *
 * 语法格式五：若Lambda体中只有一条语句，return和大括号都可以省略不写
 *      Comparator<Integer> com = (x,y) -> Integer.compare(x,y);
 *
 *
 * 语法格式六：Lambda表达式的参数列表的数据类型可以省略不写，JVM编译器通过上下文推断出数据类型，即"类型推断"
 *      (Integer x,Integer y) -> Integer.compare(x,y);
 *
 *
 * Lambda表达式需要函数式接口的支持
 * 函数式接口：接口中只有一个抽象方法的接口，称为函数式接口。可以使用@FunctionalInterface修饰
 *           可以检查是否是函数式接口
 *
 */
public class TestLambda2 {

    @Test
    public void test1(){
        int num = 0; //jdk1.7前，必须是final
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello World"+num);
            }
        };
        r.run();
        System.out.println("-----------------");
        Runnable r2 = () -> System.out.println("Hello Lambda");
        r2.run();
    }

    @Test
    public void test2(){
        Consumer<String> con = x -> System.out.println(x);
        con.accept("湖人总冠军");
    }

    @Test
    public void test3(){
        Comparator<Integer> com = (x,y) -> {
            System.out.println("函数式接口");
            return Integer.compare(x,y);
        };
    }

    @Test
    public void test4(){
        Comparator<Integer> com = (x,y) ->  Integer.compare(x,y);
        List<String> list = new ArrayList<>();
    }

    @Test
    public void test5(){
//        String[] strs = {"aaa","bbb","ccc"};

        show(new HashMap());
    }

    public void show(Map<String,Integer> map){

    }

    //需求：对一个数进行运算
    @Test
    public void test6(){
        Integer num = operation(100, x -> x * x);
        System.out.println(num);

        System.out.println(operation(200,y -> y + 200));
    }

    public Integer operation(Integer num, MyFun mf){
        return mf.getValue(num);
    }
}
