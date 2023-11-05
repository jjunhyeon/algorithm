import java.util.*;
class Solution {
    static Map<String, List<Integer>> userMap = new TreeMap<>();
    public int[] solution(String[] info, String[] query) {
               int[] answer = {};
        answer = new int[query.length];

        for (int i = 0; i < info.length; i++) {
            setMap(0, "", info[i].split(" "));
        }

        for(String key : userMap.keySet()){
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
                        //Collections.sort(userValue);
                        int low = 0;
                        int high = userValue.size();

                        while (low < high) {
                            int mid = (low + high) / 2;
                            if(userValue.get(mid) < score) low = mid + 1;
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