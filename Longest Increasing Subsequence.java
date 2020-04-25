// Time Complexity : o(n^2)
// Space Complexity :o(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public int lengthOfLIS(int[] nums) {
        int maxLen=0;
        int[] output=new int[nums.length];
        
        Arrays.fill(output,1);
        for(int i=0;i<nums.length;i++){
            for(int j=i-1;j>=0;j--){
                if(nums[i]>nums[j]){
            output[i] =Math.max(output[i],output[j]+1);
        }
            }
           maxLen = Math.max(maxLen,output[i]);  
        } 
       return maxLen; 
    }
}