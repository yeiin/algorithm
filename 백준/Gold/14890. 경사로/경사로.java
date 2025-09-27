import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        int answer = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        int[][] board = new int[n][n];
        boolean[][] visited = new boolean[n][n];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<n; i++){
            int s = board[i][0];
            boolean flag = true;

            for(int j=1; j<n; j++){
                if(visited[i][j] || board[i][j]==s) continue;
                if(Math.abs(board[i][j]-s)!=1){
                    flag = false;
                    break;
                }

                if(board[i][j]<s){
                    if(j+l>n){
                        flag = false;
                        break;
                    }

                    for(int k=j; k<j+l; k++){
                        if(board[i][k]!=board[i][j] || visited[i][k]){
                            flag = false;
                            break;
                        }
                        visited[i][k] = true;
                    }

                    if(!flag) break;
                    s = board[i][j];
                }else{
                    if(j-l<0){
                        flag = false;
                        break;
                    }
                    for(int k=j-l; k<j; k++){
                        if(board[i][k]!=board[i][j]-1 || visited[i][k]){
                            flag = false;
                            break;
                        }
                        visited[i][k] = true;
                    }

                    if(!flag) break;
                    s = board[i][j];
                }
            }

            if(flag){
                answer++;
            }
        }

        visited = new boolean[n][n];

        for(int j=0; j<n; j++){
            int s = board[0][j];
            boolean flag = true;

            for(int i=1; i<n; i++){                
                if(board[i][j]==s ||visited[i][j]) continue;

                if(Math.abs(board[i][j]-s)!=1){
                    flag = false;
                    break;
                }
                
                if(board[i][j]>s){
                    if(i-l<0){
                        flag = false;
                        break;
                    }

                    for(int k=i-l; k<i; k++){
                        if(board[k][j]!=board[i][j]-1 || visited[k][j]){
                            flag = false;
                            break;
                        }

                        visited[k][j] = true;
                    }
                }else{
                    if(i+l>n || board[i][j]!=s-1){
                        flag = false;
                        break;
                    }

                    for(int k=i; k<i+l; k++){
                        if(board[k][j]!=board[i][j] || visited[k][j]){
                            flag = false;
                            break;
                        }
                        visited[k][j] = true;
                    }
                }

                if(!flag) break;
                else s = board[i][j];
            }
            if(flag){
                answer++;
            }
           
        }

        System.out.println(answer);
    }
}
