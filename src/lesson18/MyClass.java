package lesson18;

public class MyClass {
    protected int number;
    private String name = "default";
    public double d;
    public MyClass(int number, String name) {
        this.number = number;
        this.name = name;
    }

    public MyClass(String name) {
        this.number = number;
        this.name = name;
    }

    public MyClass(int number) {
        this.number = number;
        this.name = name;
    }


    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
    }
    public String getName() {
        return name;
    }

    private void printData(){
        System.out.println(number + " " + name);
    }
}
