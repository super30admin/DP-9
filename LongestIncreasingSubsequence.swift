//
//  LongestIncreasingSubsequence.swift
//  DSA-Practice
//
//  Created by Paridhi Malviya on 3/20/26.
//

/*
 How to find out all possible subsequence
 
 1. Initially every element in itself is a subsequence of length of 1.
 */
class LongestIncreasingSubsequence {
    
    init() {
        
    }
    
    //time complexity - O(n^2)
    func lengthOfLIS(_ nums: [Int]) -> Int {
        var dp = Array(repeating: 1, count: nums.count)
        var maxLength = 1
        for i in 1..<nums.count {
            for j in 0..<i {
                if (nums[i] > nums[j]) {
                    dp[i] = max(dp[j] + 1, dp[i])
                    maxLength = max(maxLength, dp[i])
                }
            }
        }
        return maxLength
    }
    
    //optimal solution - Binary search beats DP
    /*
     array not sorted, but still,
     Make an array where
     if current number can form increasing subsequence with with last element of effective increasing subsequence, add it at idx
     else, replace the closest number which is greater than current
     */
    func lengthOfLISUsingBinarySearch(_ nums: [Int]) -> Int {
        var dp = Array(repeating: 1, count: nums.count)
        
        //let's take a effective increasing subsequence
        var arr: [Int] = [nums[0]]
        var maxLength = 1
        for i in 1..<nums.count {
            if (nums[i] > arr.last!) {
                arr.append(nums[i])
                maxLength = max(maxLength, arr.count)
            } else {
                //replace the element just greater than nums[i]
                //Find the closest greater element using binary search
                let bsIdx = binarySearchToFindClosestGreater(arr: arr, num: nums[i])
                arr[bsIdx] = nums[i]
            }
        }
        return maxLength
    }

    func binarySearchToFindClosestGreater(arr: [Int], num: Int) -> Int {
        var low = 0
        var high = arr.count - 1
        var closestGreater = Int.max
        while (low <= high) {
            let mid = low + (high - low) / 2
            if (num < arr[mid]) {
                high = mid - 1
            } else if (num > arr[mid]) {
                low = mid + 1
            } else {
                return mid
            }
        }
        return low
    }

    
}
