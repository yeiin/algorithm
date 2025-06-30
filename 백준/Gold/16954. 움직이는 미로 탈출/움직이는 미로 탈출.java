import java.util.*;
import java.io.*;

public class Main{

    static char[] newLine = {'.', '.','.','.','.','.','.','.'};
    static List<char[][]> chessList = new ArrayList<>();

    static class Node{

        int[] point;
        int count = 0;

        public Node(int[] point, int count){
            this.point = point;
            this.count = count;
        }
    }

    public static char[][] moveMap (char[][] m){
        char[][] result = new char[8][8];
        result[0] = newLine.clone();

        for(int i=1; i<8; i++){
            result[i] = m[i-1].clone();
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        char[][] chess = new char[8][8];

        for(int i=0; i<8; i++){
            chess[i] = br.readLine().toCharArray();
        }

        int answer = 0;
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(new int[]{7, 0}, 0));

        int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0, 0};
        int[] dy = {0, -1, 1, 1, 1, 0, -1, -1, 0}; 

        for(int i=0; i<8; i++){
            chessList.add(chess);
            chess = moveMap(chess);
        }    

        while (!q.isEmpty()) {
            
            Node curr = q.poll();

            if(curr.point[0] == 0 && curr.point[1]==7){
                answer = 1;
                break;
            }

            for(int i=0; i<dx.length; i++){
                int nextX = curr.point[0] + dx[i];
                int nextY = curr.point[1] + dy[i];

                if(nextX>=0 && nextX <8 && nextY>=0 && nextY<8){
                    if(chessList.get(curr.count)[nextX][nextY] != '#'){
                        int nextCount = curr.count+1;
                        if(nextCount>=8) nextCount = 7;

                        if(chessList.get(nextCount)[nextX][nextY] != '#'){
                            q.add(new Node(new int[]{nextX, nextY},  nextCount));
                        }
                    }
                }
            }
        }

        System.out.println(answer);

    }
}