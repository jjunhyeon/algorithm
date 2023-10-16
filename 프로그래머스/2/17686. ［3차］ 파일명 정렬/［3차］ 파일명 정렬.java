// 09:28 시작
// 11:25 end
import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.*;
class Solution {
    public String[] solution(String[] files) {
        Pattern p = Pattern.compile("([a-zA-Z\\s.-]+)([0-9]{1,5})");
        
        Arrays.sort(files, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2){
                Matcher st1 = p.matcher(s1);
                Matcher st2 = p.matcher(s2);
                st1.find();
                st2.find();
                
                String headOfS1 = st1.group(1);
                String headOfS2 = st2.group(1);
                
                if(!headOfS1.equalsIgnoreCase(headOfS2)){
                  return headOfS1.compareToIgnoreCase(headOfS2);
                } else { // 같은 문자열 헤드는 뒤 number 까지 비교
                  return Integer.parseInt(st1.group(2)) - Integer.parseInt(st2.group(2));   
                }
            }
        });
        
        return files;
    }
}