### 탐색
* 순차검색
  * 원하는 값을 얻을 때까지 인덱스를 순차적으로 탐색하기 시작
  * 순차검색은 빨리 찾을 수 도 있고 오래 걸릴 수 도 있습니다.

* 간격검색
  * 간격 검색은 순차 검색보다 항상 빠르고 효율적
  * 정렬된 데이터에 적합

### Jumps and returns
* Label
  * 내부 루프뿐만 아니라 외부 루프도 끊는 데 도움이 됩니다;
  * 다중반복문 탈출

```kotlin
loop@ for (i in 1..3) {
  for (j in 1..3) {
    println("i = $i, j = $j")
    if (j == 3) break@loop
  }
} 
```

```java
loop:for(int i=0;i<n;i++){
    for(int j=0;j<n;j++){
        if(arr[i][j]==1) break loop;
    }
  }
```
