package programmers.level2;

import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.*;

// 09:28 시작
// 11:25 end
public class 파일명정렬_17868 {
    public static void main(String[] args) {
        String[] files = {"img12.txt","img13.txt"};
        solution(files);
    }
    public static String[] solution(String[] files) {
        // compile(String regax) : 주어진 정규식으로부터 패턴을 만든다.
        // [a-zA-Z\\s.-] : 영소대문자와 공백 .-을 포함한 문자열을 검사한 정규식 생성
        // [0-9]{1,5} : 숫자로 이루어진 5자리 정규식 생성
        Pattern p = Pattern.compile("([a-zA-Z\\s.-]+)([0-9]{1,5})");
        
        // 정렬 조건을 재정의하기 위해 Comparator 재정의
        Arrays.sort(files, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2){
                
                // 대상 문자열의 패턴을 해석하고 주어진 패턴과 일치하는지 판별할떄 사용하는 클래스 Matcher
                Matcher st1 = p.matcher(s1);
                Matcher st2 = p.matcher(s2);
                
                // Matcher 클래스의 find()를 사용해 대상문자열이 위에서 정의한 Pattern과 일치하는지 검증할 수 있다.
                // fidn() -> 대상 문자열이 패턴과 일치하는 경우 true를 반환하고, 그 위치로 이동한다.
                st1.find();
                st2.find();
                
                // group() : 매칭된 부분을 반환한다. 즉 첫번째 group(1) 값은 head 부분이 된다.
                String headOfS1 = st1.group(1);
                String headOfS2 = st2.group(1);
                return (!headOfS1.equalsIgnoreCase(headOfS2)) ? headOfS1.compareToIgnoreCase(headOfS2) : Integer.parseInt(st1.group(2)) - Integer.parseInt(st2.group(2)) ;
            }
        });
        return files;
    }
}
