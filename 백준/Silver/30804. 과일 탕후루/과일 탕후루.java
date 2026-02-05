import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();

        int[] arr = new int[n];
        int[] count = new int[10];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Queue<Integer> q = new LinkedList<>();
        Set<Integer> set = new HashSet<>();

        int idx = 0;
        q.add(arr[idx]);
        set.add(arr[idx]);
        count[arr[idx++]]++;

        int answer = 1;

        while(!q.isEmpty() && idx<n){
            q.add(arr[idx]);
            set.add(arr[idx]);
            count[arr[idx++]]++;

            while(set.size()>2 && !q.isEmpty()){
                int tmp = q.poll();
                count[tmp]--;
                if(count[tmp]==0){
                    set.remove(tmp);
                }
            }
            answer = Math.max(answer, q.size());
        }
        System.out.println(answer);
    }
}