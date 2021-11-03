### Null Safety

- 코틀린은 컴파일러 단에서 NPE가 발생하지 않게끔 걸러준다.

-  체인으로 호출시에 유용한 `?.` 연산자 를 사용하면 코드를 짧고 간결하게 만들수 있다.

  ```kotlin
  val a = bob?.department?.head?.name
  // 하나의 속성이라도 null이면 a=null 을 반환한다.
  ```

- `let` 함수를 이용해 non-null value에 대해 연산할수 있다.

  ```kotlin
  item?.let { print(item) }
  // item 이 null이 아닐경우에만 print
  ```

- 선언문의 왼쪽에도 사용이 가능. `null`이 아닐경우에만 선언의 왼쪽 expression이 실행된다

  ```kotlin
  person?.department?.head = managersPool.getManager()
  ```

- Elvis 연산자 `?.`

  ```kotlin
  val l = b?.length ?: -1
  val parent = node.getParent() ?: return null
  val name = node.getName() ?: throw IllegalArgumentException("name expected")
  // ?: 의 왼쪽항이 null이면 오른쪽항을 반환 or return or throw
  ```

- `!!` 연산자 . 해당 변수가 null이 아님을 확인해준다.
  주의!! 잘못사용하면 NPE 발생가능!

- Safe casts. 안전타입변환?

  ```kotlin
  val aInt: Int? = a as? Int
  // a 가 Int타입으로 변환불가하다면 aInt = null
  ```

  

---

### Function Types

- 함수도 하나의 타입처럼 사용 가능

- 3가지 방법으로 인스턴스화가 가능
  ㄴ 단순히 코드블럭으로 (람다함수, 익명함수)

  ```kotlin
  val intPlus: (Int, Int) -> Int = { a, b -> a + b }
  val intPlus2: (Int, Int) -> Int = fun(a:Int, b:Int): Int { return a + b }
  ```

  ㄴ 기존 선언을 참조

  ```kotlin
  val intPlus3: Int.(Int) -> Int = Int::plus
  ```

  ㄴ 펑션 타입의 클래스를 구현

  ```kotlin
  class CustomIntPlus : (Int, Int) -> Int {
      override operator fun invoke(a: Int, b: Int): Int { return a + b }
  }
  val IntPlus4 = CustomIntPlus()
  ```

- 펑션타입 인스턴스 호출

  ```kotlin
  println(intPlus(2, 3))  // 파라미터로 호출
  println(intPlus2.invoke(2,3)) // invoke operator로 호출
  println(2.intPlus3(4)) // 확장함수처럼 호출
  ```

  

---

### 코틀린은 Checked Exception이 없다

- 예외처리가 필요할 때도 분명히 존재하지만, checked exception을 반드시 처리해주어야 하는 포인트에서,
   개발 비용이 많이 들어가는 반면, 안정성이 크게 좋아진다고 볼 수 없다.

- 코틀린은 Checked Exception이 존재하지 않아 개발자가 필요한 경우에만 try - catch문으로 예외처리가 가능

- `throw`  구문은 `Nothing` 타입을 가진다. `Nothing` 은 아무것도 return하지 않는다.

  ```kotlin
  val n = null // n의 타입은 Nothing?
  ```

---

### 코틀린은 삼항 연산자가 없다.

```kotlin
val max = if(a > b) a else b
// if문이 값을 직접 반환할수 있으므로, 삼항연산자를 굳이 만들지 않았다.
```



---

### 객체지향 SOLID 원칙

- S-  Single Responsibility Principle(단일 책임 원칙)
  : 소프트웨어의 설계 부품(클래스, 함수 등)은 하나의 책임(기능)만을 가져야 한다
- O- Open-Closed Principle(개방-폐쇄 원칙)
  : 기능을 추가하는 것에 열려 있고(Open), 그때  기존 코드를 변경하지 않고(Closed) 추가할 수 있도록 설계해야한다. 
- L- LisKov Substitution Principle(리스코프 책임 원칙)
  : 부모 클래스 객체의 자리를 자식 클래스 객체가 대신해도 코드가 동작해야 한다. 
- I- Interface Segregation Principle(인터페이스 분리 원칙)
  : 한 클래스는 자신이 사용하지 않는 인터페이스는 구현하지 않아야 한다. 하나의 일반적인 인터페이스보다 여러개의 구체적 인터페이스가 낫다.
- D- Dependency Inversion Principle(의존 역전 원칙)
  : 의존 관계를 맺을 때, 변화하기 쉬운 것(구현체)보다는 변화하기 어려운 것(추상클래스)에 의존해야 한다.

- 참고링크: https://dev-momo.tistory.com/entry/SOLID-%EC%9B%90%EC%B9%99

---

### Companion Object

- Class 내부에 정의된 오브젝트

  ```kotlin
  class GenClass {
      companion object {
          fun create() = GenClass()
      }
  }
  
  GenClass.create() // java의 static member처럼 사용가능.
  ```

