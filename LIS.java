// 300.
// passes all test cases on leetcode

class Solution {
    public int lengthOfLIS(int[] nums) {
        //edge
        if(nums == null || nums.length == 0)
        {
            return 0;
        }
        
        return lisBinarySearch(nums);
    }
    
    //time - O(n^2)
    //space - O(n^2)
    private int lisDP(int[] nums) {
        int[] result = new int[nums.length];
        Arrays.fill(result, 1); //every element is an increasing sub sequence of length 1
        int max = 1; //final answer
        
        for(int i = 1; i < nums.length; i++)
        {
            //for every i from 1 to end of nums[], check for any j < i such that nums[j] < nums[i], such i,j is an increasing sub sequence
            //for such j, the length of increasing of increasing sub sequence from 0 to i is 1 + length of increasing sub sequenence from 0 to j
            for(int j = 0; j < i; j++)
            {
                if(nums[i] > nums[j])
                {
                    //update result[i] and max if needed
                    result[i] = Math.max(result[j] + 1, result[i]);
                    max = Math.max(max, result[i]);
                }
            }
        }
        
        return max;
    }
    
    //time - O(nlogn)
    //space - O(n)
    private int lisBinarySearch(int[] nums) {
        int[] result = new int[nums.length];
        //considering the first element alone, it is an increasing sub sequence
        //so far, the longest increasing sub sequence is of length 1
        result[0] = nums[0]; 
        int index = 1; //at any point index tracks the length of LIS and the next vacant index in result[]
        
        for(int i = 1; i < nums.length; i++)
        {
            if(nums[i] > result[index - 1]) //current element is larger than last number in result[]
            {
                //current element doesn't violate the LIS so far, so add this to end of result[]
                result[index++] = nums[i]; //the length of LIS so far also increases by 1 [index++]
            }
            else //current element is smaller than last number in result[]
            {
                //probablity of finding lis with current is higher 
                //find index at which current hast to be inserted in result[]
                int replaceIndex = findIndex(result, 0, index - 1, nums[i]);
                result[replaceIndex] = nums[i];
            }
        }
        
        return index;
    }
    
    //find target or the next highest number in nums[] 
    //time - O(log n)
    //space - O(1)
    private int findIndex(int[] nums, int low, int high, int target) {
        while(low <= high)
        {
            int mid = low + (high - low) / 2;
            if(nums[mid] == target)
            {
                return mid;
            }
            else if(target < nums[mid])
            {
                high = mid - 1;
            }
            else
            {
                low = mid + 1;
            }
        }
        return low;
    }
}
