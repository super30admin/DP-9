class Solution {
    //tc-o(nlogn)//sc-o(n)
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a,b) ->{
        if(a[1] == b[1]){
            return b[0] - a[0];
        }
        return a[1]-b[1];

        } );
        int n = envelopes.length;
        int [] arr = new int[n];
        int len = 1;
        arr[0] = envelopes[0][0];
        for(int i=1;i<envelopes.length;i++)
        {
          if(envelopes[i][0] >arr[len-1])
          {
              arr[len] = envelopes[i][0];
              len++;
          }
          else{
              int bindex = binarySearch(arr,0,len-1,envelopes[i][0]);
              arr[bindex] = envelopes[i][0];
          }
        }
        return len;
    }
    private int binarySearch(int[] arr, int low,int high,int target)
    {
        while(low<=high)
        {
            int mid = low+(high-low)/2;
            if(arr[mid] == target) return mid;
            if(target<arr[mid])
            {
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return low;
    }
}