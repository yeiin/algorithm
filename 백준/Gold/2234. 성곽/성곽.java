import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[][] board = new int[n][m];
        int[][] rooms = new int[n][m];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int roomNum = 1;

        int[] dir = {1, 2, 4, 8};
        int[] dx = {0, -1, 0, 1};
        int[] dy = {-1, 0, 1, 0};

        Queue<int[]> q = new LinkedList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

       
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(rooms[i][j]!=0) continue;

                q.clear();
                q.add(new int[]{i, j});

                int count = 1;
                rooms[i][j] = roomNum;

                while(!q.isEmpty()){
                    int[] curr = q.poll();

                    for(int x = 0; x<dir.length; x++){
                        if((dir[x] & board[curr[0]][curr[1]]) == 0){
                            int[] next =  new int[]{curr[0]+dx[x], curr[1]+dy[x]};
                            if(rooms[next[0]][next[1]]==0){
                                rooms[next[0]][next[1]] = roomNum;
                                count++;
                                q.add(next);
                            }
                        }
                    }
                }

                map.put(roomNum, count);
                roomNum ++;

            }
        }

        int totalNum = roomNum-1;
        int maxNum = 0;
        int maxRooms = 0;

        for(int i: map.keySet()){
            int temp = map.get(i);
            maxNum = Math.max(maxNum, temp);
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                for(int x=2; x<dx.length; x++){
                    int nextX = i+dx[x];
                    int nextY = j+dy[x];
                    if(nextX<0 || nextX>=n || nextY<0 || nextY>=m) continue;

                    if(rooms[i][j] != rooms[nextX][nextY]){
                        int room1 = map.get(rooms[i][j]);
                        int room2 = map.get(rooms[nextX][nextY]);

                        maxRooms = Math.max(maxRooms, room1+room2);
                    }
                }
            }
        }

        System.out.println(totalNum);
        System.out.println(maxNum);
        System.out.println(maxRooms);
    }
}