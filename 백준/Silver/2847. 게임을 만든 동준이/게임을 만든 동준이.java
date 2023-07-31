
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
* 순서대로 증가될 수 있도록 만든다.
*
* */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        // 레벨의 수(N)
        int N = Integer.parseInt(bf.readLine());
        // 레벨 정보를 담을 배열
        int[] arrs = new int[N+1];
        for(int i=1; i<=N; i++){
            arrs[i] = Integer.parseInt(bf.readLine());
        }

        int result = 0;
        for(int i=1; i<=N; i++){
            int target = arrs[i];
            for(int j=i-1; j>0; j--){
                if(arrs[j] >= target){
                    // 다음 값이 더 작아야하는데 앞의 값이 크거나 같다면
                    // 다음값의 -1 값으로 기존값을 업데이트하고 그 값과의 차만큼 result를 증가시킨다.
                    // 만약 그 이전의 값도 존재한다면 그 이전의 i개수만큼 result를 추가적으로 증가한다.
                    result +=  arrs[j] - target + 1;
                    arrs[j] =  target - 1;
                    target = arrs[j];
                }
            }
        }
        System.out.println(result);
    }
}
