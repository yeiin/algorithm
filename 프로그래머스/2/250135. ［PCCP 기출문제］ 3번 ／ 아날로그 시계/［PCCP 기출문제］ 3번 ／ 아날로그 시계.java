import java.util.*;

class Solution {
 
    public double[] next(double second){
        double[] angle = new double[3];
                
        angle[0] = (second / 120) % 360;
        angle[1] = (second / 10) % 360;
        angle[2] = (second * 6) % 360;
        
        return angle;
    }
     
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        int answer = 0;

        double time1 = h1*60*60 + m1*60 + s1;
        double time2 = h2*60*60 + m2*60 + s2;
        
        if(time1==0 || time1 == 12*3600) answer++;
        
        while(time1<time2){            
                  
            double[] angle1 = next(time1); 
            double[] angle2 = next(time1+1);
            
             
            if(angle2[0] == 0) angle2[0] = 360;
            if(angle2[1] == 0) angle2[1] = 360;
            if(angle2[2] == 0) angle2[2] = 360;

            if(angle1[0] > angle1[2] && angle2[0] <= angle2[2]){
                answer ++;
            }
            
            if(angle1[1]>angle1[2] && angle2[1]<=angle2[2]){
                answer++;
            }
            
            if(angle2[0] == angle2[1] && angle2[1]==angle2[2]){
                answer--;
            }
            
            time1++;
        }
        
        return answer;
    }
}