//Time complexity:- O(Max(nm,nlogn).
//space complexity:- O(n)

class Solution {
    public int maxEnvelopes(int[][] envelopes) {
      Arrays.sort(envelopes ,(a,b)-> Integer.compare(a[0],b[0]))  ;
      int[] dp=new int[envelopes.length];
      Arrays.fill(dp,1);
        int output=0;
      for(int i=1;i<envelopes.length;i++){
          int max=0;
          for(int j=0;j<=i;j++){
              if(envelopes[j][0]<envelopes[i][0]&&envelopes[j][1]<envelopes[i][1]){
                  max=Math.max(max,dp[j]);
              }
          }
          dp[i]=1+max;
      }
        for(int m=0;m<dp.length;m++){
           output=Math.max(output,dp[m]);
        }
       return output; 
    }
}

//similar to longest increasing sequence in which here we have width and height two parameters. One envelope can
//be wrapped in another if and only if outer width and outer height are more than inner dimensions.
//For that sorting in any one parameter and applying longest increasing subsequence for other parameter.
//And finaaly obtaining maximum of dp array.