import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetProblemsTest {
    class Solution {
        public static final List<Character> vowels = Arrays.asList('a', 'e', 'i', 'o', 'u');
        public int[] vowelStrings(String[] words, int[][] queries) {
            int[] result = new int[queries.length];
            int[] prefixSum = new int[words.length];
            if (vowels.contains(words[0].charAt(0)) && vowels.contains(words[0].charAt(words[0].length()-1))) {
                prefixSum[0] = 1;
            } else {
                prefixSum[0] = 0;
            }
            for (int i = 1; i < words.length; i++) {
                String word = words[i];
                int value = 0;
                if (vowels.contains(word.charAt(0)) && vowels.contains(word.charAt(word.length()-1))) {
                    value = 1;
                }
                prefixSum[i] = prefixSum[i - 1] + value;
            }
            System.out.println(Arrays.toString(prefixSum));
            for (int i = 0; i < queries.length; i++) {
                if (queries[i][0] == 0) {
                    result[i] = prefixSum[queries[i][1]];
                } else {
                    result[i] = prefixSum[queries[i][1]] - prefixSum[queries[i][0]-1] ;
                }
            }
            return result;
        }
    }
    @Test
    public void testMed() {
        Solution solution = new Solution();
        String[] words = new String[]{"aba","bcb","ece","aa","e"};
        int[][] queries = new int[][]{{0,2},{1,4},{1,1}};
        int[] s =  solution.vowelStrings(words, queries);
        System.out.println(Arrays.toString(s));
    }

    @Test
    public void testMed2() {
        Solution solution = new Solution();
        String[] words = new String[]{"a","e","i"};
        int[][] queries = new int[][]{{0,2},{0,1},{2,2}};
        int[] s =  solution.vowelStrings(words, queries);
        System.out.println(Arrays.toString(s));
    }
}
