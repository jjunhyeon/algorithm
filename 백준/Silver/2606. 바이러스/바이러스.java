import java.util.*;

public class Main {
    static boolean visited[];
    static int result =0;
    static ArrayList<ArrayList<Integer>> nodeInfo = new ArrayList<ArrayList<Integer>>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int comCount = sc.nextInt();
        int arrCount = sc.nextInt();
        visited = new boolean[comCount+1];

        for(int i=0; i<=comCount; i++){
            nodeInfo.add(new ArrayList<Integer>());
        }

        for(int i=0; i<arrCount; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            nodeInfo.get(a).add(b);
            nodeInfo.get(b).add(a);
        }

        System.out.println(BFS());
    }

    private static int BFS() {
        // 시작은 1번 컴퓨터
        Queue<Integer>  Q = new LinkedList<>();
        Q.offer(1);
        while(!Q.isEmpty()){
            int target = Q.poll();
            visited[target] = true;
            if(nodeInfo.get(target).isEmpty()){
                continue;
            }

            for(Integer x : nodeInfo.get(target)){
                if(!visited[x]){
                    visited[x] = true;
                    Q.offer(x);
                    result ++;
                }
            }
        }
        return result;
    }
}
