import java.util.*;
/*
Time Complexity: O(N^2) for the LISRecursionWithMemo, and O(NlogN) for the binary search solution
Space Complecity: O(N^2) for the LISRecursionWithMemo and O(N) for the ArrayList
Run on Leetcode: yes
Any difficulties: no

Apparoach:
1. Using recursion on the not choose and choose cases
2. Using binary search on the sorted array
 */
public class LongestIncreasingSubsequence {
    public static int[][] dp;
    public static int LISRecursionWithMemo(int[] nums){
        dp = new int[nums.length+1][nums.length];

        for(int i = 0; i<dp.length; i++){
            Arrays.fill(dp[i], -1);
        }

       return LISRecursion(nums, 1, 0);
    }

    public static int LISRecursion(int[] nums, int currIndex, int prevIndex){
        // base condition

        if(currIndex == nums.length+1){
            return 0;
        }

        if(dp[currIndex][prevIndex] == -1){
            // not select condition

            int ans = LISRecursion(nums, currIndex+1, prevIndex);
            int currEle = nums[currIndex-1];
            int prevELe = prevIndex == 0 ? Integer.MIN_VALUE : nums[prevIndex-1];
            // select case
            if(currEle> prevELe){
                ans = Math.max(ans, 1+LISRecursion(nums, currIndex+1, currIndex) );
            }
            dp[currIndex][prevIndex] = ans;
        }

        return dp[currIndex][prevIndex];
    }

    public static int LISBinarySearchSol(int[] nums){
        if(nums.length == 1){
            return nums[0];
        }

        List<Integer> subsequence = new ArrayList<>();
        subsequence.add(nums[0]);
        for(int i = 1; i<nums.length; i++){
            int num = nums[i];
            if(num>subsequence.get(subsequence.size()-1)){
                subsequence.add(num);
            }else {
                int indexOfConsideration = binarySearch(subsequence, num);
                subsequence.set(indexOfConsideration, num);
            }
        }
        return subsequence.size();
    }

    public static int binarySearch(List<Integer> arr, int target){
        int start = 0;
        int end = arr.size()-1;

        while(start<= end){
            int mid = start+(end-start)/2;

            if(arr.get(mid) == target){
                return mid;
            }else if(arr.get(mid)>target){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return start;
    }

    public static void main(String[] args){
        System.out.println("Longest Increasing subsequence length: "+
                LISRecursionWithMemo(new int[]{10,9,2,5,3,7,101,18}));
        System.out.println("Longest Increasing subsequence length: "+
                LISBinarySearchSol(new int[]{10,9,2,5,3,7,101,18}));
    }
}
