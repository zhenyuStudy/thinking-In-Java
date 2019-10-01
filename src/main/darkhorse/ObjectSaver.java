import java.io.*;
import java.util.Date;

/**
 * @program: thinkinginjava
 * @description:
 * @author: Joeylu
 * @create: 2019-09-29 17:22
 **/
public class ObjectSaver {

    public static void main(String[] args) throws Exception {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("/Users/lumia/GitHub/thinking-In-Java/data/objectFile.obj"));
        Customer customer = new Customer("王麻子", 24);
        out.writeObject("你好！");
        out.writeObject(new Date());
        out.writeObject(customer);
        out.close();

        ObjectInputStream in = new ObjectInputStream(new FileInputStream("/Users/lumia/GitHub/thinking-In-Java/data/objectFile.obj"));
        System.out.println("obj1 " + (String) in.readObject());
        System.out.println("obj2 " + (Date) in.readObject());
        Customer obj3 = (Customer) in.readObject();
        System.out.println("obj3 " + obj3);
        in.close();
    }


}

class Customer implements Serializable {
    private String name;
    private int age;

    public Customer(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String toString() {
        return "name=" + name + ", age=" + age;
    }
}