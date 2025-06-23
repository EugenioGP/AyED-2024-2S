import org.junit.Test;

import java.util.Arrays;

public class LeetProblemLexicographicallyMinimumStringAfterRemovingStars {
    class Solution {
        public String clearStars(String s) {
            StringBuilder result = new StringBuilder(s.length());
            int[] freq = new int[26];
            for (int i=0;i<s.length();i++) {
                char c = s.charAt(i);
                if (c != '*') {
                    result.append(c);
                    freq[c-'a']++;
                } else {
                    char smallest = getSmallestChar(freq);
                    if (!result.isEmpty()) {
                        freq[smallest - 'a']--;
                        result.deleteCharAt(result.lastIndexOf(String.valueOf(smallest)));
                    }
                }
            }
            return result.toString();
        }

        private char getSmallestChar(int[] freq) {
            for (int i=0;i<freq.length;i++) {
                if (freq[i] != 0) return (char) ('a' + i);
            }
            return 'a';
        }
    }

    @Test
    public void testMed() {
        Solution solution = new Solution();
        String a = "d*o*";
        String expected = "fnohopzv";
        String result = solution.clearStars(a);
        //t = bdd p = a s = cda
        //t = bddcd p = aa s = ""
        //
        System.out.println(result);
    }

}
