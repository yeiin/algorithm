import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        int[] kbmti = new int[8];
        
        HashMap<String, int[]> map = new HashMap();
        
        map.put("RT", new int[]{0, 1});
        map.put("TR", new int[]{1, 0});
        map.put("CF", new int[]{2, 3});
        map.put("FC", new int[]{3, 2});
        map.put("JM", new int[]{4, 5});
        map.put("MJ", new int[]{5, 4});
        map.put("AN", new int[]{6, 7});
        map.put("NA", new int[]{7, 6});
        
        for(int i=0; i<survey.length; i++){
            int[] curr = map.get(survey[i]);
            
            if(choices[i]>=4){
                kbmti[curr[1]] += Math.abs(choices[i]-4);
            }else{
                kbmti[curr[0]] += Math.abs(choices[i]-4);
            }
            
        }
        
        
        
        if(kbmti[0]>=kbmti[1]) answer += "R";
        else answer += "T";
        
        if(kbmti[2]>=kbmti[3]) answer += "C";
        else answer += "F";
        
        if(kbmti[4]>=kbmti[5]) answer += "J";
        else answer += "M";
        
        if(kbmti[6]>=kbmti[7]) answer += "A";
        else answer += "N";
        
        return answer;
    }
}