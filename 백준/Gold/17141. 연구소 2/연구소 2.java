import java.io.*;
import java.util.*;

public class Main{

    static List<int[]> viruses = new ArrayList<>();
    static boolean[] visited;
    static int[] arr;

    static int[][] board;
    static int count;

    static int n;
    static int m;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int answer = Integer.MAX_VALUE;

    public static void bfs(){
        Queue<int[]> q = new LinkedList<>();
        boolean[][] qvisited = new boolean[n][n];
        int num = 0;

        for(int i: arr){
            int[] node = viruses.get(i);
            q.add(new int[]{node[0], node[1], 0});
            qvisited[node[0]][node[1]] = true;
            num++;

            if(num == count){
                answer = Math.min(answer, 0);
                return;
            }
        }

        while(!q.isEmpty()){
            int[] curr = q.poll();

            if(curr[2]+1>=answer) return;

            for(int i=0; i<dx.length; i++){
                int nextX = curr[0] + dx[i];
                int nextY = curr[1] + dy[i];

                if(nextX<0 || nextX>=n || nextY<0 || nextY>=n) continue;
                if(!qvisited[nextX][nextY] && board[nextX][nextY]!=1){
                    qvisited[nextX][nextY] = true;
                    q.add(new int[]{nextX, nextY, curr[2]+1});
                    num++;
                    if(num == count){
                        answer = Math.min(answer, curr[2]+1);
                        return;
                    }
                }
            }
        }
    }

    public static void dfs(int idx, int depth){
        if(depth == m){
            bfs();
            return;
        }

        for(int i=idx; i<viruses.size(); i++){
            if(!visited[i]){
                visited[i] = true;
                arr[depth] = i;
                dfs(i,depth+1);
                visited[i] = false;
                arr[depth] = 0;
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][n];
        count = 0;

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j]==2) viruses.add(new int[]{i, j});
                if(board[i][j]!=1) count++;
            }
        }

        visited = new boolean[viruses.size()];
        arr = new int[m];

        dfs(0, 0);

        answer = answer==Integer.MAX_VALUE?-1:answer;
        System.out.println(answer);

    }
}