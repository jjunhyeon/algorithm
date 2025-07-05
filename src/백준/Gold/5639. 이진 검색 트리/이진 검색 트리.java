import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static class Node{
        int value;
        Node leftNode;
        Node rightNode;

        Node(int value){
            this.value = value;
        }

        Node(int value, Node leftNode, Node rightNode){
            this.value = value;
            this.leftNode = leftNode;
            this.rightNode =rightNode;
        }

        void addNode(int newValue){
            // 이진 검색트리는 큰 값은 오른쪽 작은값은 왼쪽 노드로 추가한다.
            if(this.value < newValue){
                if(this.rightNode == null) this.rightNode =new Node(newValue);
                // 값이 null이 아니라면 rightNode의 하위노드로 추가한다.
                else this.rightNode.addNode(newValue);
            } else {
                if(this.leftNode == null) this.leftNode = new Node(newValue);
                else this.leftNode.addNode(newValue);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Node root = new Node(Integer.parseInt(bf.readLine()));

        String st;
        while(true){
            st = bf.readLine();
            if(st == null || st.isEmpty()) break;
            root.addNode((Integer.parseInt(st)));
        }
        postOrder(root);
    }

    // 후위순회
    static void postOrder(Node node){
        if(node == null) return;
        postOrder(node.leftNode);//왼
        postOrder(node.rightNode); //오른
        System.out.println(node.value);
    }
}
