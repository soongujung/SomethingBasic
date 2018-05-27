package basic.designpattern.factory.sample1;

public class PizzaStoreClient {
    public static void main(String [] args){
        PizzaStore nyStore = new PizzaStore(new NYPizzaFactory());
        nyStore.orderPizza("cheese");

        PizzaStore chicagoStore = new PizzaStore(new ChicagoPizzaFactory());
        chicagoStore.orderPizza("garlic");
    }
}
