// TC: O(nlogn)
// SC: O(n)

class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes==null || envelopes.length==0) return 0;
        
        int n= envelopes.length;
        
        Arrays.sort(envelopes,(a,b) -> {
            if(a[0]==b[0]){
                return b[1]-a[1];
            }
            return a[0]-b[0];
        });
        
        int[] dp = new int[n];
        dp[0]=envelopes[0][1];
        int len =1;
        
        for(int i=1;i<n;i++){
            if(envelopes[i][1]>dp[len-1]){
                dp[len]=envelopes[i][1];
                len++;
            }else{
                int bsindex= binarySearch(dp,0,len-1,envelopes[i][1]);
                dp[bsindex]=envelopes[i][1];
            }
        }
        return len;
    }
    private int binarySearch(int[] nums,int low,int high,int target){
        while(low<=high){
            int mid= low + (high-low)/2;
            if(nums[mid]==target) return mid;
            if(target>nums[mid]){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return low;
    }
}
