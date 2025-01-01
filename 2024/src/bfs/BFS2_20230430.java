package bfs;

import java.util.LinkedList;
import java.util.Queue;

/*
 * BFS(Level 탐색)
 * */
public class BFS2_20230430 {
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
        public int BFS2(Node root){
            Queue<Node> Q = new LinkedList<>();
            Q.offer(root);
            int L = 0;
            while(!Q.isEmpty()){
                int len = Q.size();
                for(int i=0; i<len; i++){
                    Node cur = Q.poll();
                    // lt와 rt중 null 이 있으면 그 녀석은 말단 노드
                    if(cur.lt == null && cur.rt == null){
                        return L;
                    }
                    if(cur.lt != null) {
                        Q.offer(cur.lt);
                    }
                    if(cur.rt != null) {
                        Q.offer(cur.rt);
                    }
                }
                L++;
            }
            return 0;
        }
    }

    public static void main (String args[]){
        Main tree = new Main();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        System.out.println(tree.BFS2(tree.root));
    }
}

