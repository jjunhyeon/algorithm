
## 문제 리뷰

백준 문제 보기

나의 소스 확인

### 1. 개요
`1부터 N까지의 자연수 중에서 M개를 고른 수열을 모두 출력` 하는 문제이다. <br>
**중복 선택이 가능** 하며, **순서가 중요**한 문제다
즉, 중복 순열을 생성하는 문제이다.

### 1. 문제를 보고 든 생각

문제의 조건을 만족하는 수열을 모두 출력하는 문제였다.
특정 수열을 나열하면서 조건에 해당하는 값만 출해야하므로 나열하며 조건을 출력하는 백트레킹 알고리즘을 생각

<br>

## 2. 첫 도전, 실패 원인

결론은 풀이에 실패했다. 

dfs 메서드의 파라미터로는 String을 지속적으로 조작해야하기 때문에 성능에 유리한 StringBuilder 그리고 return 조건 식별을 위해 depth, 2개를 사용했다.

M개를 골랐다는것은 String이 M개만큼 선택되어 수열이 생성되었음을 의미한다.
처음에는 그냥 BufferedWriter를 사용하지 않고 조건에 맞으면 bw.append가 아닌 System.out.println로 값을 출력했었다.
시간초과 발생했고 실패했다.

수열이 길어지게 되면 내장 시스템 함수를 굉장히 많이 사용하게 되고 이게 성능에 굉장히 악영향을 주었던거 같다.



```
	private static void getTargetByDfs(StringBuilder curString, int depth) throws IOException {
		// return ; 시점은
		if (depth == M) {
            for (int i = 0; i < M; i++) {
                if (i > 0) bw.append(" ");
                bw.append(curString.charAt(i));
                if(i == M - 1) bw.append("\n");
            }
			return;
		}

		for (int i = 1; i <= N; i++) {
			curString.append(defaultArray[i]);
			getTargetByDfs(curString, depth + 1);
			curString.deleteCharAt(curString.length() - 1);
		}
	}
```
<br>

## 3. 결론
- DFS를 이용해 모든 경우의 수를 탐색하였다.
- 결과를 출력할 때 `System.out.println()`을 사용했는데, **시간 초과 발생**.
- 1차시도의 실패원인은 `System.out.println()`은 호출될 때마다 **I/O 연산이 발생** 했고 이를 개선해 *`BufferedWriter` 활용을 통해 I/O 성능 최적화** 를 통해 해결할 수 있었다.
