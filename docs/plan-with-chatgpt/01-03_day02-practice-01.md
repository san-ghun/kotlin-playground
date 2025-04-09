Q: 2번으로 할게! 내가 작성한 메인 코드와 테스크 코드야. 예외처리를 테스트하고 싶었는데 완성하지 못했어.
   - `Main.kt`, `SampleTest.kt` 첨부함.

---

코드 엄청 잘 짰다! 구조도 OOP스럽고, 설계 감각도 좋아.  
이제 테스트 쪽에서 **예외 처리 검증하는 부분**만 조금 손봐주면 완벽해질 거야!

---

## ✅ 지금 테스트 코드의 문제점

이 부분들:

```kotlin
@Test
fun testDivisionByZero() {
    val expected = ArithmeticException("// by zero")
    assertEquals(expected, testCalculator.calculate(40, '/', 0))
}
```

이렇게 하면 `calculate(40, '/', 0)` 호출 시 예외가 발생하고, 테스트는 **예외 때문에 실패**해버려.

---

## 🎯 목표: 예외가 발생하는지 "확인"하는 테스트

JUnit5에서는 `assertThrows()`를 사용해야 해.  
Kotlin에서 자주 쓰는 방식은 다음과 같아:

```kotlin
@Test
fun testDivisionByZero() {
    assertThrows<ArithmeticException> {
        testCalculator.calculate(40, '/', 0)
    }
}

@Test
fun testUnsupportedOp() {
    val op = '.'
    val exception = assertThrows<IllegalArgumentException> {
        testCalculator.calculate(40, op, 2)
    }
    assertEquals("Unsupported operator: $op", exception.message)
}
```

---

## 🔍 요약

| 예외 상황         | 검증 방법                                |
|------------------|----------------------------------------|
| 예외가 발생해야 함 | `assertThrows<ExceptionType> { ... }` 사용 |
| 예외 메시지 확인  | `val e = assertThrows { ... }; assertEquals(...)` |

---

## ✨ 보너스 팁

- `assertThrows`는 JUnit 5에서 제공돼.  
  (`import org.junit.jupiter.api.assertThrows` 필요할 수도 있음)
- 메시지 검증은 디버깅에도 유용해서 우테코에서도 자주 다뤄.

---

수정한 테스트 코드 실행해보고 잘 되는지 확인해봐!  
필요하면 내가 함께 디버깅 도와줄게 😎

완료되면 알려줘 — 다음 단계로 넘어가자 💪

