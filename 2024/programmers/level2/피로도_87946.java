package programmers.level2;

/*
* 피로도
* dfs
* */
public class 피로도_87946 {

    static int result = Integer.MIN_VALUE;
    public static void main(String[] args){

        // temp ex1:)
        int k = 80;
        int[][] dungeons = {{80,20}, {50,40}, {30,10}};
        solution(k,dungeons);
    }

    public static int solution(int k, int[][] dun){

        boolean[] visited = new boolean[dun.length];
        getMaxValueByDfs(k, dun, visited);
        System.out.println("what is the result" + result);
        return result;
    }

    /*
    * 현재 피로도가 
    * 필요 피로도이상이상이어야 함
    * */
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
