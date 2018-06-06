package basic.designpattern.state.ref2;

//enum 은 static final을 내재하고 있다.
enum GumballMachineStatus {
//    SOLD_OUT(1), NO_QUARTER(2), HAS_QUARTER(3), SOLD;
    SOLD_OUT(1, "A"), NO_QUARTER(2,"B"), HAS_QUARTER(3,"C"), SOLD(4, "D");

    private int number;
    private String strStatus;
    private GumballMachineStatus(int number, String strStatus){
        this.number = number;
        this.strStatus = strStatus;
    }
    public String getStrStatus(){
        return strStatus;
    }
    public int getNumber(){
        return number;
    }
}
