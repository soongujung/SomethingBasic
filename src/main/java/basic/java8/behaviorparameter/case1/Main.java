package basic.java8.behaviorparameter.case1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    // Case 1 :
    // 선수들에 대한 요구사항
    // 선수들을 공격수 포지션에 대한 리스트를 얻고 싶어졌다. 단순 로직을 작성해 해결했다.

    public static void main(String [] args){
        List<Player> players = Arrays.asList(
                new Player(178, 10, "right","striker", "Rooney"),
                new Player(178, 11, "right","striker", "안정환"),
                new Player(178, 15, "right","midfielder", "Beckam"),
                new Player(178, 14, "right","midfielder", "Scols"),
                new Player(178, 9, "right","midfielder", "박지성"),
                new Player(178, 7, "right","defender", "차두리")
        );

        List<Player> filteredPlayer = filterPlayersByPosition(players, "striker");


        int cnt = 0;
        for(Player player : filteredPlayer){
            System.out.println(String.valueOf(++cnt) + ". " + player.getName() + ", position :: " + player.getPosition());
        }
        cnt = 0;

    }

    public static List<Player> filterPlayersByPosition(List<Player> players, String position){
        List<Player> result = new ArrayList<Player>();
        for(Player player : players){
            if(player.getPosition().equals(position)){
                result.add(player);
            }
        }
        return result;
    }
}


