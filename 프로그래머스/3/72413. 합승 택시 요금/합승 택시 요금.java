import java.util.*;

class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;
        
        HashMap<Integer, List<int[]>> map = new HashMap<>();
        
        for(int[] f: fares){
            if(!map.containsKey(f[0])){
                map.put(f[0], new LinkedList());
            }
            
            if(!map.containsKey(f[1])){
                map.put(f[1], new LinkedList());
            }
            
            map.get(f[0]).add(new int[]{f[1], f[2]});
            map.get(f[1]).add(new int[]{f[0], f[2]});
        }
    
        
        int[] sDist = new int[n+1];
        int[] aDist = new int[n+1];
        int[] bDist = new int[n+1];
        
        Arrays.fill(sDist, Integer.MAX_VALUE);
        Arrays.fill(aDist, Integer.MAX_VALUE);
        Arrays.fill(bDist, Integer.MAX_VALUE);
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2)->{return o1[1]-o2[1];});
        pq.add(new int[]{s, 0});
        sDist[s]=0;
        
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            
            for(int[] t: map.get(curr[0])){
                if(sDist[t[0]]>(sDist[curr[0]]+t[1])){
                    sDist[t[0]] = sDist[curr[0]]+t[1];
                    pq.add(t);
                }
                
            }
        }
        
        pq.add(new int[]{a, 0});
        aDist[a]=0;
        
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            
            for(int[] t: map.get(curr[0])){
                if(aDist[t[0]]>(aDist[curr[0]]+t[1])){
                    aDist[t[0]] = aDist[curr[0]]+t[1];
                    pq.add(t);
                }
                
            }
        }
        
        pq.add(new int[]{b, 0});
        bDist[b]=0;
        
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            
            for(int[] t: map.get(curr[0])){
                if(bDist[t[0]]>(bDist[curr[0]]+t[1])){
                    bDist[t[0]] = bDist[curr[0]]+t[1];
                    pq.add(t);
                }
                
            }
        }
        
        for(int i=1; i<=n; i++){
            if(sDist[i]==Integer.MAX_VALUE||aDist[i]==Integer.MAX_VALUE||bDist[i]==Integer.MAX_VALUE) continue;
            answer = Math.min(answer, sDist[i]+aDist[i]+bDist[i]);
        }
        
        return answer;
    }
}