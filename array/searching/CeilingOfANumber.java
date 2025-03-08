package array.searching;

// https://www.geeksforgeeks.org/problems/ceil-in-a-sorted-array/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=practice_card
public class CeilingOfANumber {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 3, 4, 5, 7, 10, 19, 89 };
        System.out.println(arr[findCeil(arr, 11)]);
    }

    public static int findCeil(int[] arr, int x) {
        // code here
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= x) {
                return i;
            }
        }
        return -1;
    }

}
