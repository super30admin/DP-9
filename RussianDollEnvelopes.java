/*
time : O(nlogn)
space: O(n)

approach: we first sort the given 2D array using heights and then decreasing  order
of the width(this is done so that whenever heights are same we don't have to worry
as the widths will be arranged in decreasing order so that we can only consider widths,
since if we don't sort the widths then we have to check both parameters everytime.)

After we sort them we can apply Longest increasing subsequence(LIS) on the widths,
as only they will be the driving factor now. using the binary serach technique for LIS,
We can chieve O(NlogN).

Also commented out the O(n^2) solution where we have to find out each combination.
*/




class Solution {
    public int maxEnvelopes(int[][] envelopes) {

        Arrays.sort(envelopes, (a,b) -> {
            if(a[0] == b[0]){
                return b[1] - a[1];
            }

            return a[0] - b[0];
        });

        int[] dp = new int[envelopes.length];

//         Arrays.fill(dp, 1);

//         int result = 1;



        for(int i = 0; i < envelopes.length; i++){

            dp[i] = envelopes[i][1];
//             for(int j = 0; j < i; j++){
//                 int w1 = envelopes[j][0];
//                 int w2 = envelopes[i][0];
//                 int h1 = envelopes[j][1];
//                 int h2 = envelopes[i][1];

//                 if(w2 > w1 && h2 > h1){
//                     dp[i] = Math.max(dp[i], dp[j] + 1);
//                     result = Math.max(dp[i], result);
//                 }
//             }
        }

        return findLIS(dp);

    }

    private int findLIS(int[] nums){

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
