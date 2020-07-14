// Time Complexity : O(N LogN)
// Space Complexity : O(1), resuign envelopes array
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    public int maxEnvelopes(int[][] envelopes) {
                
        if(envelopes.length==0)
            return 0;
        Arrays.sort(envelopes, (a,b)->(a[0]!=b[0]?a[0]-b[0]:b[1]-a[1]));

        int len=0;
        envelopes[len++]=envelopes[0];
        
        for(int i=1;i<envelopes.length;i++){
                if(envelopes[len-1][1]<envelopes[i][1]){
                    envelopes[len++]=envelopes[i];
                }else{
                    int index = bs(envelopes,envelopes[i][1],len-1);
                    envelopes[index]=envelopes[i];
                }
        }

        return len;
    }
    
    public int bs(int[][] envelopes,int val,int len) {
        int left = 0,right=len;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(envelopes[mid][1]==val)
                return mid;
            if(envelopes[mid][1]>val)
                right=mid-1;
            else
                left=mid+1;
        }
        
        return left;
    }
}
