package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 여행_1976 {
    static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int cityCnt = Integer.parseInt(bf.readLine());
        int lineCnt = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();

        parents = new int[cityCnt + 1];
        for (int i = 1; i <= cityCnt; i++) {
            parents[i] = i;
        }

        StringTokenizer st;
        for(int i=1; i<=cityCnt; i++){
            st = new StringTokenizer(bf.readLine());
            for(int j=1; j<=cityCnt; j++) {
                if(Integer.parseInt(st.nextToken()) == 1)  union(i, j);
            }
        }

        st = new StringTokenizer(bf.readLine());
        int start = find(Integer.parseInt(st.nextToken()));
        while(st.hasMoreTokens()){
            if(start != find(Integer.parseInt(st.nextToken()))){
                sb.append("NO");
                break;
            }
        }

        System.out.println(sb.length() == 0 ? "YES" : sb);
        bf.close();
    }

    static int find(int x) {
        if (parents[x] == x) {
            return x;
        } else {
            return parents[x] = find(parents[x]);
        }
    }

    static void union(int a, int b) {
        if (a < b) {
            parents[find(b)] = find(a);
        } else if (a > b) {
            parents[find(a)] = find(b);
        }
    }


}
