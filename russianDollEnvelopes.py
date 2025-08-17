class Solution:
    def maxEnvelopes(self, envelopes: List[List[int]]) -> int:
        envelopes.sort(key=lambda x: (x[0], -x[1]))
        lis=[]
        def binSearch(arr, num):
            low=0
            high=len(arr)

            while low<high:
                mid=(low+high)//2

                if arr[mid][1]<num[1]:
                    low=mid+1
                else:
                    high=mid
            
            return low

        for env in envelopes:
            idx=binSearch(lis, env)

            if idx==len(lis):
                lis.append(env)
            else:
                lis[idx]=env
        
        return len(lis)