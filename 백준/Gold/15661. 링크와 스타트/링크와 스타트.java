import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
static int N;
    static int[][] abilityArr;
    static boolean[] visitied;
    static int minium;


    public static void dfs(int node, int depth){

        if(depth!=N){
            int start = 0;
            int link = 0;

            for(int i=0; i<N-1; i++){
                for(int j=i+1; j<N; j++){
                    if(visitied[i] && visitied[j]){
                        start += abilityArr[i][j]+abilityArr[j][i];
                    }else if(!visitied[i] && !visitied[j]){
                        link += abilityArr[i][j]+abilityArr[j][i];
                    }
                }
            }

            int cal = Math.abs(start - link);

            minium = Math.min(minium, cal);

            for(int i=node; i<N; i++){
                if(!visitied[i]){
                    visitied[i] = true;
                    dfs(i+1, depth+1);
                    visitied[i] = false;
                }
            }
        }

    }
    

    public static void main(String[] args)throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        abilityArr = new int[N][N];
        visitied = new boolean[N];
        minium = 2000000;

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                abilityArr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);

        System.out.println(minium);


    }
}