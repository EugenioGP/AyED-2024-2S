import org.junit.Test;

public class LeetProblemNumberOfWaysToSplitArray {
    class Solution {
        public int waysToSplitArray(int[] nums) {
            int[] prefixSum = new int[nums.length];
            prefixSum[0] = nums[0];
            for (int i=1; i<nums.length;i++) {
                prefixSum[i] = nums[i] + prefixSum[i-1];
            }
            int count = 0;
            for (int i = 0; i < nums.length-1; i++) {
                if (prefixSum[i] >= prefixSum[nums.length-1] - prefixSum[i]) {
                    count++;
                }
            }

            return count;
        }
    }
    @Test
    public void testMed() {
        Solution solution = new Solution();
        int[] nums = new int[]{10,4,-8,7};
        int s =  solution.waysToSplitArray(nums);
        System.out.println(s);
        assert s == 2;
    }

    @Test
    public void testMed2() {
        Solution solution = new Solution();
        int[] nums = new int[]{2,3,1,0};
        int s =  solution.waysToSplitArray(nums);
        System.out.println(s);
        assert s == 2;
    }
}
