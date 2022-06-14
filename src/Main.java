import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String str1 = "Hello";
        String str2 = "Hello";
        String str3 = "Hello";
        String str4 = new String("HELLO");
        String str5 = new String("Hello");

        printAddresses(str1);
        printAddresses(str2);
        printAddresses(str3);
        printAddresses(str4);
        printAddresses(str5);
        System.out.println();

        System.out.println("сравнение по ссылкам");
        System.out.println(str1 == str2);
        System.out.println(str1 == str3);
        System.out.println(str1 == str4);
        System.out.println();

        System.out.println("сравнение по значению с учетом регистра");
        System.out.println(str1.equals(str2));
        System.out.println(str1.equals(str4));
        System.out.println();

        System.out.println("сравнение по значению через compareTo");
        System.out.println(str1.compareTo(str2));
        System.out.println(str1.compareTo(str4));
        System.out.println(str1.compareToIgnoreCase(str4));
        System.out.println();

        System.out.println("сравнение по значению без учета регистра");
        System.out.println(str1.equalsIgnoreCase(str4));
        System.out.println();

        System.out.println("Перевод примитивов/объектов в строку");
        String demoInt = String.valueOf(123);
        String demoDouble = String.valueOf(123.09);
        String demoBoolean = String.valueOf(true);
        String demoObject = String.valueOf(new Object());
        System.out.println(demoInt);
        System.out.println(demoDouble);
        System.out.println(demoBoolean);
        System.out.println(demoObject);
        System.out.println();

        System.out.println("Перевод строки в число");
        int intFromString = Integer.valueOf(demoInt).intValue();
        int intFromString2 = Integer.parseInt(demoInt);
        System.out.println(intFromString);
        System.out.println(intFromString2);
        System.out.println();

        System.out.println("Получить символ из строки");
        String demoCharAt = "Hello";
        System.out.println(demoCharAt.charAt(0));
        System.out.println(demoCharAt.charAt(1));
        System.out.println("Получить массив");
        System.out.println(Arrays.toString(demoCharAt.toCharArray()));
        System.out.println();

        System.out.println("Преобразование колекции/массива в строку с указанием разделителя");
        String demoJoin = String.join("; - ! &", "Hello", "World", "Java", "Best");
        String demoJoin2 = String.join(", ", new String[] {"Hello", "World", "Java", "Best"});
        System.out.println(demoJoin);
        System.out.println(demoJoin2);

        System.out.println("Разбиение строки на массив строк");
        String demoSplit = "Перевод;примитивов; и; ссылочных;типов ;данных к сторке";
        String[] array = demoSplit.split(";", 3);
        for (String s : array) {
            System.out.println(s);
        }
        System.out.println();

        System.out.println("Определение позиции элемента в строке");
        String demoFind = "Hello World";
        System.out.println(demoFind.indexOf("H"));
        System.out.println(demoFind.indexOf('W'));
        System.out.println(demoFind.indexOf("o"));
        System.out.println(demoFind.lastIndexOf("o"));
        System.out.println();

        System.out.println("Подстрока из строки");
        System.out.println(demoFind.substring(6));
        System.out.println(demoFind.substring(6, 9));
        System.out.println();

        System.out.println("Верхний/Нижний регист");
        System.out.println(demoFind.toUpperCase());
        System.out.println(demoFind.toLowerCase());
        System.out.println();

        System.out.println("Замена строки");
        String demoReplace = "Hello World World";
        System.out.println(demoReplace.replace('W', 'Q'));
        System.out.println(demoReplace.replace("World", "Den"));
        System.out.println(demoReplace.replace(" ", " - "));
        System.out.println(demoReplace.replaceAll("(.*)World(.*)", "XXX"));
        System.out.println();

        System.out.println("Преобразование строки в массив байт");
        String demoStrBytes = "SOME STRING";
        byte[] byteArray = demoStrBytes.getBytes();
        byte[] byteArray2 = demoStrBytes.getBytes(StandardCharsets.UTF_16);
        System.out.println("String to byte array : " + Arrays.toString(byteArray));
        System.out.println("String to byte array : " + Arrays.toString(byteArray2));

        System.out.println(new String(byteArray));
        System.out.println(new String(byteArray2));
        System.out.println();

        System.out.println("Строки в switch");
        String car = "BMW";
        switch (car) {
            case "Mercedes-Benz":
                System.out.println("it`s Mercedes-Benz");
            case "BMW":
                System.out.println("it`s BMW");
        }


//        long start = System.currentTimeMillis();
//        String s1 = "";
//        for (int i = 0; i < 50000; i++) {
//            s1 = s1 + "HELLO";
//            printAddresses(s1);
//        }
//        System.out.println(System.currentTimeMillis() - start);
//        long start2 = System.currentTimeMillis();
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < 50000; i++) {
//            sb.append("HELLO");
//        }
//        System.out.println(System.currentTimeMillis() - start2);

        StringBuilder stringBuilder = new StringBuilder("HELLO");

        System.out.println(stringBuilder.reverse());
        System.out.println(stringBuilder.delete(3, 4));
        System.out.println(stringBuilder.insert(0, 'X'));
        System.out.println(stringBuilder);
    }


    static final Unsafe unsafe = getUnsafe();
    static final boolean is64bit = true;

    private static Unsafe getUnsafe() {
        try {
            Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
            theUnsafe.setAccessible(true);
            return (Unsafe) theUnsafe.get(null);
        } catch (Exception e) {
            throw new AssertionError(e);
        }
    }

    public static void printAddresses(Object... objects) {
        System.out.print("address: 0x");
        long last = 0;
        int offset = unsafe.arrayBaseOffset(objects.getClass());
        int scale = unsafe.arrayIndexScale(objects.getClass());
        switch (scale) {
            case 4:
                long factor = is64bit ? 8 : 1;
                final long i1 = (unsafe.getInt(objects, offset) & 0xFFFFFFFFL) * factor;
                System.out.print(Long.toHexString(i1));
                last = i1;
                for (int i = 1; i < objects.length; i++) {
                    final long i2 = (unsafe.getInt(objects, offset + i * 4) & 0xFFFFFFFFL) * factor;
                    if (i2 > last)
                        System.out.print(", +" + Long.toHexString(i2 - last));
                    else
                        System.out.print(", -" + Long.toHexString(last - i2));
                    last = i2;
                }
                break;
            case 8:
                throw new AssertionError("Not supported");
        }
        System.out.println();
    }
}
