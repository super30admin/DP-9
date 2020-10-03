import java.util.Arrays;

public class Longest_Increasing_Subsequence {
	public int lengthOfLIS(int[] nums) {
        //edge case
        if(nums == null || nums.length == 0)
        {
            return 0;
        }
        int longestSubsequence = 1;
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        for(int i=1;i<nums.length;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(nums[i] > nums[j])
                {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                    longestSubsequence = Math.max(longestSubsequence, dp[i]);
                }
            }
        }
        return longestSubsequence;
    }
}

//time complexity - O (n ^ 2)
//space complexity - O(n) for the dp array

class Solution {
    public int lengthOfLIS(int[] nums) {
        //edge case
        if(nums == null || nums.length == 0)
            return 0;
        int[] arr = new int[nums.length];
        int len = 0;
        arr[len++] = nums[0];
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i] > arr[len-1])
            {
                arr[len] = nums[i]; len++;
            }else
            {
                int index = binarySearch(arr, 0, len-1, nums[i]);
               // System.out.println(index + "--"+nums[i]);
                arr[index] = nums[i];
            }
        }
        return len;
    }
    private int binarySearch(int[] arr, int left, int right, int target)
    {
        while(left <= right)
        {
            int mid = left + (right - left)/2;
            if(arr[mid] == target)
            {
                return mid;
            }else if(arr[mid] > target)
            {
                right = mid-1;
            }else
                left = mid +1;
        }
        return left;
    }
}

//time complexity : O(n log n)
//space - complexity : O(n)
