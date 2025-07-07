package year2024.programmers.level3;

import java.util.Arrays;
import java.util.HashSet;

/*
* dfs, String 정규식 활용(다시)
* */
public class 불량사용자_64064 {
    static HashSet<String> answerSet = new HashSet<>();
    static String[] regex;
    static boolean[] visited;
    public static void main(String[] args) {
        String[] userId = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] bannedId = {"fr*d*", "abc1**"};
        solution(userId,bannedId);
    }

    public static int solution(String[] user_id, String[] banned_id){
        regex = new String[banned_id.length];
        visited = new boolean[user_id.length];

        for(int i = 0; i < banned_id.length; i++) {
            regex[i] = banned_id[i].replace("*", ".");
        }
        dfs(0, "",user_id);
        return answerSet.size();
    }

    public static void dfs(int depth, String result, String[] user) {
        if(depth == regex.length){
            String[] st = result.split(" ");
            Arrays.sort(st);

            String newSt = "";
            for(int i=0; i< st.length; i++){
                newSt += st[i];
            }

            answerSet.add(newSt);
            return;
        }

        for(int i = 0; i < user.length; i++) {
            if(visited[i] == false && user[i].matches(regex[depth])) {
                visited[i] = true;
                dfs(depth + 1, result + " " + user[i],user);
                visited[i] = false;
            }
        }
    }
}
