import java.util.*;
import java.io.*;

public class Main{

    static class Node{
        int x;
        int y;
        int horse;
        int count;

        public Node(int x, int y, int horse, int count){
            this.x = x;
            this.y = y;
            this.horse = horse;
            this.count = count;
        }
    }

    public static void main(String[] args)throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken());
        int h= Integer.parseInt(st.nextToken());
        
        int[][] arr = new int[h][w];
        boolean[][][] visited = new boolean[h][w][k+1];

        int[] mdx = {-1, 1, 0, 0};
        int[] mdy = {0, 0, -1, 1};

        int[] hdx = {-2, -1, 1, 2, -2, -1, 1, 2 };
        int[] hdy = {-1, 2, 2, 1, 1, -2, -2, -1};

        for(int i=0; i<h; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<w; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        if(arr[0][0]==1){
            System.out.println(-1);
            return;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0, 0, 0));
        visited[0][0][0] = true;


        while(!q.isEmpty()){
            Node curr = q.poll();
            if(curr.x == h-1 && curr.y == w-1){
                System.out.println(curr.count);
                return;
            }

        
            if(curr.horse<k){
                for(int i=0; i<hdx.length; i++){
                    
                    int nextX = curr.x + hdx[i];
                    int nextY = curr.y + hdy[i];
    
                    if(nextX>=0 && nextX<h && nextY >=0 && nextY<w && arr[nextX][nextY]==0 && !visited[nextX][nextY][curr.horse+1]){
                        q.add(new Node(nextX, nextY, curr.horse+1, curr.count+1));
                        visited[nextX][nextY][curr.horse+1] = true;
                    }
                    
                }

            }

            for(int i=0; i<mdx.length; i++){
               
                int nextX = curr.x + mdx[i];
                int nextY = curr.y + mdy[i];

                if(nextX>=0&&nextX<h && nextY>=0&&nextY<w && arr[nextX][nextY]==0 &&!visited[nextX][nextY][curr.horse]){
                    q.add(new Node(nextX, nextY, curr.horse, curr.count+1));
                    visited[nextX][nextY][curr.horse] = true;
                }
        
            }

            
        }

        System.out.println(-1);
        
    }
}