//
//  RussianDollEnvelops.swift
//  DSA-Practice
//
//  Created by Paridhi Malviya on 3/21/26.
//

/*
 problem - [[4, 1], [2, 3], [1, 2], [3, 7], [3, 4], [5, 2], [5, 4], [5, 6], [6, 3], [6, 5], [6, 7]]
Sort the dimentiosn based on width and then height.
 Later make the longest increasing subsequence based on height becasue, we have already sorted it based on width.
 That lenght of longest increasing subsequence will be the no of envelops we can russian doll.
 
 At the time of the sorting, we sorted based upon width.
 If heights are equal then reverse the order. Keep the bigger height first and then the smaller height. Width are same.
 Then this will never look like an increasing subsequence.
 [[1,2],[2,3],[3,7], [3, 4], [4, 1], [5, 6], [5, 4], [5, 2], [6,7], [6,5] , [6, 3]]
 
 find longest increasin gsubsequence on [2, 3, 7, 4, 1, 6, 4, 2, 7, 5, 3]
 advantage is - we don't need to maintain the 2-D array. We can just maintain the heights and find longest subsequence.
 
 time compelxity - O(n^2)-> DP solution
 Binary search solution - O(n log n)
 */
class RussianDollEnvelops {
    
    init() {
        
    }
    
    //time complexity - O(n^2) - time limit exceeded
    func maxEnvelopes(_ envelopes: [[Int]]) -> Int {
        var envelopes = envelopes
        envelopes.sort(by: {(a, b) in

            if (a[0] == b[0]) {
                return a[1] > b[1]
            }
            return a[0] < b[0]
        })

        var dp = Array(repeating: 1, count: envelopes.count)
        var maxLength = 1
        for i in 1..<envelopes.count {
            for j in 0..<i {
                if (envelopes[i][1] > envelopes[j][1]) {
                    dp[i] = max(dp[i], dp[j] + 1)
                    maxLength = max(maxLength, dp[i])
                }
            }
        }
        return maxLength
    }
    
    //MARK: optimized
    //time complexity - O(n logn)
    //Sort one either width/height and make subsequence on the other aspect.
    func maxEnvelopesOptimized(_ envelopes: [[Int]]) -> Int {
        var envelopes = envelopes
        envelopes.sort(by: {(a, b) in
            if (a[0] == b[0]) {
                return a[1] > b[1]
            }
            return a[0] < b[0]
        })
        let n = envelopes.count
        var arr: [Int] = [envelopes[0][1]]
        var maxLength = 1
        for i in 1..<n {
            if (envelopes[i][1] > arr.last!) {
                arr.append(envelopes[i][1])
                maxLength += 1
            } else {
                //do binary search in arr and find the number which is just greater than the number
                let bsIdx = binarySearch(arr: arr, target: envelopes[i][1])
                //bsidx will provide the index which is just greater than the current processed number
                arr[bsIdx] = envelopes[i][1]
            }
        }
        return arr.count
    }

    func binarySearch(arr: [Int], target: Int) -> Int {
        var low = 0
        var high = arr.count - 1
        while (low <= high) {
            let mid = low + (high - low) / 2
            if (target == arr[mid]) {
                return mid
            } else if (target < arr[mid]) {
                high = mid - 1
            } else {
                low = mid + 1
            }
        }
        return low
    }
}
