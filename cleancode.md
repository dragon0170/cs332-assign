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

# Functions
함수는 모든 프로그램 구성의 가장 기본적인 단위이다. 이 챕터의 주제는 함수를 잘 쓰는 방법에 대한 것이다.
## 작게 만들어라
- 저자가 몇십년간 함수를 구현해보면서 느낀 제 1의 철칙은 바로 함수를 작게 만들라는 것이다.
- if, else, while 문에 들어가는 블록은 함수를 호출하는 한 줄로 구성해라
	- 중첩 구조가 생기게 함수가 커져서는 안된다는 의미
## 한가지만 해라
- ***FUNCTIONS SHOULD DO ONE THING. THEY SHOULD DO IT WELL. THEY SHOULD DO IT ONLY.***
- 함수가 추상화 수준이 하나인 스텝들만 처리한다면 그 함수는 한 가지 작업만 하는 것이다.
- 함수에서 의미 있는 다른 이름으로 또다른 함수를 뽑아낼 수 있으면 그 함수는 여러 가지 작업을 하는 것이다.
## 함수당 추상화 수준은 1개로
- 함수 내 모든 statements가 동일한 추상화 수준을 갖도록 해야한다.
- 코드가 위에서 아래로 이야기처럼 읽혀야 한다.(top-down narrative)
	- 함수가 다음 함수를 소개하는 형태
- switch 문은 웬만하면 쓰지 마라
	- polymorphic objects 때문에 어쩔 수 없이 써야한다면 polymorphic object를 생성하는 코드 안에서 딱 한번만 써라. 나머지 시스템에 노출시키지 마라.
## 서술적인 이름을 써라
- 길고 서술적인 이름이 짧고 정체를 알수없는 이름보다 낫다.
- 길고 서술적인 이름이 길고 서술적인 주석보다 낫다.
- 서술적인 이름을 쓰면 머릿속의 모듈의 디자인을 명확하게 해주고 모듈을 발전시키는 데 도움이 된다.
## Function Arguments
- arguments는 어렵고 많은 conceptual power를 필요로 한다.
- arguments가 많아지면 테스팅 관점에서도 복잡하고 어렵게 만든다.
- 가장 좋은 형태의 함수는 arguments가 없는 함수이다.
- 그 다음으로는 좋은 형태의 함수는 1개의 arugment가 있는 단항 함수다.
	- argument에 대해 물어보는 경우
		- `boolean fileExists(“MyFile”)`
	- argument에 대해 처리해서 다른 형태로 바꿔서 반환하는 경우
		- `InputStream fileOpen(“MyFile”)`
- output argument를 사용하지 마라. 헷갈린다.
	- 일반적으로 argument는 input으로 인식한다.
- Flag arugments는 흉하다.
	- 함수를 2개로 쪼개서 각각 구현해라
- 이항 함수는 단항 함수보다 이해하기 어렵다.
	- 어쩔 수 없이 써야하는 경우도 있지만 단항 함수로 바꿀 방법이 있으면 바꿔라.
		- `writeField(output-Stream, name)` -> `outputStream. writeField(name)`
- 삼항 함수는 이항 함수보다 더 이해하기 어렵다.
	- 이런 경우가 되면 보통 arguments 를 별도의 class로 wrapping 해야하는 경우가 많다.
- 동사와 키워드를 잘 사용해서 함수 이름을 서술해라.
## Side Effects 를 만들지 마라
- temporal coupling이 있으면 함수 이름에 명확하게 명시해라.
## Do something or Answer something
- 함수는 뭘 하거나 뭔가에 답하거나 둘 중 하나만 해라. 둘 다 하면 헷갈리게 한다.
## 에러 코드를 return 하기보다 Exception 을 사용해라
- exception을 사용하면 에러 처리 코드가 원래 코드에서 분리되서 간단해진다.
- try/catch block의 각 block을 별도 함수로 분리해라. 코드를 이해하고 수정하기 더 쉽다.
- 함수는 하나의 작업을 해야하고 오류 처리도 하나의 작업이다.
- 에러 코드 대신 exception을 사용하면 새로운 에러를 추가하기 간단해진다.
## 반복하지 마라
- 똑같은 코드를 반복하게되면 알고리즘이 바뀌면 수정할 곳이 여러 곳이 되고 오류가 발생활 확률도 그만큼 늘어난다.
- 중복은 소프트웨어에서 모든 악의 근원이다.
## 구조적(Structured) 프로그래밍
- 구조적 프로그래밍은 함수가 클 때 도움이 많이 된다.
- 함수를 작게 만들면 return, break, continue를 여러번 사용해도 괜찮다. goto는 쓰지마라.
## 함수 작성 방법
한번에 함수를 작고 깔끔하게 작성할 수는 없다.
1. 일단 처음 작성할 때는 길고 복잡하게 써라. nesting도 많고 argument list도 길고 이름도 이상하고 중복된 코드도 많을 것이다. 그리고 이 코드를 검증할 unit test 도 짜라.
2. 코드를 다듬고, 함수를 쪼개고, 이름을 바꾸고, 중복을 제거하고, 재배치하고, class를 쪼개가면서 수정해라. 단, 테스트 코드를 통과하도록 해라.
## 결론
- The art of programming is, and has always been, the art of language design.
- 마스터 프로그래머는 시스템을 작성할 프로그램이 아니라 들려줄 이야기라고 생각한다.
	- 프로그래밍 언어라는 수단을 가지고 이야기를 풀어갈 풍부하고 표현력이 좋은 언어를 만든다.
	- 함수가 명확하고 정확한 언어로 딱 맞아떨어져야 스토리텔링에 도움이 된다.
