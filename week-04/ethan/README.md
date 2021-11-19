## 4주차 

### Introduction to creational patterns

- Design Pattern 중 Creational Pattern 소개
- Creational Pattern 은 객체를 만드는 것과 관련된 패턴으로 주요 시스템 로직과 관련해서 객체를 생성할 수 있다는 장점이 있다. 
- Creational Pattern 을 사용하면 좋은 경우
  - 함께 사용되는 객체를 만들때 (Abstract Pattern)
  - 독립적인 복잡한 객체를 다르게 표현하고 싶을 때 (Builder)
  - 하위 클래스에 위임해서 객체의 생성 구현을 만들 때 (Factory Method)
  - 하나의 인스턴스만 사용할 때 (Singleton)
  - 객체를 쉽게 복사하고 싶을 떄 (Prototype)

### Singleton

- 하나의 객체만 생성하고 그 객체만 사용할 수 있는 것. 
- 주로 접근 범위 자체가 글로벌하다. 
- 그리고 공유할만한 리소스가 있을 때 주로 사용한다. (이런 경우는 읽기 전용으로 바꾸는게 좋다.)
- 예) LogManager 같은 것. 
- 문제점은 그 객체와의 결합도가 높아질 수 있다라는 것.

### Write, compile, and run

- Java 언어의 철학 "write once, run anywhere"
- 결국에는 바이트코드만 나오면 JVM 은 실행할 수 있다. 

### JVM components

- JVM 이 하는 활동은 다음과 같다. 
- 바이트코드를 로드하고, 검증하는 역할 (Class Loader)
  - 검증은 주로 위험한 행동을 하는 코드인지 검사하는 것. (예로 다른 곳에서 private 필드나 메소드에 접근하는 지)
  - 클래스 로더에 의해서 클래스들이 메모리에 로드된다. (이때 classpath 를 통해서 .class 파일을 찾아서 올린다. )
  - 클래스 로더는 클래스를 한번에 대량으로 올리지 않는다.
  - 클래스를 메모리에 올리는 방식은 on-demand 방식이다. 즉 필요할 때 메모리에 올린다. 예를 들면 main 함수를 실행하거나, 생성자를 호출하거나, System.out 으로 클래스를 출력하거나.
  - 클래스 로더의 종류는 다음과 같다.
    - Bootstrap, Extension/Platform, Application/System 
    - 각각이 classpath 를 가지고 있다. 
    - 참고: https://github.com/Youngerjesus/simple-search-engine/blob/master/theory/class_loader.md


- 바이트코드를 실행하는 역할 (Execution Engine)
  - JVM 서브 시스템 중에 바이트 코드를 실행하는 책임을 가진 것이 Execution Engine
  - Bytecode Interpreter: 바이트 코드를 해석해서 바로 실행하는 것.
  - JIT Compiler: 바이트 코드를 번역해 머신 언어로 바꿔서 더 실행이 빠르게 하는 것
  - GC: 힙에서 사용되지 않는 오브젝트를 제거하는 것.

- 런타임 환경을 제공해주는 역할 (Runtime Data area)
  - 런타임 환경을 제공해준다는게 프로그램 실행 환경을 제공해준다는 것
  - PC Register: 현재 실행될 명령의 주소를 저장하고 있다.
  - stack area: call stack 으로 불리는 곳. 메소드 호출 정보를 담고 있는 Stack frame 들이 저장되는 곳.
  - native method stack: native method 정보가 저장되는 곳
  - heap: 만들어진 모든 객체가 저장되는 곳.
  - method area: 클래스 수준의 정보를 저장하는 곳. 클래스 이름이나, 메소드 정보 등에 관한 것.
  - 모든 스레드들은 자신만의 pc register 과 stack 그리고 native method stack 을 가지고 있다.
  - 공유하는 자원은 heap 과 method area 이다.

### Characters

- Char 는 하나의 symbol 을 나타낼 때 주로 쓰이며 Unicode Table 에 있는 숫자와 매핑된다. (그래서 문자와 숫자간의 서로 변환이 된다.)
- '\u' 와 16진수 숫자로도 Char 를 나타낼 수 있다.
- Kotlin 에서는 Char 만을 읽는 편리한 함수는 제공해주지 않지만 그와 유사한게 있다. (readLine()!!.first())
- Kotlin 에서 String 은 Character 의 연속적인 집합으로 구성되어있는 관계다.
- 여러가지 유용한 메소드들을 제공해준다. (거의 자바에 있는 듯.)
  - isDigit(), isLetter(), isWhitespace(), isLetterOrDigit()
  - uppercaseChar(), uppercase()
  - lowercaseChar(), lowercase()

### Unicode

