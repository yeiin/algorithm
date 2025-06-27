import java.util.*;
import java.io.*;

class Main{

    static int n;
    static int m;

    static List<int[]> findList = new ArrayList<>();
    static boolean[] visited;
    static int[] arr = new int[3];
    
    public static void dfs(int depth, int index){
        
        if(depth==3){
            findList.add(arr.clone());
            return;
        }

        for(int i=index; i<visited.length; i++){
            if(!visited[i]){
                visited[i] = true;
                arr[depth] = i;
                dfs(depth+1, i);
                visited[i] = false;
            }
        }
    }


    public static int[][] deepCopy(int[][] past){
        int[][] newArr = new int[n][m];

        for(int i=0; i<n; i++){
            newArr[i] = past[i].clone();
        }

        return newArr;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];

        List<int[]> zeroList = new LinkedList<>();

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==0) zeroList.add(new int[]{i, j});
            }
        }

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        visited = new boolean[zeroList.size()];

        dfs(0, 0);
        int answer = 0;

 
        
        for(int[] numbers: findList){

            int[][] nBoard = deepCopy(map);

            for(int num: numbers){
                int[] temp = zeroList.get(num);
                nBoard[temp[0]][temp[1]] = 1;
            }

            int cnt = 3;

            for(int x =0; x<n; x++){
                for(int y=0; y<m; y++){
                    if(nBoard[x][y] == 2){
                        Queue<int[]> q = new LinkedList<>();
                        q.add(new int[]{x, y});
                        while (!q.isEmpty()) {
                            int[] curr = q.poll();
                            
                            for(int k=0; k<dx.length; k++){
                                int nX = curr[0]+dx[k];
                                int nY = curr[1]+dy[k];

                                if(nX>=0 && nX<n && nY>=0 && nY<m){
                                    if(nBoard[nX][nY]==0){
                                        nBoard[nX][nY] = 3;
                                        q.add(new int[]{nX, nY});
                                        cnt++;
                                    }
                                }
                            }

                        }
                    }
                }
            }


            answer = Math.max(answer, zeroList.size() - cnt);
            
            
            

            
        }

        System.out.println(answer);

    }
}