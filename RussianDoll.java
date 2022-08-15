// Time Complexity : O(nlogn)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    int max;
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes.length==1)
            return 1;
        
        Arrays.sort(envelopes,(a,b) -> {
            if(a[0]==b[0])
                return b[1]-a[1];
            else
                return a[0]-b[0];
        });
        
        max = findLIS(envelopes);
        return max;
    }
    
    public int findLIS(int[][] envelopes) {
        
        int[] subList = new int[envelopes.length];
        int len = -1;
        
        for(int i=0; i<envelopes.length;i++) {
            if(len==-1 || envelopes[i][1] > subList[len]){
                subList[len+1] = envelopes[i][1];
                len++;
            }else{
                int index = binarysearch(subList, 0, len, envelopes[i][1]);
                subList[index] = envelopes[i][1];
            }
        }
        
        return len+1;
    }
    
    public int binarysearch(int[] subList, int low, int high, int target) {
        while(low<=high) {
            int mid = low+ (high-low)/2;
            if(subList[mid] == target)
                return mid;
            else if(subList[mid]>target) {
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        
        return low;
    }
}