- 실제 객체인 만큼, 인터페이스를 상속받아 구현하는것도 가능하다.

  ```kotlin
  interface myInterface {
      fun create()
  }
  
  class GenClass {
      companion object: myInterface {
          override fun create() {
              GenClass()
          }
      }
  }
  
  GenClass.create()
  ```

  

---

### Top Level Function

- 클래스를 만들고 그 내부에 함수를 만들필요 없이. top level에서 선언이 가능하다. 

---

### Extentsion Function

- 라이브러리에 존재하는 클래스(임의수정불가)의 새로운 함수를 만들기 위해 클래스를 상속받은 새로운 클래스를 만들필요가 없다.

  ```kotlin
  fun Int.plus10times5(): Int {
      return this.plus(10).times(5)
  }
  
  val a = 5
  print(a.plus10times5()) //결과: (5+10)x5 = 75
  ```

  

---



### Generic: in, out

- T 타입의 파라미터를 갖는 제네릭함수가 있다고 가정할때, T의 부모클래스나 자식클래스를 타입으로 가지는 파라미터를 받을 수 없다. 코드 안정성 때문.

```kotlin
open class Parent
class Child : Parent()

fun printHelloWorld(parent1: Array<Parent>, parent2: Array<Parent>) {
    println("Hello World")
}

val any = Array(3) { Any() }			// Array<Any> -  Parent의 상위타입
val parent = Array(3) { Parent() }		// Array<Parent> - Parent Type 	
val child = Array(3) { Child() } // Array<Child> - Parent의 하위타입

printHelloWorld(parent, child)			// 컴파일 에러: 타입 mismatch.
printHelloWorld(any, parent) 				// 컴파일 에러: 타입 mismatch.
printHelloWorld(parent, parent)			// "Hello World"
```

- 이럴때 사용할수 있는 keyword 가 `in`,  `out` 이다. `printHelloWorld` 를 아래와 같이 변경하면 코드가 동작한다.

  ```kotlin
  fun printHelloWorld(parent1: Array<in Parent>, parent2: Array<out Parent>) {
      println("Hello World")
  }
  
  printHelloWorld(any, child)				//  "Hello World"
  printHelloWorld(parent, parent) 	// "Hello World"
  printHelloWorld(any, any)					// 타입 mismatch. 
  /*
  * in: 같은 타입 또는, 상위 클래스를 받을 수 있도록 해준다. 
  * out: 같은 타입 또는, 하위 클래스를 받을 수 있도록 해준다.
  */
  ```

- `in`, `out` 키워드로 타입 제약을 완화시킬 수 있으나, 사용시에 `out` 으로 받은 타입의 파라미터는 읽는 용도로 사용이 제한되고, `in`으로 받은 타입의 파라미터는 읽는용도X, 쓰는용도로만 사용이 제한된다.

  ```kotlin
  fun copy(to: Array<in Parent>, from: Array<out Parent>) {
      for( i in from.indices) {
          to[i] = from[i]
      }
  }
  
  copy(parent, child) // OK
  copy(child, parent) // 타입 mismatch
  ```

- `out` 키워드를 사용하여 하위타입의 파라미터를 받을 수 있도록 하는 것을 공변성( `covariance` ) 
  매개변수 Parent (첫번째)는 covariant type의 변수다.
- `in` 키워드를 사용하여 상위타입의 파라미터를 받을 수 있도록 하는것을 반공변성( `contravariance`).
  매개변수 Parent (두번째)는 contravariance type의 변수다.

 ### star-projection

- Star-projection은 기본적으로 `out Any?`, `in Nothing` 과 같은 용도로 사용되지만 더 간결하다.
  모든 쓰기를 방지해 준다.

  ```kotlin
  fun printHelloWorld(parent1: Array<*>, parent2: Array<*>) {
      println("Hello World")
  }
  
  fun copy(to: Array<in Parent>, from: Array<out Parent>) {
      for( i in from.indices) {
          to[i] = from[i] // 컴파일에러, 쓰기 불가능
      }
  }
  ```

  

### use-site variance vs declation-site variance

- Use-site variance(type projection)
  ㄴ 제네릭 클래스를 사용하는 관점에서 공변성을 이용하는 것
  ex) Array 사용시에 공변성을 이용. 

  ```kotlin
  fun copy(to: Array<in Parent>, from: Array<out Parent>) {
      for( i in from.indices) {
          to[i] = from[i] // 컴파일에러, 쓰기 불가능
      }
  }
  ```

  

- Declation-site variance
  ㄴ 제네릭 클래스를 선언하는 관점에서 공변성을 이용하는 것. 
  ex) 리스트 인터페이스 선언시 공변성 이용.

  ```kotlin
  public interface List<out E> : Collection<E> {}
  ```

참고링크: https://readystory.tistory.com/201



























