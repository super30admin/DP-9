// 354.
// passes all test cases on leetcode

class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        //edge
        if(envelopes == null || envelopes.length == 0 || envelopes[0].length == 0)
        {
            return 0;
        }
        //envelope[i] is an array of form [width, height]
        //sort all envelopes either based on height or width
        //after sorting, run lis on the other parameter
        //after sorting lis works because, we know that the other parameter is already in increasing order
        Arrays.sort(envelopes, (int[] a, int[] b) -> a[0] - b[0]); //increasing order of widths
        
        return russianDollsDP(envelopes);
    }
    
    //time - O(n^2)
    //space - O(n)
    private int russianDollsDP(int[][] envelopes) {
        int[] result = new int[envelopes.length];
        Arrays.fill(result, 1); //every element is an increasing sub sequence of length 1
        int max = 1; 
        
        for(int i = 1; i < result.length; i++)
        {
            for(int j = 0; j < i; j++)
            {
                //current envelope is larger than jth envelope in both height and width
                if(envelopes[i][1] > envelopes[j][1] && envelopes[i][0] > envelopes[j][0])
                {
                    //update result[i] and max if needed
                    result[i] = Math.max(result[j] + 1, result[i]);
                    max = Math.max(max, result[i]);
                }
            }
        }
        
        return max;
    }
}
