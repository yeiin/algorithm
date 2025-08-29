import java.util.*;

class Solution {
    int answer = 0;
    
    HashMap<String, List<Integer>> map = new HashMap();
    
    String[] banned_id;
    boolean[] visited;
    HashMap<String, String> vmap = new HashMap();
    
    public void makeMap(char[] userArr, int depth, int userIdx){
        if(depth==userArr.length){
            String user = new String(userArr);
            if(!map.containsKey(user)){
                map.put(user, new ArrayList());   
            }
            map.get(user).add(userIdx);
            return;
        }
        
        makeMap(userArr.clone(), depth+1, userIdx);
        
        char[] next = userArr.clone();
        next[depth] = '*';
        makeMap(next, depth+1, userIdx);
        
    }
    
    
    public void dfs(int depth){
        
        if(depth==banned_id.length){
            String v = "";
            for(int i=0; i<visited.length; i++){
                if(visited[i]) v+= "true ";
                else v+="false ";
            }
            if(!vmap.containsKey(v)){
                vmap.put(v, v);
                answer++;
            }
            
            return;
        }
        
        for(int n: map.get(banned_id[depth])){
            if(!visited[n]){
                visited[n] = true;
                dfs(depth+1);
                visited[n] = false;
            }
        }
    }
    
    public int solution(String[] user_id, String[] banned_id) {
        
        for(int i=0; i<user_id.length; i++){
            char[] userArr = user_id[i].toCharArray();
            makeMap(userArr, 0, i);
        }
        
        this.banned_id = banned_id;
        visited = new boolean[user_id.length];
        
        dfs(0);
        
        return answer;
    }
}