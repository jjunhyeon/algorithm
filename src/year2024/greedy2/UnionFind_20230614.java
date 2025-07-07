package year2024.greedy2;

import java.util.Scanner;
/*
* 친구인가? (Union / Find)
* */
public class UnionFind_20230614 {
    static int[] relation;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int arrCount = sc.nextInt();
        relation = new int[k +1];
        for(int i=1; i<=k; i++){
            relation[i] = i;
        }

        for(int i=1; i<=arrCount; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            Union(a,b);
        }

        int a = sc.nextInt();
        int b = sc.nextInt();
        int fa = find(a);
        int fb = find(b);
        if(fa == fb){
            System.out.println("YES");
        } else{
            System.out.println("NO");
        }
    }

    // 친구 관계 연결
    private static void Union(int a, int b) {
        int fa = find(a);
        int fb = find(b);
        if(fa != fb){
            relation[fa] = fb;
        }
    }

    // 친구 검증
    private static int find(int V) {
        if(relation[V] == V){
            return V;
        } else {
            // 길이진 관계에 대해 바로 처리하기 위한 코드
            // realtion[V]값에 find에 대한 결과값을 바로 넣음으로써 재귀 호출을 최소화한다.
            return relation[V] = find(relation[V]);
        }
    }
}
