import java.util.*;
import java.io.*;


class Solution {
    
    public int isOpening(int start, int end, int curr){
        if(curr>= start && curr<= end){
            curr = end;        
        }
        return curr;
    }

    public int toSeconds(String time){
        int[] minuteSeconds = Arrays.stream(time.split(":"))
                            .mapToInt(Integer::parseInt)
                            .toArray();
        return minuteSeconds[0]*60+minuteSeconds[1];
    }
    
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int video = toSeconds(video_len);
        int curr = toSeconds(pos);
        int start = toSeconds(op_start);
        int end = toSeconds(op_end);
        
        
        curr = isOpening(start, end, curr);
        for(String command : commands){
            switch(command){
                case "prev":
                    curr -= 10;
                    if(curr<0){
                        curr = 0;
                    }
                    curr = isOpening(start, end, curr);
                    break;
                case "next":
                    curr += 10;
                    if(curr>video){
                        curr = video;
                    }
                    curr = isOpening(start, end, curr);
                    break;
                
            }
        }
        
        String minute = Integer.toString(curr/60);
        String second = Integer.toString(curr%60);
        
        if(minute.length()==1){
            minute = "0"+minute;
        }
        
        if(second.length()==1){
            second = "0"+second;
        }
        
    
        return minute + ":" + second;
    }
}