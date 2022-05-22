//Time Complexity : O(n log n) 
//Space Complexity : O(n)
public class LongestIncreasingSubsequence {    
    /**Approach1: DP + Two pointers | Time O(n^2) | Space O(n)**/	
	/*public int lengthOfLIS(int[] nums) {
        int n= nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int max=1;
        for(int i=1; i<n; i++){
            for(int j=0; j<i; j++){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], dp[j]+1);                    
                }
                max = Math.max(max, dp[i]);
            }
        }
        return max;
    }*/
	
	/**Approach2: Binary Search**/
	public int lengthOfLIS(int[] nums) {
        int n= nums.length;
        int[] arr = new int[n];
        arr[0] = nums[0];     
        int len =1;
        for(int i=1; i<n; i++){
            if(nums[i] > arr[len-1]){
                arr[len] = nums[i];
                len++;
            }else{
                //replace number to just higher element in effective array
                int index = binarySearch(arr, 0, len-1, nums[i]);
                arr[index] = nums[i];
            }
        }
        return len;
    }    
    private int binarySearch(int[] arr, int low, int high, int target){
        while(low <= high){
            int mid= low + (high-low) / 2;
            if(arr[mid] == target){
                return mid;
            } else if (arr[mid] < target){
                low = mid+1;
            } else{
                high = mid-1;
            }
        }
        return low;
    }
    
	// Driver code to test above
	public static void main (String[] args) {	
		LongestIncreasingSubsequence ob  = new LongestIncreasingSubsequence();			
		int[]nums = {10,9,2,5,3,7,101,18};
		System.out.println("Length of longest increasing subsequence: "+ob.lengthOfLIS(nums));
	}
}
