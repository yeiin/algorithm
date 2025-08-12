import java.io.*;
import java.util.*;

public class Main {

    static HashSet<String> visited = new HashSet<>();
    static Queue<Node> q = new LinkedList<>();
    static Node end = new Node();

    static class Node{
        Stack<Character> aTower = new Stack<>();
        Stack<Character> bTower = new Stack<>();
        Stack<Character> cTower = new Stack<>();

        int time = 0;

        public String getState(){
            String result = "";
            for(char c: aTower) result += c;
            result+=",";
            for(char c: bTower) result += c;
            result+=",";
            for(char c: cTower) result += c;
            return result;
        }
    }

    public static int bfs(){
        String endState = end.getState();

        while (!q.isEmpty()) {
            Node curr = q.poll();

            if(curr.getState().equals(endState)) return curr.time;

            if(!curr.aTower.isEmpty()){
                Node bNode = copyNode(curr);
                char aTop = bNode.aTower.pop();
                bNode.bTower.add(aTop);
                bNode.time++;

                if(!visited.contains(bNode.getState())){
                    visited.add(bNode.getState());
                    q.add(bNode);
                }

                Node cNode = copyNode(curr);
                aTop = cNode.aTower.pop();
                cNode.cTower.add(aTop);
                cNode.time++;

                if(!visited.contains(cNode.getState())){
                    visited.add(cNode.getState());
                    q.add(cNode);
                }
            }

            if(!curr.bTower.isEmpty()){
                Node aNode = copyNode(curr);
                char bTop = aNode.bTower.pop();
                aNode.aTower.add(bTop);
                aNode.time++;

                if(!visited.contains(aNode.getState())){
                    visited.add(aNode.getState());
                    q.add(aNode);
                }

                Node cNode = copyNode(curr);
                bTop = cNode.bTower.pop();
                cNode.cTower.add(bTop);
                cNode.time++;

                if(!visited.contains(cNode.getState())){
                    visited.add(cNode.getState());
                    q.add(cNode);
                }
            }

            if(!curr.cTower.isEmpty()){
                Node aNode = copyNode(curr);
                char cTop = aNode.cTower.pop();
                aNode.aTower.add(cTop);
                aNode.time++;

                if(!visited.contains(aNode.getState())){
                    visited.add(aNode.getState());
                    q.add(aNode);
                }

                Node bNode = copyNode(curr);
                cTop = bNode.cTower.pop();
                bNode.bTower.add(cTop);
                bNode.time++;

                if(!visited.contains(bNode.getState())){
                    visited.add(bNode.getState());
                    q.add(bNode);
                }
            }
        
        }
        

        return 0;
    }

    public static Node copyNode(Node past){
        Node result = new Node();

        for(char c: past.aTower) result.aTower.add(c);
        for(char c: past.bTower) result.bTower.add(c);
        for(char c: past.cTower) result.cTower.add(c);

        result.time = past.time;

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Node start = new Node();

        StringTokenizer st = new StringTokenizer(br.readLine());

        if(Integer.parseInt(st.nextToken())!=0){
            for(Character c: st.nextToken().toCharArray()){ 
                if(c=='A') end.aTower.add('A');      
                else if(c=='B') end.bTower.add('B');      
                else end.cTower.add('C');      
                start.aTower.add(c);
            }
        }

        st = new StringTokenizer(br.readLine());
        if(Integer.parseInt(st.nextToken())!=0){
            for(Character c: st.nextToken().toCharArray()){ 
                if(c=='A') end.aTower.add('A');      
                else if(c=='B') end.bTower.add('B');      
                else end.cTower.add('C');     
                start.bTower.add(c);
            }
        }

        st = new StringTokenizer(br.readLine());
        if(Integer.parseInt(st.nextToken())!=0){
            for(Character c: st.nextToken().toCharArray()){ 
                if(c=='A') end.aTower.add('A');      
                else if(c=='B') end.bTower.add('B');      
                else end.cTower.add('C');     
                start.cTower.add(c);
            }
        }
        
        q.add(start);
        visited.add(start.getState());
        System.out.println(bfs());
    }
}
