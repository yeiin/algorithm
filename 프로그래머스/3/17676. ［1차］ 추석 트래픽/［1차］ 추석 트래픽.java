import java.util.*;

class Solution {
    
    public int timeToInt(String time){
        String[] ts = time.split(":");
        return Integer.parseInt(ts[0])*60*60 + Integer.parseInt(ts[1])*60 + Integer.parseInt(ts[2]);
    }
    
    public int solution(String[] lines) {
        int answer = 0;    
        List<int[]> list = new ArrayList();
        
        for(int i=0; i<lines.length; i++){
            String[] lineArr = lines[i].split(" ");
            String[] time = lineArr[1].split("\\.");
            int s = timeToInt(time[0])*1000 + Integer.parseInt(time[1]);
            int t = (int) (Double.parseDouble(lineArr[2].replace("s","")) * 1000);
                       
            list.add(new int[]{s-t+1,s});
        }
        
        Collections.sort(list, (o1, o2)-> o1[0]-o2[0]);
        
        List<int[]> rangeList = new LinkedList();
        int time = list.get(0)[0];      
        int sIdx = 0;
        
        while(time<86400000 && sIdx!=list.size()){
            
            for(int i=sIdx; i<list.size(); i++){
                if(list.get(i)[0]>=time+1000) break;
                rangeList.add(list.get(i));
                sIdx++;
            }
            
            List<int[]> dlist = new ArrayList();
            for(int[] f: rangeList){
                if(f[1]<time) dlist.add(f);
            }
            
            for(int[] d: dlist){
                rangeList.remove(d);
            }
            
            answer = Math.max(answer, rangeList.size());
            
            time++;
        }
        
        return answer;
    }
}