

class RussianDollEnvelopes {
    // Time complexity - O(n^2)
    // Space complexity - O(n)
    // Tested in leetcode
    
    // Approch 1 - Dynamic programming
    // Sort the input array and store the solution of subproblem into an array.
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes == null || envelopes.length == 0)
            return 0;
        Arrays.sort(envelopes, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                return a[0] == b[0] ? a[1]-b[1] : a[0] - b[0];
            }
        });
      
        int[] dp = new int[envelopes.length];
        Arrays.fill(dp,1);
        int total = 1;
        
        // run two for loop and compare each element from already processed element. If the current element is greater than the previous element then find out the maximum number of the envelope. Store into the Dp array and store maximum into an other variable and return at the end of loop.
        for(int i=1; i<envelopes.length; i++){
            int max = 1;
            for(int j=0; j < i; j++){
                 if(envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1])
            }
            dp[i] = max;
            total = Math.max(max,total);
            System.out.print(dp[i] + " ");
        }
      
        
        return total;
    }
    
    
     // Time complexity - O(2^n)
    // Space complexity - O(n)
    // TLE
    
    // Approch 1 - Recursion 
    // Sort the input array and call helper function to recurse through each posibility of the solution.
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes == null || envelopes.length == 0)
            return 0;
        Arrays.sort(envelopes, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                return a[0] == b[0] ? a[1]-b[1] : a[0] - b[0];
            }
        });
        return helper(envelopes,0, new int[]{0,0});
    }
    
    // Helper function which returns the total number of envelopes to calling function
    private int helper(int[][] envelopes, int index, int[] prev){
        if(index == envelopes.length){
            return 0;
        }
        int count1 =0, count2 =0;

        if(envelopes[index][0] > prev[0] && envelopes[index][1] > prev[1]){
            count1 = 1+helper(envelopes, index+1,envelopes[index]);
        }
        count2 = helper(envelopes,index+1,prev);
        
        return Math.max(count1,count2);
    }
}

