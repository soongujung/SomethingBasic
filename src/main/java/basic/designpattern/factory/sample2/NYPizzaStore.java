package basic.designpattern.factory.sample2;

public class NYPizzaStore extends PizzaStore{
    @Override
    public Pizza createPizza(String type) {
        Pizza pizza = null;

        if("garlic".equals(type)){
            pizza = new NYStyleGarlicPizza();
        }
        else if("cheese".equals(type)){
            pizza = new NYStyleCheesePizza();
        }

        return pizza;
    }
}
