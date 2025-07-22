import java.util.*;
import java.io.*;

class Main{
    static int answer = Integer.MAX_VALUE;
    
    static int n;
    static int m;
    
    static int count;

    static int[][] board; 
    static int[] numbers;
    static boolean[] numbersVistied;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    static List<int[]> viruses = new ArrayList<>();

    public static void bfs(){
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];

        int cnt = 0;

        for(int i: numbers){
            int[] node = viruses.get(i);
            q.add(node);
            visited[node[0]][node[1]] = true;   
        }

        while(!q.isEmpty()){
            int[] curr = q.poll();

            if(curr[2] >= answer) break;

            for(int x=0; x<dx.length; x++){
                int nextX = curr[0] + dx[x];
                int nextY = curr[1] + dy[x];

                if(nextX<0 || nextX>=n || nextY<0 || nextY>=n) continue;

                if(!visited[nextX][nextY] && board[nextX][nextY] !=1){
                    visited[nextX][nextY] = true;
                    if(board[nextX][nextY] == 0) cnt++;
                    q.add(new int[]{nextX, nextY, curr[2]+1});
                }
            }

            if(cnt==count){
                answer = Math.min(answer, curr[2]+1);
                break;
            }
           
        }
    }

    public static void dfs(int index, int depth){
        if(depth==m){
            bfs();
            return;
        }

        for(int i=index; i<viruses.size(); i++){
            if(!numbersVistied[i]){
                numbers[depth] = i;
                numbersVistied[i] = true;
                dfs(i, depth+1);
                numbers[depth] = 0;
                numbersVistied[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][n];
        numbers = new int[m];
        

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j]==2){
                    viruses.add(new int[]{i, j, 0});
                }
                if(board[i][j]==0) count++;
            }
        }

        numbersVistied = new boolean[viruses.size()];
        if(count==0){
            System.out.println(0);
            return;
        }

        dfs(0,0);
        
        answer = answer==Integer.MAX_VALUE ? -1:answer;
        System.out.println(answer);
    }
}