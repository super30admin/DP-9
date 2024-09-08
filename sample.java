// Time Complexity : O(nlogn) where n is number of elements in nums array as we are going over the original array and doing a binary search on dp array.
// Space Complexity : O(n) as dp array holds maximum n elements
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : followed code tutorial


// Your code here along with comments explaining your approach
// In this solution we are using dynammic programming with binary search to find the length of the longest increasing subsequency in the array nums. In this we will
// be maintaining a dp array where each element represents the smallest possible tail value of all increasing subsequences of a particular length. We are using the 
// binary search to find the correct position in the dp array to update which will ensure the array remains sorted. 

class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums == null) {
            return 0;
        }

        int n = nums.length;
        int max = 1;

        int[] dp = new int[n];
        // Arrays.fill(dp, 1);

        // for(int i = 1; i < n; i++) {
        //     for(int j = 0; j < i; j++) {
        //         if(nums[i] > nums[j]) {
        //             dp[i] = Math.max(dp[i], dp[j] + 1);
        //             max = Math.max(dp[i], max);
        //         }
        //     }
        // }


        // Tailored DP - nlogn
        dp[0] = nums[0];

        for(int i = 1; i < n; i++) {

            if(nums[i] > dp[max-1]) {
                dp[max] = nums[i];
                max++;
            } else {
                int binarySearchIndex = binarySearch(dp, 0, max-1, nums[i]);
                dp[binarySearchIndex] = nums[i];
            }

        }


        return max;
    }

    private int binarySearch(int[] dp, int low, int high, int target) {
        while(low <= high) {
            int mid = low + (high - low)/2;

            if(dp[mid] == target) {
                return mid;
            } else if (dp[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}



// Time Complexity : O(nlogn) where n is the number of envelopes and sorting takes O(nlogn) time and finding the Longest Increasing Subsequence also takes O(nlogn) 
// time due to binary search.
// Space Complexity : O(n) for the dp array which stores the possible heights of the envelopes in the Longest Increasing Subsequence
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : followed code tutorial


// Your code here along with comments explaining your approach
// In this solution we will be sorting the envelopes by width in ascending order first and if two envelopes have the same width then we will be sorting them in 
// descending order. We are doing this to ensure that when determining the longest increasing subsequence based on heights we are not choosing two envelopes with 
// same width as a part of same subsequence. Then the Longest Increasing Subsequence is found using dynammic programming with binary search applied to the heights
// of the sorted envelopes same as above.

class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        
        int n = envelopes.length;
        int[] dp = new int[n];

        Arrays.sort(envelopes, (a, b) -> {
            if(a[0] == b[0]) {
                return b[1] - a[1];
            }

            return a[0] - b[0];
        });

        int max = 1;

        dp[0] = envelopes[0][1];

        for(int i = 0; i < n; i++) {
            if(envelopes[i][1] > dp[max-1]) {
                dp[max] = envelopes[i][1];
                max++;
            } else {
                int binarySerachIndex = binarySerach(dp, 0, max-1, envelopes[i][1]);
                dp[binarySerachIndex] = envelopes[i][1];
            }
        }

        return max;

    }

    private int binarySerach(int[] nums, int low, int high, int target) {
        while(low <= high) {
            int mid = low + (high - low)/2;

            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}


