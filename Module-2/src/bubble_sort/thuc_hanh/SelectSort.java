package bubble_sort.thuc_hanh;

public class SelectSort {
    static double[] list = {1, 9, 4.5, 6.6, 5.7, -4.5};
    public static void selectSort(double[] list){
        for (int i = 0; i < list.length-1; i++){
            double currentMin = list[i];
            int currentMinIndex = 1;

            for (int j = i+1; j < list.length; j++){
                if (currentMin > list[j]){
                    currentMin = list[j];
                    currentMinIndex = j;
                }
            }
            if (currentMinIndex != i){
                list[currentMinIndex] = list[i];
                list[i] = currentMin;
            }
        }
    }

    public static void main(String[] args) {
        selectSort(list);
        for (int i = 0; i < list.length; i++){
            System.out.print(list[i]+" ");
        }
    }
}
