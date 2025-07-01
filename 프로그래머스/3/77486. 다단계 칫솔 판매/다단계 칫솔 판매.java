import java.util.*;

class Solution {
        
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] moneys = new int[enroll.length];
        int[] parents = new int[enroll.length];
    
        HashMap<String, Integer> indexMap = new HashMap();
        
        for(int i=0; i<enroll.length;i++){
            indexMap.put(enroll[i], i);
            if(!referral[i].equals("-")){
                
                parents[i] = indexMap.get(referral[i]);
            }else{
                parents[i] = -1;
            }
        }
        
        for(int i=0; i<seller.length; i++){
            int index = indexMap.get(seller[i]);
            int m = amount[i] * 100;
            
            while(true){
                
                if((m*0.1)<1){
                    moneys[index] += m;
                    break;
                }
                
            
                moneys[index] += Math.ceil(m * 0.9);
                
                if(parents[index] == -1){
                    break;
                }
                m -= Math.ceil(m * 0.9);
                index = parents[index];
            }
        }
        
        return moneys;
    }
}