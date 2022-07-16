'''
Time Complexity: 0(n^2)
Space Complexity: 0(n)
Run on Leetcode: Yes

Approach:
1. Go exhaustive (choose-notChoose) and you will observer the repeating sub-problems with remaining
subset as a deciding parameter
2. Perform 1D memorization to solve this problem

'''
class russianDollEnvelope:
    def __init__(self,width,height):
        self.width = width
        self.height = height
    
    # custom operators where priority given to width and then to height   
    def __lt__(self, other):
        if (self.width == other.width):
            return self.height < other.height
        return self.width < other.width

    def __gt__(self, other):
        if (self.width == other.width):
            return self.height > other.height
        return self.width > other.width

    def __eq__(self, other):
        return (self.width == other.width and self.height == other.height)
    
    def __repr__(self):
        return '('+str(self.width)+','+str(self.height)+')'
    
class Solution:
    
    def memory1D(self,envelopes,memory1D,maxSize):
        # initialize ptrs
        ptrEnd = len(envelopes)-1
        ptrStart = ptrEnd-1
        
        # iterate
        while ptrStart > -1:
            while ptrEnd != ptrStart:
                if envelopes[ptrStart].width < envelopes[ptrEnd].width and envelopes[ptrStart].height < envelopes[ptrEnd].height:
                    memory1D[ptrStart] = max(memory1D[ptrStart],memory1D[ptrEnd]+1)
                    maxSize = max(maxSize,memory1D[ptrStart])
                ptrEnd -= 1
            '''end of inner while loop'''
            ptrEnd = len(envelopes)-1
            ptrStart -= 1
        '''end of outer while loop'''
        print("Envelopes is:\t",envelopes)
        print("memory1D is:\t",memory1D)
        return maxSize
    
    def maxEnvelopes(self, envelopes: List[List[int]]) -> int:
        for i in range(0,len(envelopes)):
            rde = russianDollEnvelope(envelopes[i][0],envelopes[i][1])
            envelopes[i] = rde
        envelopes.sort()
        print("Updated envelopes is:\t",envelopes)
        # follow longest increasing subsequence pattern
        return self.memory1D(envelopes,[1]*len(envelopes),1)