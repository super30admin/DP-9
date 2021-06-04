//DP approach
//Time Complexity : O(n^2)
//Space Complexity : O(n)
// Did this code successfully run on Leetcode :yes
// Your code here along with comments explaining your approach
class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums.length==0||nums==null){
            return 0;
        }
        //use a dp array to store the max length value for each cell so far
        int[] dp = new int[nums.length];
        //Fill the array with 1 .though there is just one number the increasing subsequence is 1
        Arrays.fill(dp,1) ;
        int max = 1;
        for(int i=1;i<nums.length;i++){
            for(int j=0;j<i;j++){
                //check for strictly increasing element
                if(nums[i]>nums[j]){
                    //add 1 to the prev value and use the max
                    //and update the value in dp array 
                    dp[i] =  Math.max(dp[i],dp[j]+1);
                    max = Math.max(max,dp[i]);
                }
            }
        }
        return max;
    }
}
//Divide and Conquer/Binary Search approach
//Time Complexity : O(nlog n). logn is for binary search and n is for iterating the array
//Space Complexity : O(n)
class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums.length==0||nums==null){
            return 0;
        }
        int temp[] = new int[nums.length];
        //add the first item from nums array
        temp[0] = nums[0];
        int length=1;//though there is just one number the increasing subsequence will always be atleast 1
        for(int i=1;i<nums.length;i++){
            if(temp[length-1]<nums[i]){
                //store the numbers in ascending order in the temp array when strictly increasing item is found
                temp[length] = nums[i];
                //increase the length
                length++;
                //System.out.println(length);
            }
            else{
                //otherwise find the index of the next increasing/decreasing element and substitute it in the appropriate place to maintain the ascending order
                //this is achived by using binary search
                int index = binarySearch(temp,0,length,nums[i]);
                temp[index] = nums[i];
            }
        }
        return length;
    }
    private int binarySearch(int[] temp,int low,int high,int key){
        while(low<=high){
            int mid = low + (high-low)/2;
            if(temp[mid] == key){
                return mid;
            }
            if(temp[mid]>key){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return low;
    }
}