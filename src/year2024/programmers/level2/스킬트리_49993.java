package src.year2024.programmers.level2;

/*
 * 스킬트리
 * */
public class 스킬트리_49993 {
    public static void main(String[] args) {
        String skill = "CBD";
        String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};

        //String skill = "CBD";
        //String[] skill_trees = {"CAD"};
        solution(skill, skill_trees);
    }

    public static int solution(String skill, String[] skill_trees) {
        int skillCount = skill_trees.length;
        int result = 0;

        int lt = 0;
        while (skillCount-- > 0) {
            // 값 수정을 위해 변수생성
            String nowSkill = skill_trees[lt];
            for (int i = 0; i < skill_trees[lt].length(); i++) {
                // substring : 0부터 i까지의 문자열
                String s = skill_trees[lt].substring(i, i + 1);
                // 현재 String이 skill에 포함되지 않는다면
                if (!skill.contains(s)) {
                    nowSkill = nowSkill.replace(s, ""); // 불필요한 스킬은 없앰
                }
            }
            // 포함되어 있다면, 최상단의 문자열 확인을 통해 검증
            if (skill.indexOf(nowSkill) == 0) {
                result++;
            }
            lt++;
        }
        return result;
    }
}
