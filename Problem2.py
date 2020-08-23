class Solution:
    
    """
    
        Name : Shahreen Shahjahan Psyche
        Time : Dynammic     : O(N^2)
               
        Space: Dynammic     : O(N) [DP Array]
        
        Passed All Test Cases in LC : Time Limit Exceedeed for last 2 cases
        
        Approach : Dynammic   : # This is a similar kind of probleem like longeest subsequence. Here, wee just havee to sort the array eitheer for height or                                         width. We create an auxiliary data structure array which is the size of the nums array. Our goal is to get the maximum                                             subsequence for the current element while travarsing the 'eenvelopes' array.
                  
    """     
     
    def dynammicSolution(self, envelopes):
        envelopes.sort(key = lambda x : [x[0]])
        track = [1 for i in range(len(envelopes))]
        max_env = 1
        
        for i in range(1, len(track)):
            for j in range(0, i):
                if envelopes[i][0] != envelopes[j][0] and envelopes[i][1] > envelopes[j][1]:
                    track[i] = max(track[i], 1 + track[j])
            if track[i] > max_env:
                max_env = track[i]
        
        
        return max_env
        
    
    def maxEnvelopes(self, envelopes: List[List[int]]) -> int:
        if not envelopes:
            return 0
        
        
        max_env = self.dynammicSolution(envelopes)
        
        return max_env
                
        
        
        
        
        
        
        
