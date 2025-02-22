public class MaxValEquation {
    public static void main(String[] args) {
        int[][] arr = {{1,3},{2,0},{5,10},{6,-10}};
        System.out.println(findMaxValueOfEquation(arr, 1));
    }

    public static int findMaxValueOfEquation(int[][] points, int k) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int c = points[i][1] + points[j][1] + Math.abs(points[i][0] - points[j][0]);
                int cond = Math.abs(points[i][0] - points[j][0]);
                if (cond <= k && c > max) {
                    max = c;
                }
            }
        }
        return max;
    }
}
