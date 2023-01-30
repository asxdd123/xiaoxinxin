package stream;

import entry.Trader;
import entry.Transaction;

import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 * @Author: 就不告诉你
 * @CreateTime: 2023-01-13 16:08
 */
public class StreamTest02 {

    //java自带的日志框架
    static Logger logger = Logger.getLogger(StreamTest02.class.toString());
    static List<Transaction> transactions = null;

    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );


        //找出2011年发生的所有交易,并按交易顺序排序(从低到高)
        List<Transaction> list = transactions.stream().filter(a -> a.getYear() == 2011).sorted(Comparator.comparing(Transaction::getValue)).collect(Collectors.toList());
        logger.info("结果是: "+list);
        System.out.println(list);
        System.out.println("=============================");

        //交易员都在那些不同的城市工作过?
//        List<String> list1 = transactions.stream().map(a -> a.getTrader().getCity()).distinct().collect(Collectors.toList());
        Set<String> set = transactions.stream().map(a -> a.getTrader().getCity()).collect(Collectors.toSet());
        System.out.println(set);
        System.out.println("============================");

        //查找所有来自剑桥的交易员,并按照名字进行排序
        transactions.stream().sorted(Comparator.comparing(a -> a.getTrader().getName()))
                .filter(a -> "Cambridge".equals(a.getTrader().getCity()))
                .collect(Collectors.toList())
                .forEach(a -> System.out.println(a));
        System.out.println("============================");

        //返回所有交易员的姓名字符串,按字母顺序排序
        System.out.println(transactions.stream().map(a -> a.getTrader().getName()).sorted().collect(Collectors.joining(",")));
        System.out.println("============================");

        //有没有交易员是在米兰工作的?
        transactions.stream().filter(a -> "Milan".equals(a.getTrader().getCity())).forEach(a -> System.out.println(a));
        System.out.println("============================");

        //打印生活在剑桥的交易员的所有交易额
        transactions.stream().filter(a -> "Cambridge".equals(a.getTrader().getCity())).map(a -> a.getValue()).forEach(a -> System.out.println(a));
        System.out.println("============================");

        //所有交易流,最高的交易额是多少?
        System.out.println(transactions.stream().map(Transaction::getValue).max(Integer::compareTo).get());
        System.out.println("============================");

        //找到交易额最小的交易
        System.out.println(transactions.stream().map(Transaction::getValue).min(Integer::compareTo).get());
        System.out.println("============================");

        //根据交易年份分组
        Map<Integer, List<Transaction>> collect = transactions.stream().collect(Collectors.groupingBy(Transaction::getYear));
        for (Map.Entry<Integer, List<Transaction>> entry : collect.entrySet()) {
            List<Transaction> value = entry.getValue();
            for (Transaction transaction : value) {
                System.out.println(entry.getKey()+","+transaction);
            }
        }
    }
}
