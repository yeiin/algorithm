import java.io.*;


class Main{

    static Node currNode = null;
    static Node startNode = new Node(null, null, null);

    static class Node{
        String s;
        Node left;
        Node right;

        public void setLeftNode(Node node){
            this.left = node;
        }

        public void setRightNode(Node node){
            this.right = node;
        }

        public Node(String s, Node left, Node right){
            this.s = s;
            this.left = left;
            this.right = right;
        }

        public String toString(){
            if(left==null){
                return "s: "+s+", left"+null + ", right: "+ right.s;
            }else if(right==null){
                return "s: "+s+", left"+left.s + ", right: "+ null;
            }
            return "s: "+s+", left"+left.s + ", right: "+ right.s;
        }
    }

    public static void playL(){
        if (currNode.left == null) return;
        currNode = currNode.left;
    }

    public static void playD(){
        if(currNode.right==null) return;
        currNode = currNode.right;  
    }


    public static void playB(){
        if(currNode.left == null) return;
        currNode.left.right = currNode.right;
        
        if(currNode.right!=null){
            currNode.right.left = currNode.left;
        }
        currNode = currNode.left;
    }

    public static void playP(String s){
        Node newNode = new Node(s, currNode, currNode.right);
        
        if (currNode.right != null) {
            currNode.right.left = newNode;
        }

        currNode.right = newNode;
        currNode = newNode;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sArr = br.readLine().split("");
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<sArr.length; i++){          
            if(i==0){
                Node node = new Node(sArr[i], startNode, null);
                currNode = node;
                startNode.right = node;
            }else if(i == sArr.length-1){
                Node node = new Node(sArr[i], currNode, null);
                currNode.setRightNode(node);
                currNode = node;
            }else{
                Node node = new Node(sArr[i], currNode, null);
                currNode.right = node;
                currNode = node;
            }

        }
        
        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++){
            String[] operations = br.readLine().split(" "); 
            switch (operations[0]) {
                case "L":
                    playL();
                    break;

                case "D":
                    playD();
                    break;
                
                case "B":
                    playB();
                    break;

                case "P":
                    playP(operations[1]);
                    break;
            
                default:
                    break;
            }

        }


        while(startNode!=null){
            if(startNode.s != null) sb.append(startNode.s);
            startNode = startNode.right;
        }

        System.out.println(sb.toString());

    }
}
