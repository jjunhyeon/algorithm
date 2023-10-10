import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = Long.MAX_VALUE;

        // 초기값과 최악의값을 설정하기 위해 정렬한다.
        Arrays.sort(times);
        long start = times[0];
        long end = (long) times[times.length-1] * n;

        long mid = 0;
        long sum =0;
        // 이분탐색 조건
        while(start <= end){
            mid = (start + end) / 2;
            sum = 0;
            for(int time : times){
                sum += mid/time;
            }

            if(sum < n){
                start = mid + 1;
            } else {
                answer = Math.min(answer, mid);
                end = mid -1;
            }
        }

        return answer;
    }
    
}