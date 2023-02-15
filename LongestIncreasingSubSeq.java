import java.util.Arrays;

public class LongestIncreasingSubSeq {
	  //Time O(N^2)
	  //Space O(N)
		// Bottom up DP
	  public int lengthOfLIS(int[] nums) {
	        
	        //dp[i] = array denites the length of longest increasing subsequence untill ith index
	        int[] dp = new int[nums.length];
	        //by default length of subsequence ould be 1 at all index 
	        Arrays.fill(dp,1);
	        for(int i=1;i<nums.length;i++){
	            for(int j=0;j<i;j++){
	                if(nums[i]>nums[j] && dp[i]<=dp[j]){
	                    dp[i] = dp[j]+1;
	                }
	            }
	        }
	    int max =1;
	        for(int i=0;i<dp.length;i++){
	           max = Math.max(dp[i],max); 
	        }
	        return max;
	    }
	  
	  // DFS with Memo 
	  // Time O(N^2)
	  //Space O(N^2)
	    int max;int[][] dp ;
	    
	    public int lengthOfLISDFS(int[] nums) {
	        max = Integer.MIN_VALUE;
	        // dp[i][j] denotes the maximum increasing subsequence between ith index for prev biggest element at jth position 
	         dp = new int[nums.length][nums.length+1];
	         Arrays.stream(dp).forEach(a->Arrays.fill(a,Integer.MIN_VALUE));
	         // The trickiest part is to handle -1 index 
	        return helper(nums,0,-1); 
	    }

	    private int helper(int[] nums,int index,int prevIndex){
	        // base 
	            if(index==nums.length)
	                return 0;
	            if(dp[index][prevIndex+1]!=Integer.MIN_VALUE)
	                return dp[index][prevIndex+1];    
	        // logic
	        int greater=0,notGreater=0;
	        if(prevIndex == -1 || nums[index] > nums[prevIndex]){
	            greater = Math.max(1+helper(nums,index+1,index),helper(nums,index+1,prevIndex));
	        }else{
	           notGreater =  helper(nums,index+1,prevIndex);
	        }
	       
	        dp[index][prevIndex+1] = Math.max(greater,notGreater);
	        return dp[index][prevIndex+1];
	    }

	  
}
