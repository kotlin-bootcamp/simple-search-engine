# Comparison To Java

***

## 자바와 코틀린의 차이점

코틀린은 자바의 문제를 해결하기 위해서 나왔다. 

Kotlin fixes a series of issues that Java suffers from:

- Null references are controlled by the type system.

- No raw types

- Arrays in Kotlin are invariant

- Kotlin has proper function types, as opposed to Java's SAM-conversions

- Use-site variance without wildcards

- Kotlin does not have checked exceptions

### Null references are controlled by the type system.

코틀린 언어에서는 널 참조를 제거할려고 만들었다.
- 널을 만든 사람 자체이 자신이 만든 널 때문에 Billion 의 손실이 있다고 한다. 그 사람의 논리는 널 참조는 자동적으로 컴파일애서 checking 해줘야한다 라는 것.

코틀린에서는 Null 을 가질 수 있는 타입인지, 가질 수 없는 타입인지 명확하게 구별한다.
- NULL 을 가질 수 없는 타입인 경우에는 애초에 널 체킹이 필요하지도 않다.
- 그라고 NUll 을 가질 수 있는 타입인 경우에는 강제로 컴파일 에러를 내준다. (자바에서는 절대 해주지 않는 것)

#### Null Checking 하는 방법은 다양하다.
- 첫 번째: if 절을 이용하는 방법 
  - 물론 이 방법도 immutable 한 변수인 경우에만 된다. (검사한 후에 null 로 변경될 여지가 있으니까.)

- 코틀린에서 두 번째로 Null Checking 을 하는 방법은 ?. 를 사용하면 된다
  - 예를 들어서 b?.length 같은 경우에 b 가 널이면 null 을 리턴하게 되고 널이 아니라면 b.length 를 리턴하게 해준다.
  - 이 방법은 객체에서 프로퍼티에 접근을 chain 식으로 할 때 유용하다. bob?.department?.head?.name 즉 bob, department, head 모두가 널이 아니면 name 을 리턴하도록 하는 것이다. (Null Checking 로직이 적어진다.)
  - 이와 비슷하게 반복문에서도 null 이 아니면 실행되는 코드 블록을 let 을 통해서 만들 수 있다.
  - ?. 을 통해서 값을 가져오는게 아니라 대입을 할 때도 사용할 수 있다. person?.department?.head = managersPool.getManager() 라는 메소드에서 person 과 department 가 모두 널이 아닌 경우에 managersPool.getManager() 라는 메소드가 실행된다.

- 세 번째는 Elvis operator 를 사용하는 방법이 있다. 
  - Elvis Operator 는 ?: 의 왼쪽 값이 널이 아니면 그걸 사용하고 널이면 오른쪽 값을 사용한다라는 뜻.

#### Null 을 다루는 방법 

- !! Operator 를 이용해 Not Null 임을 나타내는 것도 가능하다.
  - Not Null 임을 명시했지만 null 인 경우에는 NPE 가 난다. 그러므로 NPE 를 만들고 싶다면 이걸 사용하면 된다.
  
- Safe casts 를 이용하기 
  - 타입을 변환할려고 하는데 Target Type 으로 변환할 수 없다면 ClassCastException 이 발생한다. 이를 막고 싶다면 타입을 변환했을 때 실패하더라도 예외를 던지고 싶지 않다면 Safe Cast 를 이용하면 된다. 대신에 Null 값을 리턴할 수 있다

- Collections of a nullable type
  - 컬렉션에 Nullable 요소가 있고 이것들을 처리하고 싶다면 filterNotNull 을 이용하면 된다.

***

## Generics

자바에서는 제네릭에 wildcard 가 있다. 

왜 Wildcard 가 필요했을까? 이건 Effective Java Item 31 에 나와있다.

- List<String> 은 List<Object> 의 하위 타입이 아니기 때문에. 애초에 다른 타입 
- 자바에서의 제네릭은 Invariant 하다. => 유연하지 않다. 

코틀린에서는 이게 없고 declaration-site variance 와 type projection, Star Projection 이 있다. (이게 더 효율적이라는 것)
- 클래스 선언해줄 때 Covariant 를 제공해주고 싶다. => declaration-site variance 사용하기
- 메소드 레벨에서 지원해주고 싶다. => type projection 사용하기
- 어떤 타입이 올 지 명확하지는 않지만 관계는 설정해주고 싶다. => Star Projection 사용하기 

***

## Array 의 Invariant 문제 해결

코틀린의 Array 는 Invariant 이다. (자바는 그렇지 않다. 이펙티브 자바 참고.)

***

## Checked Exception 

Kotlin 에서는 Checked Exception 을 지원하지 않는다. 여기에는 많은 이유가 있다.

- 예로 StringBuilder 에 append() 라는 메소드를 이용한다고 하면 I/O Exception 이 발생할 수 있다고 한다. (발생할 가능성이 없는데 단지 Appendable 인터페이스를 상속받았다는 이유로.)
- 발생하지 않는 예외가 있고 이를 처리하는 catch 문이 있다는 점은 불편하다.
- Effective Java Item 77 를 보면 예외는 절대 무시하지 말라는 얘기가 나온다. (이를 통해 혼돈을 줄 수 있는듯. 그래서 Effective Java 에서는 발생하지 않을 Exception 이름을 ignored 로 바꾸라고 하는듯.)

Bruce Eckel 은 대규모 프로그램을 만드는 상황이라면 예외처리를 신경쓰라는 요구 사항은 코드 퀄리티를 많이 떨어트린다고도 했다.

Rod Waldhoff 는 Checked Exception 은 실험이었고 실패라고 얘기했다.
- 자바 뒤에 나온 언어인 C# 과 Ruby 는 Checked Exception 이 없었다.
- Checked Exception 이 발생한다고 해서 딱히 할 수 있는 건 없다. skip, retry, report 등이 있겠지만 이 문제를 전파하는게 가장 합리적인 방법이다.
- 오히려 Checked Exception 을 사용하면서 try-catch 를 늘고려하는게 더 불편하다.
- 애초에 실패하는 케이스가 lower level 인데 이 것들을 처리하는 곳이 high level 이니까 관심사가 다르다라는 뜻.




