import java.util.Arrays;

//TC: O(n2)
//SC: O(n)

public class RussianDoll {
    public int maxEnvelopes(int[][] envelopes) {
        
        if(envelopes == null || envelopes.length == 0)
            return 0;
        
        int[] dp = new int[envelopes.length];
        Arrays.fill(dp, 1);
        // sorting based on 2nd index
        Arrays.sort(envelopes, (a,b) -> a[1] - b[1]);
        int max = 1;
        for(int i=1; i<envelopes.length; i++){
            for(int j=0; j<i; j++){
                //comparing the current indexes 0th element is greater that the previous elements 0th element and both the 1st elements are not equal
                if(envelopes[i][0] > envelopes[j][0] && envelopes[i][1] != envelopes[j][1]){
                    // Putting the max element in current index which is obtained from the prev+1 or elements value itself
                    dp[i] = Math.max(dp[i], dp[j]+1);
                    // keeping track of max value on the go
                    max = Math.max(max, dp[i]);
                }
            }
            
        }
        return max;
        
    }
}
