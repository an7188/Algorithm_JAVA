# Dynamic Programming(동적계획법)





##  ✔️ 메모이제이션

> 컴퓨터를 실행할 때 이전에 계산한 값을 메모리에 저장해서 매번 다시 계산하지 않도록 하여 전체적인 실행 속도를 빠르게 하는 기술 (같은 input = 같은 ouput



* 피보나치 수열 메모제이션 풀이

```java
import java.util.Scanner;

public class DP1 {

	static long totalCount1, totalCount2;
	static long[] call1, call2;
	static long[] memo;

	static long fibo1(int n) {
		totalCount1++;
		call1[n]++;
		if (n < 2)
			return n;
		return fibo1(n - 1) + fibo1(n - 2);

	}

	static long fibo2(int n) {
		totalCount2++;
		call2[n]++;
		if (n >= 2 && memo[n] == 0) {
			memo[n] = fibo2(n - 1) + fibo2(n - 2);

		}
		return memo[n];

	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		call1 = new long[N + 1];
		call2 = new long[N + 1];
		memo = new long[N + 1];

		memo[0] = 0;
		memo[1] = 1;

		// 메모 버전
		System.out.println(fibo2(N));
		for (int i = 0; i <= N; i++) {
			System.out.println("fibo2(" + i + ")  : " + call2[i]);
		}
		System.out.println("fibo2 callcount : " + totalCount2);

		// 비메모 버전  
		System.out.println(fibo1(N));
		for (int i = 0; i <= N; i++) {
			System.out.println("fibo1(" + i + ")  : " + call1[i]);
		}
		System.out.println("fibo2 callcount : " + totalCount1);

	}

}

```

> 단점 : 추가적인 메모리 공간이 필요하다
>
> 재귀함수 호출로 호출 스택을 사용하게 되고 실행 속도 저하 또는 오버플로우 발생
>
> 해결책→**동적계획법!** 





---



##  ✔️ DP(Dynamic Programming)

- 동적 계획법은 그리디 알고리즘과 같이 **최적화 문제 해결** 알고리즘
- 큰 문제를 작은 문제로 나눈다.





**DP 필요 조건**

> 최적 부분 문제 구조
>
> 중복 부분 문제 구조



**분할 정복과 동적계획 비교**

* 분할 정복 
  * 연관 없는 부분 문제를 분할 한다
  * 부분 문제를 재귀적으로 해결한다
  * 부분문제의 해를 결합한다.
  * 병합 정렬, 퀵 정렬
* DP
  * 부분 문제들이 연관이 없으면 적용할 수 없음 
  * 모든 부분 문제를 한번만 계산하고 결과를 저장하고 재사용한다.

> 분할 정복은 하향식 방법으로 DP는 상향식 방법으로 접근한다.





##### DP를 이용한 알고리즘

```java
public class DP2 {


		static long fibo1(int n) {
			long [] D = new long [n+1];
			D[0] = 0;
			D[1] = 1;
			
			for (int i = 2; i <= n; i++) {
				D[i]= D[i-1]+D[i-2];
			}
				return D[n];
		}



		public static void main(String[] args) {
		

			Scanner sc = new Scanner(System.in);
			int N = sc.nextInt();

			System.out.println(fibo1(N));
		
	}

}

```



