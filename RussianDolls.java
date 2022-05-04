import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
Time Complexity: O(NlogN+NlogN)
Space Complexity: O(N)
Run on leetcode: yes
Any difficulties: no

Approach:
1. Binary search on the width dimension, attempted after discussed in the class
 */
public class RussianDolls {
    public static int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;
        for (int num : nums) {
            int i = Arrays.binarySearch(dp, 0, len, num);
            if (i < 0) {
                i = -(i + 1);
            }
            dp[i] = num;
            if (i == len) {
                len++;
            }
        }
        return len;
    }

    public static int russianDolls(int[][] envelopes) {
        // sort on increasing in first dimension and decreasing in second
        Arrays.sort(envelopes, new Comparator<int[]>() {
            public int compare(int[] arr1, int[] arr2) {
                if (arr1[0] == arr2[0]) {
                    return arr2[1] - arr1[1];
                } else {
                    return arr1[0] - arr2[0];
                }
            }
        });
        // Width dimension
        int[] widthDim = new int[envelopes.length];
        for (int i = 0; i < envelopes.length; ++i) {
            widthDim[i] = envelopes[i][1];
        }
        return lengthOfLIS(widthDim);
    }
    public static void main(String[] args){
        int[][]envelopes = {
                {5,4},
                {6,4},
                {6,7},
                {2,3}
        };

        System.out.println("Number of russian dolls: "+ russianDolls(envelopes));
    }
}
