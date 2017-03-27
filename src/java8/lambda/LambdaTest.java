package java8.lambda;

import javax.swing.*;

/**
 * Created by qinbingbing on 27/03/2017.
 */
public class LambdaTest {
    public static void main(String[] args) {
        JButton button = new JButton("btn");
        button.addActionListener(e -> System.out.println("button clicked"));
    }
}
