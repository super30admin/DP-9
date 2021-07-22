/*Running time Complexity: O(log n)
Space Complexity: O(n)
Successfully Run and Compiled on leetcode
*/

class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums==null || nums.length==0) return 0;
        int[] res = new int[nums.length];
        // Arrays.fill(res,0);
        int len = 1;
        res[0] = nums[0];
        for(int i = 1;i<nums.length;i++){
           if(nums[i]>res[len-1]){
               res[len] = nums[i];
               len++;
           }
            else{
                int BSTindex = BinarySearch(res,len,nums[i]);
                res[BSTindex] = nums[i];
            }
        }
        
    return len;
    }
    private int BinarySearch(int[] arr, int high, int num){
        int low = 0;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(arr[mid]==num) return mid;
            else if(arr[mid]<num) low = mid+1;
            else high = mid-1;
        }
        return low;
    }
}
//Dynamic programming Solution 
//running time complexity: O(nxn)
class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 1) return 1;
        ArrayList<Integer> l = new ArrayList<>();
        int max = 0;
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        for(int i =1;i<nums.length;i++){
            for(int j = 0;j<i;j++){
                if(nums[i]>nums[j]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            
            }
            max = Math.max(dp[i],max);    
            
        }
        return max;
    }
}