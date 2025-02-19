import java.util.ArrayList;
import java.util.List;

public class LifeGame {
public static void main(String[] args) {
    
}    
public List<Integer> getNeighbours(int i, int j, int[][] nums) {
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
