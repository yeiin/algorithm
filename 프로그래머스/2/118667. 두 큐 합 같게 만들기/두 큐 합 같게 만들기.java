import java.util.*;

class Solution {
    
    
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        long sum1 = 0;
        long sum2 = 0;
        
        int round = 0;
        
        Queue<Integer> q1 = new LinkedList();
        Queue<Integer> q2 = new LinkedList();
        
        for(int num1: queue1){
            sum1 += num1;
            q1.add(num1);
        }
        
        for(int num2: queue2){
            sum2 += num2;
            q2.add(num2);
        }
        
        
        while(true){       
            
            if(round > q2.size() && (answer-round)>q1.size()){
                answer = -1;
                break;
            }
        
            if(sum1==sum2){
                break;
            }else if(sum1<sum2){
                int temp = q2.poll();
                round ++;
                sum2 -= temp;
                q1.add(temp);
                sum1 += temp;
            }else{
                int temp = q1.poll();
                sum1 -= temp;
                q2.add(temp);
                sum2 += temp;
            }
            
            answer ++;
        }
        
        return answer;
    }
}