class Solution {
    // TC: O(nlogn);  SC:O(1)
    //This code solves the Russian Doll Envelopes problem by first sorting envelopes by width (ascending), and by height (ascending) when widths are equal. After sorting, it applies the Longest Increasing Subsequence (LIS) algorithm on the heights using binary search optimization. For each envelope, if its height is greater than the last element in the LIS array, it extends the sequence; otherwise, it uses binary search to find the correct position to replace with a smaller height. This greedy approach maintains the smallest possible tail for each subsequence length, achieving O(n log n) time complexity and returning the maximum number of nestable envelopes.
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a,b)->{
            if (a[0] == b[0])
            {
                return a[1]-b[1];
            }
            return a[0] -b[0];
        });
        int len=1;
        int n=envelopes.length;
        int[] arr=new int[n]; //LIS on height
        arr[0]=envelopes[0][1]; //0 width, 1 height
        for(int i=1;i<n;i++)
        {
            if (envelopes[i][1]>arr[len-1])
            {
                arr[len++]=envelopes[i][1];
            }
            else
            {
                int bsIndex= binarySearch(arr, 0, len-1, envelopes[i][1]);
                arr[bsIndex]=envelopes[i][1];
            }
        }
        return len;
    }
    public int binarySearch(int[] arr,int low,int high,int val)
    {
        if(low>high)
        {
            return -1;
        }
        int mid=low+(high-low)/2;
        while (low<=high)
        {
            if(arr[mid]==val)
            {
                return mid;
            }
            else if(arr[mid]<val)
            {
                low=mid+1;
            }
            else if(arr[mid]>val)
            {
                high=mid-1;
            }
        }
        return low;
    }
}