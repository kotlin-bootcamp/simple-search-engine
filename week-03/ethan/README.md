# 3주차 

### Function 

- return 타입을 선언할 수도 있고 선언하지 않을 수도 있다. (Unit 의 경우 그냥 리턴 타입을 없애는게 컨벤션.)
- 함수를 한 줄로 표현할 수 있다면 그렇게 하는 걸 추천한다. (컨벤션 얘기, 코드를 이해하는데 도움을 준다.)


### Equality 

- '==' 연산은 객체의 상태를 비교하는 작업 (내부적으로는 equals 를 사용한다.)
- '===' 연산은 객체의 참조를 통해서 비교하는 작업.

### Error in Program

- 컴파일에러 vs 런타임 에러를 비교하는 이야기
- 런타임 에러를 잡는데 도와주는 방법은 테스트와 코드리뷰.
  - 의미있는 테스트를 많이 작성하자. (무조건 많이 X, 테스트도 유지보수가 들어가기 떄문에.)

### What is an exception

- Exception 이 발생할 경우에는 어떻게 해결하는가? (읽어보자.)
  - Exception 의 구성은 Thread Name, Exception Name, Exception Message, Stack Trace 로 이뤄져있다.
  - Stack Trace 는 어디서 발생했는지를 메소드 호출 경로를 따라서 알려준다.
  - 우리는 여기서 Internal Function 에 주목하지 말고 우리 코드를 위주로 보면 된다.

### Design Principle

- 한번에 좋은 디자인으로 설계하기는 어렵다. (도메인 지식이 점점 늘어날 것이고, 요구사항이 변경될 가능성이 있으니.) 
- 그러므로 좋은 디자인 규칙, 가이드를 세워놓고 이를 적용하자. (클린아키텍처가 생각난다.)

### The concept of patterns

- 디자인 패턴을 잘 알고 있자. (다른 개발자들이 먼저 만난 문제에 대해서 솔루션, 템플릿 제공. 확장 가능한 설계가 장점, 대신 복잡한 설계)

### String basics

- Raw String 과 Concatenating strings 이 유용하다.

### String Templats

- 출력할 때 $변수이름, ${} 이런식으로 하나의 문자열 안에서 변수를 넣는게 가능하도록 해줌. (읽기 좋다.)
```kotlin
val language = "Kotlin"
println("Have a nice $language!")        // nice code
println("Have a nice " + language + "!") // bad practice
```

### If expression 

- 다른 언어와 달리 코틀린의 If 절은 expression 이 가능하다. 
- 이를 이용해 변수에 대입할 때 if 절 사용가능. 이것도 한 줄 표현식을 권장.

### Repeating blocks

- 간단한 반복문이 필요하다면 repeat(변수) {} 로 구현이 가능하다 라는 점.

### Declaring classes

- 클래스의 property 로 런타임에 값을 할당할 것이라면 var, 그렇지 않고 초기값만 가지고 세팅할것이라면 val 키워드를 사용하면 된다
- property 로는 다양한 타입이 올 수 있고 개수에 제한이 있지는 않다. 대신에 초기값을 넣어줘야한다.

