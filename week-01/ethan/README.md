# Week 1 

***

## What is Kotlin? 

코틀린 언어의 특징은 레퍼런스에 다음과 같다고 한다.

- 코드를 읽기 쉽다.
  
  - numeric 타입에서 _ 를 지원한다는 점. (e.g 100_000_000) 
  
  - 나누기 연산인 / 대신에 floorDiv() 라는 메소드를 지원하고, 나머지 연산인 % 대신에 mod() 를 지원하는 것.
  
  - 다른 프로그래밍 언어에서 xor 연산이 ^ 로 되었는데 코틀린에서는 xor 이라고 표시된 점.  
 
  
- 많은 플랫폼을 지원한다.

  - JVM 플랫폼, Android, JS, Native 등 

- 실용적인 언어다.

  - 코틀린 1.4 부터 Standard Input 으로 바로 Boolean 타입을 받을 수 있다는 점. 
  
    - readLine().toBoolean()   
    
    - 굳이 Boolean 타입 아니고 Integer, Double, Long 등 타입으로 받는 것도 가능하다.
  
  - 그리고 코틀린 1.5 부터 String 을 Boolean 으로 좀 더 엄격하게 변환할 수 있는 메소드들이 나왔다는 점.  
  
    - String.toBooleanStrict()
    
    - String.toBooleanStrictOrNull() 

  - 자바 라이브러리를 가지고 올 수 있다. (최소 자바의 가치를 제공해줄 수 있다 라는 뜻?) 
  
  - readLine() 에서 !! 를 붙이면 이 값이 비어있지 않다는 의미를 컴파일러에게 전달해줄 수 있다는 점.
  
  - readLine() 에서 하나의 라인으로 여러 개의 값을 한번에 읽어오는게 가능하다라는 점. 
  
    - val (a, b, c, d) = readLine()!!.split(" ")
  
- 자바를 대체하기 위해서 나왔다. 

이 부분 위주로 보면 될 것 같다. 

왜 코드를 읽기 쉬운지, 어떻게 실용적인지, 자바의 문제가 뭐였고 어떻게 해결했는지?.

다음 주 스터디로 코틀린과 자바의 차이점 (https://kotlinlang.org/docs/comparison-to-java.html) 이거 보는거 어떤가? 

***

## 흥미로웠던 점 

void 함수를 호출했을 때 결과를 받아올 수 있다는 점. 

- kotlin.Unit 이라는 값으로 가져와지고 뜻은 No Result 라고 한다.  

- Unit 타입의 객체는 싱글톤 인스턴스이므로 매 번 객체를 만들지 않고 재사용한다고 한다. (이름 자체가 싱글톤임을 내포하고 있긴하다.)

- Unit 이라는 이름을 쓰는 이유는 코틀린에서는 Nothing 이라는 타입이 있고 이 이름이 void 와 유사해서이다. 

  - 여기서 Nothing 타입은 계산이 정상젇으로 완료되지 않았을 경우 사용하는 타입이라고 한다. 예외를 던지는 함수인 경우 Nothing 을 사용했었던 걸로 기억한다. 
  
- References

  - https://papago.naver.com/?sk=en&tk=ko&hn=1&st=Why%20we%20don%25%2339t%20call%20it%20%25quotVoid%25quot%3A%20because%20the%20word%20%25quotvoid%25quot%20means%20%25quotnothing%25quot%2C%20and%20there%25%2339s%20another%20type%2C%20Nothing%2C%20that%20means%20just%20%25quotno%20value%20at%20all%25quot%2C%20i.e.%20the%20computation%20did%20not%20complete%20normally%20(looped%20forev
  
  - https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/
  
***





