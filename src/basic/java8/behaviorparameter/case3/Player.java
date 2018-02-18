package basic.java8.behaviorparameter.case3;

public class Player {
    private int         height = 0;         // 신장
    private int         speed = 0;          // 달리기 속도 (100m 달리기 속도)
    private String      primaryFoot = "";   // 주로 쓰는 발
    private String      position = "";      // 포지션
    private String      name = "";

    public Player(int height, int speed, String primaryFoot, String position, String name){
        this.height = height;
        this.speed = speed;
        this.primaryFoot = primaryFoot;
        this.position = position;
        this.name = name;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String getPrimaryFoot() {
        return primaryFoot;
    }

    public void setPrimaryFoot(String primaryFoot) {
        this.primaryFoot = primaryFoot;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
