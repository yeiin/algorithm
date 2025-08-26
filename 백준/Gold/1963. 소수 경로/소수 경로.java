import java.io.*;
import java.util.*;

class Main{


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        StringTokenizer st;

        int max = 0;
        List<int[]> lists = new ArrayList<>();

        for(int t=0; t<T; t++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            max = Math.max(max, Math.max(a, b));
            lists.add(new int[]{a, b});
        }

        boolean[] nDecimals = new boolean[10001];
        nDecimals[0] = true;
        nDecimals[1] = true;

        for(int i=2; i<=Math.sqrt(10000); i++){
            if(nDecimals[i]) continue;

            for(int j = i*i; j <= nDecimals.length-1; j = j+i) {
				nDecimals[j] = true;
			}
        }

        for(int[] l: lists){

            boolean[] visited = new boolean[10001];
            Queue<int[]> q = new LinkedList<>();
            q.add(new int[]{l[0], 0});

            int min = Integer.MAX_VALUE;

            while(!q.isEmpty()){
                int[] curr = q.poll();

                if(curr[0]==l[1]){
                    min = Math.min(min, curr[1]);
                    continue;
                }

                if(curr[1]>=min) continue;

                for (int i = 0; i < 4; i++) {
                    int pow = (int) Math.pow(10, i);
                    int digit = (curr[0] / pow) % 10; 

                    for (int d = 0; d <= 9; d++) {
                        if (d == digit) continue;
                        if (i == 3 && d == 0) continue; 

                        int next = curr[0] - digit * pow + d * pow;

                        if (!nDecimals[next] && !visited[next]) {
                            visited[next] = true;
                            q.add(new int[]{next, curr[1] + 1});
                        }
                    }
                }
            }

            if(min==Integer.MAX_VALUE) System.out.println("Impossible");
            else System.out.println(min);
        }
        
    }
}