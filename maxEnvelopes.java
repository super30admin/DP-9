class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        if(n<2) return n;
        Arrays.sort(envelopes, (a,b) ->{
            if(a[0]==b[0]) return b[1]-a[1];
            return a[0]-b[0];
        });
        int[] seq = new int[n];
        int top=-1;
        for(int i=0;i<n;i++){
            if(top==-1 || envelopes[i][1]>seq[top]){
                seq[++top]=envelopes[i][1];
            }
            else{
                int idx=binarySearch(seq, envelopes[i][1], top);
                seq[idx] = envelopes[i][1];
            }
        }
        return top+1;
    }
    private int binarySearch(int[] seq, int num, int high){
        int low=0;
        while(low<high){
            int mid = low + (high-low)/2;
            if(seq[mid]==num) return mid;
            else if(seq[mid]>num){
                high=mid;
            }
            else{
                low=mid+1;
            }
        }
        return low;
    }
}
