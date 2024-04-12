//TC:O(nlog(n))
//SC: O(n)
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes,(a,b)->
        {
            if(a[0]==b[0])
            {
                return b[1]-a[1];
            }
            return a[0]-b[0];
        });
        int []arr=new int[envelopes.length];
        arr[0]=envelopes[0][1];
        int le=1;
        for(int i=1;i<envelopes.length;i++)
        {
            if(envelopes[i][1]>arr[le-1])
            {
                arr[le]=envelopes[i][1];
                le++;
            }
            else
            {
                int idx=binary(arr,0,le,envelopes[i][1]);
                arr[idx]=envelopes[i][1];
            }
        }
        return le;
    }
     private int binary(int [] arr, int s, int e, int target)
    {
        while(s<=e)
        {
          int mid=s+(e-s)/2;
          if(arr[mid]==target)
          return mid;
          else if(arr[mid]<target)
          {
            s=mid+1;

          }
          else
          {
            e=mid-1;
          }
          
        }
        return s;
    }
}