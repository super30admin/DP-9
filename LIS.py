# Time complexity: O(nlog(n)) was n^2 but reduced due to BS
# Space complexity: O(n)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no
# initiate arr with first element, if encouter a smaller element on the left of idx then 
# replace it with curr element in arr 

def lengthOfLIS(self, nums: List[int]) -> int:
        n = len(nums)
        arr = [None] * n
        arr[0] = nums[0]
        al = 1
        for i in range(n):
            if arr[al-1] < nums[i]:
                arr[al] = nums[i]
                al+=1
            else:
                bsIdx = self.BS(arr,0,al-1,nums[i])
                arr[bsIdx] = nums[i]
        return al

        
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

# DP solution
# Time complexity: O(n^2)
# Space complexity: O(n)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

def lengthOfLIS(self, nums: List[int]) -> int:
    n = len(nums)
    # initiate DP array
    dp = [1] * n
    al = 1
    for i in range(1,n):
        for j in range(0,i):
            # if ele to left of i is smaller than i then add to dp arr max of dp[i] and dp[j]+1
            if nums[i] > nums[j]:
                dp[i] = max(dp[i],dp[j]+1)
        # update max length
        al = max(al,dp[i])
    return al