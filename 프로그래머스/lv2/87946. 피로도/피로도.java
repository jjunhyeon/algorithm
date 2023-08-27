
import java.util.*;
class Solution {
    static int result = Integer.MIN_VALUE;
    
    public int solution(int k, int[][] dungeons) {
         boolean[] visited = new boolean[dungeons.length];
         getMaxValueByDfs(k, dungeons, visited);
        return result;
    }
    
    public static void getMaxValueByDfs(int pirodo, int[][] dun, boolean[] visited){

        int count =0;
        for(int i=0; i< visited.length; i++){
            if(visited[i]){
                count++;
            }
        }
        result = Math.max(count,result);


        for(int i=0; i< dun.length; i++){
            // 필요 피로도 이상이며 방문하지 않았다면
            if(pirodo >=dun[i][0] && !visited[i]) {
                visited[i] = true;
                pirodo -=  dun[i][1];
                getMaxValueByDfs(pirodo, dun,  visited);
                pirodo +=  dun[i][1];
                visited[i] = false;
            }
        }
    }
}