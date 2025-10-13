

//Time Complexity: O(nlogn)
//Space Complexity: O(n)

// Did this code successfully run on Leetcode : Yes

//We first sort the envelopes by width in ascending order. If two envelopes have the same width, we sort them by height in descending order.
// This sorting ensures that when we apply the LIS algorithm on the heights, we do not count envelopes with the same width.
// We then use a modified binary search approach to find the length of the longest increasing subsequence of heights.
// We maintain an array 'a' where we store the smallest tail of all increasing subsequences with different lengths found so far.
// For each height, we either extend the largest subsequence or replace an existing subsequence's tail using binary search to find the appropriate position.


class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        int n=envelopes.length;
        Arrays.sort(envelopes,(a,b)->{
            if(a[0]==b[0])
                return b[1]-a[1];   //dec height for same width
            return a[0]-b[0];   //asc width
        });
        int a[]=new int[n];
        int len=1;
        a[0]=envelopes[0][1];
        for(int i=1;i<n;i++){
            if(a[len-1]<envelopes[i][1]){
                a[len]=envelopes[i][1];
                len++;
            }else{
                int idx=binarySearch(a,0,len-1,envelopes[i][1]);
                a[idx]=envelopes[i][1];
            }
        }
        return len;
    }
    int binarySearch(int[] a, int l, int h, int target){
        while(l<=h){
            int mid=l+(h-l)/2;
            if(a[mid]==target)
                return mid;
            else if(a[mid]>target)
                h=mid-1;
            else
                l=mid+1;
        }
        return l;
    }
}