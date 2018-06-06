package basic.designpattern.factory.sample1;

public class PizzaStore {

    private SimplePizzaFactory simplePizzaFactory;

    public PizzaStore(SimplePizzaFactory simplePizzaFactory){
        this.simplePizzaFactory = simplePizzaFactory;
    }

    public Pizza orderPizza(String type){
        Pizza pizza = null;

        // Sample 2 에서 변화해야 하는 부분
//        if("cheese".equals(type)){
//            pizza = new CheesePizza();
//        }
//        else if("garlic".equals(type)){
//            pizza = new GarlicPizza();
//        }

        pizza = simplePizzaFactory.createPizza(type);

        return pizza;
    }
}
