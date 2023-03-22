class Solution {
    
    // Binary Search Approach
    //Time Complexity: O(n*log(n))
    //Space Complexity: O(n)
    
    public int maxEnvelopes(int[][] envelopes) {
    
        Arrays.sort(envelopes, (a,b) -> {
            
            if(a[1] == b[1]){           //sorting based on height, if height is same, then for that put descending order of width
                return b[0]-a[0];
            }
            return a[1] - b[1];
        });
        
        int[] arr = new int[envelopes.length];      //effective array
        arr[0] = envelopes[0][0];
        int len = 1;                                //we can put single doll, so max length initialize by 1
        
        for(int i=1; i<envelopes.length; i++){
                        
            if(envelopes[i][0] > arr[len - 1]){     //if envelope width is greater than last env, then add width of that envelop into the array, increase the length as well
                arr[len] = envelopes[i][0];
                len++;
            }
            else{                                   //if not, then get the sortedIndex and place the envelop width at the sorted index
                int sortedIndex = getSortedIndex(arr, 0, len-1, envelopes[i][0]);
                arr[sortedIndex] = envelopes[i][0];
             }
        }
        return len;                                 //return the length
    }
    
    
    public int getSortedIndex(int[] arr, int low, int high, int target){
        
        //get the sorted index for target    
        while(low<=high){
            
            int mid = low + (high-low)/2;
        
            if(arr[mid] == target){
                return mid;
            }
            else if(arr[mid] > target){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return low;
    }
    
    
    //Dp Apparach 2, Time limit Exceeded Error
    //Time Complexity : O(n*n)
    //Space Complexity : O(n)
//     public int maxEnvelopes(int[][] envelopes) {
        
//     Arrays.sort(envelopes, (a,b) -> {
            
//             if(a[1] == b[1]){           //sorting based on height, if height is same, then for that put descending order of width
//                 return b[0]-a[0];
//             }
//             return a[1] - b[1];
//         });
        
//         // for(int[] a : envelopes){
//         //     System.out.println(Arrays.toString(a));
//         // }
        
//         int[] dp = new int[envelopes.length];
//         int ans = 1;
        
//         for(int i=0; i<envelopes.length; i++){
            
//             int[] curr = envelopes[i];
//             dp[i] = 1;
//             for(int j=0; j<i; j++){
                
//                 int[] prev = envelopes[j];
                
//                 if(curr[0] > prev[0]){
                    
//                     dp[i] = Math.max(dp[i], 1+dp[j]);
//                 }
//             }
//             ans = Math.max(ans, dp[i]);
//         }
//         // System.out.println(Arrays.toString(dp));
//         return ans;
//     }
    
    
    
    //dp Apparach 1, Time limit Exceeded Error
    //Time Complexity : O(n*n)
    //Space Complexity : O(n)
//     public int maxEnvelopes(int[][] envelopes) {
        
//         Arrays.sort(envelopes, (a,b) -> {
//             return a[0]-b[0];
//         });
        
//         // for(int[] a : envelopes){
//         //     System.out.println(Arrays.toString(a));
//         // }
        
//         int[] dp = new int[envelopes.length];
//         int ans = 1;
        
//         for(int i=0; i<envelopes.length; i++){
            
//             int[] curr = envelopes[i];
//             dp[i] = 1;
//             for(int j=0; j<i; j++){
                
//                 int[] prev = envelopes[j];
                
//                 if(curr[0] > prev[0] && curr[1] > prev[1]){
                    
//                     dp[i] = Math.max(dp[i], 1+dp[j]);
//                 }
                
//             }
//             ans = Math.max(ans, dp[i]);
//         }
//         // System.out.println(Arrays.toString(dp));
//         return ans;
//     }
}
