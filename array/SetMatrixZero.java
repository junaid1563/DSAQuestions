package array;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/set-matrix-zeroes/

public class SetMatrixZero {

    public static void main(String[] args) {
        int[][] arr = { { 1, 2, 3 }, { 4, 0, 5 }, { 7, 8, 0 } };
        setZeroes(arr);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void setZeroes(int[][] matrix) {
        List<Integer[]> idx = new ArrayList<>();
        // finding 0 elements
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    idx.add(new Integer[] { i, j });
                }
            }
        }
        // now we go through idx list and set row and cols to 0
        for (int i = 0; i < idx.size(); i++) {

            int row = idx.get(i)[0];
            int col = idx.get(i)[1];
            // setting row to 0
            for (int j = 0; j < matrix[row].length; j++) {
                matrix[row][j] = 0;
            }
            // setting col to 0
            for (int j = 0; j < matrix.length; j++) {
                matrix[j][col] = 0;
            }
        }
    }
}
