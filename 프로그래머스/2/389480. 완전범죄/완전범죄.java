import java.util.*;

class Node{
    int damage1;
    int damage2;
    int index;
        
    public Node(int damage1, int damage2, int index){
        this.damage1 = damage1;
        this.damage2 = damage2;
        this.index = index;
            
    }
}


class Solution {
    

    public int solution(int[][] info, int n, int m) {
        int answer = Integer.MAX_VALUE;
        boolean flag = false;

        Queue<Node> q = new LinkedList();
        boolean[][][] visited = new boolean[n][m][info.length];
        q.add(new Node(0,0,0));
        visited[0][0][0] = true;
        
        while(!q.isEmpty()){
            Node curr = q.poll();
            int index = curr.index;
            
            if(index == info.length){
                answer = Math.min(answer, curr.damage1);
                flag = true;
                continue;
            }
            
            if(curr.damage1 < answer){
                int next1 = curr.damage1 + info[index][0];
                int next2 = curr.damage2 + info[index][1];
                if(next1< n && !visited[next1][curr.damage2][index]){
                    q.add(new Node(curr.damage1 + info[index][0], curr.damage2, index+1));  
                    visited[next1][curr.damage2][index] = true;
                }
                
                if (next2< m && !visited[curr.damage1][next2][index]){
                    q.add(new Node(curr.damage1, curr.damage2 + info[index][1], index+1));
                    visited[curr.damage1][next2][index] = true;
                }
            }
        }
     
        
        return flag ? answer : -1;
    }
}