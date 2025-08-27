import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = {0, 0};
        int min = Integer.MAX_VALUE;
        
        HashSet<String> jwls = new HashSet();
        
        for(String g: gems){
            jwls.add(g);
        }
        
        int s=0;
        int e=0;
        
        HashMap<String, Integer> search = new HashMap();
        
        while(s<=e || e<gems.length){
            if(jwls.size()>search.size()){
                if(e==gems.length) break;
                if(!search.containsKey(gems[e])){
                    search.put(gems[e], 1);
                }else{
                    search.put(gems[e], search.get(gems[e])+1);
                }                
                e++;
            }else{
                if(jwls.size()==search.size() && e-s+1<min){
                    answer = new int[]{s+1, e};
                    min = e-s+1;
                }
                
                if(search.get(gems[s])==1){
                    search.remove(gems[s]);
                }else{
                    search.put(gems[s], search.get(gems[s])-1);
                }
                s++;
            }
        }
        
        if(jwls.size()==search.size() && e-s+1<min){
            answer = new int[]{s+1, e};
            min = e-s+1;
        }
        
        return answer;
    }
}