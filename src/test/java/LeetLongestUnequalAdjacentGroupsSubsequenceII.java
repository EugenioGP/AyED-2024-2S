import org.junit.Test;

import java.util.*;

public class LeetLongestUnequalAdjacentGroupsSubsequenceII {
    class Solution {
        List<List<Integer>> adj = new ArrayList<>();

        private List<Integer>[] memo;

        private List<Integer> dfsMemo(int node) {
            if (memo[node] != null) {
                return memo[node];
            }

            List<Integer> bestPath = new ArrayList<>();
            bestPath.add(node);

            for (int neighbor : adj.get(node)) {
                List<Integer> candidatePath = dfsMemo(neighbor);
                if (candidatePath.size() + 1 > bestPath.size()) {
                    bestPath = new ArrayList<>();
                    bestPath.add(node);
                    bestPath.addAll(candidatePath);
                }
            }

            memo[node] = bestPath;
            return bestPath;
        }

        public List<Integer> findLongestPath() {
            memo = new List[adj.size()];
            List<Integer> longest = new ArrayList<>();
            for (int i = 0; i < adj.size(); i++) {
                List<Integer> path = dfsMemo(i);
                if (path.size() > longest.size()) {
                    longest = path;
                }
            }
            return longest;
        }


        public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {

            for (int i=0; i<words.length; i++) {
                String current = words[i];
                adj.add(new ArrayList<>());
                for (int j=i+1;j<words.length;j++) {
                    if (groups[i] != groups[j] && words[i].length() == words[j].length()) {
                        int distance = 0;
                        for (int k = 0; k < words[i].length(); k++) {
                            if (words[i].charAt(k) != words[j].charAt(k)) {
                                distance++;
                            }
                            if (distance > 1) break;
                        }
                        if (distance == 1) adj.get(i).add(j);
                    }
                }
            }
            List<Integer> longestPath = findLongestPath();
            List<String> result = new ArrayList<>();
            for (int i=0;i<longestPath.size();i++) {
                result.add(words[longestPath.get(i)]);
            }
            return result;
        }

        public static void bfsPrint(int start, List<List<Integer>> adj) {
            int n = adj.size();
            boolean[] visited = new boolean[n];
            int[] level = new int[n]; // to track depth level

            Queue<Integer> queue = new LinkedList<>();
            visited[start] = true;
            level[start] = 0;
            queue.offer(start);

            System.out.println("BFS Levels:");

            while (!queue.isEmpty()) {
                int node = queue.poll();
                int depth = level[node];

                // Print node with indentation based on its level
                System.out.println("  ".repeat(depth) + "Node " + node);

                for (int neighbor : adj.get(node)) {
                    if (!visited[neighbor]) {
                        visited[neighbor] = true;
                        level[neighbor] = depth + 1;
                        queue.offer(neighbor);
                    }
                }
            }
        }
    }
    @Test
    public void testMed() {
        Solution solution = new Solution();
        String[] words = new String[]{"a","b","c","d"};
        int[] groups = new int[]{1, 2, 3, 4, 5};
        System.out.println(solution.getWordsInLongestSubsequence(words, groups));
    }
    @Test
    public void testMed2() {
        Solution solution = new Solution();
        String[] words = new String[]{"bab","dab","cab"};
        int[] groups = new int[]{1, 2, 2};
        System.out.println(solution.getWordsInLongestSubsequence(words, groups));
    }
}
