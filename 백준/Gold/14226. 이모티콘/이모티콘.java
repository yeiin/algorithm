import java.util.*;

public class Main{

    public static class Node{
        int sticker;
        int clip;
        int count;

        public Node(int sticker, int clip, int count){
            this.sticker = sticker;
            this.clip = clip;
            this.count = count;
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int min = number;
        sc.close();
        boolean[][] visited = new boolean[2001][2001];

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(1,0, 0));
        visited[1][0] = true;

        while(!q.isEmpty()){
            Node curr = q.poll();

            if(curr.sticker == number){
                min = Math.min(min,curr.count);
            }
                
            if(curr.sticker > 0 && !visited[curr.sticker][curr.sticker]){
              
                q.add(new Node(curr.sticker, curr.sticker, curr.count+1));
                visited[curr.sticker][curr.sticker] = true;
            
            }
                
            if(curr.clip > 0 && curr.sticker + curr.clip < 2000 && !visited[curr.sticker+curr.clip][curr.clip]){
               
                visited[curr.sticker+curr.clip][curr.clip] = true;
                q.add(new Node(curr.sticker+curr.clip, curr.clip, curr.count+1));
                
            }
                    

            
            if(curr.sticker > 0 && !visited[curr.sticker-1][curr.clip]){
             
                visited[curr.sticker - 1][curr.clip] = true;
                q.add(new Node(curr.sticker - 1, curr.clip, curr.count+1));
                
            }
        }

        System.out.println(min);
        
    }
}