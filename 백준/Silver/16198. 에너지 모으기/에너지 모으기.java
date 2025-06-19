import java.util.*;
import java.io.*;;

class Main{

   static int answer = 0;

    public static void dfs(List<Integer> list, int result){

        if(list.size()<=2){
            answer = Math.max(answer, result);
            return;
        }

        for(int i=1; i<list.size()-1; i++){
            int temp = list.get(i);
            int next = result + list.get(i-1) * list.get(i+1);
            
            list.remove(i);
            dfs(list, next);
            list.add(i, temp);
        }
    }

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> list = new LinkedList<>();

        for(int i=0; i<n; i++){
            list.add(Integer.parseInt(st.nextToken()));
        }

        for(int i=1; i<list.size()-1; i++){
            dfs(list, 0);
        }
        System.out.println(answer);
    }
}