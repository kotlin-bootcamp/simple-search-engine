### Functions without names
#### Lambda expressions
* Kotlin에서 익명함수를 람다 식으로 만들 수 있습니다

```kotlin
fun(arguments): ReturnType { body }
    
// 람다식
{ arguments -> body }
```

* 중괄호로 감싼다. { .. }
* 인자와 본문은 ->로 구분한다.
* 인자는 ()로 감싸지 않는다.
```kotlin
val mul1 = fun(a: Int, b: Int): Int {
  return a * b
}

val mul2 = { a: Int, b: Int -> a * b }
```
* 인자는 형식추론이 가능하므로 타입을 생략할 수 있다.
```kotlin
val originalText = "I don't know... what to say..."
val textWithoutDots = originalText.filter({ c: Char -> c != '.' })

originalText.filter({ c -> c != '.' })
```
* 변수에 람다식을 담는경우에는 인자의 타입을 생략할 수 없다.
* 함수의 맨 마지막 인자가 람다라면 () 안에서 빼내서 밖에 람다를 표현할 수 있다.
* 인자가 하나라면 그 인자는 람다식 내부에서 **it**으로 받을 수 있다.
* 인자가 하나이면서 그 인자가 람다타입 이라면 ()를 생략할 수 있다.
람다의 코드가 한 줄에 들어갈 만큼 짧지 않으므로 코드를 여러 줄로 작성해야하는 경우 람다 **내부의 마지막 줄은 람다 반환 값**으로 처리
```kotlin
val textWithoutSmallDigits = originalText.filter {
    val isNotDigit = !it.isDigit()
    val stringRepresentation = it.toString()

    isNotDigit || stringRepresentation.toInt() >= 5
}
```

* label을 이용한 return 처리

```kotlin
val textWithoutSmallDigits = originalText.filter {
    if (!it.isDigit()) {
        return@filter true
    }

    it.toString().toInt() >= 5
}
```
* 람다 캡쳐링(Capturing variables)
  * 람다 본문 블럭 내에서 외부 함수의 로컬 변수나 글로벌 변수등을 사용할 수 있는데, 이것을 lamda capturing(포획)이라고 한다.
  * 자바와 달리 코틀린 람다 안에서는 final 변수가 아닌 본래의 변수에 접근이 가능하며, 변경도 가능하다.
    * 왜 자바에서는 안되는데 코틀린에서는 가능할까?
    * 자바에서 지역 변수(final일때만) 접근 가능한 이유는 = >
      https://jinn-blog.tistory.com/29
    * https://lovia98.github.io/blog/kotlin-lamda.html / https://velog.io/@dhwlddjgmanf/%EC%9E%90%EB%B0%94%EC%97%90%EC%84%A0-%EC%95%88-%EB%90%98%EB%8A%94%EB%8D%B0-%EC%BD%94%ED%8B%80%EB%A6%B0%EC%9D%98-%EB%9E%8C%EB%8B%A4%EC%97%90%EC%84%9C-final%EC%9D%B4-%EC%95%84%EB%8B%8C-%EC%99%B8%EB%B6%80-%EB%B3%80%EC%88%98%EB%A5%BC-%EB%B3%80%EA%B2%BD%ED%95%A0-%EC%88%98-%EC%9E%88%EB%8A%94-%EC%9D%B4%EC%9C%A0%EB%8A%94

### String Array

* 초기화
```kotlin
val stringArray = arrayOf("array", "of", "strings")

val stringArray = arrayOf<String>("array", "of", "strings")

// 빈 배열을 초기화
val newEmptyArray = emptyArray<String>()
```

* val 이지만 배열의 재할당이 아니라 배열에 요소는 변경가능하다.
  * 안되는 케이스 있다. 
```kotlin
val stringArray = arrayOf("sagacity", "and", "bravery")
print(stringArray[2])   // bravery

// val 이지만 배열의 요수 수정가능
stringArray[0] = "smart"
print(stringArray[0])   // smart

// 안되는 방식도 존재
val southernCross = arrayOf("Acrux", "Gacrux", "Imai", "Mimosa")
southernCross += "Ginan" // will not compile
```
* joinToString()을 이용하면 순서대로 쉼표로 구분하여 출력해준다.
* 배열을 쉽게 추가 할 수 있다.
```kotlin
val southernCross = arrayOf("Acrux", "Gacrux", "Imai", "Mimosa")
val stars = arrayOf("Ginan", "Mu Crucis")

val newArray = southernCross + stars
println(newArray.joinToString())    //  Acrux, Gacrux, Imai, Mimosa, Ginan, Mu Crucis
```

* 배여열은 == , !=로 비교하지 않고 contentEquals()를 사용한다.


### Reading files
#### 텍스트 읽기
* 파일이 없는 경우도 처리해줘야합니다. **NoSuchFileException** 
* 기본적으로 readText()는 UTF-8 인코딩
* 인코딩을 변경 할 수 있지만 Kotlin은 2GB보다 큰 파일에 이 기능을 사용하는 것을 권장하지 않음
```kotlin
val fileName = "src/reading.txt"
val file = File(fileName)
if (file.exists()) { // checks if file exists
  val lines = file.readText()
  print(lines)
} else print("No such file")
```

```kotlin
val line = File(fileName).readText(Charsets.US_ASCII)
```

* readLines
  * 각 줄에 대한 파일을 읽음
```kotlin
val fileName = "src/reading.txt"
val lines = File(fileName).readLines()
for (line in lines){
  println(line)
} 
```


* readBytes
  * 파일 내용을 바이트 배열로 저장해야 하는 경우
```kotlin
val lines = File(fileName).readBytes()
```


* forEachLine
  * 대용량 파일을 읽을 때 권장되는 방법
```kotlin
val fileName = "src/reading.txt"
File(fileName).forEachLine { println(it) }
```
