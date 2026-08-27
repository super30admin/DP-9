//problem1
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int[] vi=new int[n];
        vi[0]=nums[0];
        int len=1;
        for(int i=1;i<n;i++){
            if(nums[i]>vi[len-1]){
                vi[len]=nums[i];
                len++;
            }else{
                int bseindx=binarysearch(vi,0,len-1,nums[i]);
                vi[bseindx]=nums[i];
            }
        }
        return len;
    }
    public int binarysearch(int[] vi,int i,int j,int k){
        int low=i;
        int high=j;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(vi[mid]==k){
                return  mid;
            }else if(vi[mid]<k){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return low;
    }
}
//problem2
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes,(a,b)->{
        if(a[0]==b[0]){
            return b[1]-a[1];
        }
        return a[0]-b[0];
        });
        int n=envelopes.length;
        int[] vi=new int[n];
        vi[0]=envelopes[0][1];
        int len=1;
        for(int i=1;i<n;i++){
            if(envelopes[i][1]>vi[len-1]){
                vi[len]=envelopes[i][1];
                len++;
            }else{
                int bseindx=binarysearch(vi,0,len-1,envelopes[i][1]);
                vi[bseindx]=envelopes[i][1];
            }
        }
        return len;
    }
    public int binarysearch(int[] vi,int i,int j,int k){
        int low=i;
        int high=j;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(vi[mid]==k){
                return  mid;
            }else if(vi[mid]<k){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return low;
    }
}
