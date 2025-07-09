import java.util.*;
import java.io.*;

class Main{

    static int answer = 0;

    static int k;
    static int n;

    static List<HashSet<Character>> sets = new LinkedList<>();

    static List<Character> characters = new LinkedList<>();
    static HashSet<Character> iterHashSet = new HashSet<>();

    static boolean[] visited = new boolean[26];
    static String[] words;

    public static void dfs(int depth, int start){
        if(depth==k-5){
            int temp = 0;
            for(String word: words){
                boolean flag = true;

                for(char w: word.toCharArray()){
                    if(!visited[w-'a']){
                        flag = false;
                        break;
                    }
                }

                if(flag){
                    temp++;
                }
            }

            answer = Math.max(answer, temp);
            return;
        }

        for(int i=start; i<visited.length; i++){
            if(!visited[i]){
                visited[i] = true;             
                dfs(depth+1, i+1);
                visited[i] = false;
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        words = new String[n];

        visited['a' - 'a'] = true;
        visited['c' - 'a'] = true;
        visited['n' - 'a'] = true;
        visited['t' - 'a'] = true;
        visited['i' - 'a'] = true;
        
        for(int i=0; i<n; i++){
            String s = br.readLine();
            words[i] = s.substring(4, s.length()-4);
        }

        if(k<5){
            System.out.println(0);
            return;
        }else if(k==26){
            System.out.println(n);
            return;
        }

        dfs(0, 0);

        System.out.println(answer);
    }
}