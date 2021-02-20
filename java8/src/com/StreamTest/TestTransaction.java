package com.StreamTest;

import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author promise
 * @date 2020/8/31 - 22:24
 */
public class TestTransaction {
    List<Transaction> transactions = null;

    @Before
    public void before(){
        Trader raoul = new Trader("Raoul","Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");

        transactions = Arrays.asList(
                new Transaction(brian,2011,300),
                new Transaction(raoul,2012,1000),
                new Transaction(raoul,2011,400),
                new Transaction(mario,2012,710),
                new Transaction(mario,2012,700),
                new Transaction(alan,2012,950)
        );
    }

    //1.找出2011年发生的所有交易，并按交易额排序(由低到高)
    @Test
    public void test1(){
        transactions.stream()
                .filter(transaction -> transaction.getYear()==2011)
                .sorted((x,y) -> Integer.compare(x.getValue(),y.getValue()))
                .forEach(System.out::println);
    }

    //2.交易员都在哪些不同的城市工作过
    @Test
    public void test2(){
//        transactions.stream()
//                .map(transaction -> transaction.getTrader().getCity())
//                .collect(Collectors.toSet())
//                .forEach(System.out::println);

        transactions.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .distinct()
                .forEach(System.out::println);
    }

    //3.查找所有来自剑桥的交易员，并按姓名排序
    @Test
    public void test3(){
        transactions.stream()
                .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getTrader)
                .distinct()
                .sorted((x,y) -> x.getName().compareTo(y.getName()))
                .forEach(System.out::println);
    }
    //4.返回所有交易员的姓名字符串，按字母顺序排序
    @Test
    public void test4(){
        transactions.stream()
                .map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted((x,y) -> x.compareTo(y))
                .forEach(System.out::println);

        System.out.println("--------------------");
        String str = transactions.stream()
                .map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted((x, y) -> x.compareTo(y))
                .reduce("", String::concat);
        System.out.println(str);
        System.out.println("------------------------------");

        transactions.stream()
                .map(transaction -> transaction.getTrader().getName())
                .flatMap(TestTransaction::filterCharacter)
                .sorted((x,y) -> x.compareToIgnoreCase(y))
                .forEach(System.out::print);

    }

    public static Stream<String> filterCharacter(String str){
        List<String> list = new ArrayList<>();
        for (Character ch : str.toCharArray()) {
            list.add(ch.toString());
        }
        return list.stream();
    }
    //5.有没有交易员是在米兰工作的
    @Test
    public void test5(){
        boolean bl = transactions.stream()
                .anyMatch(transaction -> transaction.getTrader().getCity().equals("Milan"));

        System.out.println(bl);

    }
    //6.打印生活在剑桥的交易员的所有交易额
    @Test
    public void test6(){
        Integer count = transactions.stream()
                .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
                .collect(Collectors.summingInt(Transaction::getValue));
        System.out.println(count);
    }
    //7.所有交易中，最高的交易额是多少
    @Test
    public void test7(){
        Optional<Integer> max = transactions.stream()
                .map(Transaction::getValue)
                .max(Integer::compareTo);
        System.out.println(max.get());
    }
    //8.找到交易额最小的交易
    @Test
    public void test8(){
        Optional<Transaction> min = transactions.stream()
                .min((x, y) -> Integer.compare(x.getValue(), y.getValue()));
        System.out.println(min.get());
    }
}
