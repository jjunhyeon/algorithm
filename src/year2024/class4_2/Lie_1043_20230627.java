package src.year2024.class4_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
* 거짓말(1043번)
* */
public class Lie_1043_20230627 {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] N = bf.readLine().split(" ");

        int n = Integer.parseInt(N[0]); // 사람의 수
        int m = Integer.parseInt(N[1]); // arr의 수

        boolean[] info = new boolean[n+1]; // 알고있으면 T, 아니면 F
        N = bf.readLine().split(" ");
        int trueCount = Integer.parseInt(N[0]); // 사람의 수
        for(int i=1; i<=trueCount; i++){
            int x = Integer.parseInt(N[i]);
            info[x] = true;
        }

        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        // 파티원 정보
        ArrayList<ArrayList<Integer>> party = new ArrayList<ArrayList<Integer>>();
        for(int i=0; i<=m; i++){
            party.add(new ArrayList<>());
        }

        for (int i = 1; i <= m; i++) {
            String[] partyInfo = bf.readLine().split(" ");
            // 파티에 오는 사람 수
            int pCount = Integer.parseInt(partyInfo[0]);

            if(pCount <= 1) {
                party.get(i).add(Integer.parseInt(partyInfo[1]));
                continue;
            }

            for(int j=1; j<pCount; j++){
                int a = Integer.parseInt(partyInfo[j]);
                int b = Integer.parseInt(partyInfo[j+1]);
                if (find(a) != find(b)) {
                    union(a,b);
                }
                party.get(i).add(a); // 파티에 참여하는 사람 저장
                party.get(i).add(b);
            }
        }

        // 진실을 아는 사람과 연관 관계 있음 => info[i] T로 변경
        boolean[] visited = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            if(info[i] && !visited[i]){
                int root = find(i);
                for (int j = 1; j <= n; j++){
                    if (find(j)==root) {
                        info[j] = true;
                        visited[j] = true;
                    }
                }
            }
        }

        // 모든 파티 참석자가 F여야 과장된 얘기를 할 수 있음
        int result = 0;
        for (int i = 1; i <= m; i++) { // party
            boolean flag = false;
            for(int human : party.get(i)){
                if(info[human]){
                    flag = true;
                    break;
                }
            }
            if(!flag) result++;
        }
        System.out.println(result);
    }

    // 친구 관계 연결
    private static void union(int a, int b) {
        int fa = find(a);
        int fb = find(b);
        if(fa != fb){
            parent[fa] = fb;
        }
    }

    // 친구 검증
    private static int find(int V) {
        if(parent[V] == V){
            return V;
        } else {
            // 길이진 관계에 대해 바로 처리하기 위한 코드
            // realtion[V]값에 find에 대한 결과값을 바로 넣음으로써 재귀 호출을 최소화한다.
            return parent[V] = find(parent[V]);
        }
    }
}
