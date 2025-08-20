import java.util.*;

class Solution {
    
    int[][] board;
    int[] parent;
    int[] child;
    
    public int findParent(int idx){
        int p = parent[idx];
        while(true){
            if(p==-1) return p;
            
            if(board[p][1] ==0) return p;
            else p = parent[p];
        }
    }
    
    public int findChild(int idx){
        int c = child[idx];
        while(true){
            if(c==-1) return c;
            
            if(board[c][1] ==0) return c;
            else c = child[c];
        }
    }
    
    public String solution(int n, int k, String[] cmd) {
        board = new int[n][2];
        parent = new int[n];
        child = new int[n];
        
        parent[0] = -1;
        child[n-1] = -1;
        for(int i=1; i<n; i++){
            parent[i] = i-1;
            child[i-1] = i;
        }
        
        int cursor = k;
        
        Stack<Integer> stack = new Stack();       
        for(String c :cmd){
            
            if(c.startsWith("U")){
                String[] us = c.split(" ");
                
                for(int i=0; i<Integer.parseInt(us[1]); i++){
                    int p = findParent(cursor);
                    if(p==-1) break;
                    cursor = p;
                }
                
            }else if(c.startsWith("D")){
                String[] ds = c.split(" ");
                for(int i=0; i<Integer.parseInt(ds[1]); i++){
                    int ch = findChild(cursor);
                    if(ch==-1) break;
                    cursor = ch;
                }
            }else if(c.startsWith("C")){
                stack.push(cursor);
                
                board[cursor][1] = 1;                
                int p = findParent(cursor);
                int ch = findChild(cursor);
                
                
                if(ch==-1){ 
                    cursor = p;
                    child[p] = ch;  
                }else if(p==-1){
                    cursor = ch;
                    parent[ch] = p;
                }else{
                    cursor = ch;
                    parent[ch] = p;
                    child[p] = ch;  
                }
                
            }else{
                int b = stack.pop();
                
                board[b][1] = 0;
                
                int p = findParent(b);
                
                if(p!=-1){
                    parent[b] = p;
                    child[p] = b;
                }
                
                int ch = findChild(b);
                
                if(ch != -1){
                    child[b] = ch;
                    parent[ch] = b;
                }
                
            }    
        }
        
        StringBuilder sb = new StringBuilder();
        for(int[] a: board){
            if(a[1]==0) sb.append("O");
            else sb.append("X");
        }
        return sb.toString();
    }
}