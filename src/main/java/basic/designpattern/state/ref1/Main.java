package basic.designpattern.state.ref1;

public class Main {
    public static void main(){
        Clock myClock = new Clock();
        myClock.normal();
        myClock.alarm();
        myClock.normal();
    }
}
