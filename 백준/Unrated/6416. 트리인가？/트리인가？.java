
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Integer, Integer> vertex = new HashMap<>(); //정점의 개수를 센다
        int from = Integer.MAX_VALUE;
        int to = Integer.MAX_VALUE;
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int idx = 1;
        int edge =0;
        while (true) {
            if(!st.hasMoreTokens()) st = new StringTokenizer(bf.readLine());
            while (st.hasMoreTokens()) {
                from = Integer.parseInt(st.nextToken());
                to = Integer.parseInt(st.nextToken());
                if (from == -1 && to == -1) return;
                if ((from == 0 && to == 0)) {

                    // todo
                    // 루트가 하나만 존재해야한다
                    // 루트를 제외한 노드들의 진입 간선은 단 한개다
                    // 정점의 개수 -1 = 간선의 개수
                    int root = 0;
                    boolean flag = true;

                    for(int x: vertex.keySet()) {
                        if(vertex.get(x)== 0) root++;
                        else if(vertex.get(x)>1) {
                            flag = false;
                            break;
                        }
                    }

                    if(vertex.size()==0) {
                        System.out.println("Case "+idx+" is a tree.");
                    } else if(flag && root == 1 && edge == vertex.size()-1) {
                        System.out.println("Case "+idx+" is a tree.");
                    } else {
                        System.out.println("Case "+idx+" is not a tree.");
                    }
                    idx++;
                    vertex = new HashMap<>();
                    edge =0;
                    break;
                } else {
                    vertex.put(from, vertex.getOrDefault(from, 0));
                    vertex.put(to, vertex.getOrDefault(to, 0) + 1);
                    edge ++;
                }
            }
        }
    }
}
