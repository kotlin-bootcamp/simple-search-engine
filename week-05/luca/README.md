### Default arguments
* Kotlin은 함수 선언에서 함수 매개변수에 기본값 을 할당할 수 있습니다 .
```kotlin
fun foo(a: Int = 0, b: String = "") {

}
```

* java는 기본 인수가 없다.
* 기본 인수를 추가하는 것은 좋은 습관이며 복잡한 함수를 작성할 때 유용하다고 합니다.

### Named arguments
* Named arguments는 코드를 더 읽기 쉽게 만들어 줍니다.
```kotlin
fun calcEndDayAmount(startAmount: Int, ticketPrice: Int, soldTickets: Int) =
  startAmount + ticketPrice * soldTickets


val amount = calcEndDayAmount(
  startAmount = 1000,
  ticketPrice = 10,
  soldTickets = 500
)  // 6000
```

* 인수 재정렬도 가능합니다.

```kotlin
val amount = calcEndDayAmount(
  ticketPrice = 10,
  soldTickets = 500,
  startAmount = 1000
)  // 6000
```


### Object declarations
* object로 클래스를 정의하면, 싱클턴(Singleton) 패턴이 적용되어 객체가 한번만 생성되도록 합니다
* intellij => tools => show koltin bytecode
```kotlin
object Resource {
  val name = "Name"
}
```

* companion object
    * Java나 C#과는 달리, 코틀린에는 static 멤버 변수나 함수가 없다
    * 만약 클래스 인스턴스없이 어떤 클래스 내부에 접근하고 싶다면, 클래스 내부에 객체를 선언할 때 companion 식별자를 붙인 object를 선언하면 된다.

```kotlin
class MyClass {
  companion object Factory {
    fun create() : Myclass = Myclass()
  }
}


val instance = MyClass.create()
```


### Constructors
* 간략한 생성자
    * java

```kotlin
public class JavaA {

  private final String name;
  private final int age;

  public JavaA(String name, int age) {
    this.name = name;
    this.age = age;
  }

  //getter
}
```
* kotlin

```kotlin
class A(val name: String, val age: Int)
```


* constructor 키워드
    * 사실 class 이름 옆에 constructor 키워드를 생략한 것
    * 주 생성자가 어노테이션이나 접근 제어자(private 등)을 가지면 constructor 키워드를 생략할 수 없습니다

* init
    * init 블록에는 클래스의 객체가 만들어질 때 실행될 코드가 들어간다.
    * 초기화 블록을 주로 주 생성자와 함께 사용한다.
    * 기본 생성자는 코드를 포함할 수 없다




### Introduction to MutableList
* 변경가능한 목록 리스트 만들기

```kotlin
val numbers = mutableListOf(10.8, 14.3, 13.5, 12.1, 9.7)

println(numbers) // [10.8, 14.3, 13.5, 12.1, 9.7]
```

* java vs kotlin
    * java Immutable 만들기

```kotlin
// 방법1
List<String> fruits = Arrays.asList("Apple", "Banana", "Cherry");

// 방법2
List<String> fruits = Stream
        .of("Apple", "Banana", "Cherry")
  .collect(collectingAndThen(toList(), Collections::unmodifiableList));

// 방법3
List<String> fruits = new ArrayList<>();

fruits.add("Apple");
fruits.add("Banana");
fruits.add("Cherry");
fruits = Collections.unmodifiableList(fruits);

fruits.add("Lemon"); // UnsupportedOperationException
```

* koltin Immutable 만들기

```kotlin
// 방법1
val a = listOf('1', '2', '3')
```

* 기타기능
    * list.first()
    * list.last()
    * list.lastIndex()

### Work with MutableLists

* 목록 내용 복사
    * 깊은복사일까 얇은 복사일까
```kotlin
val list = mutableListOf(1, 2, 3, 4, 5)
val copyList = list.toMutableList()
println(list === copyList) // false


val list = mutableListOf(1, 2, 3, 4, 5)
val copyList = mutableListOf<Int>()
copyList.addAll(list)

print(copyList === list) // [1, 2, 3, 4, 5]
```

* 이외 유용한 기능
    * list.isEmpty()
    * list.isNotEmpty()
    * list.sublist(from, to)
    * list.minOrNull()
    * list.maxOrNull()
    * list.sum()
    * list.sorted()
    * list.sortedDescending()


* list.size() vs list.isempty() 가독성 o  / 성능 차이 x
```kotlin
val myList = mutableListOf("a", "b")

// 사례 1 (가독성을 이유로 추천)
if (myList.isEmpty()) {
    println("it is empty")
}

// 사례 2
if (myList.size == 0) {
    println("it is empty")
}
```
