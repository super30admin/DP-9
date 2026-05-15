// Time Complexity : O(nlogn)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/*
We initially add the first element to our list. Later, we iterate through the input array and if we find a greater
element than the last, we add it to the list, if not, we do a binary search and set at the specific position.
Lastly, we return the list size which gives us the longest increasing subsequence.
 */
class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> list = new ArrayList<>();
        list.add(nums[0]);

        for(int i = 1 ; i < nums.length ; i++) {
            if(nums[i] > list.get(list.size() - 1)) {
                list.add(nums[i]);
            }
            else {
                int k = binarySearch(list, nums[i]);
                list.set(k, nums[i]);
            }
        }
        return list.size();
    }

    private int binarySearch(List<Integer> list, int target) {
        int left = 0 , right = list.size() - 1;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(list.get(mid) == target)
                return mid;
            else if(list.get(mid) > target) {
                right = mid;
            }
            else
                left = mid + 1;
        }
        return left;
    }
}