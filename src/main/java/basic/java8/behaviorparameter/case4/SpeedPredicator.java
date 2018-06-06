package basic.java8.behaviorparameter.case4;

public class SpeedPredicator implements PlayerPredicator{
    @Override
    public boolean check(Player player, String option) {
        boolean result = false;
        if(player.getSpeed() <= Integer.parseInt(option)){
            result = true;
        }
        return result;
    }
}
