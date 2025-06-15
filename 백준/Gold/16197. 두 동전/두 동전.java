import java.io.*;
import java.util.*;

public class Main{

    static int n;
    static int m;

    static class Node{
        
        int[] marble1;
        int[] marble2;

        int count;
       
        public Node(int[] marble1, int[] marble2, int count){
            this.marble1 = marble1;
            this.marble2 = marble2;
            this.count = count;
        }
    }


    public static boolean rangeCheck(int[] num){
        if(num[0]<0 || num[0]>=n) return false;
        if(num[1]<0 || num[1]>=m) return false;

       return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        String[][] map = new String[n][m];
        List<int[]> marbles = new ArrayList<>();

        boolean[][] visited1 = new boolean[n][m];
        boolean[][] visited2 = new boolean[n][m];

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for(int i=0; i<n; i++){
            map[i] = br.readLine().split("");
            for(int j=0; j<m; j++){
                if(map[i][j].equals("o")) marbles.add(new int[]{i, j});
            }
        }

        visited1[marbles.get(0)[0]][marbles.get(0)[1]] = true;
        visited2[marbles.get(1)[0]][marbles.get(1)[1]] = true;

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(marbles.get(0), marbles.get(1), 0));

        while (!q.isEmpty()) {
            Node curr = q.poll();
            
            if((rangeCheck(curr.marble1) && !rangeCheck(curr.marble2)) 
                || (!rangeCheck(curr.marble1)&& rangeCheck(curr.marble2)) ){
                System.out.println(curr.count);
                break;
            }

            if(curr.count>10){
                System.out.println(-1);
                break;
            }
            
            if(!rangeCheck(curr.marble1) || !rangeCheck(curr.marble2)) continue;

            for(int i=0; i<dx.length; i++){

                int[] nextMarble1 = new int[2];
                int[] nextMarble2 = new int[2];

                nextMarble1[0] = curr.marble1[0] + dx[i];
                nextMarble1[1] = curr.marble1[1] + dy[i];
                nextMarble2[0] = curr.marble2[0] + dx[i];
                nextMarble2[1] = curr.marble2[1] + dy[i];

                boolean can1 = true;
                boolean can2 = true;

                if(rangeCheck(nextMarble1)){
                    if(map[nextMarble1[0]][nextMarble1[1]].equals("#")){
                        nextMarble1 = curr.marble1;
                    }else{
                        if(!visited1[nextMarble1[0]][nextMarble1[1]]) can1 = true;
                    }
                }

                if(rangeCheck(nextMarble2)){
                    if(map[nextMarble2[0]][nextMarble2[1]].equals("#")){
                        nextMarble2 = curr.marble2;
                    }else{
                        if(!visited2[nextMarble2[0]][nextMarble2[1]]) can2 = true;
                    }
                }
                
              
                if(can1 && can2)
                    q.add(new Node(nextMarble1, nextMarble2, curr.count+1));

            }
        }
    }
}