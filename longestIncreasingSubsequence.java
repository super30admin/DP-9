//Time Complexity : O(nlogn)
//Space Complexity : O(n)
//Did this code successfully run on Leetcode :yes
//Any problem you faced while coding this : no
class Solution {
    public int lengthOfLIS(int[] nums) {
        
        int[] temp = new int[nums.length];
        
        int indx = 1;
        
        temp[0] = nums[0];
        
        for(int i = 1; i < nums.length; i ++){
            
            
            if(nums[i] > temp[indx-1]){
                
                temp[indx] = nums[i];
                indx ++;
            }
            
            else if(nums[i] < temp[indx-1]){
                
                binarySearch(nums[i], temp, indx );
            }
        }
     //   for(int i = 0; i < nums.length; i ++){
            
       //     System.out.println(temp[i]);
       // }
        return indx ;
    }
    
    private void binarySearch(int number, int[] temp, int indx){
        
        int left = 0;
        int right = indx ;
        int ans = 0;
        
        while(left <= right){
            
            int mid = left + (right-left)/2;
            
            if(temp[mid] >= number){
                
                ans = mid;
                right = mid - 1;
                
            }
            else{
                
                left = mid + 1;
            }
        }
        
        temp[ans] = number;
    }
}