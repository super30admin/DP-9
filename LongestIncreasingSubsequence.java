//Method-1
class Solution {

    // Time Complexity : 0(n^2) where n is the no of elements in nums
// Space Complexity : 0(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int n = nums.length;
        int [] dp = new int[n]; //creating a dp array of size n and filling it with 1 initially
        Arrays.fill(dp, 1);
        int max = 1;    //keeping a count of the max subsequence

        for(int i = 1; i < n; i++){ //i is pointing to 1st index initially and goes up to the length of the array
            for(int j = 0; j < i; j++){ //j is pointing to 0th element and goes up to i updating the longest subsequence found in that spot in the dp array
                if(nums[j] < nums[i]){  //if next element is greater than previous, i.e if nums[i] is greater than nums[j]
                    dp[i] = Math.max(dp[i], dp[j] + 1); //i compare the previous value at ith index in dp array and the value at jth index of dp array and take a max of it and update dp[i] . I add one to j as I am moving forward and the new comparison is greater than the older 1. I am taking max of previous and new values as if I already found a greater subsequence at ithe position before, I don't want to loose it
                    max = Math.max(max, dp[i]); //also I update my max by comparing the previous max and current value at ith index
                }
            }
        }
        return max;
    }
}

//Optimizing time

class Solution {

    // Time Complexity : 0(nlogn)
// Space Complexity :0(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int n = nums.length;
        int [] dp = new int [n];    //taking an array of size n
        int len = 1;    //length is set as 1 as if there are elements, maximum subsequence has to be atleast 1
        dp[0] = nums[0];    //I add 1st element to my array to comparre
        for(int i = 1; i < n; i++){
            if(nums[i] > dp[len-1]){    //if the current element at nums is greater than the last element at dp array, I add the nums to my dp array.
                dp[len] = nums[i];
                len++;  //and increase my len as I am adding an element to dp array
            }
            else{
                int index = BinarySearch(dp, 0, len-1, nums[i]);    //If not, I am trying to find the index of the element that is just greater than nums in the dp array and I go that index and replace the nums value to that in dp. This keeps my dp array in sorted order or increasing subsequence order
                dp[index] = nums[i];
            }
        }
        return len;
    }
    public int BinarySearch(int[] dp, int low, int high, int target){   //normal Binary search
        while(low <= high){
            int mid = low + (high-low) / 2;
            if(dp[mid] == target){
                return mid;
            }
            else if(dp[mid] > target){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return low; //if the target is not found, I return the nearest element to target and return it's index
    }
}