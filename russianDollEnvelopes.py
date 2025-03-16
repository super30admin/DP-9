class Solution:
    def maxEnvelopes(self, envelopes: List[List[int]]) -> int:
        # T: O(n log n), S: O(n)
        if not envelopes:
            return 0

        # Step 1: Sort envelopes
        envelopes.sort(key=lambda x: (x[0], -x[1]))  # Sort by width asc, height desc

        # Step 2: Find LIS on heights
        heights = [h for _, h in envelopes]
        sub = []

        for h in heights:
            idx = bisect_left(sub, h)  # Binary search position
            if idx == len(sub):
                sub.append(h)  # Append if increasing
            else:
                sub[idx] = h  # Replace element to maintain LIS

        return len(sub)  # Length of LIS
