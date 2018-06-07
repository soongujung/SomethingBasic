package basic.collections.vodesign;

import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MergedMapClient {
    public static void main(String [] args){
        DevicePerformanceSet setVO = new DevicePerformanceSet("SWITCH");
        List<Map<String, Object>> totalList = new ArrayList<>();

        Map<Integer, MergetTestVO> orderMap= new HashMap<>();
        int order = 0;
        Map<String, Object> testMap1 = new HashMap<>();
        testMap1.put("A", "AAA");
        testMap1.put("B", "BBB");
        testMap1.put("C", "CCC");
        testMap1.put("D", "DDD");
        orderMap.put(order, null);
        totalList.add(testMap1);
        order++;

        Map<String, Object> testMap2 = new HashMap<>();
        testMap2.put("A", "111");
        testMap2.put("B", "222");
        testMap2.put("C", "333");
        testMap2.put("D", "444");
        orderMap.put(order, null);
        order++;
        totalList.add(testMap2);

        List<MergetTestVO> voList = new ArrayList<>();
        Map<String,List<MergetTestVO>> voListMap = new HashMap<>();

        List<Integer> iList = new ArrayList<>();

        int i=0;
        for(Map<String, Object> merged : totalList){
            final ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
            MergetTestVO mergetTestVO = objectMapper.convertValue(merged, MergetTestVO.class);
            voList.add(mergetTestVO);
//            iList.add(i);
            orderMap.put(i, mergetTestVO);
            i++;
        }

        for(MergetTestVO vo : voList){
            System.out.println(vo.toString());
        }

        Map<String, Object> jasperParameterMap = new HashMap<>();
        for(int key : orderMap.keySet()){
            System.out.println("<k,v> :: " + String.valueOf(key) + "," + orderMap.get(key) );
            // jasperParameterMap.put("device"+orderMap.get(i).getDeviceName()+orderMap.getINDIC_NM() ,orderMap.get(i))
        }
    }
}
