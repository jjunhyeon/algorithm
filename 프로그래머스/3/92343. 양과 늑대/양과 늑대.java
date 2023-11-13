import java.util.*;
class Solution {
    static ArrayList<ArrayList<Integer>> nodes = new ArrayList<ArrayList<Integer>>();
    static int answer = Integer.MIN_VALUE;
    public int solution(int[] info, int[][] edges) {
        
        int nodeCount = info.length;
        for(int i=0; i<nodeCount; i++){
            nodes.add(new ArrayList<Integer>());
        }
        
        int edgeCount = edges.length;
        for(int i=0; i<edgeCount; i++){
            int[] edge = edges[i];
            nodes.get(edge[0]).add(edge[1]);
        }
                

        dfs(0,0,0,new ArrayList<Integer>(),info);
        return answer;
    }
    
    public static void dfs(int curNode, int sheepCount, int wolfCount, ArrayList<Integer> nextNodeList,int[] info){
        
        if(info[curNode] == 0){
            sheepCount += 1;
        } else {
            wolfCount +=1;
        }
        
        if(sheepCount <= wolfCount){
            return;
        }
        
        answer = Math.max(answer, sheepCount);

        // 다음 탐색 위치 갱신 -> 자기 자신 제외 해야함
        ArrayList<Integer> nextLocation = new ArrayList<Integer>(nextNodeList);
        
        if(!nodes.get(curNode).isEmpty()){
            nextLocation.addAll(nodes.get(curNode));
        }
        nextLocation.remove(Integer.valueOf(curNode));
        
        for(int cur : nextLocation){
            dfs(cur, sheepCount, wolfCount, nextLocation,info);
        }

    }
}