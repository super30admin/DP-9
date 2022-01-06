package sol;

import java.util.*;
public class Lis {

	 public int lengthOfLIS(int[] nums) {
	     
	        int []dp= new int[nums.length];
	        
	        
	        Arrays.fill(dp,1);
	        
	        int max=1;
	        
	        for( int i=1;i<nums.length;i++){
	        for(int j=0;j<i;j++){
	            
	            if(nums[j]<nums[i]){
	            
	                dp[i]=Math.max(dp[j]+1,dp[i]);
	                
	            }
	            
	            
	         max=Math.max(dp[i],max);   
	        }    
	            
	            
	        }
	      
	        return max;
	    }
	
}
