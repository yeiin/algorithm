import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        List<Integer> times = new ArrayList();
        
        for(int i=0; i<timetable.length; i++){
            String[] time = timetable[i].split(":");
            int minutes = Integer.parseInt(time[0])*60 + Integer.parseInt(time[1]);
            times.add(minutes);
        }
        
        Collections.sort(times);
        Deque<Integer> dq = new ArrayDeque<>();
        
        dq.addAll(times);
        
        int start = 540;
        int answer = 0;
        
        while(n>0){
            List<Integer> gone = new ArrayList();
            for(int i=0; i<m; i++){
                if(dq.isEmpty()) break;
                int top = dq.peek();
                if(top<=start){
                    gone.add(dq.remove());
                }
                else break;
            }
            
            if(gone.size()<m){
                answer = start;
            }else{
                int idx = 0;
                
                while(idx<gone.size()){
                    int sTime = gone.get(idx);

                    for(int i=idx; i<gone.size(); i++){
                        if(gone.get(i)==sTime){
                            idx++;
                            continue;
                        }
                        break;
                    }

                    if(idx==m) answer = sTime-1;
                    else answer = sTime;
                }
                
                
            }
            
            start+=t;
            n--;
        }
                
        return String.format("%02d", answer/60)+":"+String.format("%02d", answer%60);
    }
}