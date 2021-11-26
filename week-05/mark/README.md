### Unicode



1) Char관련 유용한 함수

- isDIgit() , isLetter, isLetterOrDigit(), isUpperCase, isLowerCase, uppercaseChar(), uppercase(), lowercaseChar(), lowercase()

2. String관련 유용한 함수

- substringBeforeLast(), substringBefore(), substringAfterLast(), substringAfter()

---

### When

- parameter 없이도 사용가능하다.
- 가독성을 향상시킨다.

---

### Range 

range관련 유용한 키워드

- step, until, downTo

---

### Function

- 코틀린 함수에서 기본인수를 추가하는 것은 좋은 습관이다.
- 함수사용시 파라미터이름을 명시함으로서 순서를 바꿀수 있고, 가독성을 높일수 있다.

```kotlin
val amount = calcEndDayAmount(
    ticketPrice = 10,
    soldTickets = 500,
    startAmount = 1000
)  // 6000
```

---

### Constructor

- kotlin에서는 constructor 키워드 생략 가능

```kotlin
class Size constructor(width: Int, height: Int) {
    val width: Int = width    // 이것도 생략가능
    val height: Int = height  // 이것도 생략가능
    val area: Int = width * height
}
```

- 생성자 내부에 `init` 키워드로 다른 파라미터를 기반으로 하는 속성을 설정할수 있다. 
  `init` 키워드는 한 생성자 내에 여러번 사용이 가능하다.

- 부 생성자는 반드시 주생성자에게 직.간접적으로 생성을 위임해야 한다.

  ```kotlin
  class D(val name: String) {
  
      var age: Int = 20
      var height: Int = 500
  
  //    컴파일 에러!
  //    constructor(name: String, age: Int) {
  //        this.age = age
  //    }
  
      constructor(name: String, age: Int) : this(name) {
          this.age = age
      }
  
  }
  ```

  
