package programmers.level2;

import java.util.Arrays;

public class 시소짝꿍_152996_20230808_RE {
    public static void main(String[] args) {
        int[] weights = {100, 180, 360, 100, 270};
        solution(weights);
    }

    /*
    * 1.이분탐색
    * */
    private static int solution(int[] weights) {
        int result =0;

        // 중복 처리 방지를 위한 prev 변수
        int prev  =0 ;
        Arrays.sort(weights);

        for(int i=0; i< weights.length - 1; i++){

            // 같은 값일 경우
            if(i > 0 && weights[i] == weights[i-1]){
                prev--;
                result+=prev;
                continue;
            }
            // 최대 j값을 찾는다 
            // 단순 이중포문은 TLE 발생
            int j =findMaxJ(weights,weights[i],i+1);
            prev = 0;
            for(; j>i; j--){
                // case i < j 중 식별
                if(weights[i] == weights[j]){
                    prev++;
                } else if(weights[i] * 4 == weights[j] * 3){
                    prev++;
                } else if(weights[i] * 4 == weights[j] * 2){
                    prev++;
                } else if(weights[i] * 3 == weights[j] * 2){
                    prev++;
                }
            }
            result+=prev;
        }
        return result;
    }

    private static int findMaxJ(int[] weights, int num, int i) {
        int left = i;
        int right = weights.length-1;
        while(left < right){
            int mid = left + (right - left) / 2;
            if(weights[mid] > num * 2) {
                return mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
