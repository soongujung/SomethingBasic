package basic.java8.behaviorparameter.case4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    // Case 4 :
    // Case 3 대한 추가 요구사항
    // 1) if문에 flag로 지정해 동작하던 부분을 strategy pattern을 적용하기로 했다.
    //      **동작 파라미터화 :
    //          메서드가 다양한 동작(또는 전략)을 받아서 내부적으로 다양한 동작을 수행하는 것

    // 2) Predicate 방식 도입
    //      test에 대한 공통 속성을 찾았다. 사과의 어떤 속성에 기초해서 불린값을 반환하는 동작이 존재한다.
    //      예를 들면 사과가 녹색인가? 150그램 이상인가? 하는 기준에 근거해서 true, false를 return하는 방식.
    //      이와 같은 동작을 프레디케이트(Predicate)라고 한다.

    // Case 5에서는 players라는 List를 Singleton으로 분리해내는 작업을 수행할 것이다.
    // Case 6에서는 동작파라미터화 코드에 람다식을 적용한다.

    public static void main(String [] args){
        // 이 부분은 추후 코드를 수정해나가면서 싱글턴으로 생성해낼 예정이다. 지금은 우선 동작 파라미터화 코드에만 집중하자.
        List<Player> players = Arrays.asList(
                new Player(178, 10, "right","striker", "Rooney"),
                new Player(178, 11, "right","striker", "안정환"),
                new Player(178, 15, "right","midfielder", "Beckam"),
                new Player(178, 14, "right","midfielder", "Scols"),
                new Player(178, 9, "right","midfielder", "박지성"),
                new Player(178, 7, "right","defender", "차두리")
        );

        // 1) position으로 분류
        List<Player> midfielders = filterPlayers(players, new PositionPredicator(), "midfielder");
        // 2) speed 로 분류
        List<Player> speeders = filterPlayers(players, new SpeedPredicator(), String.valueOf(11));

        int cnt = 0;
        // players1 출력
        System.out.println("======== players 1 ========== ");
        for(Player player : midfielders){
            System.out.println(String.valueOf(++cnt) + ". " + player.getName() + ", position :: " + player.getPosition());
        }
        System.out.println();

        cnt = 0;
        System.out.println("======== players 2 ========== ");
        for(Player player : speeders){
            System.out.println(String.valueOf(++cnt) + ". " + player.getName() + ", speed :: " + player.getSpeed());
        }
    }

    // case 1
    public static List<Player> filterPlayersByPosition(List<Player> players, String position){
        List<Player> result = new ArrayList<>(); // Explicit type argument Player can be replaced with <>
        for(Player player : players){
            if(player.getPosition().equals(position)){
                result.add(player);
            }
        }
        return result;
    }

    // case 2
    // 입력된 speed 이하로 주파하는 선수를 뽑아내기
    public static List<Player> filterPlayersBySpeed(List<Player> players, int speed){
        List<Player> result = new ArrayList<>();
        for(Player player : players){
            if(player.getSpeed() <= speed){
                result.add(player);
            }
        }
        return result;
    }

    // case 3
    public static List<Player> filterPlayersByFlag(List<Player> players, String position, int speed, boolean flag){
        List<Player> result = new ArrayList<>();
        // true 일때 : position으로 분류
        // false 일때 : speed로 분류
        for(Player player: players){
            if((flag && player.getPosition().equals(position)) || (!flag && player.getSpeed()<11)){
                result.add(player);
            }
        }
        return result;
    }

    // case 4
    private static List<Player> filterPlayers(List<Player> players, PlayerPredicator pre, String option){
        List<Player> result = new ArrayList<>();

        for(Player player : players){
            if(pre.check(player, option)){
                result.add(player);
            }
        }

        return result;
    }
}


