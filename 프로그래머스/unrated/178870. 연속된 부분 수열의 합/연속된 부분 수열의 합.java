import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr, int k) {
        Arrays.sort(arr); // 정렬
        int sum = 0;
        int[] result = new int[2];
        ArrayList<Integer> answerList = new ArrayList<>();
        for(int i=0; i<arr.length; i++){
            sum += arr[i];
            answerList.add(i); // 인데스번호 넣기
            if(sum == k){
                if(answerList.size() == 1){
                  result[0] = result[1] = answerList.get(0);
                  break;
                }
                // 비어있지 않고 교체할 수 있다면
                if(answerList.isEmpty() || (answerList.size() > (result[1] - result[0] + 1))){
                    result[0] = answerList.get(0);
                    result[1] = answerList.get(i);
                    answerList.clear();
                    sum = 0;
                }
            } else if(sum > k){
                sum = 0;
                answerList.clear();
            }
        }
        return result;
    }
}