package array;

public class ApplyOperations {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 2, 1, 1, 0 };
        applyOperations(nums);
        for (int i : nums) {
            System.out.println(i);
        }
    }

    public static int[] applyOperations(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != 0 && nums[i] == nums[i + 1]) {
                System.out.println(nums[i] + "-" + nums[i + 1]);
                nums[i] *= 2;
                nums[i + 1] = 0;
            }
        }
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[idx] = nums[i];
                idx++;
            }
        }
        while (idx < nums.length) {
            nums[idx] = 0;
            idx++;
        }

        return nums;
    }
}
