public class Main {
    public static void main(String[] args) {

        Student student1 = new Student("Jan", "Kowal", StudentCondition.CHORY, 2000, 10);
        Student student2 = new Student("Jan", "Kowalski", StudentCondition.CHORY, 2000, 35);
        Student student3 = new Student("Marcin", "Byk", StudentCondition.CHORY, 2001, 40);
        Student student4 = new Student("An", "Gryc", StudentCondition.CHORY, 2001, 0);
        Student student5 = new Student("Piotr", "Masa", StudentCondition.CHORY, 2001, 0);

        ClassContainer classContainer = new ClassContainer();
        classContainer.addClass("1A", 5);
        classContainer.addClass("1B", 5);
        classContainer.addClass("1C", 5);
        classContainer.addClass("1D", 5);

        Class class1 = classContainer.getClasses().get("1A");
        Class class2=classContainer.getClasses().get("1B");
        Class class3=classContainer.getClasses().get("1C");
        Class class4=classContainer.getClasses().get("1D");

        class1.addStudent(student1);
        class1.addStudent(student2);
        class1.addStudent(student3);
        class1.addStudent(student4);

        class1.addPoints(student1,8);
        class1.removePoints(student1,4);
        System.out.println("////// +/- punkty  /////");
        System.out.println(student1.print());

        System.out.println("///// getStudent points=0 /////");
        class1.getStudent(student4);
        class1.summary();

        System.out.println("//// changeCondition ////");
        class1.changeCondition(student1,StudentCondition.NIEOBECNY);
        System.out.println(student1.print());

        System.out.println("//// search Myk ////");
        System.out.println(class1.search("Myk"));

        System.out.println("//// searchPartial Kow ////");
        System.out.println(class1.searchPartial("Kow"));

        System.out.println("//// countByCondition ////");
        System.out.println(class1.countCondition(StudentCondition.CHORY));

        System.out.println("//// class summary ////");
        class1.summary();

        class1.addStudent(student4);
        System.out.println("//// SortByName ////");
        class1.sortByName();
        class1.summary();

        System.out.println("//// sortByPoints ////");
        class1.sortByPoints();
        class1.summary();

        System.out.println("//// max ////");
        System.out.println(class1.max());

        class2.addStudent(student5);
        System.out.println("//// puste grupy ////");
        System.out.println(classContainer.findEmpty());

        System.out.println("//// usuniecie grupy 1C //// ");
        classContainer.removeClass("1C");

        classContainer.summary();
    }
}