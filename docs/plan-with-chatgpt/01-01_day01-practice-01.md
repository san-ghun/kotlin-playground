submission:

```kotlin
fun calculate(a: Int, op: Char, b: Int): Int {
    val result = when (op) {
        '+' -> a + b
        '-' -> a - b
        '*' -> a * b
        '/' -> a / b
        else -> 0
    }
    return result
}

fun main() {
	println(calculate(1, '/', 2))
}

```

---

좋아! 아주 깔끔하고 잘 작성했어 🙌  
기본적인 Kotlin 문법도 정확하게 쓰고 있고, `when`도 잘 활용했네.

---

## 🔍 피드백 (코치 모드 ON 🧢)

### ✅ 잘한 점
- `when` 표현식으로 분기 처리 👍  
- 함수 시그니처 (`a: Int, op: Char, b: Int`) 명확함  
- 간결한 구조로 의도 파악이 쉬움

### ⚠️ 개선 포인트
1. **예외 처리 부족**  
   - 현재는 `/` 연산 시 `b`가 0이어도 그냥 나누기를 시도함 → 예외 발생 (`ArithmeticException`)
   - `else -> 0` 처리는 다소 모호. 정의되지 않은 연산자를 넣으면 0을 반환? → **명확한 예외 발생이 더 적절**

2. **의도를 더 분명히 드러내는 코드로 개선 가능**  
   - 예외는 명시적으로 처리해주는 게 좋음
   - 실패 상황은 `throw IllegalArgumentException()` 같은 예외로 알려주자

---

## ✨ 리팩터링 버전

```kotlin
fun calculate(a: Int, op: Char, b: Int): Int {
    return when (op) {
        '+' -> a + b
        '-' -> a - b
        '*' -> a * b
        '/' -> {
            if (b == 0) throw IllegalArgumentException("0으로 나눌 수 없습니다.")
            a / b
        }
        else -> throw IllegalArgumentException("지원하지 않는 연산자입니다: $op")
    }
}

fun main() {
    println(calculate(10, '+', 5)) // 15
    println(calculate(10, '/', 0)) // 예외 발생
}
```

---

## 🧠 코치 팁
- 우테코에서는 **의도를 드러내는 코드**를 중요하게 생각해.  
  → 예외 상황을 무시하지 말고, 코드로 정확히 설명하자.
- 이런 기본기들이 **테스트 가능한 구조**와 **읽기 쉬운 코드**로 발전돼.

---

### 📌 다음 액션 (선택)
- 위 코드에 대해 테스트 코드 작성해볼래? (JUnit5 사용)
- 또는, 동일한 문제를 **객체지향적으로 분리해서** 다시 풀어보는 것도 가능해!

원하는 방향 알려줘! 난 계속 코치 모드로 대기 중이야 😎💬

