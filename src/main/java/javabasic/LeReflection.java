package javabasic;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class MyReflectionObj {
    private int a = 0;

    public MyReflectionObj() {
    }

    public MyReflectionObj(int a) {
        this.a = a;
    }

    public void sayHello(String h) {
        System.out.println("hello " + h +a);
    }

    private void sayLove(String name) {
        System.out.println("Love u " + name +a );
    }
}

public class LeReflection {

    public static void main(String[] args) {
        Class<MyReflectionObj> myReflectionObjClass = MyReflectionObj.class;
        try {
            Object o = myReflectionObjClass.getConstructor(int.class).newInstance(2);
            o = myReflectionObjClass.getConstructor().newInstance();
            MyReflectionObj o1 = (MyReflectionObj) o;
            o1.sayHello("ryan");
//            o1.sayLove("ryan");// error

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        try {
            Class<?> aClass = Class.forName("ryan.cloud.myclient.MyReflectionObj");
            Object o = aClass.getConstructor().newInstance();
            MyReflectionObj o1 = (MyReflectionObj) o;
            Field a = aClass.getDeclaredField("a");
            a.setAccessible(true);
            a.set(o1,3);
            o1.sayHello("kk");

            Method sayLove = aClass.getDeclaredMethod("sayLove", String.class);
            sayLove.setAccessible(true);
            Object gg = sayLove.invoke(o1, "gg");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
