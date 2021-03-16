/*
method 1:
using dp approach.
Traverse the array from index 1 and check all elements previous from index 0 to current index. If at any point curr number is greater than previous, update the dp[i] value to maximum.
Return the maxLen.
TC: O(n^n2)
SC: O(n)

method 2: use modified binary search method. 
Algorithm:
i) iterate the array and check if curr element is > than arr[maxlen-1], then arr[maxlen] = currNumber and maxLen++;
else find the index of curr Number in the effecive increasing subsequence by doing binary search between low =0 and high = maxlen-1;
after getting the bsIndex, add curr Number in that index. 

TC:O(nlogn)
SC :O(n)


*/
class Solution {
    public int lengthOfLIS(int[] nums) {
        
        if(nums.length == 0 || nums == null)return 0;
        
                //method 1: Using dp
        //initialise dp array of size nums.length with 1
       // int[]dp = new int[nums.length];
        //Arrays.fill(dp,1);   
        //iterate the nums array starting from index 1
//         for(int i = 1; i < nums.length;i++){
//             for(int j= 0; j < i;j++){
//                 if(nums[i] > nums[j]){ //if element at i > than number at j, then update the dp[i] with max value
//                     dp[i] = Math.max(dp[i],dp[j]+1);
//                     maxLen = Math.max(maxLen, dp[i]);
//                 }
                
//             }
//         } 
//         return maxLen;

        //method 2: binary search modified
        
        int[]arr = new int[nums.length];
        arr[0] = nums[0];
        
        int maxLen = 1;
        for(int i = 1; i < nums.length;i++){
                //find the position of curr number in effective increasing sequence
                if(nums[i] > arr[maxLen-1]){
                    arr[maxLen] = nums[i];
                    maxLen++;
                }else{
                    int bIndex = binarySearch(arr,nums[i],0,maxLen-1);
                    arr[bIndex] = nums[i];
                }
            
        }
        return maxLen;
    }
    
    private int binarySearch(int[]arr, int target, int low, int high){
        while(low <= high){
            int mid = low+(high-low)/2;
            
            if(arr[mid] == target)return mid;
            else if(arr[mid] > target){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return low;
    }
}