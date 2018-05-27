# 팩토리 메소드 패턴
피자를 만드는 활동 자체는 전부 PizzaStore클래스에 국한시키면서 분점마다 고유의 스타일을 살리는 방법
- 실제 피자를 만들어내는 것은 abstract로 만들어서, NYPizzaStore, ChicagoPizzaStore 등이 생겨나더라도
- 실제 세부적인 구현을 가려서 복잡함을 덜어내기 위해 abstract로 정의한것.
- 실제로 클라이언트 프로그래머가 그 안의 세부 구현내용(구현클래스)을 보고 동작을 파악하는 것이 아닌
- 새로운 인터페이스의 반환형만 파악하면 구현의 복잡함을 덜수 있기 때문이다.  

## 디자인 원칙 
  추상화 된 것에 의존하도록 만들어라. 구상 클래스에 의존하도록 만들지 않도록 해야 한다.
  팩토리 메소드 패턴을 구현함으로써 구상 클래스에 대한 의존성을 줄일수 있게 되었다.
  이와 같은 개념을 의존성 뒤집기 원칙(Dependency Inversion Principle)이다. 
  
## 의존성 뒤집기 설명
의존성을 뒤집게 된 과정을 설명해보면
출처: http://jusungpark.tistory.com/14?category=630296 [정리정리정리]  
왜 의존성 뒤집기 원칙이냐면...  
- PizzaStore -> NYStyleCheesePizza
- PizzaStore -> ChicagoStypeCheesePizza
- PizzaStore -> NYStyleVeggiePizza
  
이런식으로 의존이 되던 좋지않은 디자인이
- PizzaStore -> Pizza
- Pizza <- NYStyleCheesePizza
- Pizza <- ChicagoStyleCheesePizza
- Pizza <- NYStyleVeggiePizza

이런식으로 의존관계게 뒤집어지는 형상.
자세한 내용은 http://jusungpark.tistory.com/14?category=630296 을 참고하자.
  
## PizzaStore
PizzaStore 클래스에서는 createPizza() 클래스를 abstract 메소드로 만들었다. 그 이유는 아래와 같다.  
 - createPizza() 메소드는 PizzaStore를 상속하는 클래스가 반드시 구현하도록 하여 그 내용을 다르게 하기 위한 것.
 - 이렇게 함으로서 실제 코드를 유지보수하는 다른 프로그래머는 실제 객체가 생성되는 과정에 관여하기보다는 NYStyleCheesePizza클래스, NYStyleGarlicPizza클래스 내부의 소스만 수정하면 된다. 
 
## Pizza  






