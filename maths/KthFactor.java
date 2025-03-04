/**
 * This method finds the k-th factor of a given number n.
 * 
 * Approach:
 * 1. Initialize an empty list to store the factors of n.
 * 2. If n is 1, return 1 as the only factor.
 * 3. Iterate from 1 to the square root of n:
 *    - If i is a factor of n, add both i and n/i to the list of factors, because both are factors.
 * 4. After the loop, check if the square root of n is a factor and not already in the list, then add it.
 * 5. Sort the list of factors.
 * 6. Return the k-th factor if k is within the size of the list, otherwise return -1.
 * https://leetcode.com/problems/the-kth-factor-of-n/
 */
package maths;

import java.util.ArrayList;
import java.util.List;

//  Approach 
public class KthFactor {
    public static void main(String[] args) {
        System.out.println();
    }

    public static int kthFactor(int n, int k) {
        List<Integer> factors = new ArrayList<>();
        if (n == 1) {
            return 1;
        }

        for (int i = 1; i < Math.sqrt(n); i++) {
            if (n % i == 0) {
                factors.add(i);
                factors.add((n / i));
            }
        }
        int sqrt = (int) Math.sqrt(n);
        if (!factors.contains(sqrt) && n % sqrt == 0) {
            factors.add(sqrt);
        }
        factors.sort(null);
        System.out.println(factors.toString());
        return k <= factors.size() ? factors.get(k - 1) : -1;
    }
}
