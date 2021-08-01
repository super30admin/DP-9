class Solution {
    //Time O(NlogN)
    //Space O(N)
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0)
        {
            return 0;
        }
        int ar[] = new int[nums.length];
        ar[0] = nums[0];
        int len = 1;
        for(int i = 1 ; i < nums.length ; i++)
        {
            if(ar[len-1] < nums[i])
            {
                ar[len] = nums[i];
                len++;
            }
            else
            {
                int index = BinarySearch(ar , nums[i] , len);
                ar[index] = nums[i];
            }
        }
        return len;
    }
    private int BinarySearch(int[] nums , int target , int length)
    {
        int left = 0 , right = length-1;
        while(left <= right)
        {
            int mid = left + (right-left)/2;
            if(nums[mid] == target) return mid;
            if(nums[mid] > target)
            {
                right = mid-1;
            }
            else
            {
                left = mid+1;
            }
        }
        return left;
    }
}