# greedy

---------------------

  다익스트라 알고리즘 (Dijkstra Algorithm) 이란 최단거리를 탐색하는 알고리즘을 말한다.
한 정점으로 부터 다른 모든 정점까지의 최단거리를 구하는 방식으로, 가능한 적은 시간비용을 이용해 가장 빠르게 문제를 해결하는 상황에서 사용된다. 사용의 예시로는 지하철 노선 검색, 내비게이션 등이 있다.

  알고리즘의 작동 구조는 다음과 같다


1. 출발 노드 설정
2. 출발 노드로부터 각각의 노드에 대한 최소 비용을 저장
3. 최소 비용의 노드를 선택
4. 해당 노드를 통해 다른 노드로 가는 최소 비용을 저장
5. 최소 비용 노드에 대한 선택과 저장을 반복 (= 3번과 4번을 반복)

위 과정을 통해 얻은 데이터들은 배열로 처리되고 저장된다. 

# EX)
![image](https://user-images.githubusercontent.com/80773617/113661742-9ebe1f00-96e1-11eb-8e88-cb0144fde3ce.png)

![image](https://user-images.githubusercontent.com/80773617/113661787-b4334900-96e1-11eb-89ab-3d569dc23ed7.png)


















### 실행화면


코드가 실행되는 데에 걸린 시간(ms) 같이 출력


> ![일반 배열](https://user-images.githubusercontent.com/51106969/113658299-bba32400-96da-11eb-953f-cd53726911a6.PNG)
>> 일반배열

> ![우선순위 큐](https://user-images.githubusercontent.com/51106969/113658456-0d4bae80-96db-11eb-861d-79390d285ca5.PNG)
>> 우선순위 큐

### 시간복잡도

> ![시간복잡도](https://user-images.githubusercontent.com/51106969/113658862-d033ec00-96db-11eb-942e-d8e5692787a6.PNG)
>> 일반 배열을 사용하였을 경우 O(n^2) , 큐를 사용하였을 경우 O(n*logn) 임을 확인

>> pq에 삽입 될 수 있는 정점은 최대 V^2이며 거리 갱신을 위해 간선을 E번 확인하기 때문에 총 시간복잡도는 O(ElogV) 가 됨 
