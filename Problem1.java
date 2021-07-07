//Time : O(n*n)
//Space : O(n)

//Approach:
//1.Sort the array such that all widths are in ascending order and all heights of same widths in descending order.
//2.Now,since heights of envelopes are in descending order , there can be atmost 1 envelope of this width.
//3. Now find the longest increasing subsequence length of heights of envelopes and return max length.
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes.length == 0)   return 0;
        Arrays.sort(envelopes,(a,b) -> a[0]==b[0]?b[1]-a[1]:a[0]-b[0]);
        int[] result = new int[envelopes.length];
        int max = 1;
        Arrays.fill(result,1);
        for(int i = 1;i<result.length;i++){
            for(int j = 0;j<i;j++){
                if(envelopes[i][1]>envelopes[j][1])
                    result[i] = Math.max(result[i],result[j]+1);
            }
            max = Math.max(max,result[i]);
        }
        return max;
    }
}
