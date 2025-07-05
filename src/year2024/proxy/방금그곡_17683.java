package src.year2024.proxy;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/*
 * 방금그곡
 * 15:35 start
 * 기억한 멜로디를 재생 시간과 제공된 악보를 직접 보면서 비교한다.
 *  @param : 음악제목
 *  @param : 재생이 시작되고 끝난 시각
 *  @param : 악보
 * 기억한 멜로디와 악보에 사용되는 음은 C, C#, D... 등 12개
 * 각 음은 1분에 1개씩 재생
 * 음악은 반드시 처음부터 재생되며 음악 길이보다 재생된 시간이 길 때는 음악이 끊김 없이 처음부터 반복해서 재생된다.
 * 음악은 00:00를 넘겨서까지 재생되는 일은 없다.
 * 조건이 일치하는 음악이 여러 개일 때에는 라디오에서 재생된 시간이 제일 긴 음악 제목을 리턴한다.
 * 재생 시간도 동일한경우 먼저 입력된 음악 제목을 반환한다.
 * 조건 없을 경우 (None)
 * */
public class 방금그곡_17683 {

    static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm");

    public static void main(String[] args) {
        //String m = "ABCDEFG";
        String m = "BA";
        //String[] musicinfos = {"12:00,12:04,Song,A#B"};
        String[] musicinfos = {"12:00,12:04,Song,A#B"};
        solution(m, musicinfos);
    }

    private static String solution(String m, String[] musicinfos) {
        // 동일한 패턴이 존재할경우
        m = convert(m);
        int max = 0; // 최장재생시간
        StringBuilder answer = new StringBuilder();
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
