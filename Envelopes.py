# Time complexity: O(nlog(n)) DP gives time limit exceeded
# space complexity: O(n)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

def maxEnvelopes(self, envelopes: List[List[int]]) -> int:
    
        n = len(envelopes)
        # sort using width and if same width then dec height
        s = sorted(envelopes, key =lambda x:(x[0],-x[1]))
        
        # apply LIS on height
        arr = [None] * n
        arr[0] = s[0][1]
        al = 1
        for i in range(n):
            if arr[al-1] < s[i][1]: 
                arr[al] = s[i][1]
                al+=1
            else:
                bsIdx = self.BS(arr,0,al-1,s[i][1])
                arr[bsIdx] = s[i][1]
        return al

# Perform binary search to find idx to replace 
def BS(self, arr, l,h,target):
    while(l<=h):
        mid = l+(h-l) // 2
        if arr[mid] == target:
            return mid
        elif arr[mid] > target:
            h = mid-1
        else:
            l = mid+1
    return l
    
