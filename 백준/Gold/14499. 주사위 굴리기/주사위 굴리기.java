import java.io.*;
import java.util.*;

public class Main{

    static int n;
    static int m;
    static int x;
    static int y;
    static int k;
    static int[] dice = {0, 0, 0, 0, 0, 0};

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    static int[][] map;

    public static boolean roll(int directions){

        int nextX = x + dx[directions-1];
        int nextY = y + dy[directions-1];

        if(nextX>=0 && nextX<n && nextY>=0 && nextY<m){
            x = nextX;
            y = nextY;
            return true;
        }else{
            return false;
        }
    }

    public static void numbering(int directions){
        int temp = dice[2];
        switch (directions) {
            case 1:
                dice[2] = dice[3];
                dice[3] = dice[5];
                dice[5] = dice[1];
                dice[1] = temp;        
                break;
            case 2:
                dice[2] = dice[1];
                dice[1] = dice[5];
                dice[5] = dice[3];
                dice[3] = temp;   
                break;
            case 3:
                dice[2] = dice[4];
                dice[4] = dice[5];
                dice[5] = dice[0];
                dice[0] = temp;
                break;
            case 4:
                dice[2] = dice[0];
                dice[0] = dice[5];
                dice[5] = dice[4];
                dice[4] = temp;
                break;
            default:
                break;
        }


        if(map[x][y]==0){
            map[x][y] = dice[5];
        }else{
            dice[5] = map[x][y];
            map[x][y] = 0;
        }

        System.out.println(dice[2]);
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        int[] inst = new int[k];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<k; i++){
            inst[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<k; i++){ 
            if(roll(inst[i])){
                numbering(inst[i]);
            }           
        }
    }
}