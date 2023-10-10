package com.pass.programmers.level2;

import java.util.Arrays;
import java.util.Objects;

/*
 * dfs 해결
 * 모든 depth를 탐색하면서 최종 배열을 리턴한다.
 * 13:30 ~ 15:10
 * */
public class 여행경로_43238 {
    public static boolean[] isVisitedArray;
    public static String[] resultArray;
    public static String[] result;

    public static void main(String[] args) {
        //String]{] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}};
        // String[][] tickets = {{"ICN", "BOO"}, {"ICN", "COO"}, {"COO", "DOO"}, {"DOO", "COO"}, {"BOO", "DOO"}, {"DOO", "BOO"}, {"BOO", "ICN"}, {"COO", "BOO"}};
        String[][] tickets = {{"ICN", "JFK"}, {"ICN", "AAD"}, {"JFK", "ICN"}};
        isVisitedArray = new boolean[tickets.length + 1];
        // 최종 여행경로는 input param의 길이 +1이다.
        resultArray = new String[tickets.length + 1];
        result = new String[tickets.length + 1];
        getAirPortPathByDfs(tickets, 0);
        System.out.println("arrays to sring" + Arrays.toString(result));
    }

    public static void getAirPortPathByDfs(String[][] tickets, int depth) {

        // 종료조건
        if (depth == tickets.length) {
            if (Objects.isNull(result[0])) {
                result = Arrays.copyOf(resultArray, result.length);
            } else {
                for (int i = 0; i < resultArray.length; i++) {
                    if (result[i].equals(resultArray[i])) {
                        continue;
                    } else {
                        if (result[i].compareTo(resultArray[i]) > 0) {
                            result = Arrays.copyOf(resultArray, result.length);
                        }
                        break;
                    }
                }
            }
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            // 출발지, 도착지 정보
            String departuresAirPort = tickets[i][0];
            String destinationAirPort = tickets[i][1];
            // 방문하지 않았다면
            if (!isVisitedArray[i]) {
                // 처음엔 출발지 도착지 함께 처리 출발지는 ICN 고정
                if (depth == 0 && departuresAirPort.equals("ICN")) {
                    isVisitedArray[i] = true;
                    resultArray[0] = departuresAirPort;
                    resultArray[1] = destinationAirPort;
                    getAirPortPathByDfs(tickets, depth + 1);
                    isVisitedArray[i] = false;
                }

                // 출발지 이후
                if (depth > 0) {
                    String beforeAirPort = resultArray[depth];
                    // 이전 도착지와, 새로운 시작지가 같은곳
                    if (beforeAirPort.equals(departuresAirPort)) {
                        isVisitedArray[i] = true;
                        resultArray[depth + 1] = destinationAirPort;
                        getAirPortPathByDfs(tickets, depth + 1);
                        isVisitedArray[i] = false;
                    }
                    // 같지 않으면 다음 i를 찾는다.
                    continue;
                }

            }
        }
    }
}
