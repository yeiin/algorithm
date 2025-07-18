import java.io.*;
import java.util.*;

class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] board = new int[n][n];
        int answer = 0;

        int shark = 2;
        int ateNum = 0;
        int sX = 0;
        int sY = 0;

        StringTokenizer st;
        
        for(int i=0; i<n; i++){ 
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j] == 9){
                    sX = i;
                    sY = j;
                    board[i][j] = 0;
                }
            }
        }

        int[] dx = {-1, 0, 0, 1};
        int[] dy = {0, -1, 1, 0};

        while(true){
            Queue<int[]> q = new LinkedList<>();
            PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) ->{
                if(o1[2] == o2[2] && o1[0] == o2[0]) return o1[1] - o2[1];
                else if(o1[2] == o2[2]) return o1[0] - o2[0];
                return o1[2] - o2[2];

            });
            q.add(new int[]{sX, sY, 0});
            boolean[][] visited = new boolean[n][n];
            visited[sX][sY] = true;

            while (!q.isEmpty()) {
                int[] curr = q.poll();

                if(board[curr[0]][curr[1]] != 0 && board[curr[0]][curr[1]]<shark){
                    pq.add(curr);
                }

                for(int i=0; i<dx.length; i++){
                    int nextX = curr[0] + dx[i];
                    int nexty = curr[1] + dy[i];

                    if(nextX<0 || nextX>=n || nexty<0 || nexty>=n || visited[nextX][nexty]) continue;
                    if(board[nextX][nexty]>shark) continue;
                    
                    visited[nextX][nexty] = true;
                    q.add(new int[]{nextX, nexty, curr[2]+1});
                }
            }

            if(pq.isEmpty()) break;

            
            int[] next = pq.poll();

            answer += next[2];
            ateNum++;
            board[next[0]][next[1]] = 0;
            sX = next[0];
            sY = next[1];
            if(ateNum == shark){
                shark++;
                ateNum = 0;
            }
        }      

       
        System.out.println(answer);

    }
}