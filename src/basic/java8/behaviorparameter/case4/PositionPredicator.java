package basic.java8.behaviorparameter.case4;

public class PositionPredicator implements PlayerPredicator{
    @Override
    public boolean check(Player player, String option){
        boolean result = false;
        if(option.equals(player.getPosition())){
            result = true;
        }
        return result;
    }
}
