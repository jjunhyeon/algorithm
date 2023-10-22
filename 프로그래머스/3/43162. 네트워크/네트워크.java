import java.util.*;
// 17:00 시작 ~ 17:50
class Solution {
    static ArrayList<ArrayList<Integer>> networkList= new ArrayList<ArrayList<Integer>>();
    public int solution(int n, int[][] computers) {
        int answer = 0;
        for(int i=0; i<=n; i++) networkList.add(new ArrayList<Integer>());
        for(int i=0; i<computers.length; i++){
            int[] computerArray = computers[i];
            for(int j=0; j<computers[0].length; j++){
                if(i == j){
                    networkList.get(i+1).add(i+1);
                } else {
                    if(computers[i][j] == 1){
                         networkList.get(i+1).add(j+1);    
                    } else {
                        networkList.get(i+1).add(0);        
                    }
                }
            }
        }

        // 모든 노드의 visited가 true가 될 때까지 한다.
        boolean[] visited = new boolean[n+1];
        boolean isFinished = false;
        for(int i=1; i<=n; i++){
            if(!isFinished){
                if(visited[i]) continue;
                answer ++;
                isFinished = getNetworkCount(i,visited);
            }  else{
                break;
            }    
        }       
        return answer;
    }
    
    
    public static boolean getNetworkCount(int startNetwork, boolean[] visited){
        
        Queue<Integer> networkQueue = new LinkedList<>();
        networkQueue.offer(startNetwork);
        System.out.println("networkList :: " + networkList);
        visited[startNetwork] = true;
        while(!networkQueue.isEmpty()){
            int nowNetwork = networkQueue.poll();
            for(int next : networkList.get(nowNetwork)){
                // 방문안했으면
                if(!visited[next]){
                    visited[next] = true;
                    networkQueue.offer(next);
                }
            }
        }
        
        for(int i=1; i<visited.length; i++){
            if(!visited[i])  return false;
        }
        
        return true;
    }
}