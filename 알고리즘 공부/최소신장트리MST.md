# 최소신장트리 (Minimum Spannig Tree)



##  신장 트리 (Spanning Tree)

* 그래프 내의 모든 정점을 포한하는 트리
* 최소 연결 부분 그래프 즉, 간선 수가 가장 적은 그래프인다.
* 특징 :  모든 정점들이 연결되어 있어야 하고 사이클은 포함되어선 안된다.
* n개의 정점을 (n-1)개의 간선으로 연결





## 최소신장트리 (MST)

* Spanning Tree 중에서 사용된 간선들의 가중치 합이 최소인 트리



#### 구현 방법 

##### (1) 크루스칼 (Kriskal MST)

> 탐욕적인 방법(greedy method) 을 이용하여 모든 정점을 최소 비용으로 연결하는 최적 해답을 구하는 것

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author THKim
 */
public class MSTKruskalTest {

	static class Edge implements Comparable<Edge>{
		
		int start,end,weight;

		public Edge(int start, int end, int weight) {
			super();
			this.start = start;
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
//			return this.weight - o.weight; // 간선의 부호가 모두 같을때
			return Integer.compare(this.weight, o.weight);
		}
	}
	
	static int[] parents; // 부모원소를 관리(트리처럼 사용)
	private static void make() {
		parents = new int[V];
		// 모든 원소를 자신을 대표자로 만듦
		for (int i = 0; i < V; i++) {
			parents[i] = i;
		}
	}
	// a가 속한 집합의 대표자 찾기
	private static int find(int a) {
		if(a==parents[a]) return a; // 자신이 대표자.
		return parents[a] = find(parents[a]); // 자신이 속합 집합의 대표자를 자신의 부모로 : path compression
	}

	// 두 원소를 하나의 집합으로 합치기(대표자를 이용해서 합침)
	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot) return false; // 이미 같은 집합으로 합치지 않음
		
		parents[bRoot] = aRoot;
		return true;
	}
	
	static int V,E;
	static Edge[] edgeList;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		// 간선리스트 작성
		edgeList = new Edge[E];
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			edgeList[i] = new Edge(start,end,weight);
		}
		
		Arrays.sort(edgeList); // 오름차순 정렬
		
		make(); // 모든 정점을 각각으로 집합으로 만들고 출발
		
		// 간선 하나씩 시도하며 트리 만들어 감.
		int cnt = 0,result = 0;
		for (Edge edge : edgeList) {
			if(union(edge.start, edge.end)) {
				result += edge.weight;
				if(++cnt == V-1) break; // 신장트리 완성
			}
		}
		System.out.println(result);	
	}
}

```





##### (2) 프림 (Prim MST)

> 시작 정점에서부터 출발하여 신장트리 집합을 단계적으로 확장 해나가는 방법
>
> 이전 단계에서 만들어진 신장 트리를 확장하는 방법
> 

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author THKim
 */
public class MSTPrimTest {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int[][] adjMatrix = new int[N][N];
		boolean[] visited = new boolean[N];
		int[] minEdge = new int[N];
		
		StringTokenizer st = null;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < N; j++) {
				adjMatrix[i][j] = Integer.parseInt(st.nextToken());
			}
			minEdge[i] = Integer.MAX_VALUE;
		}
		
		int result=0; // 최소신장트리 비용
		minEdge[0] = 0; // 임의의 시작점 0의 간선비용을 0으로 세팅
		
		for (int i = 0; i < N; i++) {
			// 1. 신장트리에 포함되지 않은 정점 중 최소간선비용의 정점 찾기
			int min = Integer.MAX_VALUE;
			int minVertex = -1; // 최소간선비용의 정점번호
			for (int j = 0; j < N; j++) {
				if(!visited[j] && min>minEdge[j]) {
					min = minEdge[j];
					minVertex = j;
				}
			}
			
			visited[minVertex] = true; // 신장트리에 포함시킴
			result += min;  // 간선비용 누적
			
			// 2. 선택된 정점 기준으로 신장트리에 연결되지 않은 타 정점과의 간선 비용 최소로 업데이트
			for (int j = 0; j < N; j++) {
				if(!visited[j] &&  adjMatrix[minVertex][j] != 0 && minEdge[j]> adjMatrix[minVertex][j]) {
					minEdge[j] = adjMatrix[minVertex][j];
				}
			}
		}
		
		System.out.println(result);
	}

}




```

