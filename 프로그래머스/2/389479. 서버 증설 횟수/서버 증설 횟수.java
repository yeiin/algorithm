class Solution {

    
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int minimum = 0;
        int maximum = 0;
        
        int[] servers = new int[players.length];
        
        for(int i=0; i<players.length; i++){
            minimum = servers[i]*m;
            maximum = (servers[i]+1)*m-1;
            
            if(players[i]<=maximum){
                continue;
            }
            
            int addServer = 1;
            while(true){
                if((addServer+servers[i] + 1)*m > players[i]){
                    break;
                }
                addServer+=1;
            }
            
            answer += addServer;
            
            for(int j=0; j<k; j++){
                if(i+j>=24){
                    break;
                }
                servers[i+j] += addServer;
            }
            
        }
       
        return answer;
    }
}