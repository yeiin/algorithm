import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] board = new int[n][m];
        boolean[][] visited = new boolean[n][m];

        for(int i=0; i<n; i++){
            String[] temps = br.readLine().split("");
            for(int j=0; j<m; j++){
                board[i][j] = Integer.parseInt(temps[j]);
            }
        }

        HashMap<Integer, Integer> map = new HashMap<>();

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(board[i][j]==0 && !visited[i][j]){

                    int group = map.size()+2;
                    int count = 1;
                    
                    Queue<int[]> q = new LinkedList<>();
                    q.add(new int[]{i, j});
                    visited[i][j] = true;
                    board[i][j] = group;

                    while(!q.isEmpty()){
                        int[] curr = q.poll();

                        for(int k=0; k<dx.length; k++){
                            int nextX = curr[0] + dx[k];
                            int nextY = curr[1] + dy[k];

                            if(nextX<0 || nextX>=n || nextY<0 || nextY>=m) continue;
                            if(board[nextX][nextY]==1 || visited[nextX][nextY]) continue;

                            visited[nextX][nextY] = true;
                            board[nextX][nextY] = group;
                            count++;
                            q.add(new int[]{nextX, nextY});
                        }

                    }
                    map.put(group, count);
                }
            }
        }
        int[][] answer = new int[n][m];

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(board[i][j]==1){              
                    int count = 1;

                    HashSet<Integer> groups = new HashSet<>();

                    for(int k=0; k<dx.length; k++){
                        int nextX = i + dx[k];
                        int nextY = j + dy[k];

                        if(nextX<0 || nextX>=n || nextY<0 || nextY>=m) continue;
                        if(board[nextX][nextY]==1) continue;

                        groups.add(board[nextX][nextY]);
                    }

                    for(int g: groups){
                        count += map.get(g);
                    }
                    
                    answer[i][j] = count%10;
                }else{
                    answer[i][j] = 0;
                }
            }
        }


        for(int i=0; i<n; i++){
            StringBuilder sb = new StringBuilder();
            for(int j=0; j<m; j++) sb.append(answer[i][j]);
            System.out.println(sb.toString());
        }
    }
}