#space: O(n) for dp array
#time: O(nlogn)- for sorting + binary search
class Solution:
    def maxEnvelopes(self, envelopes: List[List[int]]) -> int:
        #sorting width in ascending order and height in descending order
        envelopes= sorted(envelopes, key= lambda x:(x[0],-x[1]))
        arr=[envelopes[0]]
        m=len(envelopes)
        for i in range(1,m):
            last=arr[-1]
            #check if built array's last element is smaller 
            if last[0] < envelopes[i][0] and last[1] < envelopes[i][1]:
                arr.append(envelopes[i])
            #if not then find the index in the array which is just smaller then the current element
            else:
                bsindex= self.binarysearch(arr,0,len(arr)-1,envelopes[i] )
                #replacing it
                arr[bsindex]=envelopes[i]

        return len(arr)

    def binarysearch(self,arr,low, high,target):
        while low <=high:
            mid= low + int((high-low)/2)
            if target[0] > arr[mid][0] and target[1] > arr[mid][1]:
                low=mid+1
            else:
                high=mid-1
        return low
