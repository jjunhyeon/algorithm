
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/*
 * 최소 힙 구하기
 * 0 만낫을때 가장 작은 값 출력 (없다면 0)
 * x 가 자연수라면 배열에 x값을 넣는다.
 * */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        int[] arr = new int[count];
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // 우선순위 큐 , 내부적으로 값이 오름차순으로 정렬 된다.
        for (int i = 0; i < count; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) {
                if (!pq.isEmpty()) {
                    // 비어 있찌 않으면
                    System.out.println(pq.poll());
                } else {
                    System.out.println("0");
                }
            } else {
                pq.offer(num); //값 추가
            }
        }
    }
}
