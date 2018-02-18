package basic.designpattern.state.ref1;

//import java.time.Clock;

public interface IState {
    public void normal (Clock clock);
    public void alarm (Clock clock);
}
