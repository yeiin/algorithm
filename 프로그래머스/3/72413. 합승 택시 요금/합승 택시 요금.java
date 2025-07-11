import java.util.*;

class Solution {    
    
    public int solution(int n, int s, int a, int b, int[][] fares) {    
        HashMap<Integer, List<int[]>> faresMap = new HashMap();
    
        int[] oDist;
        int[] aDist;
        int[] bDist;
        int[] parents;

        int minRoute = Integer.MAX_VALUE;
        
        for(int[] fare: fares){
            
            if(!faresMap.containsKey(fare[0])){
                faresMap.put(fare[0], new ArrayList());
            }
            
            if(!faresMap.containsKey(fare[1])){
                faresMap.put(fare[1], new ArrayList());
            }
            
            faresMap.get(fare[0]).add(new int[]{fare[1], fare[2]});
            faresMap.get(fare[1]).add(new int[]{fare[0], fare[2]});
        }
            
        oDist = new int[n+1];
        aDist = new int[n+1];
        bDist = new int[n+1];
    
        Arrays.fill(oDist, Integer.MAX_VALUE);
        Arrays.fill(aDist, Integer.MAX_VALUE);
        Arrays.fill(bDist, Integer.MAX_VALUE);
        
        oDist[s] = 0;
        aDist[a] = 0;
        bDist[b] = 0;
    
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1]-o2[1]);
        pq.add(new int[]{s, 0});
        
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            
            faresMap.get(curr[0]).sort((o1, o2) -> o1[1] - o2[1]);
            
            for(int[] f: faresMap.get(curr[0])){
                
                if(oDist[f[0]]> oDist[curr[0]] + f[1]){
                    oDist[f[0]] = oDist[curr[0]] + f[1];
                    pq.add(f);
                }
            }
        }
        
        pq.add(new int[]{a, 0});
        
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            
            for(int[] f: faresMap.get(curr[0])){
                if(aDist[f[0]]> aDist[curr[0]] + f[1]){
                    aDist[f[0]] = aDist[curr[0]] + f[1];
                    pq.add(f);
                }
            }
        }
          
        pq.add(new int[]{b, 0});
        
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
                    
            for(int[] f: faresMap.get(curr[0])){
                if(bDist[f[0]]> bDist[curr[0]] + f[1]){
                    bDist[f[0]] = bDist[curr[0]] + f[1];
                    pq.add(f);
                }
            }
        }
        
        for(int i=1; i<n+1; i++){
            
            if(oDist[i]!=Integer.MAX_VALUE && aDist[i]!=Integer.MAX_VALUE && bDist[i]!=Integer.MAX_VALUE){
                minRoute = Math.min(minRoute, oDist[i]+aDist[i]+bDist[i]);
            }
        }
        
        return minRoute;
    }
}