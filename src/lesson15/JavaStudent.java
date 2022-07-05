package lesson15;

public class JavaStudent extends Student {
    private double avgMark;

    public JavaStudent(String name, int age, double avgMark) {
        super(name, age);
        this.avgMark = avgMark;
    }

    public double getAvgMark() {
        return avgMark;
    }

    public void setAvgMark(double avgMark) {
        this.avgMark = avgMark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
//        if (!(o instanceof JavaStudent)) return false;
        if (!super.equals(o)) return false;

        JavaStudent that = (JavaStudent) o;

        return Double.compare(that.avgMark, avgMark) == 0;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;
        temp = Double.doubleToLongBits(avgMark);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
