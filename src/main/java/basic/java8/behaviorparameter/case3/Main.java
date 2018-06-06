package basic.java8.behaviorparameter.case3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    // Case 3 :
    // Case 2 대한 추가 요구사항
    // filterPlayersByPosition, filterPlayersBySpeed 메서드를 하나로 합쳐보고 싶었다.
    // Case2의 메서드를 자세히 살펴보면 filterPlayersByPosition, filterPlayersBySpeed 함수 내부의 if~else문이 대부분 중복되는 것을 확인할 수 있따.
    // 여기서는 filterPlayersByPosition, filterPlayersBySpeed 메서드를 하나의 메서드, boolean flag로 분기하여 처리하는 모습을 보인다.
    // flag를 이용해 하나로 합쳤는데, 이러한 코드는 지양해야 한다.

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
        List<Player> players1 = filterPlayers(players, "midfielder", 11, true);
        // 2) speed 로 분류
        List<Player> players2 = filterPlayers(players, "midfielder", 11, false);

        int cnt = 0;
        // players1 출력
        System.out.println("======== players 1 ========== ");
        for(Player player : players1){
            System.out.println(String.valueOf(++cnt) + ". " + player.getName() + ", position :: " + player.getPosition());
        }
        System.out.println();

        cnt = 0;
        System.out.println("======== players 2 ========== ");
        for(Player player : players2){
            System.out.println(String.valueOf(++cnt) + ". " + player.getName() + ", position :: " + player.getPosition());
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
        List<Player> result = new ArrayList<Player>();
        for(Player player : players){
            if(player.getSpeed() <= speed){
                result.add(player);
            }
        }
        return result;
    }

    // case 3
    public static List<Player> filterPlayers(List<Player> players, String position, int speed, boolean flag){
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
}


