package stdio;

import java.util.Arrays;

public class Sort {
    public static void main(String[] args) {
        int [] arrStudent1 = {1, 2, 4};
        int [] arrStudent2 = {1, 3, 4};

        int length = arrStudent1.length+arrStudent2.length;
        int [] students = new int[length];

        int count = 0;
        for (int i : arrStudent1){
            students[count] = i;
            count++;
        }
        for (int j : arrStudent2){
            students[count] = j;
            count++;
        }

        Arrays.sort(students);
        System.out.println(Arrays.toString(students));
    }
}
