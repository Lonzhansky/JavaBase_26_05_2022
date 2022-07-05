package lesson15;

import java.util.Objects;

public class Student implements Cloneable {

    private String name;
    private int age;
    private Car car;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
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

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
//        if (!(object instanceof Student)) return false;

        Student student = (Student) object;

        if (age != student.age) return false;
        return name.equals(student.name);
    }

    @Override
    public int hashCode() {
//        int result = name.hashCode();
//        result = 31 * result + age;
//        return result;

        return Objects.hash(age, name);
    }

    @Override
    protected Student clone() throws CloneNotSupportedException {
        Student temp = new Student(this.getName(), this.getAge());
        temp.setCar(new Car(car.getName()));
        return temp;
//        return (Student) super.clone();
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Destroyed");
        super.finalize();
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", car=" + (car != null ? car.getName() : "") +
                '}';
    }
}
