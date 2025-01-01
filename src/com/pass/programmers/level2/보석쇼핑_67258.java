package com.pass.programmers.level2;

import java.util.*;

/*
* 보석쇼핑
* 보석쇼핑
* 어피치의 쇼핑습관
* 스트레이트로 구간을 선택하는데 모든 종류의 보석을 선택할 수 있는 가장 짧은 구간을 찾아 리턴하는 문제
* 12: 35 ~
* 1. gems 정보를 set 자료구조에 담아 모든 종류의 보석 종류를 가져온다.
* 2. 결과 구간 리턴
* */
public class 보석쇼핑_67258 {
    public static void main(String[] args) {
        String[] gems = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
        //String[] gems ={"AA", "AB", "AC", "AA", "AC"};
        solution(gems);
    }

    private static int[] solution(String[] gems) {
        Set<String> gemsSet = new HashSet<>();
        Map<String,Integer> gemMap = new HashMap<>();
        // 1. set 구조 세팅
        for(String gem : gems){
            gemsSet.add(gem);
        }

        int gemSize = gems.length;
        int setSize = gemsSet.size();
        int[] result = {-1, gemSize}; // 초기값 설정
        int startValue = 0;
        for(int i=0; i<gemSize; i++){
            gemMap.put(gems[i], gemMap.getOrDefault(gems[i], 0) + 1);

            if(gemMap.size() == setSize){
                // 최소한의 보석이 들어갈 수 있는 사이즈의 조건임
                while(gemMap.size() == setSize){ // 하나씩 지워나가면서 중복된 값이 앞전에 몇개 포함되었는지를 식별한다.
                    gemMap.put(gems[startValue], gemMap.get(gems[startValue]) - 1);
                    // 최종적으로 중복된 값이 0이 되었을때, 그 개수만큼 인덱스의 개수가 감소된 구간이 최소의 정답 구간이다.
                    if (gemMap.get(gems[startValue]) == 0) {
                        gemMap.remove(gems[startValue]);
                    }
                    startValue++;
                }

                // 구간의 길이를 찾는다.(구간 길이 비교 이후 업데이트를 위함)
                if (i - startValue + 1 < result[1] - result[0]) {
                    result[0] = startValue;
                    result[1] = i + 1;
                }
            }
        }

        return result;
    }
}
