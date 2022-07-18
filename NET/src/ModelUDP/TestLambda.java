package ModelUDP;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * @author 孟凡喜
 * @version 1.0.0
 * @ClassName TestLambda.java
 * @createTime 2022年07月18日
 */
public class TestLambda {
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("子线程执行了。。。。");
            }
        };


        //Lambda表达式
        //如果形参列表为空，只需要保留（）
        Runnable runnable1 = () -> {
            System.out.println("子线程22执行了。。。");

        };

        new Thread(runnable1).start();

        //如果方法体中的执行语句只有一句，并且没有返回值，{}可以省略
        Runnable runnable2 = () -> System.out.println("子线程3执行了。。。");
        new Thread(runnable2).start();


        new Thread(() -> System.out.println("子线程4执行")).start();




        //匿名内部类
        Comparator<String> com = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length()-o2.length();
            }
        };

        //使用Lambda表达式(正常编写方式)
        Comparator<String> com2 =(String o1,String o2) -> {
            return o1.length()-o2.length();
        };

        //按照字符串长度进行排序
        //形参列表的数据类型会自动进行推断
        //如果省略return关键字，且执行语句必须保证只有一句
        Comparator<String> com3 = (o1,o2) -> o1.length() - o2.length();  //简化编写方式
        TreeSet<String> treeSet = new TreeSet<>(com3);
        treeSet.add("aaa");
        treeSet.add("bbbbb");
        treeSet.add("cc");
        treeSet.add("d");
        System.out.println(treeSet);

    }
}
