import java.util.*;

class Solution {
    
    static class Word {
        String text;
        int start;
        int end;
        
        Word(String text, int start, int end) {
            this.text = text;
            this.start = start;
            this.end = end;
        }
    }
    
    public int solution(String message, int[][] spoiler_ranges) {
        List<Word> words = new ArrayList<>();
        Map<String, Integer> totalCount = new HashMap<>();
        
        int n = message.length();
        int i = 0;
        
      
        while (i < n) {
            if (message.charAt(i) == ' ') {
                i++;
                continue;
            }
            
            int start = i;
            while (i < n && message.charAt(i) != ' ') {
                i++;
            }
            int end = i - 1;
            
            String word = message.substring(start, end + 1);
            words.add(new Word(word, start, end));
            totalCount.put(word, totalCount.getOrDefault(word, 0) + 1);
        }
        
        boolean[] spoiled = new boolean[words.size()];
        
        for (int[] range : spoiler_ranges) {
            int s = range[0];
            int e = range[1];
            
            if (s < n && message.charAt(s) != ' ') {
                while (s > 0 && message.charAt(s - 1) != ' ') {
                    s--;
                }
            }
            
            if (e >= 0 && e < n && message.charAt(e) != ' ') {
                while (e < n - 1 && message.charAt(e + 1) != ' ') {
                    e++;
                }
            }
            
            for (int idx = 0; idx < words.size(); idx++) {
                Word w = words.get(idx);
                if (w.start >= s && w.end <= e) {
                    spoiled[idx] = true;
                }
            }
        }
        
        Map<String, Integer> spoiledCount = new HashMap<>();
        for (int idx = 0; idx < words.size(); idx++) {
            if (spoiled[idx]) {
                String word = words.get(idx).text;
                spoiledCount.put(word, spoiledCount.getOrDefault(word, 0) + 1);
            }
        }
        
        int answer = 0;
        for (String word : totalCount.keySet()) {
            if (spoiledCount.getOrDefault(word, 0).equals(totalCount.get(word))) {
                answer++;
            }
        }
        
        return answer;
    }
}