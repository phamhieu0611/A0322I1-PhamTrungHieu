package searching_algorithms;

public class RecursionBinarySearch {
    static int[] list = {2, 4, 7, 10, 11, 45, 50, 59, 60, 66, 69, 70, 79};

    public int binarySearch(int arr[], int value,int left, int right){
        int mid = (left + right)/2;
        if(right <= left){
            return -1;
        }else{
            if(arr[mid] < value){
                return binarySearch(arr, value,left+1,right);
            }
            if(arr[mid] > value){
                return binarySearch(arr, value,left,right-1);
            }
            if(arr[mid] == value){
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        RecursionBinarySearch binarySearch = new RecursionBinarySearch();
        System.out.println(binarySearch.binarySearch(RecursionBinarySearch.list,
                10,0,RecursionBinarySearch.list.length));
    }

}