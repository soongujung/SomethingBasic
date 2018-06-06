package basic.designpattern.factory.sample2;

public abstract class PizzaStore {
    public Pizza orderPizza(String type){
        Pizza pizza;

        pizza = createPizza(type);

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }

    public abstract Pizza createPizza(String type);
    // 실제 피자를 만들어내는 것은 abstract로 만들어서, NYPizzaStore, ChicagoPizzaStore 등이 생겨나더라도
    // 실제 세부적인 구현을 가려서 복잡함을 덜어내기 위해 abstract로 정의한것.
    // 실제로 클라이언트 프로그래머가 그 안의 세부 구현내용(구현클래스)을 보고 동작을 파악하는 것이 아닌
    // 새로운 인터페이스의 반환형만 파악하면 구현의 복잡함을 덜수 있기 때문이다.
}
