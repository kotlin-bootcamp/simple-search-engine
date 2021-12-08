# 5주차

***

### Pseudocode

- 알고리즘을 짤 때 프로그래밍 언어가 아닌 수도코드를 이용해라.
    - 대중적인 프로그래밍 언어를 쓴다고 하더라도 명확하지 않을 수 있다. (명확한 코드가 아니라면)
    - 그리고 읽어야 할 코드의 양도 더 많을 수 있다.
    - 수도코드를 사용하면 알고리즘의 핵심만 표현하면 되므로 좀 더 명확하다.
    - 수도코드를 표현할 땐 텍스트로만 표현하는게 아니라 모든 프로그래밍 언어의 공통적인 특성들 (변수, if-else, 루프, 함수) 로 표현한다.

### Searching Algorithm

- Searching 은 Sequential search 와 Interval search 로 구분할 수 있다.
- Sequential search 는 Brute force 방식이므로 너무 많은 검색을 한다.
- 그래서 Searching Algorithm 이 필요하다. (Interval search)
- Interval search 는 데이터가 특정한 패턴을 가지거나 특정한 카테고리가 있다면 이를 이용해서 찾아야 하는 데이터의 영역을 줄이는 것이다.

### Interval search: Jump search

- Jump search 는 Block search 라고도 불린다.
- 여기서는 target Value 를 찾기 위해서 어레이를 일련의 블록으로 쪼개서 찾는다.
- Block search 에서 두 가지 원칙만 기억하면 된다.
    - Ascending Sorted Array 기준으로 이전 블락의 요소는 다음 블록의 요소보다 작거나 같다.
    - target Value 가 볼록의 마지막 요소보다 크다면 다음 블록으로 가면 된다. 마지막 요소보다 작다면 첫 요소부터 찾아보면 된다.
- 즉 동작과정은 다음과 같다.
    - 블록의 가장 오른쪽 요소와 target Value 와 비교하고 target Value 가 더 크다면 다음 블록으로 점프한다.
    - 블록의 요소가 더 크다면 이제 backward 로 linear search 하면된다.
- 시간복잡도는 루트 n 이다. 최악의 케이스의 경우도 루트 n + 루트 n 이라서 루트 n 이다.

```
jump_search(array, value)
    step = floor(sqrt(len(array)))              // step to move to the next block (rounding the value of the 
                                                // square root of the length of the array to a smaller integer)
    curr = 1                                    // index of the current element (the check starts from 1)
    while curr <= len(array)                    // loop while the index is not bigger than the length of the array
        if array[curr] == value                 // if the current value is equal to the target value
            return curr                         // return the index
        elif array[curr] > value                // else if the current value is greater than the target one
            ind = curr - 1                      // we start the search inside the block from the end of the block;
                                                // the starting index is to the left of the right border of the block (curr)
            while ind > curr-step and ind >= 1  // while the new index has not gone beyond the left border 
                                                // of the block (curr-step) or array (1)
                if array[ind] == value          // if the current value is equal to the target value
                    return ind                  // return the index
                ind -= 1                        // reducing the index of the current element
            return -1                           // the target value is not in the array, so return -1
        curr += step                            // increasing the index of the current element by a step 
                                                // to move to the next block
    ind = len(array)                            // we start checking the last block (if its length turned out to be less)
                                                // the starting index is equal to the last one
    while ind > curr-step                       // while the new index has not gone beyond the left border of the block (curr-step)
        if array[ind] == value                  // if the current value is equal to the target value
            return ind                          // return the index
        ind -= 1                                // reducing the index of the current element
    return -1                                   // the target value is not in the array, so return -1
```