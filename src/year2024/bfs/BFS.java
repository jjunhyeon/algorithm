package year2024.bfs;

import java.util.LinkedList;
import java.util.Queue;

/*
* BFS(레벨 탐색) 완전 탐색
* 모든 레벨의 원소를 탐색하면서 출력한다.
*
* */
public class BFS {
    static class Node{
        int data;
        Node lt, rt;
        public Node(int val){
            data = val;
            lt=rt=null;
        }
    }

    static class Main {
        Node root;
    public void BFS(Node root){
        Queue<Node> Q = new LinkedList<>();
        Q.offer(root);
        // L : 탐색레벨 (DEPTH)
        int L = 0;
        while(!Q.isEmpty()){
            int len = Q.size();
            System.out.print(L +" : ");
            for(int i=0; i< len; i++){
                Node cur = Q.poll();
                System.out.print(cur.data +" ");
                if(cur.lt != null){
                    Q.offer(cur.lt);
                }
                if (cur.rt != null) {
                    Q.offer(cur.rt);
                }
            }
            L++;
            System.out.println();
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
        tree.BFS(tree.root);
    }
}
