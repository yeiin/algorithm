import java.util.*;
import java.io.*;

class Solution {
    int answer = Integer.MAX_VALUE;
    
    int n;
    int m;
    
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    
    List<int[]> findList = new LinkedList();
    HashMap<Integer, List<int[]>> map = new HashMap();
    
    int[] arr;
    boolean[] visited;
    
    public void makeFindList(int depth, int node){
        
        if(depth == arr.length){
            findList.add(arr.clone());
            return;
        }
        
        for(int i=0; i<arr.length; i++){
            if(!visited[i]){
                arr[depth] = i+1;
                visited[i] = true;
                makeFindList(depth+1, i);
                visited[i] = false;
                arr[depth] = 0;
            }
        }
    }
    
//     public int findStep(int[][] board, int x, int y, int gX, int gY){
//         int result = 0;
        
//         //x먼저 옮기기
//         int ctrlX = 0;
//         int moveX = 0;
//         int tempX = x;
        
//         int ctrlY = 0;
//         int moveY = 0;
//         int tempY = y;

//         while(tempX!=gX){
//             if(board[tempX][tempY]!=0){
//                 ctrlX ++;
//                 moveX = ctrlX;
//             }
//             moveX ++;
//             tempX = tempX<gX ? tempX+1: tempX-1;
//         }
        
//         while(tempY!=gY){
//             if(board[tempX][tempY]!=0){
//                 ctrlY ++;
//                 moveY = ctrlY;
//             }
//             moveY ++;
//             tempY = tempY<gY ? tempY+1: tempY-1;
//         }
        
//         result = moveX + moveY;
        
//         //y먼저 옮기기
//         ctrlX = 0;
//         moveX = 0;
//         tempX = x;
        
//         ctrlY = 0;
//         moveY = 0;
//         tempY = y;

//         while(tempY!=gY){
//             if(board[tempX][tempY]!=0){
//                 ctrlY ++;
//                 moveY = ctrlY;
//             }
//             moveY ++;
//             tempY = tempY<gY ? tempY+1: tempY-1;
//         }
        
//         while(tempX!=gX){
//             if(board[tempX][tempY]!=0){
//                 ctrlX ++;
//                 moveX = ctrlX;
//             }
//             moveX ++;
//             tempX = tempX<gX ? tempX+1: tempX-1;
//         }
        
//         result = Math.min(result, moveX + moveY);
        
//         return result;       
//     }
    
    public int bfs(int[][] board, int sx, int sy, int gx, int gy) {
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sx, sy, 0});
        visited[sx][sy] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1], cost = cur[2];

            if (x == gx && y == gy) return cost;

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d], ny = y + dy[d];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny, cost + 1});
                }

                int cx = x; 
                int cy = y;
                while (true) {
                    int nxCtrl = cx + dx[d], nyCtrl = cy + dy[d];
                    if (!(nxCtrl >= 0 && nxCtrl < n && nyCtrl >= 0 && nyCtrl < m)) break;
                    cx = nxCtrl;
                    cy = nyCtrl;
                    if (board[cx][cy] != 0) break;
                }

                if (!visited[cx][cy]) {
                    visited[cx][cy] = true;
                    q.add(new int[]{cx, cy, cost + 1});
                }
            }
        }

        return Integer.MAX_VALUE;
    }
    
    public void dfs(int[] arr, int[][] board, int x, int y, int depth, int result){
        if(depth == arr.length){
            answer = Math.min(answer, result);
            return;
        }
        
        if(result>=answer) return;
        
        List<int[]> depthNode = map.get(arr[depth]);
        
        int[] first = depthNode.get(0);
        int[] second = depthNode.get(1);
        
        int nextResult = 0;
        
        //1번 먼저
        nextResult = result + bfs(board, x, y, first[0], first[1]) + 2;
        board[first[0]][first[1]] = 0;
        nextResult += bfs(board, first[0], first[1], second[0], second[1]);
        board[second[0]][second[1]] = 0;
        
        dfs(arr, board, second[0], second[1], depth+1, nextResult);
        
        board[first[0]][first[1]] = arr[depth];
        board[second[0]][second[1]] = arr[depth];
        
        //2번 먼저
        nextResult = result + bfs(board, x, y, second[0], second[1]) + 2;
        board[second[0]][second[1]] = 0;
        nextResult += bfs(board, second[0], second[1], first[0], first[1]);
        board[first[0]][first[1]] = 0;
        
        dfs(arr, board, first[0], first[1], depth+1, nextResult);
        
        board[first[0]][first[1]] = arr[depth];
        board[second[0]][second[1]] = arr[depth]; 
    }
    
    
    public int solution(int[][] board, int r, int c) {
        this.n = board.length;
        this.m = board[0].length;
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(board[i][j]!=0){
                    if(!map.containsKey(board[i][j])) map.put(board[i][j], new ArrayList());
                    map.get(board[i][j]).add(new int[]{i, j});
                } 
            }
        }
        
        arr = new int[map.size()];
        visited = new boolean[map.size()];
        makeFindList(0,0);
        
        for(int[] a: findList){
            dfs(a, board, r, c, 0, 0);
        }
        
        return answer;
    }
}