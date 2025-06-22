import java.util.*;
import java.io.*;

class Main{

    static int n;
    static boolean[] visited;
    static int[] distance;

    static HashMap<Integer, List<Integer>> map = new HashMap<>();

    static StringBuilder sb = new StringBuilder();

    public static boolean dfs(int root, int parent, int node){
        for(int route:  map.get(node)){
            if(visited[route] && route==root && route!= parent){
                visited[node] = true;
                return true; 
            }

            if(!visited[route]){
                visited[route] = true;
                boolean isCycle = dfs(root, node, route);
                if(isCycle) return true;  
                visited[route] = false;
                
            }
        }

        return false;
    }

    public static void findDistance(int node, int count){
        
        for(int route: map.get(node)){
            if(!visited[route] && distance[route]==0){
                distance[route] = count;
                findDistance(route, count+1);
            }
        }
        
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());   
        visited = new boolean[n+1];    
        distance = new int[n+1];
        
        StringTokenizer st;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            if(!map.containsKey(num1)){
                map.put(num1, new LinkedList<>());
            }
            if(!map.containsKey(num2)){
                map.put(num2, new LinkedList<>());
            }
            map.get(num1).add(num2);
            map.get(num2).add(num1);
        }

        for(int i=1; i<=n; i++){
            if(!visited[i]) {
                visited[i] = true;
                if(!dfs(i,-1, i)){
                    visited[i] = false;
                }
                
            }
        }

        for(int i=1; i<=n; i++){
            if(visited[i]) findDistance(i, 1);   
        }
      

        for(int i=1; i<=n; i++){
            sb.append(distance[i]+" ");   
        }

        System.out.println(sb.toString());
    }
}