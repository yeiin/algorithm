import java.util.*;
import java.io.*;

class Main{

    static HashMap<Integer, Set<Integer>> map = new HashMap<>();
    static int[] arr;
    static int index = 0;
    static int n;
    static boolean[] visited;

    static boolean dfs(int node){      
        
        if(index == n-1){
            return true;
        }

        Set<Integer> branches = map.get(node);

        while(true){
            boolean isFind = false;
            if(!branches.contains(arr[index+1])) return false;
            if(!visited[arr[index+1]]){
                isFind = true;
                visited[arr[index+1]] = true;
                if(dfs(arr[1+index++])) return true;
            }

            if(!isFind) break;
        }
        

        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        
        for(int i=0; i<n-1; i++){
            st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            
            if(!map.containsKey(num1)){
                map.put(num1, new HashSet<>());
            }

            if(!map.containsKey(num2)){
                map.put(num2, new HashSet<>());
            }

            map.get(num1).add(num2);
            map.get(num2).add(num1);
        }

        st = new StringTokenizer(br.readLine());
        arr = new int[n];
        visited = new boolean[n+1];
        visited[1] = true;

        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        if(dfs(1)){
            System.out.println(1);
        }else{
            System.out.println(0);
        }


    }
}