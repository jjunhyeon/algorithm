// 12 : 35 ~ 15: 30
import java.util.*;
class Solution {
    static int answer = Integer.MAX_VALUE;
    static Map<Integer,ArrayList<Integer>> myNode = new HashMap<Integer,ArrayList<Integer>>();
    public int solution(int n, int[][] wires) {
        // 전력망 수 만큼 초기화
        for(int i=1; i<=n; i++) myNode.put(i, new ArrayList<Integer>());
        for(int[] wire : wires)  {
            // 관계 연결
            myNode.get(wire[0]).add(wire[1]);
            myNode.get(wire[1]).add(wire[0]);
        }
        for(int[] wire : wires)  {
            // 자르고
            myNode.get(wire[0]).remove(Integer.valueOf(wire[1]));
            myNode.get(wire[1]).remove(Integer.valueOf(wire[0]));
            answer =  Math.min(answer,bfs(n,wire[0]));
            // 다시 원복
            myNode.get(wire[0]).add(wire[1]);
            myNode.get(wire[1]).add(wire[0]);
        }    
        return (answer == Integer.MAX_VALUE) ? 0 : answer;    
    }
    
      public int bfs(int n, int start){
        boolean[] visited= new boolean[n+1];
        int cnt=1;

        Queue<Integer> queue= new LinkedList<>();
        queue.offer(start);

        while(!queue.isEmpty()){
            int point= queue.poll();
            if(!visited[point]){
                visited[point] = true;
                ArrayList<Integer> targetList = myNode.get(point);
                if(targetList.isEmpty())break;
                else {
                    for(int j=0; j<targetList.size(); j++){    
                       if(visited[targetList.get(j)]) continue;
                       queue.offer(targetList.get(j));
                       cnt++;  
                    }    
                }
            }
        }
        return (int)Math.abs(n - 2 * cnt); 
   }
}