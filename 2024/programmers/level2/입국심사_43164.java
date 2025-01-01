package programmers.level2;

import java.util.Arrays;

/*
* 이분탐색 ...
* 이분탐색
* : 정렬된 배열안에서 특정 원소를 찾기 위해 인덱스 0부터 차례로 탐색
* mid의 값 < 찾는 원소 일때 left는 mid + 1로 하여 다시 반복
* mid의 값 > 찾는 원소 일때는 right = mid -1로 하여 다시 반복
* start, mid, end 값을 설정해야한다.
* 이 문제에선 time이 그 기준이며, tiems를 정렬 후 start는 times[0]으로 설정하고
* end값은 tiems[times-1] 값으로 설정한다.
* */
public class 입국심사_43164 {
    public static void main(String[] args) {
        int n = 6;
        int[] times = {7,10};
        solution(n, times);
    }

    public static long solution(int n, int[] times){
        long answer = Long.MAX_VALUE;

        // 초기값과 최악의값을 설정하기 위해 정렬한다.
        Arrays.sort(times);
        long start = times[0];
        long end = (long) times[times.length-1] * n;

        // 이분탐색 조건
        while(start <= end){
            long mid = (start + end) / 2;
            long sum = 0;
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
