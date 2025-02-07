import java.util.*;
import java.io.*;


public class Main{

    static String[] signs;
    static boolean[] visited;
    static List<String> numbers;
    static int k;
    

    static void dfs(int pastNum, String number, int depth){

        if(depth == k+1){
            numbers.add(number);
            return;
        }

        for(int i=0; i<10; i++){
            if(!visited[i] && check(pastNum, i, depth)){
                visited[i] = true;
                dfs(i, number+i, depth+1);
                visited[i] = false;

            }
        }

    }

    static boolean check(int pastNum, int now, int depth){

        if(depth<1){
            return true;
        }

        if(signs[depth-1].equals("<") && (pastNum<now)){
            return true;
        }else if(signs[depth-1].equals(">") && (pastNum>now)){
            return true;
        }
        return false;
    }


    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        k = Integer.parseInt(st.nextToken());
        signs = new String[k];
        visited = new boolean[10];
        numbers = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<k; i++){
            signs[i] = st.nextToken();
        }

        dfs(0, "", 0);

        System.out.println(numbers.get(numbers.size()-1));
        System.out.println(numbers.get(0));
    }


}