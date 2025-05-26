import java.util.*;

class Solution {
    int n;
    int[][] q;
    int[] ans;
    
    List<int[]> numbers = new LinkedList();
    boolean[] visited;
    
    public void dfs(int[] numberArr, int num, int count){
        if(count == 5){
            numbers.add(numberArr);
            return;
        }
        
        for(int i=num; i<=n; i++){
            if(!visited[i]){
                visited[i] = true;
                int[] nextArr = numberArr.clone();
                nextArr[count] = i;
                dfs(nextArr, i, count+1);
                visited[i] = false;
            }
        }
    }
    
    public boolean isPossible(boolean[] isExist){
        for(int i=0; i<q.length; i++){
            int count = 0;
            for(int j=0; j<q[0].length; j++){
                if(isExist[q[i][j]]){
                    count++;
                }
            }
            
            if(count != ans[i]){
                return false;
            }
        }
        
        return true;
    }
    
    public int solution(int n, int[][] q, int[] ans) {
        this.n = n;
        this.q = q;
        this.ans = ans;
        List<int[]> answerList = new LinkedList();    
        visited = new boolean[n+1];
        
        dfs(new int[5], 1, 0);
        
        for(int[] arr: numbers){
            boolean[] isExist = new boolean[n+1];
        
            for(int i=0; i<5; i++){
                isExist[arr[i]] = true;
            }
            
            if(isPossible(isExist)){
                answerList.add(arr);
            }
            
        }
        
        return answerList.size();
    }
}