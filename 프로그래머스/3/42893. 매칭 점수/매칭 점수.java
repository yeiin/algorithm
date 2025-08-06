import java.util.*;
import java.util.regex.*;


class Solution {
    
    static class Score{
        int idx;
        double internal;
        double external;
                
        public Score(int idx, int internal, int external){
            this.idx = idx;
            this.internal = internal;
            this.external = external;
        }
        
        public double getScore(){
            return internal + external;
        }
       
    }
    
    public int solution(String word, String[] pages) {
        int answer = 0;
        word = word.toLowerCase();
        
        HashMap<String, Integer> urlMap = new HashMap();
        HashMap<Integer, List<String>> graph = new HashMap();
        List<Score> scores = new ArrayList();
        
        Matcher mt = null;
        for(String page: pages){
            int index = urlMap.size();
            graph.put(index, new ArrayList());
            
            mt = Pattern.compile("(<meta property=\"og:url\" content=\"https://(\\S*)\")").matcher(page);
            
            while(mt.find()){
                String h = mt.group(2).trim();
                urlMap.put(h, index);    
            }
            
            int sc = 0;
            page = page.toLowerCase();
            mt = Pattern.compile("(?<=[^a-zA-Z])("+word+")[^a-zA-Z]").matcher(page);
            while(mt.find()){
                sc +=1;
            }

            mt = Pattern.compile("<a href=\"(\\S*)//(\\S*)\"").matcher(page);
            while(mt.find()){
                String url = mt.group(2).trim();
                graph.get(index).add(url);
            }
            
            scores.add(new Score(index,sc,0));
        }
        
        for(int i: graph.keySet()){
            List<String> slist = graph.get(i);
            double score = scores.get(i).internal;
            if(score==0) continue;
            for(String s: slist){
                if(urlMap.containsKey(s)){
                    scores.get(urlMap.get(s)).external += score/slist.size();
                }
            }
        }
        
        Collections.sort(scores, (o1, o2) -> {
            if(o1.getScore()==o2.getScore()) return o1.idx - o2.idx;
            else return Double.compare(o2.getScore(), o1.getScore());
        });
        
        return scores.get(0).idx;
    }
}