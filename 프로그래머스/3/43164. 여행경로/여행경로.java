import java.util.*;
class Solution {
    public static boolean[] isVisitedArray;
    public static String[] resultArray;
    public static String[] result;
    
    public String[] solution(String[][] tickets) {
        isVisitedArray = new boolean[tickets.length + 1];
        // 최종 여행경로는 input param의 길이 +1이다.
        resultArray = new String[tickets.length + 1];
        result = new String[tickets.length + 1];
        getAirPortPathByDfs(tickets, 0);
        return result;
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
            String departuresAirPort = tickets[i][0];
            String destinationAirPort = tickets[i][1];
            // 방문하지 않았다면
            if (!isVisitedArray[i]) {
                // 이전 출발지 또는 도착지 정보를 가져와야함 result[i-1]에 있음
                if (depth == 0 && departuresAirPort.equals("ICN")) {
                    isVisitedArray[i] = true;
                    resultArray[0] = departuresAirPort;
                    resultArray[1] = destinationAirPort;
                    getAirPortPathByDfs(tickets, depth + 1);
                    isVisitedArray[i] = false;
                } 
                
                if(depth >0){
                    String beforeAirPort = resultArray[depth];
                    if (beforeAirPort.equals(departuresAirPort)) {
                        isVisitedArray[i] = true;
                        resultArray[depth + 1] = destinationAirPort;
                        getAirPortPathByDfs(tickets, depth + 1);
                        isVisitedArray[i] = false;
                    }
                    continue;
                }
            }
        }
    }
}