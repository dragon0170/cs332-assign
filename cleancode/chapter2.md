# Meaningful Names
소프트웨어 개발을 할 때 이름은 모든 곳에서 쓰인다. 이름을 잘 지으면 개발과 협업에 있어서 단기적, 장기적으로도 모두 큰 도움이 된다.
저자가 경험을 통해 아래와 같은 이름 짓는 규칙을 정리하였다.

## 이름 짓는 규칙
### 의도(Intention)을 드러내는 이름 사용해라
- 변수, 함수, class의 이름은 왜 존재하고, 뭘 하는지, 어떻게 쓰는지에 대한 방법이 드러나야함
### 허위정보(Disinformation)를 피하라
- 이미 널리 알려진 단어(ex. hp, aix, sco)를 다른 의미로 사용하지 마라
- `accountsList` 와 같이 `List` 라는 특수한 의미를 가진 단어를 넣지말고 그냥 `accounts` 와 같이 지어라
- 너무 비슷한 이름을 사용하지 마라
	- `XYZControllerForEfficientHandlingOfStrings`
	- `XYZControllerForEfficientStorageOfStrings`
### 의미있게 구분(Distinction)해라
- 컴파일러, 인터프리터를 통과하기 위한 코드를 짜기 위해 이름을 짓지 마라
	- a1, a2, ... aN
- 쓸데 없이 nosie word를 추가하지 마라
	- moneyAmount, money
	- customerInfo, customer
	- accountData, account
	- theMessage, message
### 발음가능한(Pronounceable) 이름을 사용해라
- `genymdhms` 같은 이상한 이름 말고 `generationTimestamp` 라고 해라
### 검색가능한(Searchable) 이름을 사용해라
- 문자 하나를 사용하는 이름 쓰지마라. 검색이 어렵다.
### 인코딩(Encoding)을 피하라
- 타입을 지원하는 언어를 쓰고 최신 IDE를 쓰면 불필요하게 접두어로 타입, 멤버 변수와 같은 걸 알려줄 필요가 없다.
- interface class, concrete class 가 있을 때 굳이 인코딩이 필요하다면 implementation에 붙여라
### Mental Mapping을 피하라
- 똑똑한 프로그래머와 전문가 프로그래머의 차이 중 하나는 전문가는 ***clarity is king*** 을 안다는 것이다.
### Class, Object 이름은 명사, 명사구를 사용해라
### Method 이름은 동사, 동사구를 사용해라
- constructor가 overload 되면 static factory method를 사용하면 더 명확하다.
	- `Complex.FromRealNumber(23.0)` vs `new Complex(23.0`
### Don't be Cute
- 재미있는 이름이나 농담같은 이름 말고 명확한 이름 사용해라
- Say what you maen. Mean what you say.
### 한 개념(Concept)에 한 단어(Word)를 사용해라
- method에 fetch, retrieve, get을 다양하게 사용하면 혼란스러움
- class에 controller, manager, driver를 다양하게 사용하면 혼란스러움
### 말장난(Pun)을 하지마라
- 한 단어를 두가지 목적으로 사용하지 마라
- 프로그래머는 코드를 최대한 이해하기 쉽게 작성해야한다
### Solution 도메인의 이름을 사용해라. 적절한게 없으면 Problem 도메인 이름을 사용해라
- 코드를 보는 사람은 프로그래머다. CS 관련된 용어 사용해도 좋다. 그래도 적절한게 없으면 Problem 도메인에서 찾아서 사용해라.
### 의미있는 맥락(Meaningful Context)을 추가해라
- 이름 하나만으로는 어떤 의미인지 명확하지 않다. 잘 이름지은 class, function, namespace안에 넣어서 context를 줘라
### 불필요한 맥락(Gratuitous Context)를 없애라
- 일반적으로 짧은 이름이 긴 이름보다 좋다. 불필요한 맥락을 추가하지 마라.

좋은 이름을 고르는 건 좋은 서술하는 능력과 공유된 문화적 배경이 필요하다. 따라서 어렵다.
그리고 좋은 이름을 고르는 건 기술, 비즈니스, 매니징 문제가 아닌 교육의 문제이다. 기술, 비즈니스, 매니징적으로 뛰어다너다로 사람들은 이름을 잘 짓는 방법을 배우지 못했다.
이름을 바꾸는데 있어서 다른 개발자가 반대할까 두려워하지마라. 결국 모두에게 도움이 되는 것이다.
