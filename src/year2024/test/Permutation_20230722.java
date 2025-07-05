package src.year2024.test;

/*
* 문자열 순열 테스트
* 시간복잡도: O(n!)
* 순열 : N개 중에서 R개를 순서있게 뽑기
* */
public class Permutation_20230722 {
    public static void main(String[] args) {
        String target = "abcd";
        //solution(target.toCharArray(),0,4,4);
        boolean[] visited = new boolean[target.length()]; // 순열의 길이만큼의 방문여부를 검사할 변수를 선언
        char[] output = new char[target.length()]; // 뽑힌 결과를 저장하기 위한 변수
        orderByDictDFS(target.toCharArray(),output,visited,0,4,4);
    }

    public static void orderByDictDFS(char[] arrs,char[] output, boolean[] visited, int depth, int n, int r){
        if(depth == r){ // r개만큼 길이가 되었다면 출력
            System.out.println(output);
            return;
        }

        for(int i=0; i < n; i++){
            if(!visited[i]){ // 방문하지 않은 값이라면 탐색 시작
                visited[i] = true; // 방문여부를 체크한다.
                output[depth] = arrs[i]; // arr[i] 값으로 업데이트
                orderByDictDFS(arrs, output, visited,depth + 1, n , r);
                visited[i] = false;
            }
        }
    }

    // 순서없이 n개 중에서 r개를 뽑는 경우, 순서 보장하지 못함(사전순 순서)
    private static void solution(char[] str, int depth, int n, int r) {
        // 순열 , str을 순회한다.
        if(depth == r){
            System.out.println(str);
            return;
        }

        for(int i=depth; i<n; i++){
            swap(str,depth, i);
            solution(str, depth + 1, n, r);
            swap(str,depth,i);
        }
    }

    public static void swap(char[] ch, int depth, int i){
        char temp = ch[depth];
        ch[depth] = ch[i];
        ch[i] = temp;
    }
}
