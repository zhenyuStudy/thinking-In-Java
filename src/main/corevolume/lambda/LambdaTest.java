package lambda;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.function.BiFunction;


class LengthComparator implements Comparator<String> {

    @Override
    public int compare(String first, String second) {
        return first.length()-second.length();
    }
}

class Worker implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent event) {
        System.out.println("At the tone, the time is " + new Date());
        Toolkit.getDefaultToolkit().beep();
    }
}

public class LambdaTest {

    public static void repeatMessage(String text, int delay){
        ActionListener listener = event -> {
            System.out.println(text);
            Toolkit.getDefaultToolkit().beep();
        };
        new Timer(delay, listener).start();
    }

    public static void main(String[] args) {
        repeatMessage("hello",1000);

//        String[] planets = new String[] {"Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus","Neptune"};
//        System.out.println(Arrays.toString(planets));
//        System.out.println("Sorted in dictionary order: ");
//        Arrays.sort(planets);
//        Arrays.sort(planets,String::compareToIgnoreCase);    //method reference
//        System.out.println(Arrays.toString(planets));
//        System.out.println("Sorted by length:");
//        Arrays.sort(planets,(first, second)->first.length()-second.length());
//        System.out.println(Arrays.toString(planets));

//        Timer t1 =  new Timer(1000, event -> {
//            System.out.println("The time is " + new Date());
//            Toolkit.getDefaultToolkit().beep();
//        });
//        t1.start();

//        Timer t2 = new Timer(1000, System.out::println);
//        t2.start();
//
//        BiFunction<String,String,Integer> comp = (first,second) -> first.length()-second.length();

    }
}
