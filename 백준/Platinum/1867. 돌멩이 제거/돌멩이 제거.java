
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * packageName    : com.pass.boj.study
 * fileName       : 돌멩이제거_1867
 * author         : junhyeon
 * date           : 2024-04-28
 * description    : 모르겠음 ;;
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-04-28        junhyeon       최초 생성
 */
public class Main {
    static int[] matched;
    static boolean[] v;
    static ArrayList<Integer>[] edges;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        edges = new ArrayList[n+1];
        matched = new int[n+1];
        Arrays.fill(matched, -1);
        for (int i = 1; i <= n; i++) edges[i] = new ArrayList<>();
        while (k-->0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            edges[a].add(b);
        }
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (edges[i].size() == 0) continue;
            v = new boolean[n+1];
            if (matching(i))
                cnt++;
        }
        System.out.println(cnt);
    }

    static boolean matching(int a) {
        for (int b : edges[a]) {
            if (v[b]) continue;
            v[b] = true;
            if (matched[b] == -1 || matching(matched[b])) {
                matched[b] = a;
                return true;
            }
        }
        return false;
    }

}
