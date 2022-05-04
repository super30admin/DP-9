import java.util.Arrays;
/*
Time Complexity: O(N*M), N is the length of text1 and M is the length of text2
Space Complexity: O(N*M), Size of memoization array
Run on leetcode: yes
Any difficulties: no

Approach:
1. Similar like Longest Increasing Subsequence, recursion
 */
public class LongestCommonSubsequence {
    public static int[][] memo;

    public static int longestCommonSubsequence(String text1, String text2){
        if(text1 == null || text2 == null){
            return 0;
        }

        memo = new int[text1.length()+1][text2.length()+1];
        for(int i = 0; i<memo.length; i++){
            Arrays.fill(memo[i], -1);
        }
        return LCSRecursion(text1, text2, 0, 0);
    }

    public static int LCSRecursion(String text1, String text2, int i1, int i2){
        if(i1 == text1.length() || i2 == text2.length()){
            return 0;
        }
        int length = 0;

        if(memo[i1][i2] == -1){
            // Select when the characters are equal
            if(text1.charAt(i1) == text2.charAt(i2)){
                length = 1+LCSRecursion(text1, text2, i1+1, i2+1);
            }else{ // Move ahead when the characters does not match and select the longest subsequence

                length = Math.max(LCSRecursion(text1, text2, i1+1, i2), LCSRecursion(text1, text2, i1, i2+1));
            }

            memo[i1][i2]  = length;
        }

        return memo[i1][i2];
    }

    public static void main(String[] args){
        System.out.println("Longest Common Subsequence: "+longestCommonSubsequence("abcde","ace"));
        System.out.println("Longest Common Subsequence: "+longestCommonSubsequence("abc","abc"));
        System.out.println("Longest Common Subsequence: "+longestCommonSubsequence("abc","def"));
        System.out.println("Longest Common Subsequence: "+longestCommonSubsequence("abcd","adc"));
    }
}
