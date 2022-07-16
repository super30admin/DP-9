import java.util.Arrays;

//Time Complexity : O(NlogN)
//Space Complexity : (N)
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        //sort on increasing in first dimension and decreasing in second
        Arrays.sort(envelopes,(a,b) ->{
                    if(a[0]==b[0]){
                        return b[1]-a[1];
                    }else
                    {return a[0]-b[0];
                    }
                    });
        int [] arr = new int[n];
        int len =1;
        arr[0] = envelopes[0][1];
        for(int i = 0; i < n ;i++){
            if(envelopes[i][1] > arr[len-1]){
                arr[len] = envelopes[i][1];
                len++;
            }
            //find index and replace in the arr
            else{
                int idx = binarySearch(arr,envelopes[i][1],0,len-1);
                arr[idx] = envelopes[i][1];
            }
        }
        
        return len;
    }
    //Binary search
    private int binarySearch(int [] arr, int target, int low, int high ){
        while(low <= high){
            int mid = low + ((high-low)/2);
            if(arr[mid]==target){
            return mid;
        }
        if(arr[mid]>target){
            return binarySearch(arr,target,low,mid-1);
        }
        else{
            return binarySearch(arr,target,mid+1,high);
        }
    }
    return low;
        }
    }

