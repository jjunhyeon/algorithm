package com.pass.algostudy.recursive;


/*
* DFS(깊이 우선 탐색)
* 이진트리 순회
* 해당 문제는 최소 Depth를 구하기 위해선 BFS 코드로 처리해야하지만
* 연습을 위해 dfs로 처리
* 그러므로 하위 노드 둘 다 null이 아닌 값이 있으면 에러가 난다.
* */
public class DFS_20230430 {
    static class Main {
        Node root;
    public int DFS(int L, Node root){
        // lt 와 rt가 모두 없다면 그때의 Level 값 리턴
        if(root.lt == null && root.rt == null){
            return L;
        } else {
            return Math.min(DFS(L+1,root.lt), DFS(L+1,root.rt));
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
        System.out.println(tree.DFS(0,tree.root));
    }
}

