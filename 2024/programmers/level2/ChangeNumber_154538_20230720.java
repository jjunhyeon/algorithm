package programmers.level2;

import java.util.LinkedList;
import java.util.Queue;

public class ChangeNumber_154538_20230720 {

    static int[] changeParameters;
    static int[] result;

    public static void main(String[] args) {
        solution(10, 40, 5);
    }

    public static int solution(int x, int y, int n) {

        if (x == y) {
            return 0;
        }

        changeParameters = new int[]{2, 3, n};
        result = new int[10000001];
        int answer = bfs(x, y);

        return answer;
    }

    public static int bfs(int x, int target) {
        Queue<Integer> intQ = new LinkedList<Integer>();
        intQ.offer(x);

        while (!intQ.isEmpty()) {
            int nowValue = intQ.poll();
            // 숫자에 대한 처리 진행
            for (int i = 0; i < 3; i++) {
                int changedNum = 0;

                if (i == 2) {
                    changedNum = nowValue + changeParameters[i];
                } else {
                    changedNum = nowValue * changeParameters[i];
                }
                
                // 값 넘어버리면 무시
                if(changedNum > target){
                    continue;
                }

                // 다음 값이 처음, 현재값의 값보다 더 크다면
                if(result[changedNum] == 0 || result[changedNum] > result[nowValue] + 1){
                    result[changedNum] = result[nowValue] + 1;
                    intQ.offer(changedNum);
                }
            }
        }
        // 0이 아니라면 리턴 , 0이라면 값에 도달할 수 없는것이므로 -1
        return result[target] != 0 ? result[target] : -1;
    }
}
