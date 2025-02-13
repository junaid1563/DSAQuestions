package array;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/spiral-matrix/
public class SpiralMatrix {
    public static void main(String[] args) {
        // int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
        int[][] matrix = { { 1, 2, 3, 4, 21 }, { 5, 6, 7, 8, 22 }, { 9, 10, 11, 12, 23 } };
        System.out.println(spiralOrder(matrix));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        int topLimit = 0, bottomLimit = matrix.length - 1, leftLimit = 0, rightLimit = matrix[0].length - 1;
        int row = topLimit, col = leftLimit;
        List<Integer> ans = new ArrayList<>();
        while (leftLimit <= rightLimit && topLimit <= bottomLimit) {

            // first move left to right on top
            while (leftLimit <= rightLimit && topLimit <= bottomLimit && col <= rightLimit) {
                ans.add(matrix[row][col]);
                System.out.println("left->right");
                col++;
            }
            topLimit++;
            row = topLimit;
            col = rightLimit;
            // now move top to bottom on right
            while (leftLimit <= rightLimit && topLimit <= bottomLimit && row <= bottomLimit) {
                ans.add(matrix[row][col]);
                System.out.println("top->bottom");
                row++;
            }
            rightLimit--;
            row = bottomLimit;
            col = rightLimit;
            // now move right to left on bottom
            while (leftLimit <= rightLimit && topLimit <= bottomLimit && col >= leftLimit) {
                ans.add(matrix[row][col]);
                System.out.println("right->left");
                col--;
            }
            bottomLimit--;
            row = bottomLimit;
            col = leftLimit;
            // now move bottom to top on left
            while (leftLimit <= rightLimit && topLimit <= bottomLimit && row >= topLimit) {
                ans.add(matrix[row][col]);
                System.out.println("bottom->right");
                row--;
            }
            leftLimit++;
            row = topLimit;
            col = leftLimit;
        }
        return ans;
    }
}
