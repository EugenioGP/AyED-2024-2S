import org.junit.Test;

import java.util.Arrays;

public class LeetProblemUsingaRobottoPrinttheLexicographicallySmallestString {
    class Solution {
        public String robotWithString(String s) {
            StringBuilder t = new StringBuilder();
            StringBuilder paper = new StringBuilder(s.length());
            char[] sorted = s.toCharArray();
            Arrays.sort(sorted);

            for (int k=0;k<sorted.length;k++) {
                char c = sorted[k];
                String character = String.valueOf(c);
                int i = s.indexOf(character);
                if (i != -1) {
                    if (t.isEmpty() || c < t.charAt(t.length()-1)) {
                        t.append(s, 0, i);
                        paper.append(s.charAt(i));
                        if (i+1 < s.length()) {
                            s = s.substring(i+1);
                        } else {
                            s = "";
                        }
                    } else {
                        while (!t.isEmpty() && t.charAt(t.length()-1) <= c) {
                            paper.append(t.charAt(t.length()-1));
                            t.deleteCharAt(t.length()-1);
                        }
                        t.append(s, 0, i);
                        paper.append(s.charAt(i));
                        if (i+1 < s.length()) {
                            s = s.substring(i+1);
                        } else {
                            s = "";
                        }
                    }

                }
            }
            if (!t.isEmpty()) {
                while (!t.isEmpty()) {
                    paper.append(t.charAt(t.length()-1));
                    t.deleteCharAt(t.length()-1);
                }
            }
            return paper.toString();
        }
    }

    @Test
    public void testMed() {
        Solution solution = new Solution();
        String a = "bac";
        String expected = "fnohopzv";
        String result = solution.robotWithString(a);
        //t = bdd p = a s = cda
        //t = bddcd p = aa s = ""
        //
        System.out.println(result);
    }

}
