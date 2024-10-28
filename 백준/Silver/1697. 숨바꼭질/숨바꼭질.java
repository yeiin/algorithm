import java.util.*;

public class Main{

    public static class Node{
        int x;
        int move;

        public Node(int x, int move){
            this.x = x;
            this.move = move;
        }

    }
 


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        boolean[] visited = new boolean[100001];
        Arrays.fill(visited, false);
        sc.close();
        int minimum = Math.abs(n-m);

        Queue<Node> q = new LinkedList<>();
        q.add( new Node(n, 0));
        visited[0] = true;

        while(!q.isEmpty()){
            Node curr = q.poll();

            if (curr.x == m) {
                minimum = Math.min(curr.move, minimum);
            }else{
                if(2*curr.x<=100000 && !visited[2*curr.x]){
                    q.add(new Node(2*curr.x, curr.move +1));  
                    visited[2*curr.x] = true;
                }
                if(curr.x-1>=0 && !visited[curr.x-1] ){
                    q.add(new Node(curr.x-1, curr.move +1));
                    visited[curr.x-1] = true;
                }
                if(curr.x + 1<=100000 && !visited[curr.x+1] ){
                    q.add(new Node(curr.x+1, curr.move +1));   
                    visited[curr.x+1] = true;         
                }
                
            }
        }

        System.out.println(minimum);
        
    }
}