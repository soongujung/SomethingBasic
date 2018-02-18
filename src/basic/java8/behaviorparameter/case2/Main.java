package basic.java8.behaviorparameter.case2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    // Case 2 :
    // Case 1 대한 추가 요구사항
    // 추가적으로 축구선수들의 speed에 따라 걸러진 리스트를 알고 싶어졌다.
    // 이에 filterPlayersBySpeed(List<Player>, int speed)메서드를 추가하게 되었다.

    public static void main(String [] args){
        List<Player> players = Arrays.asList(
                new Player(178, 10, "right","striker", "Rooney"),
                new Player(178, 11, "right","striker", "안정환"),
                new Player(178, 15, "right","midfielder", "Beckam"),
                new Player(178, 14, "right","midfielder", "Scols"),
                new Player(178, 9, "right","midfielder", "박지성"),
                new Player(178, 7, "right","defender", "차두리")
        );

        List<Player> filteredPlayer = filterPlayersBySpeed(players, 11);


        int cnt = 0;
        for(Player player : filteredPlayer){
            System.out.println(String.valueOf(++cnt) + ". " + player.getName() + ", position :: " + player.getPosition());
        }

        cnt = 0;
    }

    public static List<Player> filterPlayersByPosition(List<Player> players, String position){
        List<Player> result = new ArrayList<>(); // Explicit type argument Player can be replaced with <>
        for(Player player : players){
            if(player.getPosition().equals(position)){
                result.add(player);
            }
        }
        return result;
    }

    // 입력된 speed 이하로 주파하는 선수를 뽑아내기
    public static List<Player> filterPlayersBySpeed(List<Player> players, int speed){
        List<Player> result = new ArrayList<Player>();
        for(Player player : players){
            if(player.getSpeed() <= speed){
                result.add(player);
            }
        }
        return result;
    }
}


