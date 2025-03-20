class Solution {
    //Time Complexity:(nlogn)
    //Space Complexity:(n)
    public int maxEnvelopes(int[][] envelopes) {
        
        Arrays.sort (envelopes, (a,b) ->{
            if (a[0] == b[0]){
                return b[1] - a[1];
            }
            return a[0] - b[0]; 
        });

        int[] dp = new int [envelopes.length];
        
//         Arrays.fill (dp,1);

// int max = 1;
//         for (int i = 1; i < envelopes.length;i++){
//             for (int j = 0; j <=i -1;j ++){
//                 if (envelopes[i][0] > envelopes[j][0] &&envelopes[i][1] > envelopes[j][1] ){
//                     dp[i] = Math.max (dp[i], 1 + dp[j]);
//                     max = Math.max (max,dp[i]);
//                 }
//             }
//         }
        // return max;
        dp[0] = envelopes[0][1];
        int len =1;
        for (int i =1 ; i < envelopes.length; i++){
                if (envelopes[i][1] >dp[len -1] ){
                    dp[len] = envelopes[i][1];
                    len++;
                } else {
                    //find the index of the element that is just greater
                    //
                    int bIndex = bSearch (dp, envelopes[i][1],0, len -1);
                    dp[bIndex] = envelopes[i][1];
                }
        }        
        return len;
    }

    private int bSearch (int[] arr, int target, int start, int end){

        while ( start<= end){
            int mid = start + (end -start)/2;
            if (arr[mid] == target){
                return mid;
            } else if (arr[mid] > target){
                end = mid -1;
            } else {
               start = mid +1; 
            }
        }
        return start;
    }
}
