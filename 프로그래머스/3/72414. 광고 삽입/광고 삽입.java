import java.util.*;

class Solution {
    
    public int timeToSecond(String time){
        int result = 0;
        String[] strings = time.split(":");
        
        result += Integer.parseInt(strings[0]) * 3600;
        result += Integer.parseInt(strings[1]) * 60;
        result += Integer.parseInt(strings[2]);
         
        return result;
    }
    
    public String secondToTime(int second){
        String[] time = new String[3];
        
        time[0] = Integer.toString(second/3600);
        second%=3600;
        
        time[1] = Integer.toString(second/60);
        second%=60;
        
        time[2] = Integer.toString(second);
        
        for(int i=0; i<3; i++){
            if(time[i].length()==1) time[i] = "0"+time[i];
        }
        
        return String.join(":", time);
    }
    
    public String solution(String play_time, String adv_time, String[] logs) {
        
        int playTime = timeToSecond(play_time);
        int advTime = timeToSecond(adv_time);
        int lastUserTime = 0;
        
        int[] playArr = new int[playTime+1];
        
        for(String log: logs){
            String[] timeLog = log.split("-");
            
            int startTime = timeToSecond(timeLog[0]);
            int endTime = timeToSecond(timeLog[1]);
            lastUserTime = Math.max(lastUserTime, endTime);
            
            playArr[startTime]++;
            if(endTime<=playTime){
                playArr[endTime] --;
            }  
        }
        
        for(int i=1; i<playArr.length; i++){
            playArr[i] += playArr[i-1];
        }
        
        int startIdx = 0;
        int endIdx = advTime;
        long count = 0;
        
        for(int i=startIdx; i< endIdx; i++){
            count += playArr[i];
        }
                
        long maxCount = count;
        int maxTime = 0;
        
        while(endIdx<lastUserTime){
                        
            count -= playArr[startIdx]; 
            count += playArr[endIdx];
            startIdx++;
            endIdx++;
            
            if(count > maxCount){
                maxCount = count;
                maxTime = startIdx;
            } 
        }
        
        return secondToTime(maxTime);
    }
}