public class Student implements Comparable<Student> {
    private String name;
    private String lastName;
    StudentCondition stan;
    private Integer birthYear;
    private double points;

    public Student(String name, String lastName, StudentCondition stan, Integer birthYear, double points) {
        this.name = name;
        this.lastName = lastName;
        this.stan = stan;
        this.birthYear = birthYear;
        this.points = points;
    }

    @Override
    public int compareTo(Student s) {
        return this.lastName.compareTo(s.lastName);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public double getPoints() {
        return points;
    }

    public void setStan(StudentCondition stan) {
        this.stan = stan;
    }

    public Integer getBirthYear() {
        return birthYear;
    }

    public StudentCondition getStan() {
        return stan;
    }

    public void setPoints(double points) {
        this.points = points;
    }

    public String getLastName() {
        return lastName;
    }

    public String print() {
        return "Student{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", stan=" + stan +
                ", birthYear=" + birthYear +
                ", points=" + points +
                '}';
    }
}
