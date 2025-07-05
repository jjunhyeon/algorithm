
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	static char[][] info;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(bf.readLine()," ");
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        info = new char[R][C];
        
        //입력되는 행렬 값 저장
        for(int i=0;i<R;i++){
            String str = bf.readLine();
            for(int j=0;j<C;j++){
                info[i][j] = str.charAt(j);
            }
        }
        
        int answer = searchByBinary(R,C);
        bw.write(String.valueOf(answer));
        bw.flush();		//결과 출력
        bw.close();
        bf.close();
        
	}
	private static int searchByBinary(int R, int C) {
		int start = 0;
        int end = R - 1;
        //이분 탐색 진행
        while(start <= end){
            int mid = (start + end) / 2;
            //지울 수 있을 때
            if(validate(mid, R, C)){
                start = mid + 1;
            }else{	//지울 수 없을 때
                end = mid - 1;
            }
        }
        return start;
	}
	
	// 중복되는 문자열이 존재하는지 확인하는 함수
	private static boolean validate(int mid, int R, int C) {
		//중복을 확인하기 위한 Set
        HashSet<String> set = new HashSet<>();
        //mid + 1 행부터 문자열 만들기 진행
        for(int i=0;i<C;i++){
            StringBuilder str = new StringBuilder();
            //문자열 만들기
            for(int j=mid+1;j<R;j++){
                str.append(info[j][i]);
            }
            //중복되는 문자열이 있을 때
            if(set.contains(str.toString())){
                return false;
            }
            //문자열 추가
            set.add(str.toString());
        }
        return true;
	}
}
