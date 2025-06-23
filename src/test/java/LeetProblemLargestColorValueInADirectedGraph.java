import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetProblemLargestColorValueInADirectedGraph {
    class Solution {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        String colors;

        Character dfs(int node, Map<Character, Integer> current) {
            Character c = colors.charAt(node);
            List<Integer> neighbours = adjList.get(node);
            Character largest = c;
            if (neighbours != null) {
                for (int i=0; i<neighbours.size();i++) {
                    Character largestChar = dfs(neighbours.get(i), current);
                    if (largestChar != largest) largest = largestChar;
                }
            }

            current.computeIfAbsent(c, k -> 0);
            current.put(c, current.get(c) + 1);
            if (current.get(c) > current.get(largest)) largest = c;
            return largest;
        }
        public int largestPathValue(String colors, int[][] edges) {
            this.colors = colors;
            for (int i=0; i<edges.length;i++) {
                if (edges[i][0] == edges[i][1]) return -1;
                if (adjList.get(edges[i][0]) == null) {
                    adjList.put(edges[i][0], new ArrayList<>());
                }
                adjList.get(edges[i][0]).add(edges[i][1]);
            }
            int largestAmount = 0;
            for (Integer node: adjList.keySet()) {
                Map<Character, Integer> current = new HashMap<>();
                Character largestColor = dfs(node, current);
                if (current.get(largestColor) > largestAmount) largestAmount = current.get(largestColor);
            }
            return largestAmount;
        }
    }
    @Test
    public void testMed() {
        Solution solution = new Solution();
        int s =  solution.largestPathValue("abaca", new int[][]{
                {0, 1},
                {0, 2},
                {2, 3},
                {3, 4}
        });
    }


}
