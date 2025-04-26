class Solution {
    
    int answer = 0;
    int max = 0;
    
    public void check(int[][] coor){
        int[][] timeArr = new int[max+1][max+1];
        for(int j=0; j<coor.length; j++){
            if(coor[j][0]<0){
                    continue;
                }
                System.out.println("j: "+ coor[j][0]+", "+coor[j][1]);
                if(timeArr[coor[j][0]][coor[j][1]]==1){
                    answer++;
                }
                timeArr[coor[j][0]][coor[j][1]]++;
                
            }
                 
            System.out.println(answer);
            System.out.println();
    }
    
    public int solution(int[][] points, int[][] routes) {
       
        int completeRobots = 0;
        int[][] coor = new int[routes.length][2];
        int[] nextGoal = new int[routes.length];
        int[] nextIndex = new int[routes.length];
        
        for(int i=0; i<routes.length; i++){
            nextGoal[i] = routes[i][1]-1;
            nextIndex[i] = 1;
            coor[i] = points[routes[i][0]-1].clone();
        }
        
        for(int i=0; i<points.length; i++){
            max = Math.max(max, Math.max(points[i][0],points[i][1]));
        }
        
        
        check(coor);
        
        while(completeRobots < routes.length){
            int[][] timeArr = new int[max+1][max+1];
            
            for(int i=0; i<coor.length; i++){  
                if(nextIndex[i] == -1){
                    continue;
                }
                
                int[] nextPoint = points[nextGoal[i]].clone();
                                
                if(coor[i][0] != nextPoint[0]){
                    if(nextPoint[0] > coor[i][0]){
                        coor[i][0]+=1;
                    }else{
                        coor[i][0]-=1;
                    }
                }else if(coor[i][1] != nextPoint[1]){
                    if(nextPoint[1] > coor[i][1]){
                        coor[i][1]+=1;
                    }else{
                        coor[i][1]-=1;
                    }
                }
                
                if(timeArr[coor[i][0]][coor[i][1]]==1){
                    answer++;
                }
                timeArr[coor[i][0]][coor[i][1]]++;
                
                if(coor[i][0]==nextPoint[0] && coor[i][1] == nextPoint[1]){
                    if(nextIndex[i] == routes[0].length-1){
                        completeRobots++;
                        nextIndex[i] = -1;
                        coor[i][0] = -1;
                        coor[i][1] = -1;
                        
                    }else{
                        nextIndex[i] += 1;
                        nextGoal[i] = routes[i][nextIndex[i]]-1;
                    }
                }
                
                
            }
        }
        
        return answer;
    }
}