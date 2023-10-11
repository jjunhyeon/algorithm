// 12: 20 ~ 
import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

class Solution {
    static Map<String, CustumStringDate> custumMap = new HashMap<>();    
    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer = {};
        ArrayList<Integer> answerList = new ArrayList<>();
        makeTermsExpiredDate(today,terms);
        int idx =1;
        for(String privacy : privacies){
            // 약관명
            boolean isExpiredTerm = true;
            String termName = privacy.split(" ")[1];
            for (String key : custumMap.keySet()) {
                if(key.equals(termName)){
                    String termDate = privacy.split(" ")[0];
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.M.d");
                    LocalDate nowTermDate = LocalDate.parse(termDate,formatter);
                    // privacy에 가지고 있는 약관정보가 오늘 날짜를 기준으로 생성한 만료일자 이전이거나 같은날이라면 false 처리한다.
                    if(nowTermDate.isEqual(custumMap.get(key).expiredDay) || nowTermDate.isBefore(custumMap.get(key).expiredDay)){
                        isExpiredTerm = false;
                        break;
                    }
                }
            }  
            if(!isExpiredTerm){
                answerList.add(idx);
            }
            idx ++;
        }
        return answer = answerList.stream().mapToInt(Integer::intValue).toArray();
    }
    
    // 각 약관에 대한 만료일자를 생성하는 map생성
    public static void makeTermsExpiredDate(String today, String[] terms){
        for(String term : terms){
            String temrName = term.split(" ")[0];
            int addMonth = Integer.parseInt(term.split(" ")[1]);   
            custumMap.put(temrName, new CustumStringDate(addMonth,today));
        }
    }

    public static class CustumStringDate {
        int addMonth;
        String today;
        LocalDate expiredDay;
        public CustumStringDate(int addMonth, String today){
            this.today = today;
            this.addMonth = addMonth;
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.M.d");
            LocalDate date = LocalDate.parse(today,formatter);
            this.expiredDay = date.minusMonths(addMonth);
        }
        @Override
        public String toString(){
            return this.addMonth + " " + this.today + " " + this.expiredDay;
        }
    }
}