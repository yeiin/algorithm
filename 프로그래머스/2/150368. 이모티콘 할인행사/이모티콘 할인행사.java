import java.util.*;

class Solution {
    
    int n;
    List<int[]> percentages;
    int[] arr;
    
    public void dfs(int depth){
        
        if(depth==n){
            percentages.add(arr.clone());
            return;
        }
        
        for(int i=10; i<=40; i+=10){
            arr[depth] = i;
            dfs(depth+1);
        }
    }
    
    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = {0, 0};
        
        n = emoticons.length;
        percentages = new ArrayList();
        arr = new int[n];
        
        int[][] eForSale = new int[emoticons.length][5];
        
        for(int i=0; i<emoticons.length; i++){
            eForSale[i][0] = emoticons[i];
            for(int j=1; j<5; j++){
                eForSale[i][j] = eForSale[i][0] - eForSale[i][0]/10 * j;
            }
            
        }
        
        dfs(0);
        
        for(int[] percentage: percentages){
            
            int price = 0;
            int nSub = 0;
            
            for(int[] user: users){
                int temp = 0;
                for(int p=0; p<percentage.length; p++){
                    if(percentage[p]>=user[0]){
                        temp += eForSale[p][percentage[p]/10];
                    }
                    
                    if(temp>=user[1]) break;
                    
                }
                
                if(temp>=user[1]) nSub++;
                else price += temp;
                
            }
            
            if(answer[0]<nSub){
                answer = new int[]{nSub, price};
            }else if(answer[0]==nSub && answer[1]<price){
                answer = new int[]{nSub, price};
            }
            
        }
        
        return answer;
    }
}