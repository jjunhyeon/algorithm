package src.year2024.programmers.level2;

import java.util.*;

/*
 * Union / find
 * */
public class 혼자놀기_131130 {

    static int[] parent;
    public static void main(String[] args) {
        //int[] cards = {8,6,3,7,2,5,1,4};
        int[] cards = {1,5,3,2,6,7,8,4};
        solution(cards);
    }

    public static int solution(int[] cards) {
        parent = new int[cards.length + 1];

        Map<Integer,Integer> resultMap = new HashMap<>();
        // parent 초기값
        for (int i = 1; i <= cards.length; i++) {
            parent[i] = i;
        }
        
        // 같은 집합끼리 같은 넘버로 그룹핑
        for (int i = 1; i <= cards.length; i++) {
            union(i, cards[i - 1]);
        }

        for (int i = 1; i < parent.length; i++) {
            int root = find(i);
            resultMap.put(root, resultMap.getOrDefault(root, 0) + 1);
        }

        if(resultMap.size() == 1){
            return 0;
        }
        ArrayList<Integer> answer = new ArrayList<Integer>(resultMap.values());
        Collections.sort(answer, Comparator.reverseOrder());
        return answer.get(0) * answer.get(1);
    }

    // 관계연결
    public static void union(int a, int b) {
        int fa = find(a);
        int fb = find(b);
        if (fa != fb) {
            parent[fa] = fb;
        }
    }

    // 검증
    public static int find(int V) {
        if (parent[V] == V) {
            return V;
        } else {
            // 관계가 길어질 경우 처리하기 위한 코드
            // find 하면서 만난 모든 값의 부모 노드를 root로 만든다.
            return parent[V] = find(parent[V]);
        }
    }
}
