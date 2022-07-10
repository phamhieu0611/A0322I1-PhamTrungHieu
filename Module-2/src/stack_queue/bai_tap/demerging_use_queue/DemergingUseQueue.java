package stack_queue.bai_tap.demerging_use_queue;

import java.util.*;

public class DemergingUseQueue {
    public static void main(String[] args) {
        StudentList stdL[] = new StudentList[5];
        List<StudentList> studentLists = new ArrayList<>();
        Queue<StudentList> queueNu= new LinkedList<>();
        Queue<StudentList> queueNam= new LinkedList<>();

        stdL[0] = new StudentList("Nguyen Van A", true, "01/01/2000");
        stdL[1] = new StudentList("Nguyen Van B", true, "02/02/2000");
        stdL[2] = new StudentList("Nguyen Thi C", false, "03/03/2000");
        stdL[3] = new StudentList("Nguyen Thi D", false, "04/04/2000");
        stdL[4] = new StudentList("Nguyen Van E", true, "05/05/2000");
        System.out.println("Before sort: ");
        for (StudentList stdLValue : stdL){
            System.out.println(stdLValue.toString());
            if (stdLValue.isGender()){
                queueNam.add(stdLValue);
            }else
                queueNu.add(stdLValue);
        }
        String someOutput ="";
        while (!queueNu.isEmpty()){
            someOutput = someOutput+queueNu.remove()+"\n";
        }
        while (!queueNam.isEmpty()){
            someOutput = someOutput+queueNam.remove()+"\n";
        }
        System.out.println("\nAfter Sort: ");
        System.out.println(someOutput);
    }
}
