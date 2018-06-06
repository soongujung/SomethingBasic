package basic.designpattern.state.ref1;

public class AlarmState implements IState{
    private int min = 0;
    private final int ALARM_TIME = 5;

    public AlarmState(){
        System.out.println("AlarmState 클래스 ");
        min = 0;
    }

    @Override
    public void normal(Clock clock) {
        while(min <= ALARM_TIME) {
            System.out.println("count of alarm : "  + min );
            min++;
        }
        clock.setState(new NormalState());
    }

    @Override
    public void alarm(Clock clock) {

    }

}
