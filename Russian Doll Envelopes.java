//Dp approach
//Time Complexity : O(n^2). for sorting,  O(nlog n) and for filling dp array , O(n^2). Hence aymptotically, it is O(n^2)
//Space Complexity : O(n)
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes==null||envelopes.length==0){
            return 0;
        }
        //Approach : Sort the input array in ascending order of widths and then perform the same as LongetsIncreasing subsequence(  question) for the heights or viceversa for heights
        //sort the width
        Arrays.sort(envelopes,(a,b) -> {
            return a[0]-b[0];
        });
        int n = envelopes.length;
        //use a dp array to find the strictly increasing heights of the dolls
        int[] dp = new int[envelopes.length];
        //fill it by 1 as atleast there will be one answer
        Arrays.fill(dp,1);
        int max = 1;
        for(int i=1;i<n;i++){
           for(int j=0;j<i;j++){
                if(envelopes[i][0]>envelopes[j][0] && envelopes[i][1]>envelopes[j][1]){
                    //both the height and width have to be checked again togeter inorder to remove the same height or same widths from the final result. Ex: [6,4] [6,7], though 6 are same , 4 and 7 should be compared
                    dp[i] = Math.max(dp[i],dp[j]+1);
                    max = Math.max(dp[i],max);
                }
           }
        }
        return max;
    }
}

//Divide and Conquer/Binary search approach
//Time Complexity : O(nlog n)
//Space Complexity : O(n)
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes==null||envelopes.length==0){
            return 0;
        }
        //Approach : The sort criterion has been changed [we are sorting in ascending order of widths and in case widths are same them we sort them in descending order of heights], we then find the strictly Longest increasing subsequence on the height.
        //sort the width
        Arrays.sort(envelopes,(a,b) -> {
            if(a[0] == b[0]) {
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });
        int n = envelopes.length;
        int temp[] = new int[n];
        //add the first item from nums array
        temp[0] = envelopes[0][1];
        int length=1;//though there is just one number the increasing subsequence will always be atleast 1
        for(int i=1;i<n;i++){
            if(temp[length-1]<envelopes[i][1]){
                //store the numbers in ascending order in the temp array when strictly increasing item is found
                temp[length] = envelopes[i][1];
                //increase the length
                length++;
                //System.out.println(length);
            }
            else{
                //otherwise find the index of the next increasing/decreasing element and substitute it in the appropriate place to maintain the ascending order
                //this is achived by using binary search
                int index = binarySearch(temp,0,length,envelopes[i][1]);
                temp[index] = envelopes[i][1];
            }
        }
        return length;
        
    }
    private int binarySearch(int[] temp,int low,int high,int key){
        while(low<=high){
            int mid = low + (high-low)/2;
            if(temp[mid] == key){
                return mid;
            }
            if(temp[mid]>key){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return low;
    }
}
