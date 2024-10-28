import java.util.*;

public class Main{

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        Queue<Integer> q = new LinkedList();
        int back = 0;

        for(int i= 0; i<number; i++){
            String next = sc.next();
            if(next.equals("push")){
                back = sc.nextInt();
                q.add(back);

            }else if(next.equals("pop")){
                if(q.isEmpty()){
                    System.out.println("-1");
                }else{
                    System.out.println(q.poll());
                }
                
            }else if(next.equals("front")){
                if(q.isEmpty()){
                    System.out.println("-1");
                }else{
                    System.out.println(q.peek());
                }

            }else if(next.equals("back")){
                if(q.isEmpty()){
                    System.out.println("-1");
                }else{
                    System.out.println(back);
                }

            }else if(next.equals("size")){
                System.out.println(q.size());

            }else if(next.equals("empty")){
                if(q.isEmpty()){
                    System.out.println("1");
                }else{
                    System.out.println("0");
                }

            }
        }



        sc.close();
    }
}