package lesson18;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class ReflectionAPI {

    public static void main(String[] args) {
        MyClass myClass = new MyClass(1, "");

        String name = null;
        try {
            System.out.println(myClass.getClass());
            System.out.println(Arrays.toString(myClass.getClass().getFields()));
            System.out.println(Arrays.toString(myClass.getClass().getDeclaredFields()));

            Field field = myClass.getClass().getDeclaredField("name");
            field.setAccessible(true);
            name = (String) field.get(myClass);
            field.set(myClass, (String) "new value");

            System.out.println(Arrays.toString(myClass.getClass().getDeclaredMethods()));

            Method method = myClass.getClass().getDeclaredMethod("printData");
            method.setAccessible(true);
            method.invoke(myClass);


            Class clazz = Class.forName(MyClass.class.getName());
            Class[] params = {int.class};
            myClass = (MyClass) clazz.getConstructor(params).newInstance(1);

            Constructor[] constructors = clazz.getConstructors();
            for (Constructor constructor : constructors) {
                Class[] paramTypes = constructor.getParameterTypes();
                for (Class paramType : paramTypes) {
                    System.out.print(paramType.getName() + " ");
                }
                System.out.println();
            }


        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException | ClassNotFoundException | InstantiationException | NoSuchFieldException e) {
            e.printStackTrace();
        }

        System.out.println(name);
        System.out.println(myClass.getName());

//        myClass.printData();
    }


}
