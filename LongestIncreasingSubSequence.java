//Time Complexity:  o(n) log(n)
//Space Complexity: o(n)
//Expln: Maintain a dp array and keep adding elements to the end if the values are increasing order so everytime we compare
// with the last element in the dp array if its less that last element. Then perform binary search on the dp array and replace
// the element which is just greater than the val because the val is less than the element we are replacing which opens up more
// possibility of Increasing sequence in this way return the length of the dp array we computed. We have to maintain another len variable
// to do the add and compare operation as the fixed length will be the length of array.
class Solution {
    int[] dp;
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if(len == 0) return 0;
        dp = new int[len];
        int index = 0;
        dp[0] = nums[0];
        index++;
        for(int i =1; i  < len; i++)
        {
            if(nums[i] > dp[index-1])
            {
                dp[index] = nums[i];
                index++;
            }
            else
                binarySearch(dp, nums[i], index-1);
        }
        return index;
    }
    private void binarySearch(int[] dp, int val, int index)
    {
        int low = 0;
        int high = index;
        while(low <= high)
        {
            int mid = low+ (high - low)/2;
            if(dp[mid]  == val) return;
            else if(dp[mid] > val) high = mid -1;
            else low = mid+1;
        }
        dp[low] = val;
    }
}