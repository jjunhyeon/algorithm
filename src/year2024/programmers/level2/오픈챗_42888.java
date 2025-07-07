package year2024.programmers.level2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 오픈챗_42888 {


    public static void main(String[] args) {
       String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
       solution(record);
    }

    public static String[] solution(String[] record){
        ArrayList<String> chatLog = new ArrayList<>();
        HashMap<String, String> nickMap = new HashMap<>();

        for (String log : record) {
            StringTokenizer st = new StringTokenizer(log);
            String command = st.nextToken();
            String userId = st.nextToken();
            String nickname = "";

            if (!command.equals("Leave")) {
                nickname = st.nextToken();
            }

            switch (command) {
                case "Enter":
                    nickMap.put(userId, nickname);
                    chatLog.add(userId + "님이 들어왔습니다.");
                    break;
                case "Leave":
                    chatLog.add(userId + "님이 나갔습니다.");
                    break;
                case "Change":
                    nickMap.put(userId, nickname);
                    break;
            }
        }

        // change는 담기지 않으므로 정답의 사이즈
        String[] answer = new String[chatLog.size()];

        int logIdx = 0;
        for (String str : chatLog) {
            // userId를 기준으로 닉네임 전환
            int endOfId = str.indexOf("님");
            String userId = str.substring(0, endOfId);
            answer[logIdx++] = str.replace(userId, nickMap.get(userId));
        }
        return answer;
    }
}
