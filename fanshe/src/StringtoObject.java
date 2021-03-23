import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import static java.lang.Class.forName;
public class StringtoObject{

    public static void main(String[] args) throws Exception {
        String user = "User.printString";//字符串是该类的全限定名
        boolean point=user.contains(".");
        Class<?> clzz =null;
        if(!point){
            try {
                clzz = Class.forName(user);

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }else{
            String className=user.substring(0,user.indexOf("."));
            try {
                clzz = Class.forName(className);

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        try{
            Method met= clzz.getMethod("printString");
            String rv= (String) met.invoke(clzz.newInstance());


        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

}
