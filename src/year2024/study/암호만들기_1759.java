package year2024.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * packageName    : com.pass.boj.study
 * fileName       : 암호만들기_1759
 * author         : junhyeon
 * date           : 2024-05-12
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-05-12        junhyeon       최초 생성
 */
public class 암호만들기_1759 {
    static int len, fullLen;
    static String[] word;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        len = Integer.parseInt(st.nextToken());
        fullLen = Integer.parseInt(st.nextToken());
        word = new String[fullLen];

        st = new StringTokenizer(bf.readLine());
        for(int i=0; i<fullLen; i++){
            word[i] = st.nextToken();
        }

        // 사전순 정렬
        Arrays.sort(word);
        boolean[] visited =new boolean[fullLen];
        dfsByWord(0, 0, visited, new StringBuilder());
    }

    private static void dfsByWord(int start, int depth, boolean[] visited, StringBuilder cur) {

        if(depth == len){
            if(checkContainAEIOU(cur) && checkAtLeastTwoCharNotAEIOU(cur)){
                System.out.println(cur);
            }
            return;
        }

        for(int i=start; i<fullLen; i++){
            if(!visited[i]){
                cur.append(word[i]);
                visited[i] = true;
                dfsByWord(i+1, depth+1, visited, cur);
                visited[i] = false;
                cur.setLength(cur.length() - 1);
            }
        }
    }

    // AEIOU 포함 체크
    private static boolean checkContainAEIOU(StringBuilder st){
        for(char ch : st.toString().toCharArray()){
            if((ch == 'a' || ch == 'e' || ch =='i' || ch =='o' || ch == 'u')){
                return true;
            }
        }
        return false;
    }

    // AEIOU 제외한 2개 이상의 자음체크
    private static boolean checkAtLeastTwoCharNotAEIOU(StringBuilder st){
        int check = 0;
        for(char ch : st.toString().toCharArray()){
            if(!(ch == 'a' || ch == 'e' || ch =='i' || ch =='o' || ch == 'u')){
                check ++;
            }
            if(check >= 2){
                return true;
            }
        }
        return false;
    }
}
