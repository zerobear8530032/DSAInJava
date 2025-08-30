package OOPS.compare;

import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
        Student st1= new Student(1,"Zero");
        Student st2= new Student(5,"Zara");
        Student st3= new Student(3,"aman");
        Student st4= new Student(2,"sahu");
        Student st5= new Student(9,"neha");

        Student [] list= {st1,st2,st3,st4,st5};
//        passing sorting logic
        Arrays.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o2.name.compareTo(o1.name);
            }
        });
//        using interface implementation
        System.out.println(Arrays.toString(list));
        Arrays.sort(list);
        System.out.println(Arrays.toString(list));

    }
}
