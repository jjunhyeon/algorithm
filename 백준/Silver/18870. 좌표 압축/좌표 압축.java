import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

/*
 * 좌표압축(정렬, 해쉬맵 활용)
 * */
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        // N 좌표 수
        int N = Integer.parseInt(bf.readLine());
        int[] arrs = new int[N];
        String[] str = bf.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arrs[i] = Integer.parseInt(str[i]);
        }
        solution(arrs);
    }

    /*
    * param : arr
    * */
    public static void solution(int[] arr){

        // 정답
        int[] result = Arrays.copyOf(arr, arr.length);
        // 정렬
        Arrays.sort(arr);
        HashMap<Integer,Integer> myMap = new HashMap();
        int rank = 0;
        for(int i=0; i<arr.length; i++){
            if(!myMap.containsKey(arr[i])){
                myMap.put(arr[i],rank);
                rank ++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int key : result){
            int ranking = myMap.get(key);
            sb.append(ranking).append(" ");
        }

        System.out.println(sb);
    }
}
