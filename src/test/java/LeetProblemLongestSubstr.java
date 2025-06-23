import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class LeetProblemLongestSubstr {
    class Solution {
        public String lengthOfLongestSubstring(String s) {
            String substr = "";
            String current = "";
            for (int i=0; i<s.length();i++) {
                char c = s.charAt(i);
                if (current.indexOf(s.charAt(i)) >= 0) {
                    if (current.length() > substr.length()) {
                        substr = current;
                    }
                    current = current.substring(current.indexOf(c)+1);
                }
                current = current + c;
            }
            if (current.length() > substr.length()) {
                substr = current;
            }
            return substr;
        }
        /*
        curr = "dv"
        res = "dv"
        djvdf
        si char existe en current -> current = substr desde pos , si current > que result result = current
        sino
        current = current + char
         */
    }
    @Test
    public void testMed() {
        Solution solution = new Solution();
        String a = "abcabcbb";
        String s =  solution.lengthOfLongestSubstring(a);
        System.out.println(s);
    }

    @Test
    public void testMed2() {
        Solution solution = new Solution();
        String a = "dvdf";
        String s =  solution.lengthOfLongestSubstring(a);
        System.out.println(s);
    }
    @Test
    public void testMed3() {
        Solution solution = new Solution();
        String a = "pwwkew";
        String s =  solution.lengthOfLongestSubstring(a);
        System.out.println(s);
    }
}
