
import java.util.*;
// 12: 20 start
// graph 탐색문제
// 1. graph 생성 , 2. bfs 탐색 후 가장 먼 거리 정보 도출
// 3. 해당 거리와 일치하는 노드의 수 return
class Solution {
    static ArrayList<ArrayList<Integer>> nodeGraphList = new ArrayList<>();
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        int len = edge.length;
        // 초기화
        for(int i=0; i<=n; i++) nodeGraphList.add(new ArrayList<>());
        for(int i=0; i<len; i++){
            int aNode = edge[i][0];
            int bNode = edge[i][1];
            // 관계연결
            nodeGraphList.get(aNode).add(bNode);
            nodeGraphList.get(bNode).add(aNode);
        }
        
        // 1번 노드부터 시작, 1번 노드로부터 가장 멀리 떨어진 노드의 수만 찾으면 됨
        answer = findLongestNodeCountByBfs(1,n);        
        return answer;
    }
    
    // 특정 노드로부터 가장 먼 노드의 개수를 리턴한다.
    public int findLongestNodeCountByBfs(int startNode,int len){
        int answer = 0;
        Queue<Integer> myQ = new LinkedList<>();
        boolean[] visited = new boolean[len+1];
        int[] distance = new int[len+1];
        myQ.offer(startNode);
        visited[startNode] = true;

        while(!myQ.isEmpty()){
            int nod = myQ.poll();
            for(int n : nodeGraphList.get(nod)){
                // n값은 있지만 더 이상 sum 값이 변하지 않았다면 그녀석은 끝 노드임.
                // 방문하지 않았으면
                if(!visited[n]){
                    // 마지막 offer한 node의 수가 정답임
                    visited[n] = true;
                    myQ.offer(n);
                    distance[n] = distance[nod] + 1;
                }
            }
        }

        int maxNumber = Arrays.stream(distance)
                             .max()
                             .orElse(0);
        
        for(int i=0; i<distance.length; i++) if(maxNumber == distance[i]) answer++;
        return answer;
    }
}