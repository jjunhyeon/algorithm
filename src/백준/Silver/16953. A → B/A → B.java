import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.StringTokenizer;

/*
 * A -> B
 * */
public class Main {
    public static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        long N = Long.parseLong(st.nextToken());
        long M = Long.parseLong(st.nextToken());
        getCountOfAtoB(N, M, 1);
        answer = (answer == 0) ? -1 : answer;
        System.out.println(answer);
    }

    private static void getCountOfAtoB(long start, long target, int depth) {

        // 더 커버리면 빠구
        if (start > target) {
            return;
        }

        // 정답 처리2
        if (start == target) {
            answer = depth;
            return;
        }

        getCountOfAtoB(start * 2, target, depth + 1);
        getCountOfAtoB(start * 10 + 1, target, depth + 1);
    }
}
