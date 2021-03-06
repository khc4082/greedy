# greedy

---------------------
<p align="center"><img width="30%" alt="이름표" src="https://user-images.githubusercontent.com/80773617/113665613-b77e0300-96e8-11eb-9536-2c89668c7165.png"></p>

### 다익스트라 알고리즘 (Dijkstra Algorithm) 이란 최단거리를 탐색하는 알고리즘을 말한다.
한 정점으로 부터 다른 모든 정점까지의 최단거리를 구하는 방식으로, 가능한 적은 시간비용을 이용해 가장 빠르게 문제를 해결하는 상황에서 사용된다. 사용의 예시로는 지하철 노선 검색, 내비게이션 등이 있다.

  알고리즘의 작동 구조는 다음과 같다


1. 출발 노드 설정
2. 출발 노드로부터 각각의 노드에 대한 최소 비용을 저장
3. 최소 비용의 노드를 선택
4. 해당 노드를 통해 다른 노드로 가는 최소 비용을 저장
5. 최소 비용 노드에 대한 선택과 저장을 반복 (= 3번과 4번을 반복)

위 과정을 통해 얻은 데이터들은 배열로 처리되고 저장된다. 

### 예시)

<img width="200" alt="다익스트라" src="https://user-images.githubusercontent.com/80773617/113661742-9ebe1f00-96e1-11eb-8e88-cb0144fde3ce.png"> <img width="400" alt="배열" src="https://user-images.githubusercontent.com/80773617/113661787-b4334900-96e1-11eb-89ab-3d569dc23ed7.png">

--------------------
### 일반 배열을 이용한 소스코드

dijkstra 알고리즘에서 먼저,
``` 
System.out.print("V 입력:");  
System.out.print("E 입력:");
```  
간선을 입력하여 배열 D는 출발점으로부터 점 V까지의 거리를 저장하는 데 사용되고, 최종적으로 출발점으로부터 점 V까지의 최단 거리가 저장된다. 출발점은 `D[0]=0`으로, 시작점이 a정점이라면` D[a] = 0`이 된다. 또 다른 각 점 V에 대해서 `boolean[] check = new boolean[V];` 로 인해 배열을 초기화 시킨다. 
```
int min = Integer.MAX_VALUE;
int index = -1;
```
가장 작은 값을 기억할 변수를 선언해주고, 그 위치를 기억 할 변수까지 선언해준다. 또한 그 안에서 아직 처리를 하지 않았으면서, 가장 짧은 거리이면, `min = D[j];` -> 이 값이 정의 되면서 새로운 친구로부터 갈 수 있는 경로들을 업데이트 하는 것이다. 
마지막으로, 
```
for (int j = 0; j < V; j++) {
                
                if (!check[j] && adj[index][j] != 0 && D[index] != Integer.MAX_VALUE
                        && D[index] + adj[index][j] < D[j]) {
                    D[j] = D[index] + adj[index][j]; 
	}
   }
   ```
아직 처리하지 않았으면서 경로가 존재하고, index까지의 거리와 index부터 j까지의 거리가 D[j]보다 작다면, 남아있는 점 중 index까지의 거리와 index부터 j까지의 거리가 D[j]보다 짧은 거리를 더해 줌으로써 `check[index] = true;` - > 처리된 배열로 체크 할수 있고, 배열을 출력하게 되는 것이다.

### 우선순위 큐를 이용한 소스코드

배열을 이용한 코드에서는 1번부터 N번 정점까지 모든 정점을 매번 탐색하므로 N의 시작복잡도가 발생한다. 우리는 이 부분에서 우선순위 큐를 이용하여 시간복잡도를 줄일 수 있다.우선순위 큐는 힙 정렬을 사용하기 때문에 logN의 시간복잡도로 매번 가장 작은 거리를 갖는 정점을 찾을 수 있다.

```
if (i == 0) { 


D[i] = new Edge(i, 0);

 } else { 

D[i] = new Edge(i, Integer.MAX_VALUE);

 }
 
 pq.add(D[i]);
Edge edge = pq.poll();
```

현재 정점과 인접한 정점들을 갱신시키고 나서, 정점과 거리 정보를 우선순위 큐에 넣어준다. 그러면 우선순위 큐에는 check가 false인 정점들의 정보가 담기게 된다. `poll()` 메서드를 호출하는 행위만으로 가장 짧은 거리를 갖는 정점의 정보를 얻을 수 있다.
우선순위 큐에 정점의 번호와 거리 정보를 넣기 위해 Edge 라는 클래스를 별도로 만들어서 정점 번호와 거리를 넣고, 주의해야 할 것은, 기본 자료형이 아니기 때문에 Comparable 를 구현하여서 정렬 기준을 정해줘야 한다. 가장 짧은 거리부터 선택되어야 하므로 거리를 기준으로 오름차순이 되도록 `compareTo()`를 구현한다.
















----------------
### 실행화면


코드가 실행되는 데에 걸린 시간(ms) 같이 출력


> <img width="130" alt="다익스트라 진짜 배열" src="https://user-images.githubusercontent.com/51106969/113662249-b1852380-96e2-11eb-8a3f-7f77b6d14b03.PNG">
>> 일반배열

> <img width="130" alt="다익스트라 큐" src="https://user-images.githubusercontent.com/51106969/113662255-b4801400-96e2-11eb-9c11-23559759b8e5.PNG">
>> 우선순위 큐

### 시간복잡도

> <p align="center"><img width="50%" alt="시간복잡도" src="https://user-images.githubusercontent.com/51106969/113662260-b649d780-96e2-11eb-8e99-4fdd47c3cdf9.PNG"></p>

>> 일반 배열을 사용하였을 경우 O(n^2) , 큐를 사용하였을 경우 O(n*logn) 임을 확인

>> pq에 삽입 될 수 있는 정점은 최대 V^2이며 거리 갱신을 위해 간선을 E번 확인하기 때문에 총 시간복잡도는 O(ElogV) 가 됨 

