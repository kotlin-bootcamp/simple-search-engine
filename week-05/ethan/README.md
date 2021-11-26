# 5주차

***

### Default arguments

- function 선언에 파라미터 값으로 Default Value 를 넣는게 가능하다. 
- 함수 호출자의 입장에서는 Default Value 가 있는 파라미터의 경우에는 생략하고 함수 호출을 해도된다.

### Named arguments

- 함수 호출할 때 argumentName 과 argumentValue 를 같이 넘기는게 가능하다. (Example 1 참고)
- 이를 통해서 함수가 어떤 일을 하는지 좀 더 이해하기 쉽다. (함수 선언부를 보지 않아도 파라미터의 이름을 알 수 있으니까.)
- Named Argument 의 또 다른 특징으로는 파라미터의 순서를 신경쓰지 않아도 된다. (그래서 거리가 가까운 파라미터의 경우에는 가까이 묶는다면 더욱 코드 이해가 좋을 것.)
- 파라미터의 순서를 보장하는 Positional Argument 뒤에 Named Argument 를 쓰는 것 가능.
- Named Argument 뒤에 Positional Argument 쓰는 것도 가능한데 순서를 맞춰서 써야한다.  
- Default Argument 와 같이 쓸 때 조심해야한다. (Example 2 참고)
- 단점이라고 하면 한 화면에서 볼 수 있는 코드의 수가 줄어든다는 점.  

#### Example 1 

```kotlin
val amount = calcEndDayAmount(
    startAmount = 1000,
    ticketPrice = 10,
    soldTickets = 500
)  // 6000
```

#### Example 2  

```kotlin
fun calcEndDayAmount(startAmount: Int = 0, ticketPrice: Int, soldTickets: Int) =
        startAmount + ticketPrice * soldTickets

val amount = calcEndDayAmount(10, 500)  // Won't work —


fun calcEndDayAmount(startAmount: Int, ticketPrice: Int, soldTickets: Int = 0) =
        startAmount + ticketPrice * soldTickets

val amount = calcEndDayAmount(10, 500)  // 작동한다. —
```

### Constructors

- 기본 생성자는 컴파일러에 의해 자동으로 생성된다. (생성자가 없다면)
- 클래스 선언에서 무조건 이 프로퍼티가 필요하다고 할 때 Primary Constructor 를 사용하면 된다. 
  - Primary Constructor 를 사용하면 내부에 프로퍼티를 선언하지 않아도 자동으로 생겨난다. 
  - Primary Constructor 에서도 함수와 같이 Named Argument 와 Default Argument 를 사용하는게 가능하다.
  - Primary Constructor 에서 선언한 프로퍼티 말고 다른 프로퍼티가 없다면 클래스를 한 줄로만 만드는 것도 가능하다. (주로 Data 클래스)
- Primary Constructor 는 단순히 값을 넣어주는 역할만 한다. 코드 블락은 딱히 없다. 
- 만약에 Primary Constructor 에서 받은 프로퍼티로 어떠한 로직을 통해서 다른 프로퍼티에 값을 넣어주는게 필요한 경우에는 init {} 블락을 이용하면 된다.
- init 블락은 여러개 넣을 수 있고 각 프로퍼티 값 세팅을 포함해서 순서대로 실행된다.
- 그리고 Coding Convention 으로 Primary Constructor 에서 받은 파라미터는 앞에 _ 를 붙여주자.

### Object declarations

- 코틀린에서 Singleton 객체를 만드는 방법은 간단하다. 그냥 Object 선언을 넣으면 된다. 이러면 싱글톤을 만들기 위해서 해야하는 구현을 생략해도 된다. (코틀린의 유용함을 나타내는 측면.)
- 싱글톤을 사용하는 방법으로 Nested Class 를 추천한다. 이는 클래스끼리 서로 관련성이 있다면 독립적인 클래스를 만드는 것보다 Nested Class 를 만드는 걸 추천한다.
  - 여기서 말하는 관련성은 모든 객체가 가지고 있을만한 공통적인 Property 나 생성자 대신에 팩토리 메소드를 사용하기 위해 Factory 를 만드는 것 
  - 이런 공통적인 특성들은 싱글톤으로 만들면 좋은데 Nested Class 에서도 Object 선언부가 있으면 싱글톤으로 만들 수 있음.
  - 주의 할 점은 Outer Class 는 Nested class 의 property 와 function 을 이용하는게 가능하지만 그 역은 안된다.
   

### Debugging

- Debugging 은 소프트웨어의 버그를 찾는 과정.
- 프로그램을 디버깅 하는 방법은 크게 3가지가 있다.
  - Logging: Logging 은 프로그램의 상태를 출력하도록 해서 런타임중에 어떠한 일이 진행중인지 알 수 있도록 하는것.
  - Assertions: Assertion 은 프로그램의 상태를 사전에 검사해서 올바르지 않은 상태인경우 실패하도록 하는 방법이다.
    - 이는 Fail Fast 라고 불리는데 일이 더 커지기 전에 미리 막는다는 취지다.
    - Object 의 상태를 검사할 땐 check() 메소드를 사용하면 되고, 메소드의 아규먼트가 유효한지 검사할려면 require() 메소드를 이용해서 검사하면 된다.
  - Attaching a debugger: Debugger 를 사용하는 것으로 디버거를 사용하면 런타임 정보를 가지고 와서 볼 수 있고, 이를 통해 다양한 시나리오를 적용해보는 것도 가능하다.

