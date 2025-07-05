import java.util.*;
class Solution {
    static int[] changeParameters;
    static int[] result;
    
    public int solution(int x, int y, int n) {
      
        if (x == y) {
            return 0;
        }
        
        changeParameters = new int[]{2, 3, n};
        result = new int[10000001];
        int answer = bfs(x, y);
        return answer;
    }
    
     public int bfs(int x, int target) {
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
         return result[target] != 0 ? result[target] : -1;
    }
}