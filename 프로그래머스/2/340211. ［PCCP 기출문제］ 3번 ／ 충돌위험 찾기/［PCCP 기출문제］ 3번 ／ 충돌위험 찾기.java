class Solution {

    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        int max = 0;
        int completeRobots = 0;
        
        int[][] coor = new int[routes.length][2];
        int[] nextGoal = new int[routes.length];
        int[] nextIndex = new int[routes.length];
        
        for(int i=0; i<points.length; i++){
            max = Math.max(max, Math.max(points[i][0],points[i][1]));
        }
        
        int[][] timeArr = new int[max+1][max+1];
        
        for(int i=0; i<routes.length; i++){
            nextGoal[i] = routes[i][1]-1;
            nextIndex[i] = 1;
            coor[i] = points[routes[i][0]-1].clone();
            
            if(timeArr[coor[i][0]][coor[i][1]]==1){
                    answer++;
            }
            
            timeArr[coor[i][0]][coor[i][1]]++;
        }
        
        
                  
        while(completeRobots < routes.length){
            timeArr = new int[max+1][max+1];
            
            for(int i=0; i<coor.length; i++){  
                
                if(nextIndex[i] == -1){
                    continue;
                }
                
                int[] nextPoint = points[nextGoal[i]].clone();
                                
                if(coor[i][0] != nextPoint[0]){
                    coor[i][0] += Integer.compare(nextPoint[0], coor[i][0]);
                }else if(coor[i][1] != nextPoint[1]){
                    coor[i][1] += Integer.compare(nextPoint[1], coor[i][1]);
                }
                
                if(timeArr[coor[i][0]][coor[i][1]]==1){
                    answer++;
                }
                
                timeArr[coor[i][0]][coor[i][1]]++;
                
                if(coor[i][0]==nextPoint[0] && coor[i][1] == nextPoint[1]){
                    if(nextIndex[i] == routes[i].length - 1){
                        completeRobots++;
                        nextIndex[i] = -1;
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
