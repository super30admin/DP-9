// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
sorted the given list(either acc to width or height) used Binary search method to place each element in the list at its position
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes,(a,b)-> {
            if(a[0]==b[0]){
                return b[1]-a[1];
            }
            else return a[0]-b[0];
            });
        int n=envelopes.length;
        int []arr = new int[n];
        arr[0] = envelopes[0][1];
        int len=1;
        for(int i=1;i<n;i++){
            if(envelopes[i][1] > arr[len-1]){
                arr[len] = envelopes[i][1];
                len++;
            }
            else{
                int bsindex = Bsearch(arr,envelopes[i][1],0,len-1);
                arr[bsindex] = envelopes[i][1];
            }
            
        }
        return len;
    }
    private int Bsearch(int [] arr,int target,int low,int high){
        int mid;
        while(low<=high){
            mid = low+(high-low)/2;
            if(arr[mid] == target) return mid;
            else if(arr[mid] < target) low= mid+1;
            else high = mid-1;
        }
        return low;
    }
}