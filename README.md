# java-racingcar-precourse

## 기능 목록

### 메인 로직
- [x] 입력 받은 문자열로부터 자동차 이름을 추출한다.
- [x] 자동차 도메인의 초기값을 설정한다.
- [x] 각 자동차에 대해 시도마다 랜덤값으로 전진 여부를 판단한다.
- [x] 한 번의 시도마다 자동차 도메인에 결과를 반영하고 출력한다.
- [x] 가장 멀리 이동한 거리를 측정한다.
- [x] 가장 멀리 이동한 우승자 명단을 만든다.

### 입력 및 출력
- [x] 시작 시 안내 메시지를 출력한다. (`경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)`)
- [x] 사용자로부터 문자열을 입력 받는다.
- [x] 시도 횟수 질문 안내 메시지를 출력한다. (`시도할 횟수는 몇 회인가요?`)
- [x] 시도 횟수를 입력 받는다.
- [x] 실행 결과를 출력한다.
- [x] 최종 우승자를 출력한다.

### 예외처리
- [x] 입력된 자동차 이름이 null 혹은 공백일 경우 `IllegalArgumentException`을 발생시킨다.
- [x] 입력된 자동차 이름에 특수문자가 포함될 경우 `IllegalArgumentException`을 발생시킨다.
- [x] 입력된 자동차 이름이 5자를 초과할 경우 `IllegalArgumentException`을 발생시킨다.
- [x] 입력된 시도 횟수가 0 이하일 경우 `IllegalArgumentException`을 발생시킨다.
- [x] 입력된 시도 횟수가 2,147,483,648 이상인 경우 `IllegalArgumentException`을 발생시킨다.

### 추가적인 조건
- [x] 시도 횟수 자료형은 int로 설정한다. 그러므로 시도 횟수 최대 값은 2,147,483,647이다.
- [x] 시도 횟수가 0일 경우 잘못된 입력으로 판단한다.
- [x] 자동차 이름은 null 혹은 공백이 아니다.
- [x] 자동차 이름에 특수문자가 포함될 수 없다.

## 프로젝트 구조

src/
├─ main/
│  └─ java/racingcar/
│     ├─ Application.java
│     ├─ controller/
│     │  └─ RacingcarController.java
│     ├─ service/
│     │  └─ RacingcarService.java
│     ├─ model/
│     │  └─ Car.java
│     ├─ validator/
│     │  └─ InputValidator.java
│     ├─ parser/
│     │  └─ InputParser.java
│     ├─ dto/
│     │  ├─ InputRequest.java
│     │  ├─ RaceResult.java
│     │  ├─ RoundSnapshot.java
│     │  └─ CarSnapshot.java
│     └─ view/
│        ├─ InputView.java
│        └─ OutputView.java
└─ test/
└─ java/racingcar/
├─ ApplicationTest.java
├─ model/CarTest.java
├─ validator/InputValidatorTest.java
├─ parser/InputParserTest.java
└─ service/RacingcarServiceTest.java

## 패키지 별 역할

- controller: 입력 수집 → validate/parse → DTO → service → view 위임
- service: 라운드 시뮬레이션, 스냅샷 생성, 우승자 산출
- model: 도메인 엔티티(Car)
- validator: 입력 형식/제약 검증
- parser: String → List<String>, int 변환
- dto: 레이어 간 불변 전송 모델
- view: 경주 정보 입력 및 결과/우승자 출력

## 다이어그램

```mermaid
sequenceDiagram
    autonumber
    participant App as Application
    participant C as RacingcarController
    participant IV as InputView
    participant OV as OutputView
    participant V as InputValidator
    participant P as InputParser
    participant S as RacingcarService
    participant M as Car
    participant DTO1 as InputRequest
    participant DTO2 as RaceResult
    participant DTO3 as RoundSnapshot/CarSnapshot

    App->>C: run()
    activate C

    %% 1) 입력
    C->>IV: inputCarNames()
    IV-->>C: rawCarNames (String)
    C->>IV: inputTryCount()
    IV-->>C: rawTryCount (String)

    %% 2) 검증
    C->>V: validateCarNames(rawCarNames)
    V-->>C: ok / IllegalArgumentException
    C->>V: validateTryCount(rawTryCount)
    V-->>C: ok / IllegalArgumentException

    %% 3) 파싱
    C->>P: parseCarNames(rawCarNames)
    P-->>C: carNames (List<String>)
    C->>P: parseTryCount(rawTryCount)
    P-->>C: tryCount (int)

    %% 4) DTO 구성 및 서비스 호출
    C->>DTO1: new InputRequest(carNames, tryCount)
    C->>S: getRaceResult(InputRequest)
    activate S

    note over S: createCar(names)<br/>→ List<Car> 생성

    %% 5) 라운드 반복
    loop tryCount 회
        S->>S: startRace(carList)
        note over S: 각 Car에 대해<br/>Randoms.pickNumberInRange(0,9) ≥ 4 이면 go()
        S->>DTO3: new CarSnapshot(name, distance) × n
        S->>DTO3: new RoundSnapshot(round, carSnapshots)
    end

    %% 6) 우승자 계산
    S->>S: getLongestDistance(carList)
    S->>S: findWinner(carList, longestDistance)
    S-->>DTO2: new RaceResult(roundSnapshots, winnerList)
    deactivate S

    %% 7) 출력
    C-->>C: RaceResult 수신
    C->>OV: printRaceResult(carNames, tryCount, RaceResult)
    activate OV
    note over OV: "실행 결과" 출력<br/>라운드별로<br/>name : "-".repeat(distance)
    OV-->>C: 최종 우승자 출력 "최종 우승자 : a, b"
    deactivate OV

    C-->>App: 완료
    deactivate C
```
