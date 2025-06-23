import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class LeetProblemContainerWithMostWater {
    class Solution {
        public int maxArea(int[] height) {
            int left = 0;
            int right = height.length - 1;
            int maxArea = 0;
            while (left < right) {
                int area = Math.min(height[left], height[right]) * (right - left);
                if (area > maxArea) {
                    maxArea = area;
                }
                if (height[left] < height[right]) {
                    left++;
                } else {
                    right--;
                }
            }
            return maxArea;
        }
    }
    @Test
    public void testMed() {
        Solution solution = new Solution();
        int[] height = new int[]{1,8,6,2,5,4,8,3,7};
        int s =  solution.maxArea(height);
        System.out.println(s);
        assert s == 49;
    }

    @Test
    public void testMed2() {
        Solution solution = new Solution();
        int[] height = new int[]{1, 1};
        int s =  solution.maxArea(height);
        System.out.println(s);
        assert s == 1;
    }

    @Test
    public void testMed3() {
        Solution solution = new Solution();
        int[] height = new int[]{0, 1};
        int s =  solution.maxArea(height);
        System.out.println(s);
    }
    @Test
    public void testMed4() {
        Solution solution = new Solution();
        int[] height = new int[]{1, 0, 2};
        int s =  solution.maxArea(height);
        System.out.println(s);
    }
}
