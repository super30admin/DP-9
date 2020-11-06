//Time Complexity: O(nlogn + n^2), asymptotic O(n^2)
//Space Complexity: O(m) where m is length of envelopes array.
import java.util.Arrays;

public class RussianDolls {
	public int maxEnvelopes(int[][] envelopes) {
        if(envelopes == null || envelopes.length == 0) return 0;
        int size = envelopes.length;
        int[] dp = new int[size];
        int max = 1;
        
        Arrays.fill(dp, 1);
        Arrays.sort(envelopes, (int[] a, int[] b) -> (a[0] - b[0]));
        
        for(int i = 0; i < size; i++){
            for(int j = 0; j < i; j++){
                if(envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    max = Math.max(max, dp[i]);
                }
            }
        }
        
        return max;
    }
}
