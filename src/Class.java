import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Class {
    private String groupName;
    private int maxStudents;
    private ArrayList<Student> students;

    public Class(String groupName, int maxStudents) {
        this.groupName = groupName;
        this.maxStudents = maxStudents;
        this.students = new ArrayList<>();
    }

    public String getGroupName() {
        return groupName;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }
    public double getGroupSize(){
        return students.size();
    }
    public int getMaxGroupSize() {
        return maxStudents;
    }

    public void addStudent(Student student) {
        for (Student stud : students) {
            if (stud.getName().contains(student.getName())) {
                System.out.println("Student o tym imieniu juz istnieje");
            }
        }

        if (students.size() >= maxStudents) {
            System.err.println("Maksymalna ilosc studentow, nie mozna dodac wiecej.");
            return;
        }
        students.add(student);
    }

    public void addPoints(Student student,double points){
        student.setPoints(student.getPoints()+points);
    }
    public void getStudent(Student student){
        if(student.getPoints()<=0){
        students.remove(student);
        }
    }
    public void changeCondition(Student student,StudentCondition stan){
        student.setStan(stan);
    }
    public void removePoints(Student student, double points){
        student.setPoints(student.getPoints()-points);
    }
    public String search(String lastName) {
        Comparator<Student> byLastName = Comparator.comparing(Student::getLastName);

        for (Student student : students) {
            if (byLastName.compare(student, new Student("", lastName, StudentCondition.ODRABIAJACY, 0, 0)) == 0) {
                return student.print();
            }
        }
        return "Nie ma takiego nazwiska w systemie";
    }
    public String searchPartial(String namePart) {
        String str="";
        for (Student student : students) {
            if (student.getName().contains(namePart) || student.getLastName().contains(namePart)) {
               str+=student.print()+"\n";
            }
        }
        if(str==""){
            return "Brak w systemie";
        }
        return str;
    }
    public int countCondition(StudentCondition condition) {
        int count = 0;
        for (Student student : students) {
            if (student.getStan() == condition) {
                count++;
            }
        }
        return count;
    }
    public void summary() {
        for (Student student : students) {
            System.out.println( student.print());
        }
    }
    public ArrayList<Student> sortByName() {
        Collections.sort(students);
        return students;
    }
    public ArrayList<Student> sortByPoints() {
        Collections.sort(students, new Comparator<Student>() {
            public int compare(Student s1, Student s2) {
                if (s1.getPoints() > s2.getPoints())
                    return -1;
                if (s1.getPoints() < s2.getPoints())
                    return 1;
                return 0;
            }
        });
        return students;
    }
    public String max() {
        Student mostPoints= Collections.max(students, Comparator.comparing(Student::getPoints));
        return mostPoints.print();
    }
}
