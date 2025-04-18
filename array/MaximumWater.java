package array;
public class MaximumWater {
    public static void main(String[] args) {
        int[] arr = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
        System.out.println(maxArea(arr));
    }

    // https://leetcode.com/problems/container-with-most-water/
    // Approach
    // maximize area
    // move the smaller element pointer each time
    
    public static int maxArea(int[] height) {
        int i = 0, j = height.length - 1;
        int area = 0;
        while (i < j) {
            int h = Math.min(height[i], height[j]);
            int w = j - i;
            int currentArea = h * w;
            System.out.println("currentArea= " + currentArea);
            if (currentArea > area) {
                area = currentArea;
            }
            // move smaller height pointer
            if (height[i] > height[j]) {
                j--;
            } else {
                i++;
            }
        }
        return area;
    }
}