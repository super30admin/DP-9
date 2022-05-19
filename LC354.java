//Time Complexity : O(nlogn)
//Space Complexity : O(n)

class Solution {
    public int maxEnvelopes(int[][] envelopes) {
     
        Arrays.sort(envelopes, (a,b) ->{
           
            if(a[1] == b[1])
            {
                return b[0]-a[0];
            }
            
            return a[1] - b[1];
        });
        
        if(envelopes == null || envelopes.length == 0)
        {
            return 0;
        }
        
        
        int m = envelopes.length;
        int n = envelopes[0].length;
        
        int arr[] = new int[m];
        int len = 1;
        arr[0] = envelopes[0][0];
        
        for(int i=1;i<envelopes.length;i++)
        {
            if(envelopes[i][0] > arr[len-1])
            {
                arr[len] = envelopes[i][0];
                len++;
            }
            else
            {
                int bs_index = binarySearch(arr,0,len-1,envelopes[i][0]);
                arr[bs_index] = envelopes[i][0];
            }
        }
        
        return len;
    }
    
    private int binarySearch(int arr[],int low,int high,int target)
    {
        while(low <= high)
        {
            int mid = low + (high-low)/2;
            
            if(arr[mid] == target)
            {
                return mid;
            }
            else if(arr[mid] <target)
            {
                low = mid+1;
            }
            else
            {
                high = mid-1;
            }
        }
        
        return low;
    }
}
