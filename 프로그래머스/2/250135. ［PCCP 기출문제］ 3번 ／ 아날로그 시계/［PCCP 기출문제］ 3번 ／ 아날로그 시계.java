class Solution {
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        int answer = 0;
        
        double startTime = h1 * 3600 + m1 * 60 + s1;
        double endTime = h2 * 3600 + m2 * 60 + s2;
        
        
        if(startTime == 0 || startTime == 12*3600){
            answer += 1;
        }
        
        while (startTime < endTime){
            
            double currH = startTime / 120 % 360;
            double currM = startTime / 10 % 360;
            double currS = startTime * 6 % 360;
            
            
            double nextH = (startTime + 1) / 120 % 360;
            double nextM = (startTime + 1) / 10 % 360;
            double nextS = (startTime + 1) * 6 % 360;
            
            if(nextH == 0){
                nextH = 360;
            }
            
            if(nextM == 0){
                nextM = 360;
            }
            
            if(nextS == 0){
                nextS = 360;
            }
            
            
            if(currS < currH && nextS >= nextH){
              
                answer += 1;
            }
            
            if(currS < currM && nextS >= nextM){
    
                answer += 1;
            }
            
            if(nextS == nextM && nextH == nextM){
                answer -= 1;
            }
            
            
            startTime += 1;
            
        }
        
        return answer;
    }
}