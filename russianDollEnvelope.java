// Time Complexity : O(nlogn)
// Space Complexity :O(n)
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes==null || envelopes.length==0) return 0;
        int len=1;
        int n= envelopes.length;
        int[] dp=new int[n];
        Arrays.fill(dp,1);
        Arrays.sort(envelopes,(a,b)-> {
            if(a[0]==b[0]){
                return b[1]-a[1];
            }
                return a[0]-b[0];
            });
        
        dp[0] = envelopes[0][1];
        
        for(int i=1;i<n;i++){
           if(envelopes[i][1] > dp[len-1]){
               dp[len++] = envelopes[i][1];
           }else{
               int index= binSearch(dp,0,len-1,envelopes[i][1]);
               dp[index] = envelopes[i][1];
           }
        }
        
        return len;
    }
    
    private int binSearch(int[] dp, int l, int h, int n){
        while(l<=h){
           int mid=l+(h-l)/2;
           if(n==dp[mid]){
               return mid;
           } else if(n<dp[mid]){
               h=mid-1;
           }else{
               l=mid+1;
           }
        }
        return l;
    }
}