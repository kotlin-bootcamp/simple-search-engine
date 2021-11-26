# 4주차 

### Characters 

- 문자는 유니코드 테이블 에서 16진수 코드로 나타낼 수도 있다 . 코드는 \u 다음으로 시작합니다 
- 이러한 코드를 나타내기 위해 일련의 문자를 사용하지만 코드 자체는 정확히 하나의 문자를 나타냅니다.
```kotlin
val ch = '\u0040' // it represents '@'
println(ch) // @
```

- 숫자를 문자로 또는 그 반대로 변환할 수도 있다.
```kotlin
al ch = 'a'
println(ch.toInt())   // 97
val num = 97
println(num.toChar()) // a
```

- How to read characters
```kotlin
val ch: Char = readLine()!!.first()
```

- 더하기 ( ) 및 빼기( -)를 위한 두 가지 연산자를 통해 다음 및 이전 문자를 가져올 수 있다.


- ### Working with strings

- 코틀린 동등성 연산 자바랑 다르다.

