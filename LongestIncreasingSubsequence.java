/*
* Approach1: Tabulation
- The idea is to keep track of lengths in the dp array
- Create a dp array and fill it with 1s because all the elements are 1 length subsequence on its own
- Iterate through the nums array starting index 1 and find if the number/numbers before that is smaller than the current index
    - if we find it, that means at curr index the length of the subsequence might change and as we need max, we can get the max of curr index length + 1 or earlier subsequence length
    - keep track of max variable to get the max subsequence
- TC: O(n^2)-> nested iterations
-SC: O(n) -> dp array
 */
class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int max = 1;

        for(int i = 1; i < nums.length; i++){
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]){
                    // compare earlier and current and get the max
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    max = Math.max(max, dp[i]);
                }
            }
        }
        return max;     
    }
}

/*
* Approach2: Memoization
- Choose/ Not choose approach
- At every index we have an option to choose and not choose and then again find the longest subsequence from the remaining subarray
- Memoize the result to avoid recomputation
-TC: O(n^2)
- SC: O(n^2) -> stack space and dp matrix
 */
class Solution {
    Integer[][] memo;
    public int lengthOfLIS(int[] nums) {
        this.memo = new Integer[nums.length][nums.length + 1];
        return helper(nums, 0, -1);
    }

    private int helper(int[] nums, int i, int prevNum){
        //base - return 0 if i is at the last index
        if(i == nums.length)
            return 0;
        //logic

        //if we have already computated the longest subsequence for that element, return the length from memo matrix
        if(memo[i][prevNum+1] != null)
            return memo[i][prevNum + 1];
        
        //not choose - increment i pointer and prevNum to compare with remains the same
        int case1 = helper(nums, i + 1, prevNum);

        //choose - if the prevNum is -1 or current element is greater than the element at prevnum
        int case2 = 0;
        if(prevNum == -1 || nums[i] > nums[prevNum]){
            case2 = 1 + helper(nums, i + 1, i);
        }
        //save the computed result in the memo matrix
        memo[i][prevNum+1] = Math.max(case1, case2);
        return Math.max(case1, case2);
    }
}

// /*
// * Approach3: Binary Search on effective increasing subsequence array
// - The idea is to have an effective increasing subsequence which will always be in sorted fashion lets call is arr
// - If nums[i] > arr[latest filled element]
//     - add nums[i] to arr[curr index] because then nums[i] satisfies the criteria for increasing subsequence 
// - else
//     - replace value just greater than nums[i] with nums[i], at this point "arr" is not giving us the actual or resultant increasing subsequence but its giving us a subsequence that maybe in future could become the longest increasing subsequence
// - so if we want to keep track of the LIS, whenever we add the element in "arr" or index of arr increases. we store the elements in arr to a temp array to consider that as LIS up to that point
// - TC: O(nlogn) -> logn for binary search on arr and n for iterating the nums array
// -SC: O(n) -> arr to maintain effective increasing subsequence
//  */
class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] arr = new int[nums.length];
        int le = 1;
        arr[0] = nums[0];

        for(int i = 1; i < nums.length; i++){
            if(nums[i] > arr[le - 1]){
                arr[le] = nums[i];
                le++; 
            }
            else{
                int elementJustGreaterIndex = binarySearch(arr, 0, le-1, nums[i]);
                arr[elementJustGreaterIndex] = nums[i];
            }
        }
        return le;
    }

    private int binarySearch(int[] nums, int low, int high, int target){
        while(low <= high){
            int mid = low + (high - low)/2;

            if(nums[mid] == target){
                return mid;
            }
            else if(nums[mid] > target){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return low;
    }
}



