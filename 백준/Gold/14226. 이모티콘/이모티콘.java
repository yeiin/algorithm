import java.util.*;
import java.io.*;


public class Main {
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int s = Integer.parseInt(br.readLine());
        boolean[][] visited = new boolean[2*s+1][2*s+1];
    
        visited[1][0] = true;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{1, 0, 0}); //이모티콘 수, 시간, clipboard에 수

        int min = Integer.MAX_VALUE;

        while(!q.isEmpty()){
            int[] curr = q.poll();

            if(curr[0]==s){
                min = Math.min(min, curr[1]);
                continue;
            }

             if(!visited[curr[0]][curr[0]]){
                visited[curr[0]][curr[0]] = true;
                q.add(new int[]{curr[0], curr[1]+1, curr[0]});
            }

            if(curr[0]+curr[2] < 2*s && !visited[curr[0] + curr[2]][curr[2]]){
                visited[curr[0]+curr[2]][curr[2]] = true;
                q.add(new int[]{curr[0]+curr[2], curr[1]+1, curr[2]});
            }


            if(curr[0]-1 > 1 && !visited[curr[0]-1][curr[2]]){
                visited[curr[0]-1][curr[2]] = true;
                q.add(new int[]{curr[0]-1, curr[1]+1, curr[2]});
            }     

        
        }
        System.out.println(min);
    }
}
