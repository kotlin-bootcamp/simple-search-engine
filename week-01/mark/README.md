### Why Kotlin?
- MultiPlatform(JVM / Android / JS / Native) 언어, 거기에다가 간결하고 안정성있기까지!
- OOP, Functional Programming 등 다양한 프로그래밍 패러다임을 지원할수 있도록 설계
- 이러한 장점들로 인해 인기가 높아지고 있음 ( https://pypl.github.io/PYPL.html );생각보다 순위는낮네..Abap은 뭐길래?https://krksap.tistory.com/264
---
### Bug, Debug

버그를 줄이기 위해  
- Easy-to-read code  
- Automate-Test code 

.Debugging시에는 무지성 디버거 실행은 NO..
```
1. 코드를 면밀히 살피고,
2. 로그를심고,
3. 디버거 실행.
```

---

### Self Documenting Code

- XXcking java script..  
![img.png](img.png)
- https://www.youtube.com/watch?v=x_Yw2f161CU
  AI도 인정한 worstLanguage

#### self-documenting-code지향해야하는 이유
```
- 시간절약. 유지보수에 용이 
- 재사용가능 
- 협업에 용이
- e.t.c. for future
```
#### Ways of self-documenting-code
```
- 변수명, 함수명을 잘 만들자. 
- 코드를 짧게쓰려고 가독성을 해치지 말자.
- 명확한 역할을가진 함수로 분리하자.
- 프로그램 논리의 순서대로 리팩토링
```
#### Naming Variables : 명명 규칙
클린코드 2장을 참고합시다..  
와닿는거만 좀 정리해보자면..
```
- 주석이 필요없을 정도의 구체적인 네이밍 : 1.존재이유, 2.수행기능, 3. 사용방법 고려
- 서로 비슷한 네이밍은 피하기. 유사한 개념은 관용적 표기법 사용(ex. boolean리턴하면 is--- )
- 불용어 사용하지 않기
- 검색하기 쉽도록, 자주등장하는 단어가 껴있을 떄는 길게
- 클래스 이름에는 동사 사용하지 않기.
- 메서드 이름에는 동사를 사용하기.
```
ㄴ 코틀린은 아니지만, 실습해볼만한 실전 코드가 있습니다..ㅎㅎ

#### 문서 주석 
```kotlin
/**
* 레거시 코드에선 많이 봤는데, 갈수록 안쓰는것 같다.
* 안쓰는게 더 COOL해 보여..
* 하지만 Self-documenting이 안된다면 써주는 것도 좋을듯
*/
```

---
### OOP(Object oriented programming)
```
1. Encapsulation : 사용자는 객체 내부의 구현, 상태를 알필요가 없다.
2. Data abstraction : 객체는 추상화되어 제공되어야 한다.
3. Inheritance : 부모-자식 클래스 간 상속을 통해 공통로직 구현 / 같은함수-다른구현을 할수있다.
4. Polymorphism : 같은 이름을 가진 함수라도 다른 로직을 가질수 있다.
```
---
### 알쓸(알아두면 쓸모~~없~~있는)지식
- Literal 과  Type의 차이?
  ![image-20211027022820630](/Users/kakao_ent/Library/Application Support/typora-user-images/image-20211027022820630.png)
- Integer에 _되는건 신박하다..첨봄   
  문제풀다가 이런경우도 있었음. (https://hyperskill.org/learn/step/4362)
```
나쁜코드:   val a = 512343
좋은코드:   val a = 512_343
```
- kotlin의 char는 2byte
- 코틀린에서는. Boolean에 정수값 할당 불가
- 코틀린에서는 xor 논리연산자가 제공. 우선순위는 ! > xor > && > ||
- 코틀린에서 모든 함수는 값 또는 special Value(ex. Unit, Nothing)을 반환한다.
```kotlin
val result = println("text")
print(result) // 결과: kotlin.Unit.  Java에선 불가한 코드. Unit타입은 Java의 void와 대응된다.
```
참고: https://www.baeldung.com/kotlin/void-type


- 정보단위를 나타내는 2 개의 측정(mesurance) 시스템,
```
2진법 : kibibyte(KiB), mebibyte(MeB), gibibyte(GiB), tebibyte(TiB), pebiByte(PiB)  
10진법: kilobyte(KB), megabyte(MB), gigabyte(GB), terabyte(TB), petabyte(PB)

IEC(International Electrtechnical Commission) 의 권장 KiB, MiB , GiB 을 주로 사용하도록 하자.
```
#### Code Style Convention 관련해서는.
- IntelliJ에서는 alt+cmd+L 로 어느정도 해결,
- IDE나 sourceTree로 커밋시에 reformmat해주는 기능도 있다.


