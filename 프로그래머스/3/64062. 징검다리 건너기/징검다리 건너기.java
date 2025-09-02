import java.util.*;

class Solution {
    public int solution(int[] stones, int k) {
        int answer = Integer.MAX_VALUE;
        
        int start = 0;
        int end = k-1;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2)->{
            return o2[1]-o1[1];
        });
        
        for(int i=start; i<end; i++){
            pq.add(new int[]{i, stones[i]});
        }
        
        while(end<stones.length){
            pq.add(new int[]{end, stones[end]});
            while(true){
                int[] curr = pq.peek();
                
                if(curr[0]>=start && curr[0]<=end){
                    answer = Math.min(answer, curr[1]);
                    break;
                }
                pq.poll();
            }
            
            
            start++;
            end++;
            
        }
        
        return answer;
    }
}