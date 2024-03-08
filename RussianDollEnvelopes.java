// Time Complexity :O(nlogn)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yess
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach: sort and applied Binary Search
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        int n= envelopes.length;
        if(n==0) return 0;
        
        Arrays.sort(envelopes, (a,b) ->{
            if(a[0]==b[0]){
                return b[1]-a[1];
            }
            return a[0]-b[0];
        });

        int arr[]= new int[n];
        int length=1;
        arr[0]=envelopes[0][1];

        for(int i=1; i<n;i++){
            if(envelopes[i][1]>arr[length-1]){
                arr[length]=envelopes[i][1];
                length++;
            }
            else{
                int low=0;
                int high=length-1;

                while(low<high){
                    int mid=low+(high-low)/2;
                    if(arr[mid]>=envelopes[i][1]){
                        high=mid;
                    }
                    else{
                        low=mid+1;
                    }
                }
                arr[low]=envelopes[i][1];
            }
        }
        return length;
    }
}