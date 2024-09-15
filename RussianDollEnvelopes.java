package dp9;

import java.util.Arrays;

public class RussianDollEnvelopes {
	
	 public int maxEnvelopes(int[][] envelopes) {
	     
	       if(envelopes.length == 0) return 0; 
	        // sort width in ascending order
	        Arrays.sort(envelopes, (a, b) -> a[0] - b[0]);
	        
	    int max = 1;
	    int dp [] = new int [envelopes.length];
	        Arrays.fill(dp, 1);
	    for(int i = 1; i < envelopes.length; i++){
	        
	        for(int j = 0; j < i; j++){
	            // update dp[i] after checking the previous envelopes
	            if(envelopes[j][0] < envelopes[i][0] && envelopes[j][1] < envelopes[i][1])
	                dp[i] = Math.max(dp[i], dp[j] + 1);
	        }
	        max = Math.max(dp[i], max);
	    }
	    return max;
	           
	    }
	 
	 public static void main(String[] args) {
		 int[][] envelopes = new int[][] {{5,4},{6,4},{6,7},{2,3}};
		 RussianDollEnvelopes rde = new RussianDollEnvelopes();
		 System.out.println(rde.maxEnvelopes(envelopes));
	 }
}
