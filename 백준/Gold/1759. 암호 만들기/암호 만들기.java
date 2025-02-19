import java.util.*;
import java.io.*;



public class Main{

    static int l;
    static int c;
    static int a;
    static List vowels = List.of('a', 'e', 'i', 'o', 'u');
    static char[] arr;
    static char[] result;
    static boolean[] visited;


    static void dfs(int index, int depth){

        if(depth==l){
            if(a>0 && l-a>=2){
                for(int i=0; i<l; i++){
                System.out.print(result[i]);
                }
                System.out.println();
            }
            return;
        }


        for(int i=index; i<c; i++){
            if(!visited[i]){
                visited[i] = true;
                result[depth]=arr[i];
                if(vowels.contains(arr[i])){
                    a+=1;
                }
                dfs(i, depth+1);
                visited[i] = false;
                if(vowels.contains(arr[i])){
                    a-=1;
                }
            }   
        }
        
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        a = 0;

        arr = new char[c];
        result = new char[l];
        visited = new boolean[c];

        String input = br.readLine().replace(" ", ""); 
        arr = input.toCharArray();
        
        Arrays.sort(arr);

        dfs(0,0);
    }
}