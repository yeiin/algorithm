import java.util.*;

class Solution {
    
    int[] fees;
    HashMap<Integer, Integer> answers = new HashMap();
    HashMap<Integer, Integer> map = new HashMap();
    
    public int timeToInt(String time){
        String[] times = time.split(":");
        return Integer.parseInt(times[0])*60 + Integer.parseInt(times[1]);
    }
    
    public int getFee(int roundTime){
        int result = fees[1];
        roundTime -= fees[0];
        
        if(roundTime>0){
            int a = roundTime/fees[2];
            if(roundTime%fees[2] != 0) a++;
            result += a*fees[3];
        }

        return result;
    }
    
    public int[] solution(int[] fees, String[] records) {
        this.fees = fees;
        
        for(String r: records){
            
            String[] record = r.split(" ");
            int key = Integer.parseInt(record[1]);
                        
            if(record[2].equals("IN")){
                map.put(key, timeToInt(record[0]));
            }else if(map.containsKey(key)){        
                
                int roundTime = timeToInt(record[0]) - map.get(key);
                if(answers.containsKey(key)) {
                    roundTime += answers.get(key);
                }
                
                map.remove(key);
                answers.put(key, roundTime);
            }
        }
        
        for(int key: map.keySet()){
            int roundTime = timeToInt("23:59") - map.get(key);

            if(answers.containsKey(key)) {
                    roundTime += answers.get(key);
            }
                
            answers.put(key, roundTime);
        }
                
        List<Integer> keyList = new ArrayList<>(answers.keySet());
        Collections.sort(keyList);
        int[] results = new int[keyList.size()];
        
        int index = 0;    
        
        for(int key: keyList){
            results[index++] = getFee(answers.get(key));
        }
        
        return results;
    }
}