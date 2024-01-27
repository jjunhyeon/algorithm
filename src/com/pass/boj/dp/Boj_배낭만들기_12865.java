import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 백준 - 배낭 만들기
public class Boj_배낭만들기_12865 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        st = new StringTokenizer(bf.readLine());

        // 물품의 수
        int T = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        // 무게별, 최대 가중치 정보를 저장한다.
        int[] dp = new int[W + 1];

        List<int[]> myList = new ArrayList<>();
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(bf.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            myList.add(new int[]{weight,value});
        }

        // 무게별, 최대 가중치 값으로 저장한다.
        // weight 보다 작은 값에 대해 dp의 값을 모두 업데이트한다.
        // 4,6,4,3,5 값에 대한 조합을 적용해야한다. 그치?
        // dfs ? O(log n)
        for(int i=0; i<T; i++){
            // 무게 초과
            int curWeight = myList.get(i)[0];
            int curValue = myList.get(i)[1];
            if(curWeight > W) continue;
            dp[curWeight] = Math.max(dp[curWeight], curValue);
        }

        // TODO
        // 사랑니 이슈로 진행이 어렵다.. 다시풀어보자.

        int answer = 0;
        for(int i=1; i<=W; i++){
            answer = Math.max(answer, dp[i]);
        }

        System.out.println(answer);
        bf.close();
    }
}