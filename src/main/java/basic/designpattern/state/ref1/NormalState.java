package basic.designpattern.state.ref1;

public class NormalState implements IState{
    private Clock clock = null;
    NormalState(){
        System.out.println("Normal State 클래스 생성자 ");
    }


    @Override
    public void normal(Clock clock) {
        System.out.println( "normal 메소드");
    }

    @Override
    public void alarm(Clock clock) {
        System.out.println("clock 메소드 ");

    }
}
