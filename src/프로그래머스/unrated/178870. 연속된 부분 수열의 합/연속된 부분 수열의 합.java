import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr, int k) {
         int sum = 0;
        int[] result = new int[2];
        result[0] = -1;
        result[1] = -1;
        int start = 0;
        int end = 0;
        for (int i = 0; i < arr.length; i++) {
            end = i;
            sum += arr[end]; // 값이 작으면 오른쪽으로 한칸씩

            while(sum > k){
                sum -= arr[start++]; // 값이 더 커지면 다시 왼쪽으로 한칸
            }

            if (sum == k) {
                if ((result[0] == -1 && result[1] == -1) || (end - start < result[1] - result[0])) {
                    result[0] = start;
                    result[1] = end;
                }
            }
        }
        return result;
    }
}