- ASCII 코드의 문제점을 해결하기 위해서 Unicode 가 등장했다. (bit 낭비, Symbol 개수가 제한적.)
- Unicode 는 두 가지 부분으로 이뤄진다. UCS (Universal character set) 와 UTF (Universal transformation format)
- Unicode 는 그리고 0 ~ 16 가지의 Plane 으로 쪼개져있다. (Plane 이 그룹핑을 말하는 듯.)
- 기본 0 Plane 은 Basic Multilingual Plane (BMP) 로 표시되며 일반적인 언어에서 쓰는 심볼들이 모두 다 있다. (아스키코드도 포함.)
- SMP 는 BMP 다음으로 오는 Unicode plane 으로 특수하 문자들, 기하하적 문자, emoji 등이 포함되어있다.
- 주로 사용하는게 UTF-8 과 UTF-16 이다. 이는 1 ~ 4 바이트까지의 가변 인코딩을 지원한다 라는 것. (UTF-8 은 1바이트씩 짤라서 인코딩을 지원, UTF-16 은 2바이트씩 잘라서 인코딩을 지원. 또 UTF-8 은 아스키코드와 호환이 되지만 UTF-16 은 그렇지 않은듯)

### Working with strings

- 코틀린에서 String 은 인덱스를 통해서 각 Character 에 접근하는게 가능하다.
- 원래 마지막 문자 같은 경우는 length - 1 이런식으로 일반적인 언어에서는 접근하는데, last() 라는 메소드를 제공해줌으로써 코드 읽기가 쉽다.
- String 은 Immutable 하기 때문에 특정 요소에 접근해서 바꾸는건 에러가난다.
- String 비교를 할 땐 == 연산자를 이용하면 된다. (equals 보다 == 을 권장하는듯.)
- 값이 비어있음을 나타낼 땐 isEmpty() 메소드를 사용하면 된다. 

### Getting substrings

- String 에서 subString() 메소드를 이용하면 subString 을 얻을 수 있다. 여기서 startIndex 와 endIndex 를 인자로 넘겨줄 수 있고 이 사이에 있는 값이 전달된다. (주의할 점은 endIndex 는 이전까지만 된다라는 것.)
- subString 에서 endIndex 를 생략할 수도 있다. (이 경우에는 startIndex 부터 String 의 끝까지의 subString 이 리턴된다.)
- 또 유용한 메소드로 subStringBefore, subStringAfter 같은 메소드가 있다. 인자로 delimiter 역할을 해주는 걸 넘겨주면 된다. 이때 두 번째 인수로 String 값을 넘기면 못찾았을 때 전달될 메시지가 리턴된다.
- 이 외에도 subStringBeforeLast, subStringAfterLast 같은 메소드도 있다.
- String 의 매칭되는 문자열을 바꿔주는 메소드로 replace 메소드가 있다.
- replace 는 매칭되는 모든 문자열을 바꿔준다. 한 번만 바꿔주길 원한다면 replaceFirst() 메소드를 사용하자.
- 그리고 String 같은 경우는 Immutable 하니까 replace 해도 원본은 바뀌지 않는다.
- 코틀린에서 uppercase, lowercase 와 같은 메소드를 이용해서 전부 대문자, 소문자로 바꿀 수 있다.

### Ranges

- 코틀린에서는 범위 검사를 사용할 때 Range 를 이용해서 좀 더 이해하기 쉬운 코드를 작성할 수 있다.
- Range 는 기본적으로 in a..b 로 표현되고 a <= <= b 조건을 나타낸다.
- Range 조건의 부등호는 !in 을 이용하면 된다.
- Range 조건들 끼리도 논리 연산자 결합이 가능하다.
- Range 조건 자체를 변수에 할당하는 것도 가능하다.
- Range 는 숫자 범위 뿐 아니라 사전 범위에서도 가능하다.
- in 뿐 아니라 until 도 가능

### When expression

- when 이라는 절을 통해서 if 절을 줄일 수 있다. (다양한 실행 흐름이 있는 경우에)
- when 절에서 여러 개의 값을 통해서 하나의 실행 흐름을 결정하는 것도 가능하다.
- when 절에서 복잡한 조건문을 실행할려면 '{}' 로 감싸면 된다. 
- when 절에서 결과를 가져오려면 마지막 문장에 변수를 적으면 된다.

### For loop and ranges

- kotlin 에서는 for loop 을 지원한다. (이는 ranges, arrays, collection 에서 사용이 가능하다.)
- for loop 에서 Range 를 통해서 반복될 루프의 수를 정해줄 수 있다. 
- for loop 에서 step 을 통해서 for loop 의 증가폭(?) 을 결정해줄 수 있다.
- for loop 에서 downTo 를 통해서 역순으로 진행하는 것도 가능하다. 











