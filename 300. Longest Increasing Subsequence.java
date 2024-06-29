// Time Complexity : O(nlogn)
// Space Complexity : O(n)
// Method used : DP + Binary Search

class Solution {
    public int lengthOfLIS(int[] nums) {

        // This is the most optimal approach, we use DP + Binary search here

        List<Integer> result = new ArrayList();
        int n = nums.length;
        result.add(nums[0]);

        for(int i = 1; i < n; i++)
        {
            if(nums[i] > result.get(result.size() - 1)) result.add(nums[i]);

            else
            {
                binarySearch(result, 0, result.size() - 1, nums[i]);
            }
        }

        return result.size();
    }

    private void binarySearch(List<Integer> result, int low, int high, int target)
    {
        while(low <= high)
        {
            int mid = low + (high - low) / 2;

            if(target == result.get(mid)) return;

            if(target < result.get(mid)) high = mid - 1;

            else low = mid + 1;
        }

        // replace the target element with element at low index
        result.set(low, target);
    }
}
