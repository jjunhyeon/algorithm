package src.year2024.programmers.level2;

import java.util.*;

public class 주차요금계산_92341 {

    public static void main(String[] args) {
        //int[] fees = {180, 5000, 10, 600};
        //String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
        int[] fees = {180, 5000, 10, 1000};
        //String[] records = {"16:00 3961 IN", "17:00 2541 OUT", "17:00 2541 IN", "23:54 2741 IN"};
        String[] records = {"17:00 3961 IN", "17:01 2541 OUT","17:01 2541 IN"};
        solution(fees, records);
    }

    public static int[] solution(int[] fees, String[] records) {
        int[] answer = {};
        PriorityQueue<Fare> fareQ = new PriorityQueue<>();

        HashMap<String, Integer> answerMap = new HashMap<>();
        for (int i = 0; i < records.length; i++) {
            String eachRecord = records[i];
            String[] target = eachRecord.split(" ");
            fareQ.add(new Fare(target[0], target[1], target[2]));
        }

        // 초기값
        Fare targetCar = fareQ.poll();
        // 1번 출입 차
        String nowCarNumber = targetCar.carNumber;
        int nowHour = Integer.parseInt(targetCar.hourAndMinute.split(":")[0]);
        int nowMinute = Integer.parseInt(targetCar.hourAndMinute.split(":")[1]);
        String nowStatus = targetCar.InOrOutInfo;
        if (fareQ.isEmpty()) {
            int totalTime = (23 - nowHour) * 60 + 59 - nowMinute;
            answer = new int[1];
            if (totalTime <= fees[0]) {
                answer[0] = fees[1];
            } else {
                // Math.ceil -> 올림처리 return double
                answer[0] = fees[1] + (int) Math.ceil((double) (totalTime - fees[0]) / fees[2]) * fees[3];
            }
            return answer;
        }
        // 1개만 있을경우에 대한 처리
        while (!fareQ.isEmpty()) {
            // 현재 target
            Fare nextFareInfo = fareQ.poll();
            String nextCarNumber = nextFareInfo.carNumber;
            int newHour = Integer.parseInt(nextFareInfo.hourAndMinute.split(":")[0]);
            int newMinute = Integer.parseInt(nextFareInfo.hourAndMinute.split(":")[1]);

            // 이전 차와 지금 차 번호가 일치하고 OUT이라면 정산
            if (nowCarNumber.equals(nextCarNumber) && "OUT".equals(nextFareInfo.InOrOutInfo)) {
                // IN -> OUT 정산해야하는 케이스
                nowStatus = nextFareInfo.InOrOutInfo;
                int totalMinute = (newHour - nowHour) * 60 + newMinute - nowMinute;
                // 기본시간보다 작을 시 기본요금만 부과, 총 시간만 누적
                answerMap.put(nextCarNumber, answerMap.getOrDefault(nextCarNumber, 0) + totalMinute);
            } else if (nowCarNumber.equals(nextFareInfo.carNumber) && "IN".equals(nextFareInfo.InOrOutInfo)) {
                // 나간후에 즉시 다시 들어옴
                nowStatus = nextFareInfo.InOrOutInfo;
                nowHour = newHour;
                nowMinute = newMinute;
                if (fareQ.isEmpty()) {
                    answerMap.put(nowCarNumber, answerMap.getOrDefault(nowCarNumber, 0) + (23 - nowHour) * 60 + 59 - nowMinute);
                }
            }

            // 차 번호가 달라진 경우(무조건 IN)
            if (!nowCarNumber.equals(nextFareInfo.carNumber)) {
                // 직전 차의 상태를 확인해볼필요가 있음. IN / OUT
                if ("IN".equals(nowStatus)) { // 직전 차량에 대한 시간 처리를 해줘야함
                    answerMap.put(nowCarNumber, answerMap.getOrDefault(nowCarNumber, 0) + (23 - nowHour) * 60 + 59 - nowMinute);
                }
                if (fareQ.isEmpty()) {
                    answerMap.put(nextCarNumber, answerMap.getOrDefault(nextCarNumber, 0) + (23 - newHour) * 60 + 59 - newMinute);
                }
                nowStatus = nextFareInfo.InOrOutInfo;
                nowHour = newHour;
                nowMinute = newMinute;
                nowCarNumber = nextCarNumber;
            }
        }

        /*
         * TreeMap에 Comparator를 생략하면 기본 Comparator가 동작합니다.
         * Comparator에서 문자열을 비교하는 경우 compareTo() 메서드가 실행됩니다.
         * 이 메서드는 문자열을 사전 순으로 비교하고 오름차순으로 정렬합니다.
         * */
        Map<String, Integer> sortedMap = new TreeMap<>(answerMap);
        answer = new int[sortedMap.size()];
        int idx = 0;
        for (final String key : sortedMap.keySet()) {
            int totalTime = sortedMap.get(key);
            if (totalTime <= fees[0]) {
                answer[idx++] = fees[1];
            } else {
                double addTime = totalTime - fees[0];
                addTime = Math.ceil(addTime / fees[2]);
                // Math.ceil -> 올림처리 return double
                answer[idx++] = fees[1] + (int) addTime * fees[3];
            }
        }
        return answer;
    }

    public static class Fare implements Comparable<Fare> {
        String hourAndMinute;
        String carNumber;
        String InOrOutInfo;
        int intCarNumber;

        Fare(String hourAndMinute, String carNumber, String InOrOutInfo) {
            this.hourAndMinute = hourAndMinute;
            this.carNumber = carNumber;
            this.InOrOutInfo = InOrOutInfo;
            intCarNumber = Integer.parseInt(carNumber);
        }

        @Override
        public int compareTo(Fare o) {
            if (this.intCarNumber > o.intCarNumber) {
                return 1;
            } else if (this.intCarNumber == o.intCarNumber) {
                int thisHour = Integer.parseInt(this.hourAndMinute.split(":")[0]);
                int thisMinute = Integer.parseInt(this.hourAndMinute.split(":")[1]);
                int hour = Integer.parseInt(o.hourAndMinute.split(":")[0]);
                int minute = Integer.parseInt(o.hourAndMinute.split(":")[1]);
                if (thisHour > hour) {
                    return 1;
                } else if (thisHour == hour) {
                    if (thisMinute > minute) {
                        return 1;
                    } else if(thisMinute == minute){
                        if("IN".equals(this.InOrOutInfo)){
                            return -1;
                        }
                    }
                }
                return 0;
            } else return -1;
        }

        @Override
        public String toString() {
            return this.hourAndMinute + " " + this.carNumber + " " + this.InOrOutInfo;
        }
    }
}
