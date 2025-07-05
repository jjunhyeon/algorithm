package src.year2024.programmers.level2;

import java.util.*;

/*
 * DFS 해결
 * 모든 조합의 솔루션을 DFS를 순회하며 Hash에 담고
 * Hash에 담긴 n 사이즈를 기준으로 최대 value의 키를 리턴한다.
 * */
public class 메뉴리뉴얼_72411 {
    public static Map<Integer, Map<String, Integer>> resultMap = new HashMap<>();
    public static Set<Integer> courseSet = new HashSet<>();
    public static int dfsMaxValue = 0;
    public static ArrayList<String> resultList = new ArrayList<>();

    public static void main(String[] args) {
        //String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        String[] orders = {"XWY"};
        //String[] orders = {"XYZ", "XWY", "WXA"};
        int[] course = {2, 3, 4};
        solution(orders, course);
    }

    public static String[] solution(String[] orders, int[] course) {
        // course 배열의 각 원소는 자연수가 오름차순으로 정렬되어 있다.
        dfsMaxValue = course[course.length - 1];
        // course value만큼 map의 길이와 key값 설정
        for (int c : course) {
            resultMap.put(c, new HashMap<>());
            courseSet.add(c);
        }

        for (String order : orders) {
            // acb -> abc 정렬 처리 후 조합 찾아야한다.
            char[] beforeSortChar = order.toCharArray();
            Arrays.sort(beforeSortChar);
            boolean[] visited = new boolean[order.length()];
            getStringCombination(new String(beforeSortChar), new StringBuilder(), 0, visited);
        }

        for (int n : course) {
            int maxValue = 0;
            Map<String, Integer> eachCourseMap = resultMap.get(n);
            for (String key : eachCourseMap.keySet()) {
                maxValue = Math.max(maxValue, eachCourseMap.get(key));
            }

            // 최소 2명 이상에게서 선택 받아야 정답처리
            if (maxValue < 2) continue;

            for (String key : eachCourseMap.keySet()) {
                // 최대길이의 course라면 resultList에 add
                if (maxValue == eachCourseMap.get(key)) resultList.add(key);
            }
        }
        Collections.sort(resultList);
        return resultList.toArray(String[]::new);
    }

    public static void getStringCombination(String order, StringBuilder builderResult, int depth, boolean[] visited) {

        int conditionLength = builderResult.length();
        // course의 길이만큼의 length가 되었으면
        if (courseSet.contains(conditionLength)) {
            String builderString = builderResult.toString();
            int cnt = resultMap.get(conditionLength).getOrDefault(builderString, 0) + 1;
            resultMap.get(conditionLength).put(builderString, cnt);
            // builder의 길이가 course의 최대 길이라면 back
            if (dfsMaxValue == conditionLength) return;
        }

        for (int i = depth; i < order.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                builderResult.append(order.charAt(i));
                getStringCombination(order, builderResult, i + 1, visited);
                visited[i] = false;
                builderResult.deleteCharAt(builderResult.length() - 1);
            }
        }
    }
}
