### Garbage Collector

- 미사용 오브젝트 추적 알고리즘
  1) RC(Reference Counting): 미사용오브젝트를 관리하는 알고리즘.
     - 모든 객체는 RC라는 필드를 가진다. 자신을 참조하는 오브젝트의 갯수를 관리한다.
     - 모든 객체에 필드가 추가되므로 비효율. circular한 참조를 찾을수 없다.
  2) Tracing: 사용하는 오브젝트를 관리하는 알고리즘
     - RC root가 사용하는 오브젝트들의 링크를 형성한다. 보통 이방법을 많이 쓴다.
     - Circular한 참조를 찾을수 있다. 
- 메모리 클리닝 알고리즘
  1.  세대 가설
      - 통계적으로 최근에 생성된  객체들의 수명이 짧으므로, 생성된 시간 기반으로 세대를 관리한다. young object들부터 GC를 수행한다. 다음세대는 메모리가 더필요할때만 GC수행한다.
  2.  다른방법도 있다고 한다.
      - 메모리를 몇개의 구역으로 나누고, 해당구역에 old/new 오브젝트들을 같이 저장하는 방식- 무슨방식인지 모르겠음.
- GC 자동화의 단점
  1. GC하는 리소스떄문에 수행이 느려짐(C++과 비교하면 이해가 쉽다)
  2. GC하는시간에 지연이 발생(Full GC)
  3. 메모리가 비효율적으로 운영됨.. 정리된 메모리들이 파편화되어 있어서 다음 객체를 저장할때 파편화되어 저장될수가 있음.. 
- 사용자는 GC를 취사선택가능



---

### Inner Class vs Nested Class

Inner class

- Outer class의 멤버변수 사용가능
- Outer class가 선언되어야 사용가능
- 외부클래스의 변수에 접근할때는 this@${OuterClass}.${variable}

Nested Class

- 별개의 클래스로 동작.

사용하는이유?

- Encapsulation
- 객체 구조를 이해하기 쉽게.

---

### label

break, continue와 같이 써서 이제까지 보지못한 문법을..
바로 윗스코프가 아닌 외부루프에 적용되도록 할수 있다.

```
loop@ for (i in 1..3) {
    for (j in 1..3) {
        for (k in 1..3) {
            if (k == 2) continue@loop
            println("i = $i, j = $j, k = $k")
        }
    }
}
```

