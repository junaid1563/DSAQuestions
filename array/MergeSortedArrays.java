package array;

public class MergeSortedArrays {
    public static void main(String[] args) {
        int []nums1={1,2,3,0,0,0};
        int[] nums2={2,5,6};
        merge(nums1, 3, nums2, nums2.length);
        for(int i:nums1){
            System.out.println(i);
        }
    }
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] arr = new int[m + n];
        int i = 0, j = 0, c = 0;
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                arr[c] = nums1[i];
                c++;
                i++;
            } else {
                arr[c] = nums2[j];
                c++;
                j++;
            }
        }
        while (i < m) {
            arr[c] = nums1[i];
            c++;
            i++;
        }
        while (j < n) {
            arr[c] = nums2[j];
            c++;
            j++;
        }
        for (int k = 0; k < m + n; k++) {
            nums1[k] = arr[k];
        }
    }
}
