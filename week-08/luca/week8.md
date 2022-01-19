### List
#### 소개
* Kotlin에서 익명함수를 람다 식으로 만들 수 있습니다

`listOf`<br>
* 불변으로 변경할 수 없다.

```kotlin
val cars = listOf<String>("BMW", "Honda", "Mercedes")
cars[0] = "Renault" // Error
```


`mutableListOf`<br>
* 언제든지 변경할 수 있다.

```kotlin
val cars = mutableListOf<String>("BMW", "Honda", "Mercedes")
cars[0] = "Renault"
println(cars) // output: [Renault, Honda, Mercedes]
```

#### 초기화
* 빈 목록을 초기회하는 경우

```kotlin
val staff = emptyList<String>()

val staff = listOf<String>()
```

#### 메서드
* size
* isEmpty()
* indexOf(element)
  * 지정된 요소가 처음 나타나는 인덱스를 반환합니다. 목록에 없으면 함수는 를 반환합니다 -1.
* contains(element)
  * 정된 요소가 목록에 있으면 반환하고 그렇지 않으면 반환 합니다 false.

#### 요소 반복

```kotlin
val participants = listOf("Fred", "Emma", "Isabella")

for (participant in participants) {
  println("Hello $participant!")
}

// Hello Fred!
// Hello Emma!
// Hello Isabella!
```
---------------------------------------------------------------------

### Mutable List
#### List
* 재할당하여 추가를 할 수 있지만 이것은 비효율적인 방법입니다.
* 해당 코드를 디컴파일 하여 분석을 해보면 재할당하는 것을 볼 수 있습니다.
```kotlin
var places = listOf<String>("Paris", "Moscow", "Tokyo") // note var keyword
places += "Saint-Petersburg" // reassignment, slow operation
println(places) // output: [Paris, Moscow, Tokyo, Saint-Petersburg]
```

```kotlin
List places = CollectionsKt.listOf(new String[]{"Paris", "Moscow", "Tokyo"});
      places = CollectionsKt.plus((Collection)places, "Saint-Petersburg");

// CollectionsKt.plus 를 확인 해보면 재할당하는 것을 볼 수 있습니다.
public operator fun <T> Collection<T>.plus(element: T): List<T> {
  val result = ArrayList<T>(size + 1)
  result.addAll(this)
  result.add(element)
  return result
}
```
#### 초기화
```kotlin
val cars = mutableListOf("Ford", "Toyota", "Audi", "Mazda", "Tesla")
println(cars) // output: [Ford, Toyota, Audi, Mazda, Tesla]

val cars = mutableListOf<String>()
println(cars) // output: []
```
* List를 MutableList로 변환도 할 수 있습니다.
```kotlin
val cars = listOf("Ford", "Toyota").toMutableList()
cars.add("Tesla")
println(cars) // output: [Ford, Toyota, Tesla]
```
#### 요소 추가및 제거 메서드
`추가`<br>
* add(element)
* set(index, element) / mutableList[index] = element
* addAll(elements)

`제거`<br>
* removeAt(index)
* remove(element)
  * 지정한 요소의 제일 앞에 요소 하나만 제거
* clear()

---------------------------------------------------------------------
### Map
#### Map collection
* 키를 통해 해당하는 값을 효율적으로 검색가능
* List오 같이 변경 할 수 없는 컬렉션입니다
```kotlin
val students = mapOf(
  "Zhenya" to 5,
  "Vlad" to 4,
  "Nina" to 5
)
println(students) // output: {Zhenya=5, Vlad=4, Nina=5}
```

#### 요소
`pair`<br>
* map과 같이 key-value 형태를 가진 함수입니다.
```kotlin
val (name, grade) = Pair("Zhenya", 5) // easy way to get the first and the second values
println("Student name is: $name And their grade is: $grade")

val p = Pair(2, 3)
println("${p.first} ${p.second}") // 2 3
val (first, second) = p
println("$first $second")         // 2 3

val (name, grade) = "Vlad" to 4
println("Student name is: $name And their grade is: $grade")
// output: Student name is: Vlad And their grade is: 4 
```

#### 초기화
```
val staff = mapOf<String, Int>("John" to 1000)

val staff = mapOf("Mike" to 1500)
```

* 빈 map을 초기화해야 하는 경우
```
val emptyStringToDoubleMap = emptyMap<String, Double>()
```



#### 메서드/속성
* size
* isEmpty()
* containsKey(key)
* containsValue(value)


#### 요소반복
```kotlin
 val employees = mapOf(
  "Mike" to 1500,
  "Jim" to 500,
  "Sara" to 1000
)

for (employee in employees)
  println("${employee.key} ${employee.value}")

for ((k, v) in employees)
  println("$k $v")
```

---------------------------------------------------------------------
### Mutable Map
#### Mutable Map
* Map과 다르게 가변이다.
```
val staff = mutableMapOf(
   "John" to 500,
   "Mike" to 1000,
   "Lara" to 1300
)

staff["Nika"] = 999

println(staff) // output: {John=500, Mike=1000, Lara=1300, Nika=999}
```

#### 초기화

