package by.javacourse.se.homework1.task8;

import java.util.*;

public class PayStudends {

    public static void main(String[] args) {

        int[] array = {1, 2, 3, 4, 5, 3, 2, 1, 2, 6, 5, 4, 3, 3, 2, 1, 1, 3, 3, 3, 4, 2};
    }

    static class Student {
        public Student(int id) {
            this.id = id;
        }

        int id;
        int pay = 0;

        List<Student> moreThan = new ArrayList<>();
        List<Student> lessThan = new ArrayList<>();

        public String toString() {
            return "Student{" + "id=" + id + ", moreThan=" + moreThan + '}';
        }
    }


    private static Set<Student> getMinorStudents(Collection<Student> students) {
        Set<Student> set = new HashSet<>();

        for (Student student : students) {
            if (student.moreThan.isEmpty()) {
                set.add(student);
            }
        }
        return set;
    }
}