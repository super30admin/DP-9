import java.util.Arrays;
// time complexity is o(n2) n is no  of envelops
//space complexity is 0(n)
//1. sort the width
//2. compare height and width of current index with privious index height and width if both are grater then update value with max value

public class RussianDollEnvelopes {
	    public int maxEnvelopes(int[][] envelopes) {
	        if(envelopes.length==0) return 0;
	        Arrays.sort(envelopes, (a, b)->a[0]-b[0]);//sort by width
	        int[] dp = new int[envelopes.length];
	        Arrays.fill(dp, 1);
	        int res = 1;
	        for(int i = 1; i < dp.length; i++){
	            for(int j = 0; j < i; j++){//check every previous envelope and update dp[i]
	                if(envelopes[i][0]>envelopes[j][0]&&envelopes[i][1]>envelopes[j][1]){
	                    dp[i] = Math.max(dp[i], dp[j]+1);
	                }
	            }
	            res = Math.max(res, dp[i]);//find the max dp[i]
	        }
	        return res;
	    }
	
}
