### IntelliJ IDEA 단축키

Cmd+X : 라인 잘라내기

Cmd+D : 라인 복사+붙여넣기

Cmd+J : 라이브템플릿/코드스니펫

Cmd+Y : 함수선언보기

Ctrl+J : 함수 description보기 / 한번더 누르면 별개탭으로. 좋은데?

Ctrl+space : 자동완성

---

### Big O notation

- 최악의 상황에 대한 시간 복잡도를 설명할 수 있는 표기법

---

### Abstract Data Type

- 값, 값들의 연산이 가능한 하나의 데이터 타입
- 실제 데이터의 구조(구현)는 중요하지 않고, 사용자(구현자)의 관점에서 바라보는 데이터 타입
- int 도 하나의 ADT로 볼수있다. 실제 데이터를 컴퓨터가 어떻게 저장하는지는 중요하지 않고, 연산이 가능하므로

---

### Call Stack

- 프로그램이 실행되며 함수 연쇄 호출시에 이용하는 스택

- stack에 함수 주소, 파라미터, 지역변수, 중간계산 데이터, 등이 포함.

- 아래와 같은 옵션으로 콜스택의 크기(maXimum Stack Size) 지정 가능

  ```shell
  kotlin {programName} -Xss256k
  ```

---

### Software Architecture

- 시스템 구성요소와 그들의 상호작용. 

- 직접적인 영향을 주는것.
  ㄴ 프로젝트 구조. 
  ㄴ IT 환경

- 간접적인 영향 : 프로젝트를 둘러싼 환경의 변화
  ㄴ 비즈니스 전략(프로젝트의 주된 목표?). 
  ㄴ Human Dynamics(인재관리?)

- ADR(Architecture Decision Record): 아키텍쳐를 결정할때 더 좋은 결정을 내리기 위해 작성하는 문서

  ㄴ https://www.youtube.com/watch?v=0ljhJZBLs_U. 

- 아키텍쳐는 UML로 시각화 가능
  ㄴ 애플리케이션, 정보, DB, 네트워크. 

---

### Creational Pattern

- 객체 생성에 중점을 둔 패턴, 객체 생성을 시스템의 다른 요소들과 분리하여 느슨한 결합을 만든다.
- 일반적인 5가지 Creational Pattern 종류
  1. Factory Method 패턴: 오브젝트 생성을 위한 함수를 상위클래스에 만들고, 객체 생성은 하위 클래스에 위임한다. 런타임 이전에는 객체의 유형을 알지 못하는 경우에 사용가능.
     https://ko.wikipedia.org/wiki/%ED%8C%A9%ED%86%A0%EB%A6%AC_%EB%A9%94%EC%84%9C%EB%93%9C_%ED%8C%A8%ED%84%B4
  2. Singleton 패턴: 프로그램 내에 인스턴스가 하나만 존재해야 할 경우에 사용
  3. Prototype 패턴: 객체를 복사하여 리턴하는 함수를 만들고, 그 함수를 이용해서 해당 클래스의 객체를 복사해서 사용.
  4. Builder 패턴: 생성이 복잡한(생성자 파라미터가 많거나 복잡한로직이 있는경우) 오브젝트를 생성할때, 복잡한 생성과정을 따로 분리할 수 있도록 builder클래스를 구현하여 객체를 생성한다. 다양한 variation의 객체를 생성할 수 있다.
     https://www.youtube.com/watch?v=qWiqt5EctSE&list=PLDV-cCQnUlIYcAmW4j27i8aYPbja9HePm&t=463s
  5.  Abstract Factory 패턴: 팩토리별로 정해진 객체들을 생성해야 할때 유용한 패턴. 
     각 팩토리에서 생성되는 객체들은 같은 클래스를 상속받는다.
     https://ko.wikipedia.org/wiki/%EC%B6%94%EC%83%81_%ED%8C%A9%ED%86%A0%EB%A6%AC_%ED%8C%A8%ED%84%B4
- 너무 정해진 패턴에 얽매일 필요는 없다.

---

### Singleton

- 프로그램 전역에서 접근 가능한 오브젝트
- 클래스의 객체를 생성하려 하면 그 객체의 처음 초기화 인스턴스를 반환
- spring bean은 스프링 컨테이너(싱글톤 레지스트리)에 의해 하나의 객체만을 유지할수 있게 된다.
- Stateless 하도록 유지한다.
- SRP(Single Responsibility Principle)을 위반하게 된다. 하나의 로직이 다른 로직에 영향을 줄수 있게 되어버림

---

### Write / Compile / Run

`.java` -(컴파일)->`.class`(바이트코드) -(JVM)->low-level-code로 실행

- JVM은 자바 바이트코드라면 어떤 환경에서든지 실행.
  ㄴ JVM언어: 바이트코드로 컴파일될수 있는 언어: Java, Kotlin, Scala, Groovy, Clojure, ...  

---

### JVM 구성요소

- 클래스로더: 바이트코드 로드, 바이트코드에 대한 데이터를 메모리 영역에 할당
- 런타임 데이터 영역: JVM 메모리 영역. 
  ㄴ PC 레지스터: 프로그램 카운터. 현재 실행중인 명령어주소. 
  ㄴ 스택: 콜 스택 메모리. 
  ㄴ 기본 메서드 스택: 기본 메서드 정보 저장. 
  ㄴ 힙: 동적으로 생성된 객체 저장. 
  ㄴ 메서드 영역: 클래스 이름, 직계 부모 클래스 이름. 메서드 정보 등의 정적 정보 저장. 
- 실행 엔진: 바이트코드 실행을 담당.
  ㄴ 가비지 컬렉터: 실행하지 않는 힙메모리 영역 정리. 
  ㄴ JIT(Just In Time 컴파일러): 바이트코드를 기본 기계어로 변환(빠르게). 
  ㄴ 인터프리터: 바이트코드를 한줄씩 해석하고. 실행. 

---

### Garbage Collector

- 가비지 컬렉터 동작단계
  1. 프로그램이 더이상 사용하지 않는 메모리 부분을 확인   
     ㄴ 가비지 수집 알고리즘에 의해 동작(e.g. 프로그램이 도달할 수 없는 객체: 쓰레기로 간주)
  2. 쓰레기 삭제

- 가비지컬렉터를 직접 호출도 가능

```kotlin
System.gc()
RunTime.getRuntime().gc()
```

