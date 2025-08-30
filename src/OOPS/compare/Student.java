package OOPS.compare;

public class Student implements  Comparable<Student>{
    String name;
    int rollno;

    public Student(int rollno, String name) {
        this.rollno = rollno;
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int compareTo(Student o) {
//        if this return 0 means equal
//        if this return <0 then o is greater
//        if this return >0 then this is gerater;
        return this.rollno-o.rollno ;
    }
}
