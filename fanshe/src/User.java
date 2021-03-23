import javafx.scene.paint.Stop;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class User {
    private String name="JIANHUI";
    private int age=26;
    private double money=100000.00;

    public User(){

    }

    public User(String name,int age,double money){
        this.name=name;
        this.age=age;
        this.money=money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }


    public String sayHello(String name,int age){
//        return name+", 你好!我今年"+age+"几岁了";
        return "hello";
    }

    public void printString(){
        System.out.println("StringToObject");
    }
    public static <T> StringBuffer ObjectToJson(T t){
        Class<?> c=t.getClass();
        Field[] fields=c.getDeclaredFields();
        Method[] methods=c.getDeclaredMethods();
        StringBuffer sb=new StringBuffer("{");
        for(Field field:fields){
            field.setAccessible(true);
            if(sb.equals("{")){
                sb.append(",");
            }
            sb.append("\n"+"\""+field.getName()+"\":");
            try {
                sb.append(field.get(t));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        for(Method method:methods){
            method.setAccessible(true);
            if(sb.equals("{")){
                sb.append(",");
            }
            sb.append("\n"+"\""+method.getName()+"\":");
            sb.append(method);
        }
        sb.append("\n}");
        return sb;
    }

    public static void main(String[] args) {
        User user = new User();
        StringBuffer a=ObjectToJson(user);
        System.out.println(a);
    }
}
