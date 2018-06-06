package basic.designpattern.factory.sample2;

import java.util.ArrayList;

public class Pizza {
    String name;
    String dough;
    String sauce;
    ArrayList<String> toppings = new ArrayList<>();

    public void prepare(){
        System.out.println(" preparing... ");
    }

    public void bake(){
        System.out.println(" Baking... ");
    }

    public void cut(){
        System.out.println(" cutting... ");
    }

    public void box(){
        System.out.println(" boxing... ");
    }

    public String getName(){
        return this.name;
    }
}
