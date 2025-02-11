package array;

public class MaximumPoints {
    public static void main(String[] args) {
        int[] arr = { 1, 79, 80, 1, 1, 1, 200, 1 };
        System.out.println(maxScore(arr, 3));
    }

    public static int maxScore(int[] cardPoints, int k) {
        int score = Integer.MIN_VALUE;
        int m = cardPoints.length - k;
        // find total sum
        int total = 0;
        for (int i : cardPoints) {
            total += i;
        }
        // loop through n-k window to find maximum sum o subArray of k size
        for (int i = 0; i <= cardPoints.length - m; i++) {
            int sum = total;
            for (int j = i; j < m + i; j++) {
                sum -= cardPoints[j];
            }
            if (sum > score) {
                score = sum;
            }
        }
        return score;
    }
}
