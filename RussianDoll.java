import java.util.Arrays;

//Time O(N^2)
//Space O(N)
public class RussianDoll {
	 public int maxEnvelopes(int[][] envelopes) {
	        
	       Arrays.sort(envelopes, (a, b) -> {
	        if (a[0] == b[0]) {
	            return a[1] - b[1];
	        }
	        else {
	            return a[0] - b[0];
	        }
	    });
	        int max =1;
	        int[] dp = new int[envelopes.length];
	        //by default length of subsequence ould be 1 at all index 
	        Arrays.fill(dp,1);
	        for(int i=1;i<envelopes.length;i++){
	            for(int j=0;j<i;j++){
	                if(envelopes[i][0]>envelopes[j][0] && envelopes[i][1] > envelopes[j][1] && dp[i]<dp[j]+1){
	                    dp[i] = dp[j]+1;
	                    max = Math.max(max,dp[i]);
	                }
	            }
	        }
	        return max;
	    }
}
