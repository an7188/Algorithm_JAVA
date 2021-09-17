

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



---



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





---





#### ⬛️ DP를 이용한 **최장 증가 수열(LIS)**

**LIS (Longest Increasing Subsequence Algorithm)**

➡️ 최장증가수열 알고리즘으로 증가하는 원소들의 가장 긴 부분집합을 찾는 알고리즘이다.





#####  Brute-force 접근 방법

수열의 모든 부분 집합을 구하여 그 부분 집합이 증간 수열인지 판단한다.

증가 수열 중 가장 길이가 긴 값을 구한다.

```java
import java.util.Scanner;

public class DP2_LIS_Test {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		int N= sc.nextInt();
		int [] arr= new int [N];
		int [] LIS =new int[N]; //각 원소를 끝으로 하는 최장 길이
		
		for (int i = 0; i < N; i++) {
			arr[i]=sc.nextInt();
		}
		
		int max=0; //전체중의 최대 길이
		for (int i = 0; i < N; i++) {
			LIS[i]=1;
			
			for (int j = 0; j < i; j++) { //j : i의 앞쪽 원소 
				if (arr[j]<arr[i] && LIS[i]<LIS[j]+1) {
					LIS[i]=LIS[j]+1;
				}
			}//i를 끝으로 하는 최장 길이 값 계산 완
			if(max<LIS[i]) max=LIS[i];
		}
		
		System.out.println(max);
		
	}

}

```





#### ◼️ binarysearch (이진 탐색) 함수 사용

> **=> Arrays.binarySearch(이진탐색을 당할 배열, 찾는 값);**
>
> 오름차순으로 정렬된 리스트에서 특정한 값의 위치를 찾는 알고리즘
>
> 무조건 정렬을 해준 후 비교를 해야 한다.



```java
import java.util.Arrays;
import java.util.Scanner;

public class DP_LIS2 {

	public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
		
		
		int N= sc.nextInt();
		int [] arr= new int [N];
		int [] LIS =new int[N]; //해당 길이를 증가수열 중 맨 끝을 최소값으로 유지 
		
		
		for (int i = 0; i < N; i++) {
			arr[i]=sc.nextInt();
		}
		
		int size=0; //LIS에 채워진 원소 수 
		for (int i = 0; i < N; i++) {
			//중복값이 없으므로 탐색 실패 : 음수 값 ==> 삽입 위치로 환산 
			
			int temp =Math.abs(Arrays.binarySearch(LIS, 0,size,arr[i]))-1;
			
			LIS[temp]= arr[i];
			
			
			//추가된 위치가 맨 뒤라면 사이즈 증가
			if (temp ==size ) size++;
		
		}
		
			System.out.println(size);
		
	
	}

}

```







----



## 모든 쌍 최단 경로



#### 플로이드 와샬(Floyd Warshall) 알고리즘

> 모든 정점에서 모든 정점으로의 최단 경로를 구할 경우 사용하는 알고리즘!
>
> 거쳐가는 정점을 기준으로 알고리즘을 수행한다



