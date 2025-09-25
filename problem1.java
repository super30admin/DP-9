class Solution {
    //Approach 1 : Recursion based solution

    //This recursive solution finds the Longest Increasing Subsequence by exploring two choices at each array position:
// skip the current element or include it (if it's greater than the previous element). At each index, it calculates
// case0 (skip current element) and case1 (include current element + 1), then returns the maximum of both.
// The recursion continues until all elements are processed (base case), then backtracks to find the optimal solution.
// The algorithm explores all possible subsequences and returns the length of the longest increasing one.

    // TC: O(2^n) ; SC :O(2^n) (Recursive stack)
    public int lengthOfLIS(int[] nums) {
        int n= nums.length;
        return helper(nums, 0,-1);
    }
    public int helper(int[] nums, int idx, int prevIdx){
        //base case
        if(idx == nums.length){
            return 0;
        }

        int case0= helper(nums, idx+1, prevIdx);
        int case1=0;
        if(prevIdx == -1 || nums[idx] > nums[prevIdx]){
           case1=1+ helper(nums, idx+1, idx);
        }
        return Math.max(case0, case1);
    }
    // Approach 2: Recursion with  Memoization
//Memoization is an optimization technique that caches results of function calls to avoid redundant computations.
// The memoized LIS solution uses a 2D array memo[n+1][n+1] to store results for each (idx, prevIdx) combination,
// where prevIdx+1 handles the -1 case. Before computing recursively, it checks if the result is already cached
// (memo[idx][prevIdx+1] != Integer.MIN_VALUE) and returns it immediately if found. If not cached, it computes
// the result using the same recursive logic, stores it in the memo table, and returns it.
// This reduces time complexity from O(2^n) to O(n²) by eliminating repeated subproblem calculations.
    int[][] memo;
    // TC: O(n^2) ; SC :O(n^2)
    public int lengthOfLIS1(int[] nums) {
        int n = nums.length;
        memo= new int[n+1][n+1];
        for(int i=0; i<=n; i++){
            Arrays.fill(memo[i],Integer.MIN_VALUE);
        }
       return helper1(memo, 0,-1);
    }
    int helper1(int[] nums, int idx, int prevIdx){
        if(idx == memo.length){
            return 0;
        }
        if(memo[idx][prevIdx+1]!=-Integer.MIN_VALUE){
            return memo[idx][prevIdx+1];
        }
        int case1= helper1(nums, idx+1, prevIdx);
        int case2=0;
        if (prevIdx==-1 || nums[idx] > nums[prevIdx]){
            case2=1+ helper1(nums, idx+1, idx);
        }
        memo[idx][prevIdx+1]=Math.max(case1, case2);
        return  Math.max(case1, case2);

    }

    // Approach 3: Tabulation here has one decision hence we take 1d array
    // TC: O(n^2) ; SC: O(n)
    public int lengthOfLIS2(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        int max=1;

        for (int i=1; i<n; i++){
            for(int j=0; j<i; j++){
                if(nums[i]>nums[j]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                    max=Math.max(dp[i],max);
                }
            }
        }

        return max;
    }

    // Approach 4: Track Path
    // TC: nlogn
    public int lengthOfLIS3(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n];
        arr[0]= nums[0];
        int len=1;
        for (int i=1; i<n; i++){
            if(nums[i]>arr[len-1]){
                arr[len]=nums[i];
                len++;
            }
            else{
                int bsIndex= binarySearch(arr,0,len-1,nums[i]);
                arr[bsIndex]=nums[i];
            }
        }
        return len;

    }
    private int binarySearch(int[] nums, int l, int r, int target){
        while (l <= r){
            int mid = l+(r-l)/2;
            if(nums[mid]==target){
                return mid;
            }
            else if(nums[mid]>target){
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return l;
    }


}
