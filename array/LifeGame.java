package array;

import java.util.ArrayList;
import java.util.List;

// approach
// count live and dead neighbours for each cell, then apply rules based on numbers
// to count live and dead cells , check 8 neighbouring cells
// https://leetcode.com/problems/game-of-life/
public class LifeGame {
    public static void main(String[] args) {
        int[][] board = { { 0, 1, 0 }, { 0, 0, 1 }, { 0, 1, 1 }, { 0, 0, 0 } };
        gameOfLife(board);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void gameOfLife(int[][] board) {
        int[][] arr = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                arr[i][j] = board[i][j];
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                List<Integer> n = getNeighbours(i, j, arr);
                int dead = n.get(0);
                int live = n.get(1);
                if (board[i][j] == 0) {
                    // dead cell
                    if (live == 3) {
                        board[i][j] = 1;
                    }
                } else {
                    // live cell
                    if (live < 2 || live > 3) {
                        board[i][j] = 0;
                    } else if (live == 2 || live == 3) {
                        continue;
                    }
                }
            }
        }
    }

    public static List<Integer> getNeighbours(int i, int j, int[][] nums) {
        int live = 0, dead = 0;
        List<Integer> ans = new ArrayList();
        // total 8
        // 1. horizontal
        // left
        if (j - 1 >= 0) {
            if (nums[i][j - 1] == 0) {
                dead++;
            } else {
                live++;
            }
        }
        // right
        if (j + 1 < nums[i].length) {
            if (nums[i][j + 1] == 0) {
                dead++;
            } else {
                live++;
            }
        }
        // 2. vertical
        // top
        if (i - 1 >= 0) {
            if (nums[i - 1][j] == 0) {
                dead++;
            } else {
                live++;
            }
        }
        // bottom
        if (i + 1 < nums.length) {
            if (nums[i + 1][j] == 0) {
                dead++;
            } else {
                live++;
            }
        }
        // 3. left diagonals
        // top-left
        if (i - 1 >= 0 && j - 1 >= 0) {
            if (nums[i - 1][j - 1] == 0) {
                dead++;
            } else {
                live++;
            }
        }
        // bottom left
        if (i + 1 < nums.length && j - 1 >= 0) {
            if (nums[i + 1][j - 1] == 0) {
                dead++;
            } else {
                live++;
            }
        }
        // 4. right diagonals
        // top right
        if (i - 1 >= 0 && j + 1 < nums[i].length) {
            if (nums[i - 1][j + 1] == 0) {
                dead++;
            } else {
                live++;
            }
        }
        // bottom right
        if (i + 1 < nums.length && j + 1 < nums[i].length) {
            if (nums[i + 1][j + 1] == 0) {
                dead++;
            } else {
                live++;
            }
        }
        ans.add(dead);
        ans.add(live);
        return ans;
    }
}
