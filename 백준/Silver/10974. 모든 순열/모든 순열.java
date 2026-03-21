import java.io.*;

class Main{
    static int[] arr;
    static boolean[] visited;
    static int[] numbers;

    public static void dfs(int depth){
        if(depth==arr.length){
            for(int num: numbers){
                System.out.print(arr[num]+" ");
            }
            System.out.println();
            return;
        }

        for(int i=0; i<arr.length; i++){
            if(!visited[i]){
                visited[i]=true;
                numbers[depth] = i;
                dfs(depth+1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        arr = new int[n];
        visited = new boolean[n];
        numbers = new int[n];

        for(int i=0; i<n; i++){
            arr[i] = i+1;
        }

        dfs(0);
    }
}