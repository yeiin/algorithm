import java.util.*;

public class Main{

    static class Node{
        int x;
        int count;

        public Node(int x, int count){
            this.x = x;
            this.count = count;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        sc.close();
        int result = Math.abs(N-K);

        Queue<Node> q = new LinkedList<>();
        boolean[] visited = new boolean[100001];
        q.add(new Node(N,0));
        visited[N] = true;

        while (!q.isEmpty()) {

            Node curr = q.poll();

            if(curr.x == K){
                result = curr.count;
                break;
            }

            if(curr.count <= result){

                int next = 2 * curr.x;
                
                while(next!=0 && next<=100000){
                    if(!visited[next]){
                        q.add(new Node(next, curr.count));
                        visited[next] = true;
                    }
                    next *= 2;
                }
                
                if(curr.x-1>=0 && !visited[curr.x-1]){
                    q.add(new Node(curr.x-1, curr.count+1));
                    visited[curr.x-1] = true;
            }

                if(curr.x+1<=100000 && !visited[curr.x+1] ){
                        q.add(new Node(curr.x+1, curr.count+1));
                        visited[curr.x+1] = true;
                }
    
                
            }
            
        }
        System.out.println(result);
    }
}