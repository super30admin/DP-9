class Solution:
    def maxEnvelopes(self, envelopes: List[List[int]]) -> int:
        """Binary search approach
        Time complexity-O(nlogn)
        Space complexity-O(n)"""
        envelopes.sort(key=lambda x: (x[0],-x[1]))
        arr=[envelopes[0]]
        for i in range(1, len(envelopes)):
            if envelopes[i][0]>arr[-1][0] and envelopes[i][1]>arr[-1][1]:
                arr.append(envelopes[i])
            else:
                index=self.searchIndexforGreaterELeinArr(arr, 0, len(arr)-1, envelopes[i][1])
                if index>len(arr)-1:
                    arr.append(envelopes[i])
                else:
                    arr[index]=envelopes[i]
        return len(arr)
    
    def searchIndexforGreaterELeinArr(self, newArr, low, high, element):
        while low<=high:
            mid=low+(high-low)//2
            if newArr[mid][1]==element:
                return mid
            if newArr[mid][1]>element:
                high=mid-1
            else:
                low=mid+1
        return low
        """DP Approach TopDown Approach
        Time Limit exceeded"""
        # dparr=[1 for i in range(len(envelopes))]
        # maxi=1
        # envelopes.sort(key=lambda x: x[0])
        # for i in range(1, len(envelopes)):
        #     for j in range(i):
        #         if envelopes[i][0]>envelopes[j][0] and envelopes[i][1]>envelopes[j][1]:
        #             dparr[i]=max(dparr[i],dparr[j]+1)
        #             maxi=max(dparr[i], maxi)
        # return maxi
            
        