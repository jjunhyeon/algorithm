package src.year2024.recursive;

/*
* 이진수 출력(재귀로)
* */
public class BinaryNumber_20230326 {
    static class Main {
        public void DFS(int n) {

            if(n==0){
                return;
            } else{
                DFS(n/2);
                System.out.print(n%2 + " ");
            }
        }
    }
    /*
     * 값 입력받기
     * */
    public static void main(String[] args) {
        Main T = new Main();
        T.DFS(11);
    }
}
