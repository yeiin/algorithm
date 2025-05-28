import java.util.*;

class Solution {

    public boolean isEven(int number){
        if(number%2==0){
            return true;
        }
        return false;
    }
    
    public int isType(int number, int childCount){
        boolean evenNode = isEven(number);
        boolean evenChild = isEven(childCount);
            
        if((evenNode && evenChild) || (!evenNode && !evenChild)){
            return 0;
        }
        
        return 1;
    }

    
    public int[] solution(int[] nodes, int[][] edges) {
        
        HashMap<Integer, List<Integer>> forest = new HashMap<>();
        HashMap<Integer, Integer> indexMap = new HashMap();
        
        int[] answer = {0,0};
        
        for(int i=0; i<nodes.length; i++){
            indexMap.put(nodes[i],i);
            forest.put(nodes[i], new ArrayList());
        }
        
        for(int[] edge: edges){
             forest.get(edge[0]).add(edge[1]);
             forest.get(edge[1]).add(edge[0]);
        }
        
        boolean[] hasGroup = new boolean[nodes.length];
        List<List<Integer>> groups = new ArrayList();
        
        Queue<Integer> q = new LinkedList();
        
        for(int root: nodes){        
            if(!hasGroup[indexMap.get(root)]){
                List<Integer> newGroup = new ArrayList();
                q.add(root);
                while(!q.isEmpty()){
                    int curr = q.poll();
                    hasGroup[indexMap.get(curr)] = true;
                    newGroup.add(curr);
                    List<Integer> subTree = forest.get(curr);
                    for(int s: subTree){
                        if(!hasGroup[indexMap.get(s)]) q.add(s);
                        
                    }
                }
                groups.add(newGroup);
            }   
        }
        
        for(List<Integer> group: groups){
            for(int root: group){
                int rootType = isType(root, forest.get(root).size());
                
                boolean flag = false;
                for(int node: group){
                    if(node == root) continue;
                    if(rootType != isType(node, forest.get(node).size()-1)){
                        flag = true;
                        break;
                    }
                }
                
                if(!flag){
                    answer[rootType]++;
                }
            } 
            
        }
        return answer;
    }
}