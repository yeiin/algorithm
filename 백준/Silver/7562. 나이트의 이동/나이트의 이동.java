import java.util.*;

public class Main{

    public static class Node{
        int x;
        int y;
        int count;

        public Node(int x, int y, int count){
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testNum = sc.nextInt();

        for(int i=0; i<testNum; i++){
            int N = sc.nextInt();
            boolean[][] visited = new boolean[N][N];

            int[] dx = {-2, -1, 1, 2, -2, -1, 1, 2};
            int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};

            Queue<Node> q = new LinkedList<>();
            int x = sc.nextInt();
            int y = sc.nextInt();

            int finishX = sc.nextInt();
            int finishY = sc.nextInt();

            q.add(new Node(x, y, 0));
            visited[x][y] = true;

            while (!q.isEmpty()) {
                Node curr = q.poll();

                if(curr.x == finishX && curr.y == finishY){
                    System.out.println(curr.count);
                    break;
                }

                for(int j=0; j<dx.length; j++){
                    int nextX = curr.x + dx[j];
                    int nextY = curr.y + dy[j];

                    if(nextX>=0 && nextX<N && nextY>=0 && nextY<N){
                        if(!visited[nextX][nextY]){
                            q.add(new Node(nextX, nextY, curr.count+1));
                            visited[nextX][nextY] = true;
                        }
                    }
                }
            }


        }

        sc.close();
    }
}