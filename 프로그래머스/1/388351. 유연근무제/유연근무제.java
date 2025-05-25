class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        
        int day = startday - 1;
        int answer = 0;
        boolean[] events = new boolean[schedules.length];
        
        for(int i = 0; i<schedules.length; i++){
            schedules[i] = schedules[i]/100*60 + schedules[i]%100;
        }
        
        for(int i=0; i<timelogs[0].length; i++){
            
            day %= 7;
            
            if(day==5||day==6){
                day++;
                continue;
            }
            
            for(int j=0; j<timelogs.length; j++){
                if(!events[j]){
                    int time = timelogs[j][i]/100*60 + timelogs[j][i]%100;
                    if(time > (schedules[j] + 10)){
                        events[j] = true;
                    }
                }
            }
            
            day++;
            
            
            
        }
        
        
        for(int i = 0; i<schedules.length; i++){
            if(!events[i]) answer++;
        }
        
        return answer;
    }
}