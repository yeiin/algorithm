class Solution {
    
    int w;
    
    public int[] calHW(int number){
        
        int currH = number/this.w;
        int currW = number%this.w;
        int reverse = 0;
        
        if(currW != 0) currH += 1;
        if(currH%2 == 0){
            currW = (this.w - currW) % this.w + 1;
            reverse = 1;
        }
        if(currW == 0){
            if(reverse == 1){
                currW = 1;
            }else{
                currW = this.w;
            }
        }
        
        return new int[]{currH, currW, reverse};
    }
    
    public int solution(int n, int w, int num) {
     
        this.w = w;
        
        int[] top = calHW(n);
        int[] box = calHW(num);
                
        int answer = top[0] - box[0];
      
        if(top[2] == 1 && top[1] <= box[1]){
            answer += 1;  
        }else if(top[2] == 0 && top[1] >= box[1]){
            answer += 1;
        }
        
        return answer;
    }
}