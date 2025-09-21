import java.util.*;

class Solution {

    List<Integer>[] graph;
    int[][] dp;
    int[] sales;

    public int solution(int[] sales, int[][] links) {
        int n = sales.length;
        this.sales = sales;
        graph = new ArrayList[n + 1];
        dp = new int[n + 1][2];

        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();
        for (int[] link : links) {
            graph[link[0]].add(link[1]);
        }

        dfs(1); 
        return Math.min(dp[1][0], dp[1][1]);
    }

    void dfs(int node) {
        dp[node][1] = sales[node - 1]; 
        if (graph[node].isEmpty()) return;

        int extra = Integer.MAX_VALUE;
        for (int child : graph[node]) {
            dfs(child);

            dp[node][1] += Math.min(dp[child][0], dp[child][1]);

            dp[node][0] += Math.min(dp[child][0], dp[child][1]);

            extra = Math.min(extra, dp[child][1] - Math.min(dp[child][0], dp[child][1]));
        }

        dp[node][0] += extra;
    }
}