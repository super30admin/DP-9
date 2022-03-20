/*
time : O(n^2)
space : O(n)
approach: we are trying to determine at each number whether from the beginning can it
form any increasing subsequence and add to it the current number, as in the dp every index will contain
the longest subsequence that can be formed until there.

Different approach could be using binary search which will give O(NlogN) solution
where we try to form the subsequence not the exact one but the possible ones and
we try to find the correct index of the incoming number in that sorted array
using binary search, It is sorted because from the beginning we are finding the
correct index for each  number.

*/

class Solution {
    public int lengthOfLIS(int[] nums) {

        int[] dp = new int[nums.length];

        Arrays.fill(dp, 1);

        int result = 1;

        for (int i = 1; i < nums.length; i++){
            for(int j = 0; j < i; j++){
                if(nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    result = Math.max(dp[i], result);
                }

            }
        }


        return result;
    }
}

//alternate O(nlogn) solution
class Solution {
public int findLIS(int[] nums){

        int[] dp = new int[nums.length];

        dp[0] = nums[0];

        int curr = 0;

        for(int i = 1; i < nums.length; i++){
            if(nums[i] > dp[curr]){
                dp[++curr] = nums[i];
            }
            else {
                int index = binarySearch(nums[i], dp, curr);
                dp[index] = nums[i];
            }
        }

        return curr+1;
    }

    private int binarySearch(int target, int[] nums, int high){
        int low = 0;

        while(low < high){
            int mid = low + (high - low) / 2;

            if(nums[mid] == target){
                return mid;
            }
            if(nums[mid] > target){
                high = mid;
            }
            else if(nums[mid] < target){
                low = mid + 1;
            }
        }

        return low;
    }
  }
