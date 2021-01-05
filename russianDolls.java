// Time Complexity : o(n^2)
// Space Complexity : n
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
//LC : 354
//Approach: DP

class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        
        if(envelopes.length == 0 || envelopes == null) return 0;
        Arrays.sort(envelopes, (a,b)->a[0]-b[0]);
        int max = 1 ;
                                        
        int[] arr = new int[envelopes.length]; 
                                        
        for(int i = 0 ; i < arr.length; i++){
            arr[i] = 1;
        }
        
        for(int i = 1 ; i < envelopes.length ; i++)
        {
            for(int j = 0 ; j < i ; j++)
            {
               if(envelopes[j][0] < envelopes[i][0] && envelopes[j][1] < envelopes[i][1]){
                   arr[i] = Math.max(arr[i],arr[j]+1);
                   max = Math.max(max, arr[i]);
               }
               
               else
                   continue;
            }
        }
        
        return max;
                                    
    }
}

// Time Complexity : o(n^2)
// Space Complexity : n
// Did this code successfully run on Leetcode : no
// Any problem you faced while coding this : 57/85 test cases passed
//LC : 300
//Approach: Binary search

class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if(n == 0)
            return 0;
        int len = 0 ;
        //arr to store the sequence
        int[] arr = new int[nums.length];
        //add first element and increment len
        arr[0] = nums[0]; len++;
        for(int i = 1 ; i < nums.length ; i++)
            
        {   //append if the sequence is increasing
            if(nums[i]>arr[len-1]){
                arr[len] = nums[i];
                len++;
            }
            else{
                //binary search the index in arr where we can put nums[i]
                int index  = binarySearch(arr, 0 , len-1, nums[i]);
                arr[index] = nums[i];
            }
        }
    return len;  
    }
    
    public int binarySearch(int[] nums, int low , int high , int target){
            
            while(low <= high){
                int mid = low + (high-low)/2;
                if(nums[mid] == target) return mid;
                else if(nums[mid]>target) high = mid-1;
                else low = mid+1;
            }           
            return low;
        }
}
