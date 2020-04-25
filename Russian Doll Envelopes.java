// Time Complexity : o(n^2)
// Space Complexity : o(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        int maxLen=0;
        int[] output=new int[envelopes.length];
        
        Arrays.sort(envelopes, (int[] a, int[] b) -> (a[0]-b[0]));
        Arrays.fill(output,1);
        
        for(int i=0;i<envelopes.length;i++){
            for(int j=i-1;j>=0;j--){
                if(envelopes[i][0]>envelopes[j][0] && envelopes[i][1]>envelopes[j][1]){
                    output[i]=Math.max(output[i],output[j]+1);
                }
            }
            maxLen=Math.max(maxLen,output[i]);
        }
        return maxLen;
    }
}