package src.year2024.programmers.level2;

import java.util.Arrays;

/*
 * 연속된 부분 순열, 프로그래머스(178870)
 * */
public class Subsequence_20230710 {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 1, 2, 3, 4, 5};
        int k = 5;
        System.out.println(Arrays.toString(twoPointer(arr, k)));
    }

    public static int[] twoPointer(int[] arr, int k) {
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
                //초기값이거나 , 더 범위가 좁다면 교체
                if ((result[0] == -1 && result[1] == -1) || (end - start < result[1] - result[0])) {
                    result[0] = start;
                    result[1] = end;
                }
            }
        }
        return result;
    }

    // fail
    // 한쪽으로만 값을 증가시켰을때, target값이 초과했을떄 돌아올 수가 없었음
    /*private static int[] solution(int[] arr, int k) {
        Arrays.sort(arr); // 정렬
        int sum = 0;
        int[] result = new int[2];
        ArrayList<Integer> answerList = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            answerList.add(i); // 인데스번호 넣기
            if (sum == k) {
                if (answerList.size() == 1) {
                    result[0] = result[1] = answerList.get(0);
                    break;
                }
                // 비어있지 않고 교체할 수 있다면
                if (answerList.isEmpty() || (answerList.size() > (result[1] - result[0] + 1))) {
                    result[0] = answerList.get(0);
                    result[1] = answerList.get(i);
                    answerList.clear();
                    sum = 0;
                }
            } else if (sum > k) {
                sum = 0;
                answerList.clear();
            }
        }
        System.out.println(Arrays.toString(result));
        return result;
    }*/
}
