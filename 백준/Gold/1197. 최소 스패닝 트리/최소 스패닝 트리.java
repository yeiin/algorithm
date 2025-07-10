import java.io.*;
import java.util.*;

public class Main{

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());        
        
        List<int[]> graph = new ArrayList<>();

        for(int i=0; i<e; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.add(new int[]{a, b, w});
            
        }

        graph.sort((o1, o2)-> o1[2] - o2[2]);
        
        long answer = 0;
        HashSet<Integer> visited = new HashSet<>();
        int[] parents = new int[v+1];

        for(int i=1; i<v+1; i++){
            parents[i] = i;
         }

        for(int[] edge: graph){
            
            if(!visited.contains(edge[0]) || !visited.contains(edge[1])){
                answer += edge[2];
                visited.add(edge[0]);
                visited.add(edge[1]);

                int pa = parents[edge[0]];
                int pb = parents[edge[1]];
                int p = Math.min(pa,pb);

                for(int i=1; i<v+1; i++){
                    if(parents[i] == pa || parents[i] == pb){
                        parents[i] = p;
                    }
                }

            }else if(parents[edge[0]] != parents[edge[1]]){

                answer += edge[2];

                int pa = parents[edge[0]];
                int pb = parents[edge[1]];
                int p = Math.min(pa,pb);

                for(int i=1; i<v+1; i++){
                    if(parents[i] == pa || parents[i] == pb){
                        parents[i] = p;
                    }
                }

            }

        }

        System.out.println(answer);
    }
}