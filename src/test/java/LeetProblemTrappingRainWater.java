import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class LeetProblemTrappingRainWater {
    class Solution {
        public int trap(int[] height) {
            int count = 0;
            int left = 0;
            int right = 1;
            int max = 0;
            int maxIndex = 0;

            while (left < height.length -1) {
                if (height[right] >= height[left]) {
                    int minValue = Math.min(height[left], height[right]);
                    for (int i=left+1; i<right; i++) {
                        count = count + minValue - height[i];
                    }
                    left = right;
                    max = 0;
                    maxIndex = 0;
                } else {
                    if (height[right] > max) {
                        max = height[right];
                        maxIndex = right;
                    }
                }

                right++;
                if (right >= height.length) {
                    if (maxIndex > 0) {
                        right = maxIndex;
                        int minValue = Math.min(height[left], height[right]);
                        for (int i=left+1; i<right; i++) {
                            count = count + minValue - height[i];
                        }
                        left = right;
                        right = left + 1;
                        max = 0;
                        maxIndex = 0;
                    } else {
                        left++;
                        right = left + 1;
                    }
                }
            }
            return count;
        }
    }
    @Test
    public void testMed() {
        Solution solution = new Solution();
        int[] height = new int[]{4,2,0,3,2,5};
        int s =  solution.trap(height);
        assert s == 9;
        System.out.println(s);
    }

    @Test
    public void testMed2() {
        Solution solution = new Solution();
        int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        int s =  solution.trap(height);
        assert s == 6;
        System.out.println(s);
    }

    @Test
    public void testMed3() {
        Solution solution = new Solution();
        int[] height = new int[]{4,2,3};
        int s =  solution.trap(height);
        assert s == 1;
        System.out.println(s);//[4,2,0,3,2,4,3,4]


    }
    @Test
    public void testMed4() {
        Solution solution = new Solution();
        int[] height = new int[]{4,2,0,3,2,4,3,4};
        int s =  solution.trap(height);
        System.out.println(s);
        assert s == 10;

    }


}
