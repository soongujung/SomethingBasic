package basic.collections.jackson;

import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JacksonMapClient {
    public static void main(String [] args){
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("PERF_MAX", 11.1);
        resultMap.put("rnum", 1);
        resultMap.put("MCH_IP", "10.1.30.21");

        Map<String, Object> resultMap2 = new HashMap<>();
        resultMap2.put("PERF_MAX", 11.2);
        resultMap2.put("rnum", 2);
        resultMap2.put("MCH_IP", "10.1.30.22");

        Map<String, Object> resultMap3 = new HashMap<>();
        resultMap3.put("PERF_MAX", 11.3);
        resultMap3.put("rnum", 3);
        resultMap3.put("MCH_IP", "10.1.30.23");

        List<Map<String, Object>> fetchedList = new ArrayList<>();
        fetchedList.add(resultMap);
        fetchedList.add(resultMap2);
        fetchedList.add(resultMap3);

        Map<String, Object> resultMap4 = new HashMap<>();
        resultMap4.put("PERF_MAX", 11.4);
        resultMap4.put("rnum", 4);
        resultMap4.put("MCH_IP", "10.1.30.24");

        Map<String, Object> resultMap5 = new HashMap<>();
        resultMap5.put("PERF_MAX", 11.5);
        resultMap5.put("rnum", 5);
        resultMap5.put("MCH_IP", "10.1.30.25");

        Map<String, Object> resultMap6 = new HashMap<>();
        resultMap6.put("PERF_MAX", 11.6);
        resultMap6.put("rnum", 6);
        resultMap6.put("MCH_IP", "10.1.30.26");

        List<Map<String, Object>> fetchedList2 = new ArrayList<>();
        fetchedList.add(resultMap4);
        fetchedList.add(resultMap5);
        fetchedList.add(resultMap6);


        List<List<Map<String,Object>>> fetchedSet = new ArrayList<>();
        fetchedSet.add(fetchedList);
        fetchedSet.add(fetchedList2);

        List<PerfVO> voList = new ArrayList<>();

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
        for(List<Map<String, Object>> item : fetchedSet){
            for(Map<String, Object> map : item){
                PerfVO perfVO = mapper.convertValue(map, PerfVO.class);
                voList.add(perfVO);
            }

        }

        for(PerfVO resultVO : voList){
            System.out.println(resultVO.toString());
        }

    }
}










