package com.pass.programmers.level2;


import java.util.*;

/*
*
1. Map에 기본 a - z 넘버링 담는다 Map<String,Integer>
2. 문자열을 탐색하면서 currentString + nextString check
3. if (true) => + nextChar check (until not contain)
4. else => put && result[idx] = map.get(key);
* */
public class 압축3차_17684 {
    public static void main(String[] args) {
        String msg = "TOBEORNOTTOBEORTOBEORNOT";
        //String msg = "KAKAO";
        solution(msg);
    }

    private static int[] solution(String msg) {

        List<Integer> answerList = new ArrayList<>();
        // 1. msg validate skip 압축 알고리즘은 영문 대문자만 처리한다.
        // Locale.ROOT : default 대문자 처리 옵션
        msg = msg.toUpperCase(Locale.ROOT);
        int msgSize = msg.length();

        // 2. 기본 dictionary 만들기
        // 순서보장 및 integer 값 세팅을 위해 필요한 변수 처리를 사용하지 않기 위해 일반 Map이 아닌 LinkedHashMap 사용
        Map<String, Integer> myDictionary = new LinkedHashMap<>();

        // 1단계 문자열 처리
        for (char c = 'A'; c <= 'Z'; c++) {
            myDictionary.put(String.valueOf(c), myDictionary.size() + 1);
        }

        // 2. 문자열을 탐색하면서 currentString + nextString check
        for (int i = 0; i < msgSize; i++) {
            // 현재 한글자의 스트링
            StringBuilder currentString = new StringBuilder();
            currentString.append(msg.charAt(i));

            int idx = i + 1;

            while (idx < msg.length()) {
                // 포함하지 않는다면 정답입니다.
                if (!myDictionary.containsKey(currentString + String.valueOf(msg.charAt(idx)))) {
                    // 정답에 넣고, 다음 idx번호를 map에 색인에 추가 해야겠죠
                    answerList.add(myDictionary.get(currentString.toString()));
                    myDictionary.put(currentString.append(msg.charAt(idx)).toString(), myDictionary.size() + 1);
                    break;
                }
                currentString.append(msg.charAt(idx));
                i++;
                idx++;
            }
            // idx len은 끝났는데 현재 처리해야할 str이 남았을경우 처리
            if (idx == msg.length()) answerList.add(myDictionary.get(currentString.toString()));
        }

        return answerList.stream().mapToInt(Integer::intValue).toArray();
    }
}
