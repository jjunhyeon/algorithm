import java.util.*;
class Solution {
    Map<Integer,Map<String, Integer>> answerMap = new HashMap<>();// 길이, 메뉴조합, 반복횟수
    Set<Integer> set = new HashSet<>(); // course
    int dfsMaxValue;
    public String[] solution(String[] orders, int[] course) {
        
        dfsMaxValue = course[course.length-1];
        List<String> answerList = new ArrayList<>();
        for(int n : course) answerMap.put(n, new HashMap<>());
        for(int n : course) set.add(n);
    
        for(String order : orders){
            char[] arr = order.toCharArray();
            Arrays.sort(arr);
            boolean[] visited = new boolean[order.length()];
            setMenuCombinations(new String(arr), new StringBuilder(), 0, visited);    
        }
        
        for(int n : course){
            int max = 0; 
            Map<String, Integer> temp = answerMap.get(n);
            for(String key  : temp.keySet()){
                max = Math.max(max,temp.get(key));   
            }
            
            if(max < 2){
                continue;
            } 
            
            for(String key : temp.keySet()){
                if(temp.get(key) == max) answerList.add(key);
            }
            
        }
        Collections.sort(answerList);
        return answerList.toArray(String[]::new);
    }
    
    public  void setMenuCombinations(String order, StringBuilder stBuilder, int depth, boolean[] visited){
        int len = stBuilder.length();
        if(set.contains(len)){
            String temp = stBuilder.toString();
            int cnt = answerMap.get(len).getOrDefault(temp, 0) + 1;
            answerMap.get(len).put(temp, cnt);
            if(len == dfsMaxValue) return;
        }
        
        for(int j=depth; j<order.length(); j++){
          if(!visited[j]){
              visited[j] = true;
              stBuilder.append(order.charAt(j));
              setMenuCombinations(order, stBuilder, j + 1, visited);
              visited[j] = false;
              stBuilder.deleteCharAt(stBuilder.length()-1);
            }
        }
    }
    
}