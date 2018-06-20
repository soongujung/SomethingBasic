package basic.collections.maplist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapListMergeClient {
    public static void main(String [] args){
        List<Map<String,Object>> mergedList = new ArrayList<>();
        List<Map<String,Object>> resultList1 = new ArrayList<>();

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

        resultList1.add(map1);
        resultList1.add(map2);
        resultList1.add(map3);
        resultList1.add(map4);

        mergedList.addAll(resultList1);

        List<Map<String,Object>> resultList2 = new ArrayList<>();
        Map<String,Object> map5 = new HashMap<>();
        Map<String,Object> map6 = new HashMap<>();
        Map<String,Object> map7 = new HashMap<>();
        Map<String,Object> map8 = new HashMap<>();

        map5.put("최대", 1);
        map5.put("평균", 0.5);
        map5.put("id", "A0005");

        map6.put("최대", 3);
        map6.put("평균", 2);
        map6.put("id", "A0006");

        map7.put("최대", 4);
        map7.put("평균", 3);
        map7.put("id", "A0007");

        map8.put("최대", 10);
        map8.put("평균", 5);
        map8.put("id", "A0008");

        resultList2.add(map5);
        resultList2.add(map6);
        resultList2.add(map7);
        resultList2.add(map8);

        mergedList.addAll(resultList2);

        for(Map<String, Object> dataMap : mergedList){
            System.out.println(dataMap.toString());
        }

    }
}
