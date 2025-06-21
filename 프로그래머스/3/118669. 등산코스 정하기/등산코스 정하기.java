import java.util.*;

class Solution {
    
    class Node{
        int node;
        int intensity;
        
        public Node(int node, int intensity){
            this.node = node;
            this.intensity = intensity;
        }
    }
    
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        
        int minIntensity = Integer.MAX_VALUE;
        int minSummit = Integer.MAX_VALUE;
        
        HashMap<Integer, List<int[]>> map = new HashMap();
        HashMap<Integer, Integer> gateMap = new HashMap();
        HashMap<Integer, Integer> summitMap = new HashMap();
        
        int resultIntensity = Integer.MAX_VALUE;
        int resultSummit = Integer.MAX_VALUE;
        
        for(int[] path: paths){
            if(!map.containsKey(path[0])) map.put(path[0], new ArrayList()); 
            if(!map.containsKey(path[1])) map.put(path[1], new ArrayList());
            
            map.get(path[0]).add(new int[]{path[1], path[2]});
            map.get(path[1]).add(new int[]{path[0], path[2]});
        }

        for(Integer m: map.keySet()){
            map.get(m).sort((o1, o2) -> o2[1] - o1[1]);
        }
        
        Queue<Node> q = new LinkedList();
        
        for(int gate: gates){
            gateMap.put(gate, gate);
            q.add(new Node(gate, 0));
        }
        
        for(int summit: summits){
            summitMap.put(summit, summit);
        }
        
        int[] visited =  new int[map.size()+1];
        
        while(!q.isEmpty()){      
            Node curr = q.poll();
            
            if(summitMap.containsKey(curr.node)){   
                if(minIntensity > curr.intensity){
                    minIntensity = curr.intensity;
                    minSummit = curr.node;
                }else if(minIntensity==curr.intensity && minSummit>curr.node){
                    minSummit = curr.node;
                }
                continue;
            }
            
            if(gateMap.containsKey(curr.node) && curr.intensity !=0) continue;
            
            if(curr.intensity > minIntensity) continue;

            for(int[] route: map.get(curr.node)){
                if(visited[route[0]] > Math.max(curr.intensity, route[1]) || visited[route[0]] == 0){
                    visited[route[0]] = Math.max(curr.intensity, route[1]);
                    q.add(new Node(route[0], Math.max(curr.intensity, route[1])));
                }
            }
            
        }
        
        return new int[]{minSummit, minIntensity};
    }
}