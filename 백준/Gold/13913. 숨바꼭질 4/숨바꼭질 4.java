import java.util.*;

public class Main{

    static boolean[] visited = new boolean[100001];

    static class Node{
        int x;
        int time;

        public Node(int x, int time){
            this.x = x;
            this.time = time;
        }
    }

    public static boolean visit(int node){
        if( 0 <= node && node <=100000){
            if(!visited[node]){
                visited[node] = true;
                return true;
            }
            
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        Queue<Node> q = new LinkedList<>();
        int[] parent = new int[100001];
        Node start = new Node(N, 0);
        Node end =  new Node(K, 100000);

        q.add(start);
        visited[N] = true;

        while(!q.isEmpty()){

            Node curr = q.poll();

            if(curr.x == K){
                end = curr;
               break;
            }else{
                if( visit(curr.x-1) ){
                    q.add(new Node(curr.x-1, curr.time+1));
                    parent[curr.x-1] = curr.x;
                }
                if(visit(curr.x+1)){
                    q.add(new Node(curr.x+1, curr.time+1));
                    parent[curr.x+1] = curr.x;
                }
                if(visit(2*curr.x)){
                    q.add(new Node(2*curr.x, curr.time+1));
                    parent[2*curr.x] = curr.x;
                }
            }

            

        }

        System.out.println(end.time);

        int parentx = end.x;
        Stack<Integer> stack = new Stack<>();
        while(true){
            stack.push(parentx);
            if(parentx == N){
                break;
            }
            parentx = parent[parentx];
        }

        while(!stack.isEmpty()){
            int top = stack.pop();
            System.out.print(top+" ");
        }
    }
}