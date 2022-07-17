package com.interview.s30.dp;

import java.util.Arrays;

/**
 * Leetcode 354: https://leetcode.com/problems/russian-doll-envelopes/
 * Time Complexity : O(NlogN)
 * Space Complexity : O(N)
 * Did this code successfully run on Leetcode : Yes
 * Any problem you faced while coding this : No
 */
public class RussianDolls
{
    public int maxEnvelopes(int[][] envelopes)
    {
        Arrays.sort(envelopes, (a, b) -> {
            if(a[0]==b[0]) {
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });

        int envelopeCount = envelopes.length;
        int result[][] = new int[envelopeCount][2];
        int index = 0;

        int length = 0;

        result[0] = new int[]{envelopes[0][0],envelopes[0][1]};

        for(int i=1; i<envelopeCount; i++) {
            int currentEnvelope[] = envelopes[i];
            if(result[index][1] < currentEnvelope[1]) {
                index++;
                result[index] = new int[]{currentEnvelope[0], currentEnvelope[1]};
            }
            else {
                int j =0;
                for(j =0; j < index; j++) {
                    if(result[j][1] >= currentEnvelope[1]) {
                        break;
                    }
                }
                result[j] = new int[]{currentEnvelope[0], currentEnvelope[1]};
            }
        }

        return index + 1;

    }
}
