### Log Level

- Debug : 진단. 디버그 용도로 함수의 결과값이나 특정단계의 결과를 기록.
- Info : 애플리케이션의 중요 정보를 기록. e.g) api의 수행결과를 기록
- Warn : 애플리케이션 실패의 첫단계. 실제 사용에의 문제는 없지만 바람직하지 않은 일이 발생시 사용가능
- Error : 애플리케이션 실패의 두번쨰 단계. 사용에 문제가 있으나, 애플리케이션 종료까진 하지않음. 
  e.g) 네트워크 에러로 수행에 실패
- Fatal : 애플리케이션 실패의 세번째 단계. 사용에 문제가 있고, 치명적이기에 애플리케이션을 종료.

---

### procedural programming

 = 절차적 프로그래밍. = 명령형 프로그래밍

순차적 프로그래밍과는 다른개념. 
함수, 메서드 호출의 개념을 의미

---

### Compile Error & Runtime Error

- Compile Error: 문법에러. 컴파일 자체 불가
- Runtime Error: 프로그래머의 로직 오류, 처리되지 않은 예외
  ㄴ 테스트 자동화와 코드리뷰로 방지 가능

---

### Design Principles

- DRY( Don't Repeat Yourself) - 재사용성을 높여라
- You Ain't Gonna Need It ( YAGNI ) -  필요없는 작업은 하지마라, 
- Keep it Simple, Stupid (KISS) - 코드를 심플하게 유지해라.(가독성 및 이해 증가)

ㄴ 말은 쉽지만, 실제 스킬 발전은 개발하면서 증진시킬 수 있다.

---

### Design Pattern의 목적

- 코드 재사용이 용이하도록. - 다른프로젝트에서 가져다 쓰기 용이
- 사이드 이펙트가 적도록.
- 유지보수가 용이하도록.

한편..

- 디자인 패턴을 남용하면 오히려 더 복잡해질 수 있다.(패턴 어뷰징) 
  ㄴ KISS를 기억..
  ㄴ 클래스 폭발: 불필요한 수많은 클래스가 생성되는 현상..
  ㄴ 구현시간이 늘어남.
  ㄴ 불필요한 유연성..(오버프로그래밍)

### Design Pattern을 알아야 하는 이유

- 이미 검증된 설계 솔루션
- 유연성과 유지보수성을 향상시킨다. loosely coupled
- 장기적 관점에서 개발의 속도향상
- 프로그램 설명시에 보편적 용어로 설명 가능
- 표준 라이브러리. 프레임워크에서 많이 사용
- 패턴을 알면, 가독성이 향상된다

---

### Single Responsibility Principle

- 단일 책임 원칙: 하나의 함수/클래스/모듈이 하나의 일만 하게 하라.
- 하나의 기능이 변경되더라도 전혀 다른기능에는 영향을 주지 않아야 한다. 
- 단순히 기능을 쪼갠다는 개념이 아닌, 같은 기능을 하는 것은 모으고, 다른 기능을 하는것은 분리.



---

### Tip 

- `==` 와 `===` 의 차이점 : 
  `==` 는 구조적 동등성을 가질때 `true`
  `===` 는 참조(주소값)이 동일한지 `true`

- 특이점. 불변 객체는 동일한 참조값을 가진다.

  ```kotlin
  var a = 2 // var로 선언되었지만, Int타입이므로 immutable
  var b = 2
  println(a == b)	// true
  println(a === b) // true
  ```

  ㄴ 오답노트:  두 값의 `===` 연산이 `true` 일때, 한쪽 값이 변하면 다른 값도 변하는가?
  ㄴ 값이 object이면 `true`,  값이 `Int`, `String` 등이면 `false`

  

- `val` 키워드로 생성된 변수는 reassign이 불가. 내부 상태값은 변경가능 = immutable
  `var` 키워드로 생성된 변수는 reassign 가능 mutable

- ${}를 유용하게 사용

  ```kotlin
  val world = "World!"
  val helloWorld = "hello $world"
  ```

- repeat문

  ```kotlin
  repeat(3) {
    println("간단한 for loop 대체")
  }
  ```

  
