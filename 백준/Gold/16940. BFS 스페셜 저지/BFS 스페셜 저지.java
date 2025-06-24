import java.util.*;
import java.io.*;

class Main{

    static class Node{
        int number;
        int depth;

        public Node(int number, int depth){
            this.number = number;
            this.depth = depth;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashMap<Integer, List<Integer>> tree = new HashMap<>();
        StringTokenizer st;
        
        for(int i=0; i<n-1; i++){
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            
            if(!tree.containsKey(n1)){
                tree.put(n1, new ArrayList<>());
            }

            if(!tree.containsKey(n2)){
                tree.put(n2, new ArrayList<>());
            }

            tree.get(n2).add(n1);
            tree.get(n1).add(n2);
        }

        int[] arr = new int[n];
        
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(1, 0));
        
        boolean[] visited = new boolean[n+1];
        visited[1] = true;

        if(arr[0]!=1){
            System.out.println(0);
            return;
        }

        int index = 1;

        while(!q.isEmpty()){

            Node curr = q.poll();

            if(!tree.containsKey(curr.number)){
                continue;
            }
            HashSet<Integer> children = new HashSet<>();
            for(int i: tree.get(curr.number)){
                if(!visited[i]) children.add(i);
            }
            
            for(int i=index; i<index+children.size(); i++){
                if(!children.contains(arr[i])){
                    System.out.println(0);
                    return;
                }
                visited[arr[i]] = true;
                q.add(new Node(arr[i], curr.depth+1));
            }
            index+=children.size();
        }
       
        System.out.println(1);
    }
}