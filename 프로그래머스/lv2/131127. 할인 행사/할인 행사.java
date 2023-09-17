
import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int result = 0;
        int length = Arrays.stream(number).sum();

        HashMap<String, Integer> answers = new HashMap<>();
        for (int k = 0; k < want.length; k++) {
            int t = number[k];
            String item = want[k];
            for (int j = 0; j < t; j++) {
                answers.put(item, answers.getOrDefault(item, 0) + 1);
            }
        }

        for (int i = 0; i < discount.length; i++) {
            boolean isBuy = true;
            // i가 점차 증가함에 따라 discount의 길이가 length 보다 작으면?
            int realLength = (i + length > discount.length) ? discount.length : i + length;
            HashMap<String, Integer> tempAnswer = new HashMap<>();
            for (int j = i; j < realLength; j++) {
                tempAnswer.put(discount[j], tempAnswer.getOrDefault(discount[j], 0) + 1);
            }

            for (String key : answers.keySet()) {
                if (!(tempAnswer.containsKey(key) && answers.get(key) == tempAnswer.get(key))) {
                    isBuy = false;
                    break;
                }
            }
            if (isBuy) {
                result += 1;
            }
        }

        return result;
    }
}