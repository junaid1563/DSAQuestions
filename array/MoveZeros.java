package array;
public class MoveZeros {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 0, 3, 4, 5, 0, 0, 4,2 };
        moveZeroes(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void moveZeroes(int[] nums) {
        int idx = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                idx++;
                nums[idx] = nums[i];
            }
        }
        if (idx != -1) {

            for (int i = idx + 1; i < nums.length; i++) {
                nums[i] = 0;
            }
        }
    }
}
