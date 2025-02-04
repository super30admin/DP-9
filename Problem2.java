class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? Integer.compare(b[1], a[1]) : Integer.compare(a[0], b[0]));
        int n = envelopes.length;
        int[] arr = new int[n];
        arr[0] = envelopes[0][1];
        int l = 1;

        for(int i=1;i<n;i++){
            
            if(envelopes[i][1]>arr[l-1]){
                arr[l] = envelopes[i][1];
                l++;
            }
            else{
                int bindex = binary(arr,0,l-1,envelopes[i][1]);
                arr[bindex] = envelopes[i][1];
            }


        }

        return l;
        
    }

    public int binary(int[] arr,int l, int h, int target){

        while(l<=h){
            int mid = l + (h-l)/2;
            if(arr[mid]==target){
                return mid;
            }
            else if(arr[mid]>target){
                h = mid-1;
            }
            else{
                l = mid+1;
            }
        }
        return l;
    }
}