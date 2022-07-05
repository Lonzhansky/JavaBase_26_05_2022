package lesson15;

import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Student student1 = new Student("Den", 27);
        student1.setCar(new Car("Mercedes"));
        Student student3 = student1.clone();
//        Student student4 = new Student(student1.getName(), student1.getAge());



//        JavaStudent javaStudent1 = new JavaStudent("Den2", 27, 90.4);
//
//        System.out.println(student1.equals(javaStudent1));
//        System.out.println(javaStudent1.equals(student1));
//
//        System.out.println(student1.hashCode());
//        System.out.println(student2.hashCode());


        // Если hashCode student1 = student2 -> то это не 100% точность того что по equals они тоже равны
        // Если equals student1 и student2 даёт true -> тогда hashCode точно одинаковый


//        System.out.println(student1);
//        System.out.println(student3);
//        System.out.println();
//        student1.setName("seftrsed");
//        student1.setAge(22);
//        student1.getCar().setName("BMW");
//
//        System.out.println(student1);
//        System.out.println(student3);


//        while (true) {
//            new Student("Den", 27);
//        }

//        Object o = new Object();
//
//        synchronized (o) {
//            try {
//                System.out.println("Stopping...");
//                o.wait(5000);
//                System.out.println("Running...");
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }


    }
}
