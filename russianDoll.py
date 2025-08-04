"""
Sort envelopes by width ascending and height descending (to avoid false LIS on same widths)
Then extract the heights and find the Longest Increasing Subsequence (LIS) on them
This transforms the 2D problem into a classic LIS problem
"""
"""
Time Complexity: O(n log n)
Space Complexity: O(n)
"""

import bisect

class russianDoll:
    def maxEnvelopes(self, envelopes: list[list[int]]) -> int:
        envelopes.sort(key=lambda x: (x[0], -x[1]))

        heights = [h for _, h in envelopes]
        lis = []

        for h in heights:
            i = bisect.bisect_left(lis, h)
            if i == len(lis):
                lis.append(h)
            else:
                lis[i] = h

        return len(lis)

if __name__ == "__main__":
    obj = russianDoll()
    print(obj.maxEnvelopes([[5,4],[6,4],[6,7],[2,3]]))     # 3
    print(obj.maxEnvelopes([[1,1],[1,1],[1,1]]))           # 1
    print(obj.maxEnvelopes([[4,5],[4,6],[6,7],[2,3],[1,1]]))  # 4
