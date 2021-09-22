# ✏️ BFS 와 DFS 



### ✔️ 깊이 우선 탐색 (DFS)

* 임이의 노드에서 시작해서 다음 분기로 넘어가기 전에 해당 분기를 마지막 노드까지 탐색하는 방법
* **스택** 또는 **재귀함수**로 풀기 가능하지만 재귀로 풀면 더 쉽다
* 단순 검색 속도 자체는 BFS에 비해 느림
* 반드시 어떤 노드를 방분했는지 체크를 해줘야함 아니면 무한 루프에 빠짐



### ✔️ 너비 우선 탐색 (BFS)

* 임의의 노드에서 시작해서 인접한 노드를 먼저 탐색하는 방법
* **큐**를 사용
* 두 노드 사이의 최단 경로 혹은 임의의 경로를 찾고 싶을 때 사용한다.



---



## ◼️ DFS 와 BFS 비교

> 깊이 우선 탐색의 경우 - 모든 친구 관계를 다 살펴 봄
>
> 너비 우선 탐색의 경우 - A와 가까운 관계부터 탐색

**<코드>**

```java
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_1260_DFS_BFS {

	static int[][] check; // 간선들간에 연결 확인
	static boolean[] checked; // 확인 여부
	static int n; // 정점의 개수
	static int m; // 간선 개수
	static int start; //시작정점
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m= sc.nextInt();
		start = sc.nextInt();
		
		check = new int[n+1][n+1]; // 간선들의 좌표
		checked = new boolean[n+1]; 
		
		
		//간선의 연결상태 저장
		for (int i = 0; i < m; i++) {
			int x= sc.nextInt();
			int y= sc.nextInt();
			
			check[x][y]=check[y][x]=1;
		}
		
		
		
		dfs(start); 
		
		
		checked = new boolean[n+1];
		System.out.println();
		
		bfs();
		
	}
	
	// 시작점을 변수로 받고 확인 하고 출력
	private static void dfs(int i) {
		checked[i]=true;
		System.out.print(i+" ");
		
		
		for (int j = 0; j <= n; j++) {
			if (check[i][j]==1 && checked[j]==false) { // 간선 좌표에 값이 1이고 false이면
				
				dfs(j); // 다음 깊이로 넘어감 
			}
		}
		
	}

	private static void bfs() {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(start); // 시작점을 큐에 넣음
		checked[start]=true;
		System.out.print(start+" ");
		
		
		while(!queue.isEmpty()) {
			int temp = queue.poll();
			
			
			for (int i = 1; i <=n; i++) {
				if (check[temp][i]==1 &&  checked[i]==false) {
					queue.offer(i);
					checked[i]=true;
					
					System.out.print(i+" ");
					
				}
			}
		}

	}

}
```


![KakaoTalk_Photo_2021-09-15-16-09-20](https://user-images.githubusercontent.com/89010467/133712821-74e05c8c-304a-49e0-94fa-c2430f3ba873.jpeg)