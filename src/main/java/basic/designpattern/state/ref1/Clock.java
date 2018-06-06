package basic.designpattern.state.ref1;


public class Clock {
    private IState state;
    public Clock(){

    }

    public void setState(IState state) {
        this.state = state;
    }

    public void normal (){
        state.normal(this);
    }
    public void alarm(){
        state.alarm(this);
    }
}
