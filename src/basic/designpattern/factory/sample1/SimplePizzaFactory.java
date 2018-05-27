package basic.designpattern.factory.sample1;

public class SimplePizzaFactory {
    public Pizza createPizza(String type){
        Pizza pizza = null;
        if("cheese".equals(type)){
            pizza = new CheesePizza();
        }
        else if("garlic".equals(type)){
            pizza = new GarlicPizza();
        }

        return pizza;
    }
}
