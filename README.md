# greedy

---------------------

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
