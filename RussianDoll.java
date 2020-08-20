/**
 * Time: O(n^2)
 * Space: O(n)
 */
class Solution {
    public int maxEnvelopes(int[][] en) {
        if(en == null || en.length == 0) return 0;

        Arrays.sort(en,(a, b)->(a[0]-b[0]));

        int[] dp = new int[en.length];
        Arrays.fill(dp,1);
        int max = 1;

        for(int i=1;i<en.length;i++)
        {
            // System.out.println(Arrays.toString(en[i]));
            for(int j=0;j<=i;j++){
                if(en[i][1] > en[j][1] && en[i][0] != en[j][0])
                    dp[i] = Math.max(dp[i],dp[j]+1);
            }
            max = Math.max(max,dp[i]);
        }

        return max;
    }
}