package src.year2024.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * leetCode
 * 백트레킹 문제
 * */
public class LetterCombinations_4119483 {
    public static ArrayList<String> outPut;
    public static Map<Integer, String[]> phoneInfo = new HashMap<>();
    public static ArrayList<String> output;
    public static Integer[] keyPad;
    public static int length;

    public static void main(String[] args) {
        // 번호정보
        String digits = "23";
        letterCombinations(digits);
    }

    private static List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return new ArrayList<String>();
        }

        length = digits.length();
        keyPad = new Integer[length];
        for (int i = 0; i < length; i++) {
            keyPad[i] = Character.getNumericValue(digits.charAt(i));
        }

        output = new ArrayList<String>();
        makeLetterInfo();
        getDfsCombinations(0, "");
        return output;
    }

    /*
     * 번호에 위치한 문자 정보를 맵에 저장하는 메서드
     * */
    public static void makeLetterInfo() {
        String[][] infos = {
                {},
                {"a", "b", "c"},
                {"d", "e", "f"},
                {"g", "h", "i"},
                {"j", "k", "l"},
                {"m", "n", "o"},
                {"p", "q", "r", "s"},
                {"t", "u", "v"},
                {"w", "x", "y", "z"}
        };
        for (int i = 1; i <= infos.length; i++) {
            phoneInfo.put(i, infos[i - 1]);
        }
    }

    public static void getDfsCombinations(int index, String letter) {
        /*
         * 종료조건 index가(0,1...) length와 같아졌을때
         * */
        if (index >= length) {
            if (index == length) {
                output.add(letter);
            }
            return;
        }

        int depth = keyPad[index];
        String[] ch = phoneInfo.get(depth);
        for (final String c : ch) {
            getDfsCombinations(index + 1, letter + c);
            // 문자열을 원상복귀 시켜야한다!
            if (letter.length() >= 1) {
                letter.substring(0, letter.length() - 1);
            }
        }
    }
}
