class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = health;
        int attackCount = 0;
        int bandageTime = 0;
        int time = 0;
        
        while(time < attacks[attacks.length-1][0]){
            time += 1;
            
            if(time == attacks[attackCount][0]){
                answer -= attacks[attackCount][1];
                bandageTime = 0;
                attackCount += 1;
            }else{
                bandageTime += 1;  
                answer +=  bandage[1];
                if(bandageTime == bandage[0]){
                    bandageTime = 0;
                    answer += bandage[2];
                }

                if(answer > health) answer = health;          
            }
            
            if(answer <= 0) break;
            
        }
        
        if(answer <= 0) answer = -1;
        if(answer > health) answer = health;
            
        
        return answer;
    }
}