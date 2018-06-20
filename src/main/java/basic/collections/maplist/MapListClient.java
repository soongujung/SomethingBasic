package basic.collections.maplist;

import java.util.*;

public class MapListClient {
    public static void main(String [] args){
        List<Map<String,Object>> resultList = new ArrayList<>();
        Map<String,Object> map1 = new HashMap<>();
        Map<String,Object> map2 = new HashMap<>();
        Map<String,Object> map3 = new HashMap<>();
        Map<String,Object> map4 = new HashMap<>();

        map1.put("최대", 1);
        map1.put("평균", 0.5);
        map1.put("id", "A0001");

        map2.put("최대", 3);
        map2.put("평균", 2);
        map2.put("id", "A0002");

        map3.put("최대", 4);
        map3.put("평균", 3);
        map3.put("id", "A0003");

        map4.put("최대", 10);
        map4.put("평균", 5);
        map4.put("id", "A0004");

        resultList.add(map1);
        resultList.add(map2);
        resultList.add(map3);
        resultList.add(map4);

        System.out.println("======== mapList org  ==========");
        for(Map<String,Object> dataMap : resultList){
            System.out.println(dataMap.toString());
        }

        System.out.println();
        System.out.println("======== mapList range ==========");
        Object [] inputArr = resultList.toArray();
        Object [] testObjArr = Arrays.copyOfRange(inputArr, 2,4);


        for(Object testObj : testObjArr){
            Map<String,?> dataMap = (Map<String,?>)testObj;
            System.out.println(testObj.toString());
        }

    }
}
