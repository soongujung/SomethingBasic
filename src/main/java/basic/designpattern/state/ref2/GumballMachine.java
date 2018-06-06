package basic.designpattern.state.ref2;

public class GumballMachine {
    enum TypeTest{
        SOLD_OUT(1), NO_QUARTER(2), HAS_QUARTER(3), SOLD(4);
        private final int num;
        TypeTest(int num){
            this.num = num;
        }
        public int getTypeStatus(){
            return num;
        }
    };
    //    private int state = GumballMachineStatus.SOLD_OUT;
    public static void main(String[] args) {
//        System.out.println(GumballMachineStatus.SOLD_OUT.getClass().getName());
        System.out.println("===== TEST =====");
        System.out.println(GumballMachineStatus.SOLD_OUT);
        System.out.println(GumballMachineStatus.SOLD_OUT.getNumber());
//      java에서 기본자료형의 타입을 출력하려면 아래와 같은 방식으로 캐스팅 해줘야 한다.
//      참고자료
//        https://stackoverflow.com/questions/12361492/how-to-determine-the-primitive-type-of-a-primitive-variable
//        TODO : README.md에 정리해놓을 것
        System.out.println(((Object)GumballMachineStatus.SOLD_OUT.getNumber()).getClass().getName());
        System.out.println("===== TEST =====");
    }

}
