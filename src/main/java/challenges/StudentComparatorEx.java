package challenges;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StudentComparatorEx
{
    public static void main (String[] args)
    {
        Student s1 = new Student(1, "abc", 10);
        Student s2 = new Student(2, "xcg", 19);
        List<Student> students = new ArrayList<>();
        students.add(s1);
        students.add(s2);
        students.sort(new RollComparator());
    }

    static class Student
    {
        int rollCall;
        String name;
        int age;

        Student (int rollCall, String name, int age)
        {
            this.rollCall = rollCall;
            this.name = name;
            this.age = age;
        }
    }

    static class RollComparator implements Comparator<Student>
    {
        @Override public int compare (Student s1, Student s2)
        {
            return s1.rollCall - s2.rollCall;
        }
    }
}
