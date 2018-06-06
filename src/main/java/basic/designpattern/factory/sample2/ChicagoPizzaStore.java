package basic.designpattern.factory.sample2;

public class ChicagoPizzaStore extends PizzaStore{
    @Override
    public Pizza createPizza(String type) {
        Pizza pizza = null;
        if("cheese".equals(type)) {
            pizza = new ChicagoStyleCheesePizza();
        }
        else if("garlic".equals(type)){
            pizza = new ChicagoStyleGarlicPizza();
        }
        return pizza;
    }
}
