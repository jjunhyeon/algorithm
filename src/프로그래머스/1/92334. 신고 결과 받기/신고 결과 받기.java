import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = {};
        // 중복 신고 필터 + 정렬 순서 유지를 위해 사용
        Set<String> reportSet = new LinkedHashSet<String>();
        // 순서 유지
        Map<String,List<String>> reportMap = new LinkedHashMap<>();
        Map<String, Integer> reportedUser = new HashMap<>();
        int listSize = id_list.length;
        
        answer = new int[listSize];
        // 맵 데이터 초기화
        for(int i=0; i<listSize; i++){
            reportMap.put(id_list[i], new ArrayList<String>());
        }

        int reportLoopSize = report.length;     
        // 1. set에 데이터 넣기
        for(int i=0; i<reportLoopSize; i++){
            reportSet.add(report[i]);
        }
        // 2. 신고 정보와 종합 신고 정보 데이터 세팅
        for(String rep: reportSet){
            String reporter = rep.split(" ")[0];
            String reported = rep.split(" ")[1];
            reportMap.get(reporter).add(reported); 
            reportedUser.put(reported, reportedUser.getOrDefault(reported,0) + 1);
        }

        for(String key : reportedUser.keySet()){
            if(reportedUser.get(key) >= k){
                int idx = 0;
                for(String reportKey : reportMap.keySet()){                    
                    List<String> target = reportMap.get(reportKey);
                    // 신고당한사람이 포함되어 있다면
                    if(target.contains(key)) answer[idx] += 1;
                    idx ++;
                }
            }
        }
        return answer;
    }
}