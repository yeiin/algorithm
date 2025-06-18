import java.util.*;

class Solution {
    
    String[][] table = new String[50][50];
    
    HashMap<String, Integer> map = new HashMap();
    List<String> stringList = new ArrayList();
    
    public String pointToString(int x, int y){
        return x+","+y;
    }
    
    public void updatePoint(String r, String c, String value){
        int x = Integer.parseInt(r)-1;
        int y = Integer.parseInt(c)-1;
        
        String key = pointToString(x, y);
        if(map.containsKey(key)){
            int groupIdx = map.get(key);
            stringList.set(groupIdx, value);
        }else{
            table[x][y] = value;
        }
    } 
    
    public void updateValue(String value, String newValue){
        
        for(int i=0; i<stringList.size(); i++){
            if(stringList.get(i).equals(value)){
                stringList.set(i, newValue);
            }
        }
        
        for(int i=0; i<50; i++){
            for(int j=0; j<50; j++){
                if(table[i][j] != null && table[i][j].equals(value)) table[i][j] = newValue; 
            }
        }
    } 
    
    public void merge(String r1, String c1, String r2, String c2){
        int x1 = Integer.parseInt(r1)-1;
        int y1 = Integer.parseInt(c1)-1;
        int x2 = Integer.parseInt(r2)-1;
        int y2 = Integer.parseInt(c2)-1;
        
        if(x1==x2 && y1==y2) return;
        
        String key1 = pointToString(x1, y1);
        String key2 = pointToString(x2, y2);
        
        if(map.containsKey(key1) && map.containsKey(key2)){
            int groupIdx = map.get(key1);
            
            if(stringList.get(groupIdx).equals("")){
                stringList.set(groupIdx,stringList.get(map.get(key2)));
            }
            
            List<String> updateList = new ArrayList();
            
            for(String k: map.keySet()){
                if(map.get(k) == map.get(key2)) updateList.add(k);
            }
            
            for(String k: updateList) map.replace(k, groupIdx);
            
        }else if(map.containsKey(key1)){
            int groupIdx = map.get(key1);
            map.put(key2, groupIdx);
            if(stringList.get(groupIdx).equals("") && table[x2][y2]!=null){
                stringList.set(groupIdx,table[x2][y2]);
            }
            table[x2][y2] = null;
            
        }else if(map.containsKey(key2)){
            
            int groupIdx = map.get(key2);
            if(table[x1][y1]!=null) stringList.set(groupIdx, table[x1][y1]);
            
            map.put(key1, groupIdx);
            table[x1][y1] = null;
            
        }else{
            String value = "";
            if(table[x1][y1]!=null) value = table[x1][y1];
            else if(table[x2][y2]!=null) value = table[x2][y2];
            
            stringList.add(value);
            
            table[x1][y1] = null;
            table[x2][y2] = null;

            map.put(key1, stringList.size()-1);
            map.put(key2, stringList.size()-1);
        }
                
    }
    
    public void unmerge(String r, String c){
        int x = Integer.parseInt(r)-1;
        int y = Integer.parseInt(c)-1;
        
        String key = pointToString(x, y);
        
        if (!map.containsKey(key)) return;

        int groupIdx = map.get(key);
        
        List<String> deleteList = new ArrayList();
        
        for(String k: map.keySet()){
            if(map.get(k) == groupIdx) deleteList.add(k);
        }
        
        for(String d: deleteList) map.remove(d);
        
        if(stringList.get(groupIdx).equals("")) table[x][y] = null;
        else table[x][y] = stringList.get(groupIdx);       
    }
    
    public String print(String r, String c){
        int x = Integer.parseInt(r)-1;
        int y = Integer.parseInt(c)-1;
       
        String key = pointToString(x, y);
        
        if(map.containsKey(key)){
            if(stringList.get(map.get(key)).equals("")) return "EMPTY";
            else return stringList.get(map.get(key));
        }
        
        if(table[x][y] == null) return "EMPTY";
        else return table[x][y];
    }
    
    public String[] solution(String[] commands) {
        List<String> answer = new ArrayList();
                
        for(String command: commands){
            String[] c = command.split(" ");
            
            if(c[0].equals("UPDATE")){
                if(c.length == 4) updatePoint(c[1], c[2], c[3]);
                else updateValue(c[1], c[2]);      
            }else if(c[0].equals("MERGE")){
                merge(c[1], c[2], c[3], c[4]);
            }
            else if(c[0].equals("UNMERGE")){
                unmerge(c[1], c[2]);
            }else{
                answer.add(print(c[1], c[2]));
            }
        }
        
        return answer.toArray(String[]::new);
    }
}