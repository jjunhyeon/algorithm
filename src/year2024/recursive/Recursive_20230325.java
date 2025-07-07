package year2024.recursive;

/*
* 깊이 우선 탐색 : DFS
* 재귀함수(Recursive)
* DFS 라는 함수는 stack 프레임구조를 갖는다.
* 단순히 재귀 함수를 호출하는 위치를 기준으로 System.out.print n 부터 1까지 출력되던것이
* 1부터 n까지 역으로 출력하는것은 재귀 함수의 구조가 stack 구조를 갖기 때문이다.
* */
public class Recursive_20230325 {
    static class Main {
        public void DFS(int n) {
            if(n ==0){
                return ;
            } else{
                DFS(n - 1);
                System.out.print(n+ " ");
            }
        }
    }
    /*
     * 값 입력받기
     * */
    public static void main(String[] args) {
        Main T = new Main();
        T.DFS(3);
    }
}
