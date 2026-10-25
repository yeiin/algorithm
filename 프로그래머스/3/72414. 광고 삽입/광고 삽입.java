import java.util.*;

class Solution {
    
    public int timeToSecond(String s){
        String[] arr = s.split(":");
        int result = 0;
        result += Integer.parseInt(arr[0]) * 3600;
        result += Integer.parseInt(arr[1]) * 60;
        result += Integer.parseInt(arr[2]);
        return result;
    }
    
    public String secondToTime(int second){
        String result = "";
        result += String.format("%02d", second / 3600);
        result += ":";
        second %= 3600;
        result += String.format("%02d", second / 60);
        result += ":";
        second %= 60;
        result += String.format("%02d", second);
        return result;
    }
    
    public String solution(String play_time, String adv_time, String[] logs) {
        String answer = "";
        int play = timeToSecond(play_time);
        int adv = timeToSecond(adv_time);
        int[] times = new int[play+1];
        
        for(String log: logs){
            String[] logArr = log.split("-");
            
            int start = timeToSecond(logArr[0]);
            int end = timeToSecond(logArr[1]);
            
            times[start]++;
            times[end]--;
        }
        
        for (int i = 1; i < play; i++) {
            times[i] += times[i - 1];
        }
        
        long count = 0;
        for(int i=0; i<adv; i++){
            count+=times[i];
        }
        
       
        long maxCount = count;
        int maxStart = 0;
        for (int start = 1; start <= play - adv; start++) {
            count -= times[start - 1];
            count += times[start + adv - 1];

            if (count > maxCount) {
                maxCount = count;
                maxStart = start;
            }
        }
        
        answer = secondToTime(maxStart);
        
        return answer;
    }
}