### Debugging features

- Loop 에 Breakpoint 를 걸었을 때 단순히 멈출 라인만 정하는게 아니라 Loop 가 어디까지 순회할 것인지도 정하는게 가능하다.
- class 에서 breaking point 를 걸면 초기화 메소드가 되기 전의 상태를 볼 수 있고, 초기화 되고나서 프로퍼티의 값을 봅 수 있다.
- 내가 찾고자 하는 Exception 이 어디에서 났는지 디버거를 통해서 그 지점으로 갈 수 있다. 

### Introduction to MutableList

- 하나의 요소만 다루는게 아니라 많은 요소를 다루기 위해서 MutableList 를 통해서 처리할 수 있다. 
- mutableListOf() 메소드를 통해서 MutableList 클래스를 만들 수 있다.
- 들어올 수 있는 구체적인 타입을 지정하고 싶다면 <> 을 쓰고 거기에 해당 타입을 넣으면 된다. (<> 를 안쓰면 MutableList 에 타입을 섞어서 넣는 것도 가능하다.)
- readLine()!! 을 통해서 input 으로 받은 데이터를 MutableList 로 변환하는 것도 가능.
- MutableList 를 만들 때 구체적인 사이즈를 선언하는 것도 가능. 사이즈를 선언해놓고 한 개의 값만 넣으면 해당 값으로 사이즈 개수만큼 채워짐. (e.g MutableList(5) {"a"} )
- MutableList 에서도 first(), last() 메소드 존재. 그리고 lastIndex 도 존재한다.

### Work with MutableLists

- joinToString() 메소드를 통해 list 에 있는 요소를 합쳐서 출력할 수 있다. (인수로 String 값을 전달할 수 있고 이를 전달하면 출력할 때 그 문자가 List 요소 사이마다 포함되서 출력된다.)
- MutableList 끼리 '+' 연산자를 통해 join 하는게 가능하다. 이 경우 하나의 MutableList 로 표현됨.
_ MutableList 끼리 '==', '!=' 연산자를 통해 비교하는 것도 가능하다.
- add, addAll() 메소드를 통해서 List 에 값을 추가하는게 가능하다. 
- remove, removeAt(), clear() 메소드를 통해서 List 에 값을 지우는게 가능하다.
- '+=' 연산자를 통해서 리스트에 값을 추가하거나 리스트 끼리 합치는 것도 가능하다.
- index 로 리스트 요소에 접근해서 값을 변경하는 것도 가능하다.
- Kotlin 에서 toMutableList() 메소드를 통해 리스트에 있는 요소들을 복사하는게 가능하다. (이는 참조를 공유하는게 아니다.)
- List 에서 isEmpty(), isNotEmpty() 와 같은 메소드를 제공해서 값이 비었는지, 안 비었는지 알 수 있는 메소드를 제공해준다.
- subList() 를 통해서 List 의 일부를 가져올 수 있다.
- element in List 를 통해서 리스트 안에 해당 요소가 들어있는지 확인할 수 있다. (Java 의 contains() 메소드와 같다.)
- indexOf() 메소드를 통해서 해당 값이 몇 번 인덱스이 있는지 알 수 있다.
- minOrNull(), maxOrNull() 메소드를 통해서 최소값, 최대값을 바로 알 수 있다.
- sum() 메소드를 통해서 모든 요소들을 합치는게 가능하다.
- sorted(), sortedDescending() 메소드를 통해서 리스트를 정렬하는 것도 가능하다.

### For loop and lists

- List 에서 in 을 사용해서 for loop 에서 순회할 수 있다.
- List.indices 를 통해서 index 를 가져와서 for loop 에서 사용하는 것도 가능하다.
- List 의 index 요소와 range 표현식을 통해서 루프를 순회하는 것도 가능하다.

```kotlin
for (day in daysOfWeek){
    println(day)
}

for (index in daysOfWeek.indices){
    println("$index: ${daysOfWeek[index]}")
}
for (index in 1..5) {
    println("$index: ${daysOfWeek[index]}")
}

for (index in 1 until daysOfWeek.lastIndex) {
    println("$index: ${daysOfWeek[index]}")
}

for (index in daysOfWeek.lastIndex downTo 0 step 2) {
    println("$index: ${daysOfWeek[index]}")
}
```

### Processing strings
- String 을 list 로 바꿔야하는 경우와 순회하는 방법에 대한 theory 
- String 에서 split() 메소드를 이용하면 해당 인수로 전달한 문자열을 기준으로 자르고 이를 List 로 반환된다. (이 List 의 경우 해당 요소에 resize 와 reassign 이 안된다. 그러고 싶다면 toMutableList() 메소드를 호출해서 바꿀 수 있도록 변환해주면 된다.)
- String 을 순회하는 방법은 다음과 같다.

```kotlin
for (ch in str) {
    if (Character.isWhitespace(ch))
        count++
}

for (i in 0 until scientistName.length) {
    print("${scientistName[i]} ") // print the current character
}

for (index in rainbow.indices){
    println("${index+1}: ${rainbow[index]}")
}
``` 

