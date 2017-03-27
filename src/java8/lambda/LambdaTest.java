package java8.lambda;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;

/**
 * Created by qinbingbing on 27/03/2017.
 */
public class LambdaTest {
    public static void main(String[] args) {
        JButton button = new JButton("btn");
        button.addActionListener(e -> System.out.println("button clicked"));

        Runnable noArguments = () -> System.out.println("Hello World");

        ActionListener oneArgument = e -> System.out.println("button clicked");

        Runnable multiStatement = () -> {
            System.out.print("Hello");
            System.out.println(" World");
        };

        BinaryOperator<Long> add = (x, y) -> x + y;

        BinaryOperator<Long> addExplicit = (Long x, Long y) -> x + y;

        final String[] array = {"hello", "world"};

        String name = "aaa";
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("hi " + name);
            }
        });

        String name1 = "111";
//        name1 = "222";
        button.addActionListener(e -> System.out.println("hi " + name1));

        Map<String, Integer> oldWordCounts = new HashMap<String, Integer>();
        Map<String, Integer> diamondWordCounts = new HashMap<>();

        Predicate<Integer> atLeast5 = x -> x > 5;

        BinaryOperator<Long> addLongs = (x, y) -> x + y;

//        BinaryOperator addWithNoType = (x, y) -> x + y;
    }
}
