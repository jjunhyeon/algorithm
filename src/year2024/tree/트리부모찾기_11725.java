package year2024.tree;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
* 트리의 부모찾기
* */
public class 트리부모찾기_11725 {
    static ArrayList<ArrayList<Integer>> nodeList = new ArrayList<>();
    static boolean[] isVisited;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        // 간선 관계 정보
        int N = Integer.parseInt(bf.readLine());
        isVisited = new boolean[N + 1];
        parent = new int[N+1];

        for(int i=0; i<N+1; i++){
            nodeList.add(new ArrayList<>());
        }

        for(int i=0; i<N-1; i++){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int parentValue =  Integer.parseInt(st.nextToken());
            int childValue = Integer.parseInt(st.nextToken());
            nodeList.get(parentValue).add(childValue);
            nodeList.get(childValue).add(parentValue);
        }

        dfs(1);
        for(int i=2; i<parent.length; i++) System.out.println(parent[i]);
        bf.close();
    }

    public static void dfs(int start){
        for(Integer item : nodeList.get(start)){
            if(isVisited[item]) continue;
            isVisited[item] = true;
            parent[item] = start;
            dfs(item);
        }
    }
}
