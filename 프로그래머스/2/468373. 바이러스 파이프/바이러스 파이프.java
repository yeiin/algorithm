import java.util.*;

class Solution {
    
    List<int[]> pipes = new LinkedList<>();
    int[] pArr;
    int k;
    
    public void makePipe(int depth, int past){
        if(depth == k){
            pipes.add(pArr.clone());
            return;
        }
        
        for(int i = 1; i <= 3; i++){
            if(i == past) continue;
            pArr[depth] = i;
            makePipe(depth + 1, i);
        }
    }
    
    public int solution(int n, int infection, int[][] edges, int k) {
        int answer = 0;
        
        pArr = new int[k];
        this.k = k;
        
        HashMap<Integer, List<int[]>> graph = new HashMap<>();
        for(int[] e : edges){
            graph.putIfAbsent(e[0], new LinkedList<>());
            graph.putIfAbsent(e[1], new LinkedList<>());
            
            graph.get(e[0]).add(new int[]{e[1], e[2]});
            graph.get(e[1]).add(new int[]{e[0], e[2]});
        }
        
        makePipe(0, 0);
        
        for(int[] comb : pipes){
            Set<Integer> visited = new HashSet<>();
            visited.add(infection);
            
            for(int c : comb){
                Queue<Integer> q = new LinkedList<>(visited);
                
                while(!q.isEmpty()){
                    int cur = q.poll();
                    
                    for(int[] node : graph.getOrDefault(cur, Collections.emptyList())){
                        int next = node[0];
                        int pipeType = node[1];
                        
                        if(!visited.contains(next) && pipeType == c){
                            visited.add(next);
                            q.add(next);
                        }
                    }
                }
            }
            
            answer = Math.max(answer, visited.size());
        }
        
        return answer;
    }
}