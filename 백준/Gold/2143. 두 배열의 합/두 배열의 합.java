import java.io.*;
import java.util.*;

public class Main{

    static int n;
    static int m;

    static int[] a;
    static int[] b;

    static HashMap<Integer, Long> aMap = new HashMap();
    static HashMap<Integer, Long> bMap = new HashMap();

    public static void aDfs(int depth, int result, boolean start){
        
        if(!start){
            if(!aMap.containsKey(result)) aMap.put(result,0L);
            long temp = aMap.get(result)+1;
            aMap.replace(result,temp);
        }
        
        if(depth==n) return;
        aDfs(depth+1, result+a[depth], false);
    }

    public static void bDfs(int depth, int result, boolean start){
        if(!start){
            if(!bMap.containsKey(result)) bMap.put(result,0L);
            long temp = bMap.get(result)+1;
            bMap.replace(result,temp);
        }

        if(depth==m) return;
        bDfs(depth+1, result+b[depth], false);
    }

    public static void main(String[] args) throws IOException{
        long answer = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        n = Integer.parseInt(br.readLine());
        a = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }

        m = Integer.parseInt(br.readLine());
        b = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++){
            b[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<a.length; i++){
            aDfs(i, 0, true);
        }

        for(int i=0; i<b.length; i++){
            bDfs(i, 0, true);
        }

        for(Integer aNum: aMap.keySet()){
            if(bMap.containsKey(t-aNum)){
                answer += aMap.get(aNum) * bMap.get(t-aNum);
            }
        }

        System.out.println(answer);
    }
}