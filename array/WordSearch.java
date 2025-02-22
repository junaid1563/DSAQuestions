package array;

public class WordSearch {
    public static void main(String[] args) {
        // char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A',
        // 'D', 'E', 'E' } };
        char[][] board = { { 'a' }, { 'b' } };
        System.out.println(exist(board, "ba"));

    }

    public static boolean exist(char[][] board, String word) {
        int i = 0, j = 0;
        String str = "";
        boolean[][] arr = new boolean[board.length][board[0].length];
        return find(board, i, j, word, str, arr);
    }

    public static String reverse(String str) {

        String ans = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            ans += str.charAt(i) + "";
        }
        return ans;
    }

    public static boolean find(char[][] board, int row, int col, String word, String str, boolean[][] arr) {
        System.out.println("str = " + str);
        // base cases
        if (str.equals(word) || str.equals(reverse(word))) {
            // +ve case
            return true;
        }
        // -ve cases
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
            // boundary cases
            return false;
        }
        if (arr[row][col]) {
            // already visited cell
            return false;
        }

        // recurse
        // pre
        arr[row][col] = true;

        // recurse
        boolean top, down, left, right;
        if (word.charAt(str.length()) == board[row][col] || reverse(word).charAt(str.length()) == board[row][col]) {
            top = find(board, row - 1, col, word, str + board[row][col] + "", arr);
            right = find(board, row, col + 1, word, str + board[row][col] + "", arr);
            down = find(board, row + 1, col, word, str + board[row][col] + "", arr);
            left = find(board, row, col - 1, word, str + board[row][col] + "", arr);

        } else {
            top = find(board, row - 1, col, word, str, arr);
            right = find(board, row, col + 1, word, str, arr);
            down = find(board, row + 1, col, word, str, arr);
            left = find(board, row, col - 1, word, str, arr);

        }

        // post
        arr[row][col] = false;
        return left || right || top || down;
    }
}
