package year2024.programmers.level2;

import java.util.*;

public class 할인행사_131127 {

    public static void main(String[] args) {
        String[] want = {"banana", "apple", "rice", "pork", "pot"};
        int[] number = {3, 2, 2, 2, 1};
        String[] discount = {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"};
        solution(want, number, discount);
    }

    public static int solution(String[] want, int[] number, String[] discount) {
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
