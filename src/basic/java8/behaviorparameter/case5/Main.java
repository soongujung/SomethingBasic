package basic.java8.behaviorparameter.case5;

import basic.java8.behaviorparameter.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String [] args){
        List<Player> players = Arrays.asList(
                new Player(178, 10, "right","striker", "Rooney"),
                new Player(178, 11, "right","striker", "안정환"),
                new Player(178, 15, "right","midfielder", "Beckam"),
                new Player(178, 14, "right","midfielder", "Scols"),
                new Player(178, 9, "right","midfielder", "박지성"),
                new Player(178, 7, "right","defender", "차두리")
        );

        List<Player> filteredPlayers = filterPlayers(players, new PlayerPredicator<Player>() {
            @Override
            public boolean check(Player obj, String option) {
                boolean result = false;
                if(obj.getPosition().equals(option)){
                    result = true;
                }
                return result;
            }
        }, "midfielder");

        // case 1 : 익명 클래스를 이용해 구현한 방식 (람다로 바꿔쓸수 있다.)
        int cnt = 0;
        System.out.println("======== players 1 ========== ");
        for(Player player : filteredPlayers){
            System.out.println(String.valueOf(++cnt) + ". " + player.getName() + ", position :: " + player.getPosition());
        }

        // case 2 : generic interface를 구현한 클래스를 사용하는 방식
        System.out.println();
        List<Player> filteredPlayers2 = filterPlayers(players, new PositionPredicator(),"midfielder");
        cnt = 0;
        System.out.println("======== players 2 ========== ");
        for(Player player : filteredPlayers2){
            System.out.println(String.valueOf(++cnt) + ". " + player.getName() + ", position :: " + player.getPosition());
        }

    }

    public static <T> List<T> filterPlayers(List<T> players, PlayerPredicator<T> predicator, String option){
        List<T> filteredPlayers = new ArrayList<>();

        for(T player : players){
            if(predicator.check(player, option)){
                filteredPlayers.add(player);
            }
        }
        return filteredPlayers;
    }
}


