package programmers.level2;

import java.util.*;

public class 순위검색_72412 {
    public static void main(String[] args) {
        String[] info = {"java backend junior pizza 150", "python frontend senior chicken 210", "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80", "python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100", "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250", "- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150"};
        solution(info, query);
    }

    static Map<String, List<Integer>> userMap = new TreeMap<>();

    private static int[] solution(String[] info, String[] query) {
        int[] answer = {};
        answer = new int[query.length];

        for (int i = 0; i < info.length; i++) {
            setMap(0, "", info[i].split(" "));
        }

        for (String key : userMap.keySet()) {
            Collections.sort(userMap.get(key));
        }

        int idx = 0;
        for (String sql : query) {
            // and + 공백으로 구분
            String[] sqlArray = sql.split("and");
            int score = Integer.parseInt(sqlArray[3].split(" ")[2].trim());
            StringBuilder target = new StringBuilder();
            target.append(sqlArray[0].trim()).append(sqlArray[1].trim()).append(sqlArray[2].trim()).append(sqlArray[3].split(" ")[1]);
            for (String key : userMap.keySet()) {
                if (key.contains(target)) {
                    List<Integer> userValue = userMap.get(key);
                    // 이분탐색 value에서 스코어 찾기
                    Collections.sort(userValue);
                    int low = 0;
                    int high = userValue.size();

                    while (low < high) {
                        int mid = (low + high) / 2;
                        if (userValue.get(mid) < score) low = mid + 1;
                        else high = mid;
                    }
                    answer[idx] = userValue.size() - low;
                }
            }
            idx++;
        }
        return answer;
    }

    public static void setMap(int idx, String s, String arr[]) {
        if (idx == 4) {
            userMap.computeIfAbsent(s, k -> new ArrayList<Integer>()).add(Integer.parseInt(arr[4]));
            return;
        }

        setMap(idx + 1, s + arr[idx], arr);
        setMap(idx + 1, s + "-", arr);
    }

}
