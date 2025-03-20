import java.util.*;


class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        
        HashMap<String, Integer> friendHash = new HashMap<String, Integer>();
        
        for(int i=0; i<friends.length; i++){
            friendHash.put(friends[i], i);
        }
        
        int[][] arr = new int[friends.length][friends.length];
        int[] giftPoint = new int[friends.length];
        int[] nextGift = new int[friends.length];
        
        for(int i=0; i<gifts.length; i++){
            StringTokenizer st = new StringTokenizer(gifts[i]);
            int from = friendHash.get(st.nextToken());
            int to = friendHash.get(st.nextToken());
            arr[from][to] += 1;
            
            giftPoint[from] +=1;
            giftPoint[to] -= 1;
        }
        
    
        for(int i=0; i<friends.length; i++){
            for(int j=i; j<friends.length; j++){
                
                if(arr[i][j] > arr[j][i]){
                    nextGift[i] += 1;
                }else if(arr[j][i] > arr[i][j]){
                    nextGift[j] += 1;
                }else if(giftPoint[i] > giftPoint[j]){
                    nextGift[i] += 1;
                }else if(giftPoint[i] < giftPoint[j]){
                    nextGift[j] += 1;
                }
            }
            
        }
        
        
        
       
        for(int k=0; k<friends.length; k++){
            System.out.println(nextGift[k]);
            answer = Math.max(nextGift[k], answer);
        }
        
        return answer;
    }
}