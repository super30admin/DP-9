'''
Time Complexity: 0(nlogn)
Space Complexity: 0(n)
Run on Leetcode: Yes

Approach:
1. Sort the list is following pattern
    a. increasing order of width
    b. in case of width match, decreasing order of height
2. If current value height is greater than the effective array's last value i.e. 
height, simply append the current value to the stack
3. Else, perform binary-search in the effective-nums array that replaces the current 
value 'in-place'
'''
class russianDollEnvelope:
    def __init__(self,width,height):
        self.width = width
        self.height = height
    
    # custom operators where priority given to width and then to height   
    def __lt__(self, other):
        if (self.width == other.width):
            return self.height > other.height # height in decreasing order
        return self.width < other.width

    def __gt__(self, other):
        if (self.width == other.width):
            return self.height < other.height # height in decreasing order
        return self.width > other.width 

    def __eq__(self, other):
        return (self.width == other.width and self.height == other.height)
    
    def __repr__(self):
        return '('+str(self.width)+','+str(self.height)+')'
    
class Solution:
    
    def __init__(self):
        self.effectiveNums = []
    
    def binarySearch(self,low,high,target):
        
        while low <= high:
            mid = (high-low)//2 + low
            
            if self.effectiveNums[mid] == target:
                self.effectiveNums[mid] = target
                return
            
            elif self.effectiveNums[mid] < target:
                low = mid+1
            
            elif self.effectiveNums[mid] > target:
                high = mid-1
        '''end of while loop'''
        self.effectiveNums[low] = target
        return 
    
    def maxEnvelopes(self, envelopes: List[List[int]]) -> int:
        for i in range(0,len(envelopes)):
            rde = russianDollEnvelope(envelopes[i][0],envelopes[i][1])
            envelopes[i] = rde
        envelopes.sort()
        print("Updated envelopes is:\t",envelopes)
        
        self.effectiveNums.append(envelopes[0].height)
        
        # iterate the nums from index 1
        for i in range(1,len(envelopes)):
            # compare with the last index of effective nums
            if self.effectiveNums[-1] < envelopes[i].height:
                self.effectiveNums.append(envelopes[i].height)
            else:
                # perform binarySearch
                self.binarySearch(0,len(self.effectiveNums)-1,envelopes[i].height)
        '''end of nums iteration'''
        # print("Effective nums is:\t",self.effectiveNums)
        # print("Longest count is:\t",len(self.effectiveNums))
        return len(self.effectiveNums)
        