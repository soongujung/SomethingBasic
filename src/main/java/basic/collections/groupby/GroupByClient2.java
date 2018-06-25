package basic.collections.groupby;

import java.util.*;
import java.util.stream.Collectors;

public class GroupByClient2 {
    public static void main(String [] args){
        List<Map<String, Object>> mapList = new ArrayList<>();

        Map<String,Object> map1 = new HashMap<>();
        map1.put("국어", 98);
        map1.put("수학", 98);
        map1.put("영어", 98);
        map1.put("이름", "김윤석1");

        Map<String,Object> map2 = new HashMap<>();
        map2.put("국어", 99);
        map2.put("수학", 99);
        map2.put("영어", 99);
        map2.put("이름", "김윤석2");

        Map<String,Object> map3 = new HashMap<>();
        map3.put("국어", 100);
        map3.put("수학", 100);
        map3.put("영어", 100);
        map3.put("이름", "김윤석3");

        mapList.add(map1);
        mapList.add(map2);
        mapList.add(map3);

//        Map<String, List<Student>> result = studentList.stream().collect(Collectors.groupingBy(Student::getDept));
//        mapList.stream().collect(
//                Collectors.groupingBy(map->map.get("과목")), Collectors::toCollection(ArrayList::new));
        System.out.println("asdfasd");
    }
}
