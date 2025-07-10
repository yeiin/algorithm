import java.util.*;
import java.io.*;

public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<t; i++){
            int count = -1;
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            HashMap<Integer, List<Integer>> map = new HashMap<>();

            for(int j=0; j<m; j++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                if(!map.containsKey(a)) map.put(a, new LinkedList<>());
                if(!map.containsKey(b)) map.put(b, new LinkedList<>());

                map.get(a).add(b);
                map.get(b).add(a);
            }

            boolean[] visited =new boolean[n+1];
            Queue<Integer> q = new LinkedList<>();
            q.add(1);

            while(!q.isEmpty()){
                int curr = q.poll();

                if(!visited[curr]){
                    visited[curr] = true;
                    count ++;
                }

                for(int next: map.get(curr)){
                    if(!visited[next]){
                        q.add(next);
                    }
                }
            }

            sb.append(count+"\n");
        }

        System.out.println(sb.toString());
    }
}