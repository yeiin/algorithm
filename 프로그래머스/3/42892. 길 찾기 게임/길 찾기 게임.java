import java.util.*;

class Solution {
    List<Integer> pre = new ArrayList();
    List<Integer> post = new ArrayList();
    
    int[][] nodeinfo;
    
    public void dfs(List<int[]> nodes){
        
        if(nodes.size()==1) {
            pre.add(nodes.get(0)[0]);
            post.add(nodes.get(0)[0]);
            return;
        }
                
        int max = 0;
        int index = 0;
        
        for(int i=0; i<nodes.size(); i++){
            int[] curr = nodes.get(i);
            if(curr[2]>max){
                max = curr[2];
                index = i;
            }
        }
        
        List<int[]> left = new ArrayList();
        List<int[]> right = new ArrayList();
        for(int i=0; i<index; i++){
            left.add(nodes.get(i));
        }
        
        for(int i=index+1; i<nodes.size(); i++){
            right.add(nodes.get(i));
        }
        
        pre.add(nodes.get(index)[0]);
        if(!left.isEmpty()) dfs(left); 
        if(!right.isEmpty()) dfs(right);        
        post.add(nodes.get(index)[0]);
    }
    
    public int[][] solution(int[][] nodeinfo) {
        int[][] answer = new int[2][nodeinfo.length];
        this.nodeinfo = nodeinfo;
        
        List<int[]> nodes = new ArrayList();
        
        for(int i=0; i<nodeinfo.length; i++){
            nodes.add(new int[]{i+1, nodeinfo[i][0], nodeinfo[i][1]});
        }
        
        Collections.sort(nodes, (o1, o2) -> o1[1]-o2[1]);
        
        dfs(nodes);
        
        for(int i=0; i<pre.size(); i++){
            answer[0][i] = pre.get(i);
            answer[1][i] = post.get(i);
        }
        return answer;
    }
}