## 기능 구현 설명

### 1. 연산 기능 (Operations)
1. 덧셈 (Addition)
2. 뺄셈 (Subtraction)
3. 곱셈 (Multiplication)
4. 나눗셈 (Division)
5. 삼각 함수 (Sine, Cosine, Tangent)
6. `BasicCalculator`의 연산자 형식: `+`, `-`, `*`, `/`
7. `ScientificCalculator`의 연산자 형식: `+`, `-`, `*`, `/`, `sin`, `cos`, `tan`

### 2. 피연산자 (Operands)
1. 피연산자 형식: `[0-9]+[.]?[0-9]*` (정수 및 소수 가능)
2. 천 단위 구분자(쉼표 `,`)를 포함하지 않음

### 3. 입력 (Inputs)
1. 입력 형식: `피연산자 연산자 피연산자` 또는 `피연산자 연산자`

### 4. 출력 (Outputs)
1. 천 단위 구분자를 포함하지 않고 결과를 출력
2. 결과를 콘솔에 출력

---

## 1. 테스트 케이스 설명

### 1.1 **BasicCalculatorTest** → **ScientificCalculatorTest**
**목적**: 기본적인 사칙연산 및 삼각함수 연산이 정상적으로 동작하는지 검증

#### **테스트 항목**
1. **testAddition**: `2 + 3` 연산을 수행하여 `5.0`이 반환되는지 검증
2. **testSubtraction**: `4 - 3` 연산을 수행하여 `1.0`이 반환되는지 검증
3. **testMultiplication**: `4 * 3` 연산을 수행하여 `12.0`이 반환되는지 검증
4. **testDivision**: `6 / 3` 연산을 수행하여 `2.0`이 반환되는지 검증
5. **testDivisionByZero**: `6 / 0` 연산 시 `ArithmeticException`이 발생하는지 검증
6. **testSine**: `90 sin` 연산을 수행하여 `1.0`이 반환되는지 검증
7. **testCosine**: `90 cos` 연산을 수행하여 `0.0`이 반환되는지 검증
8. **testTangent**: `45 tan` 연산을 수행하여 `1.0`이 반환되는지 검증

---

### 1.2 **Operation Interface & 개별 연산 테스트**
**목적**: 사칙연산 및 삼각함수를 수행하는 개별 클래스들이 정상적으로 동작하는지 검증

#### **테스트 항목**
1. **AdditionTest**: `2 + 3`을 수행하여 `5.0`이 반환되는지 검증
2. **SubtractionTest**: `4 - 3`을 수행하여 `1.0`이 반환되는지 검증
3. **MultiplicationTest**: `4 * 3`을 수행하여 `12.0`이 반환되는지 검증
4. **DivisionTest**: `6 / 3`을 수행하여 `2.0`이 반환되는지 검증
5. **DivisionTest (예외 테스트)**: `6 / 0` 시 `ArithmeticException`이 발생하는지 검증
6. **SineTest**: `90 sin`을 수행하여 `1.0`이 반환되는지 검증
7. **CosineTest**: `90 cos`을 수행하여 `0.0`이 반환되는지 검증
8. **TangentTest**: `45 tan`을 수행하여 `1.0`이 반환되는지 검증

---

### 1.3 **ScientificCalculator 확장**
**목적**: 사칙연산에서 삼각 함수 연산을 확장하여, 향후 적분 및 미적분 기능 추가 시 유연하게 대응할 수 있도록 설계

#### **확장 계획**
1. **BasicCalculator** → **ScientificCalculator** 확장
    - 사칙연산만 가능했던 기존 `BasicCalculator`를 확장하여 `ScientificCalculator` 추가
    - 삼각함수 연산 (sin, cos, tan) 지원
    - 적분, 미적분과 같은 추가 연산을 손쉽게 확장할 수 있는 구조 설계

---

### 1.4 **테스트 전략 및 결론**

#### **TDD 적용 방식**
1. **테스트 코드 작성** → 각 기능에 대한 테스트 케이스를 작성
2. **기능 코드 구현** → 테스트가 통과하도록 기능을 구현
3. **테스트 실행 및 수정** → 모든 테스트가 성공하도록 리팩토링 진행

#### **결론**
- 모든 연산이 정상적으로 동작하는지 검증되었으며,
- 올바르지 않은 입력을 처리할 수 있도록 테스트됨
- 프로그램 종료 조건도 테스트됨
- 콘솔 입출력이 예상대로 작동하는지 확인됨
- `BasicCalculator`에서 `ScientificCalculator`로 확장하여 삼각함수를 추가 개발 하였으며, 차후에 추가 연산(적분, 미적분 등)의 개발 설계 가능함   
