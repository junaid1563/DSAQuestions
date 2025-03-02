package array;

import java.util.ArrayList;

public class Merge2dArrays {
    public static void main(String[] args) {
        int[][] nums1 = { { 1, 2 }, { 2, 3 }, { 4, 5 } };
        int[][] nums2 = { { 1, 4 }, { 3, 2 }, { 4, 1 } };
        System.out.println(length(nums1, nums2));
        int[][] ans = mergeArrays(nums1, nums2);
        for (int i = 0; i < ans.length; i++) {
        }
    }

    public static int length(int[][] nums1, int[][] nums2) {
        int i = 0, j = 0, col = 0;
        while (i < nums1.length && j < nums2.length) {
            int id1 = nums1[i][0];
            int id2 = nums2[j][0];
            if (id1 == id2) {
                col++;
            } else {
                col += 2;
            }
            i++;
            j++;
        }
        while (i < nums1.length) {
            col++;
            i++;
        }
        while (j < nums2.length) {
            col++;
            j++;
        }
        return col;
    }

    public static int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int i = 0, j = 0, col = 0;

        ArrayList<int[]> list = new ArrayList<>();
        while (i < nums1.length && j < nums2.length) {
            int id1 = nums1[i][0];
            int id2 = nums2[j][0];
            int val1 = nums1[i][1];
            int val2 = nums2[j][1];
            int[] cell = new int[2];
            if (id1 == id2) {
                int val = val1 + val2;
                cell[0] = id1;
                cell[1] = val;

                i++;
                j++;
            } else if (id1 < id2) {
                cell[0] = id1;
                cell[1] = val1;
                i++;
            } else {
                cell[0] = id2;
                cell[1] = val2;
                j++;
            }
            list.add(cell);
            col++;
        }
        while (i < nums1.length) {
            int id1 = nums1[i][0];
            int val1 = nums1[i][1];
            int[] cell = new int[2];
            cell[0] = id1;
            cell[1] = val1;
            list.add(cell);
            col++;
            i++;
        }
        while (j < nums2.length) {
            int id2 = nums2[j][0];
            int val2 = nums2[j][1];
            int[] cell = new int[2];
            cell[0] = id2;
            cell[1] = val2;
            list.add(cell);
            col++;
            j++;
        }
        int[][] ans = new int[list.size()][2];
        for (int x = 0; x < list.size(); x++) {
            ans[x] = list.get(x);
        }
        return ans;
    }
}
