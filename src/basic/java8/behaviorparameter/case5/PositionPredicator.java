package basic.java8.behaviorparameter.case5;

import basic.java8.behaviorparameter.Player;

public class PositionPredicator implements PlayerPredicator<Player> {
    @Override
    public boolean check(Player player, String opt) {
        boolean result = false;
        if(player.getPosition().equals(opt)){
            result = true;
        }
        return result;
    }
}
