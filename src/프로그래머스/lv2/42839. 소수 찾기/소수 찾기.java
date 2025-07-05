import java.util.*;

class Solution {
    public static String target;
    public static boolean[] visited;
    public static int answer = 0;
    public static Set<Integer> mySet = new HashSet<>();
    
    public int solution(String numbers) {
        
        target = numbers;
        StringBuilder sb = new StringBuilder();
        visited = new boolean[numbers.length()];
        findPrimeNumberByDfs(0,sb);
        return answer;
    }
    
    
    public static void findPrimeNumberByDfs(int index, StringBuilder currentString){
        
        if(currentString.length() > 0){
            int intValue = Integer.parseInt(currentString.toString());
            if(!mySet.contains(intValue)){
                mySet.add(intValue);
                if(isPrimeNumber(intValue)) answer ++;    
            }
        }
        
        if(index == target.length()) {
            return;
        }
        
        for(int i= 0; i<target.length(); i++){
            if(!visited[i]){
                visited[i] = true;
                currentString.append(target.charAt(i));
                findPrimeNumberByDfs(index + 1, currentString);
                // 원복처리
                currentString.deleteCharAt(currentString.length() - 1);    
                visited[i] = false;
            }
        }
    }
    
    public static boolean isPrimeNumber(int number){
        if(number == 0 || number ==1) return false;
        for(int i = 2; i <= Math.sqrt(number); i++){
            if(number % i == 0) return false;
        }
        return true;
    }
}