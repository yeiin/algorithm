import java.io.*;
import java.util.*;

class Main{

    static class Node{
        long num;
        int count;
        String operations;

        public Node(long num, int count, String operations){
            this.num = num;
            this.count = count;
            this.operations = operations;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
    
        int s = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        char[] op = {'*', '+', '-', '/'};

        HashSet<Long> set = new HashSet<>();

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(s, 0, ""));
        set.add(Integer.toUnsignedLong(s));

        while (!q.isEmpty()) {

            Node curr = q.poll();

            if(curr.num==t){
                if (curr.count==0) {
                    System.out.println(curr.count);
                }else{
                    System.out.println(curr.operations);
                }                
                return;
            }

            for(int i=0; i<op.length; i++){
                long next = -1;
                if(op[i]=='+'){
                    next = curr.num+curr.num;
                }else if(op[i]=='-'){
                    next = curr.num-curr.num;       
                }else if(op[i]=='*'){
                    next = curr.num * curr.num;
                }else if(curr.num != 0){
                    next = curr.num/curr.num;
                }

                if(!set.contains(next) && next != -1){
                    set.add(next);
                    q.add(new Node(next, curr.count+1, curr.operations+op[i]));
                }
            }            
        }

        System.out.println(-1);
    }
}