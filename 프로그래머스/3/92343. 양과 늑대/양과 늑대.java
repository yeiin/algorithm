import java.util.*;

class Solution {
    int answer = 0;
    
    int[] info;
    int[][] edges;
    
    public void dfs(int index, boolean[] visited, int sheep, int wolf) {
        visited[index] = true;
        if (info[index] == 0) sheep++;
        else wolf ++;
        
        if (sheep <= wolf) return;
        
        answer = Math.max(answer, sheep);

        for (int[] edge : edges) {
            if (visited[edge[0]] && !visited[edge[1]]) {
                dfs(edge[1], visited.clone(), sheep, wolf);
            }
        }
        
    }
    
    public int solution(int[] info, int[][] edges) {
        this.info = info;
        this.edges = edges;
         
        dfs(0, new boolean[info.length], 0, 0);
        
        return answer;
    }
}