class Solution {
    //Time O(NlogN)
    //Space O(1)
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes ,  new Comparator<>()
                    {
                        public int compare(int[] a ,int[] b)
                        {
                            if(a[0] == b[0]) return b[1] - a[1];
                            return a[0]-b[0];
                        }
                    });
        int len = 1;
        int ar[][] = new int[envelopes.length][2];
        ar[0] = envelopes[0];
        for(int i = 1 ; i < ar.length ; i++)
        {
            if(envelopes[i][0] > ar[len-1][0] && envelopes[i][1] > ar[len-1][1])
            {
                ar[len] = envelopes[i];
                len++;
            }
            else
            {
                int index = BinarySearch(ar , envelopes[i] , len);
                ar[index] = envelopes[i];
            }
        }
        return len;
    }
    private int BinarySearch(int[][] ar , int[] target , int len)
    {
        int left = 0 , right = len-1;
        while(left <= right)
        {
            int mid = left + (right-left)/2;
            if(ar[mid][1] >= target[1])
            {
                right = mid-1;
            }
            else
            {
                left = mid+1;
            }
        }
        return left;
    }
}