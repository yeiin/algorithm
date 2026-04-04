import java.io.*;
import java.util.*;

class Main{

    static int v;
    static int[] parents;

    public static void setParents(int[] curr){
        int pa = parents[curr[0]];
        int pb = parents[curr[1]];

        for(int i=1; i<=v; i++){
            if(parents[i]==pa || parents[i]==pb){
                parents[i] = pa;
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        long answer = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2)-> o1[2]-o2[2]);
        
        for(int i=0; i<e; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(a>b){
                int temp = a;
                a = b;
                b = temp;
            }

            pq.add(new int[]{a, b, c});
        }

        parents = new int[v+1];
        boolean[] visited = new boolean[v+1];

        for(int i=1; i<=v; i++){
            parents[i] = i;
        }

        while(!pq.isEmpty()){
            int[] curr = pq.poll();

            if(!visited[curr[0]] || !visited[curr[1]]){
                visited[curr[0]] = true;
                visited[curr[1]] = true;
                answer += curr[2];
                setParents(curr);
            }else if(parents[curr[0]]!= parents[curr[1]]){
                answer += curr[2];
                setParents(curr);
            }
        }
        System.out.println(answer);

    }

}