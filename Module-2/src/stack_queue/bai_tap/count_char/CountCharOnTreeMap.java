package stack_queue.bai_tap.count_char;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountCharOnTreeMap {
    public static void main(String[] args) {
        Map<Character, Integer> treeMap = new TreeMap<Character, Integer>();
        Scanner sc = new Scanner(System.in);
        System.out.println("In put string to count character in there: ");
        String string = sc.nextLine();

        for (int i = 0; i < string.length(); i++){
            char charAt = string.toUpperCase().charAt(i);
            if (treeMap.get(charAt) != null){
                int count = treeMap.get(charAt);
                treeMap.put(charAt, count+1);
            }else {
                treeMap.put(charAt, 1);
            }
        }
        System.out.println(treeMap);
    }
}
