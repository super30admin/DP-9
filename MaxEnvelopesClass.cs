public class Solution {
    public int MaxEnvelopes(int[][] envelopes) {
        if(envelopes == null || envelopes.Length == 0){
            return 0;
        }
        
        Array.Sort(envelopes, new Comparison<int[]>(
            (a,b) => {
                if(a[0] == b[0]){
                    return a[1].CompareTo(b[1]);
                }

                return b[0].CompareTo(a[0]);
            }
        ));

        int n = envelopes.Length;
        int[] dp = new int[n];
        Array.Fill(dp, 1);
        int max = 1;

        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                if(envelopes[j][0] > envelopes[i][0] && envelopes[j][1] > envelopes[i][1]){
                    dp[i] = Math.Max(dp[i], 1 + dp[j]);
                }
            }
            max = Math.Max(dp[i], max);
        }
        return max;
    }

    // TC => O(n^2)
    // SC => O(n)

    //  public int MaxEnvelopes(int[][] envelopes) {
    //     if(envelopes == null || envelopes.Length == 0){
    //         return 0;
    //     }
        
    //     Array.Sort(envelopes, new Comparison<int[]>(
    //         (a,b) => {
    //             if(a[0] == b[0]){
    //                 return a[1].CompareTo(b[1]);
    //             }

    //             return b[0].CompareTo(a[0]);
    //         }
    //     ));

    //     int n = envelopes.Length;
    //     int[] dp = new int[n];
    //     Array.Fill(dp, 1);
    //     int max = 1;

    //     for(int i = 1; i < n; i++){
    //         for(int j = 0; j < i; j++){
    //             if(envelopes[j][0] > envelopes[i][0] && envelopes[j][1] > envelopes[i][1]){
    //                 dp[i] = Math.Max(dp[i], 1 + dp[j]);
    //             }
    //         }
    //         max = Math.Max(dp[i], max);
    //     }
    //     return max;
    // }
}