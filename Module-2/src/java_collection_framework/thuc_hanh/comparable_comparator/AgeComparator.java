package java_collection_framework.thuc_hanh.comparable_comparator;

import java.util.Comparator;

public class AgeComparator implements Comparator<Student> {
    @Override
    public int compare(Student student1, Student student2) {
        if (student1.getAge() > student2.getAge()){
            return 1;
        }else if (student1.getAge() == student2.getAge()){
            return 0;
        }else {
            return -1;
        }
    }
}
