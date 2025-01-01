package dfs;

/*
* DFS(깊이 우선 탐색) 기초
* 이진트리 순회
* 전위순회
* 부모 -> 왼쪽 자식 -> 오른쪽 자식(부모가 기준)
* 중위순회 출력(부모가 가운데)
* 왼쪽자식 -> 부모 -> 오른쪽자식
* 후위순회 (부모가 마지막)
* 왼쪽자식 -> 오른쪽 자식 -> 부모
*
* */
public class DFSBasic_20230409 {
    static class Main {
        Node root;
    public void DFS(Node root){
        if (root == null) {
            return;
        } else {
            // 전위순회
            //System.out.print(root.data + " ");
            DFS(root.lt);
            // 중위순회
            //System.out.print(root.data + " ");
            DFS(root.rt);
            // 후위순회
            System.out.print(root.data + " ");
        }
    }
}

    public static void main (String args[]){
        Main tree = new Main();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        tree.root.rt.lt= new Node(6);
        tree.root.rt.rt = new Node(7);
        tree.DFS(tree.root);
    }
}

class Node{
    int data;
    Node lt, rt;
    public Node(int val){
        data = val;
        lt=rt=null;
    }
}
