
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;


class Solution {
    static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm");
    public String solution(String m, String[] musicinfos) {
        // 동일한 패턴이 존재할경우
        // 재생시간이 높은 순, 재생 시간도 동일하다면 먼저 입력돈 음악 제목 반환
        m = convert(m);
        int max = 0; // 최장재생시간
        StringBuilder answer = new StringBuilder();
        // 같은 문자열에 대해서만 시간 차순으로 정렬한다.
        for (String music : musicinfos) {
            LocalTime startTime = LocalTime.parse(music.split(",")[0], TIME_FORMATTER);
            LocalTime endTime = LocalTime.parse(music.split(",")[1], TIME_FORMATTER);
            int timeGap = (int) startTime.until(endTime, ChronoUnit.MINUTES);

            // 일부분의 멜로디보다 시간 갭이 크다면, 멜로디 내용을 추가해서 맞쳐준다.
            StringBuilder melodyBuilder = new StringBuilder();
            String heardMelody = convert(music.split(",")[3]);
            for (int j = 0; j < timeGap; j++) { // 전체멜로디 만들기
                melodyBuilder.append(heardMelody.charAt(j % heardMelody.length()));
            }

            if (melodyBuilder.toString().contains(m)) { // 기억한멜로디(방금그곡)이 전체멜로디에 들어있는지
                if (max < melodyBuilder.toString().length()) { // 가장 긴 멜로디인 경우 정답 업데이트
                    max = melodyBuilder.toString().length();
                    answer.setLength(0);
                    answer.append(music.split(",")[2]);
                }
            }
        }
        return answer.length() == 0 ? "(None)" : answer.toString();
    }

    private static String convert(String m) {
        m = m.replaceAll("A#", "a");
        m = m.replaceAll("C#", "c");
        m = m.replaceAll("D#", "d");
        m = m.replaceAll("F#", "f");
        m = m.replaceAll("G#", "g");
        return m;
    }
}