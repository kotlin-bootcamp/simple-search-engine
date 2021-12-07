### Singleton

- 싱글턴 클래스는 하나의 인스턴스만을 가진다.
- 싱글턴 클래스는 애플리케이션의 어디에서든 접근 가능하다.

### Object

- 코틀린이 싱글턴 오브젝트를 제공하기 위한 키워드
- 생성자 사용은 불가, 애플리케이션 어디에서든 접근이 가능

### Nested Object

- 특정 클래스 안에 object를 생성할 수 있다 = nested object

- 해당 object는 클래스 scope에서만 유효하다.

- nested object/class는 outer class의 값을 사용할 수 없다.(완전 별개의 클래스로 동작) = java `static` 과 동일. 

  ```kotlin
  class Player(val id: Int) {    
      val speed = 7  
      object Properties {
          val defaultSpeed = speed // compile error, cannot get variable 'speed'
      }
  }
  ```

  ㄴ nested class 에서 사용하고 싶다면?

  1. `inner class` 로 만들어서 사용한다. inner Class는 outer class의 인스턴스가 있어야만 인스턴스 생성 

  ```kotlin
  val instance_1 = OuterClass1.NestedClass() // 생성가능
  val instance_2 = OuterClass2.InnerClass() // 컴파일에러, 생성 불가
  val instance_3 = OuterClass3().InnerClass() // 생성가능
  ```

  `inner class`는 내부사용목적으로만(`private`으로)사용하는게 좋다. 

  2. `companion object` 에 값을 생성하면 nested object/class 에서 사용가능하다.

  

- 클래스와 연관된 싱글턴 객체들을 object로 관리하면 가독성이 좋아지고 프로그래밍하기 좋다. 

- companion object vs nested object? vs static keyword(in Java) = nested class vs inner class(non-static class in java).  
  ㄴ 컴패니언 내부 `private` 변수는 내부클래스/오브젝트에서 사용가능하다.  
  ㄴ nested object/nested class 는 별개의 독립된 오브젝트로서 작동한다. object는 싱글턴.  
  ㄴ inner class는 outer class의 값을 자유롭게 사용할 수 있다. outer class에 완전 종속적이고, outer class에서만 사용한다.  

---

### Debuging

1. Logging
2. Assertion
3. Debugger

###  ㄴ Assertion

- Check(condition: Boolean) -> IllegalStateException. 
- Require(condition: Boolean) ->IllegalArgumentException. 
- Assert(condition: Boolean) -> -ea(enable assertion = true) 일때만 사용가능

```kotlin
// 이렇게 사용가능
check(false) { "check error message"}
require(false) { "require error message"}
```

### ㄴ예외발생 디버깅

IntelliJ 내장디버거로 예외발생시 브레이크포인트 처리가 가능. 
Run > View breakpoints

---

### 용어

- fail fast: 오류가능성이 있는것을 모두 보고하는 시스템을 말함.  

---

### 인상적인것

- regex로 스플릿하기
