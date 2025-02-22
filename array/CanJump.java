package array;
// https://leetcode.com/problems/jump-game/
public class CanJump {
    public static void main(String[] args) {
        int[] arr={3,2,1,1,4};
        System.out.println(canJump(arr));
    }
    public static boolean canJump(int[] nums) {
        int maxJump = nums[0];
        for (int i = 1; i < nums.length ; i++) {
            if (maxJump <= 0) {
                return false;
            }
            int cj = nums[i];
            // compare last left jump steps with current element to find maxJump steps
            maxJump = Math.max(cj, --maxJump);

        }
        return true;
    }
}
