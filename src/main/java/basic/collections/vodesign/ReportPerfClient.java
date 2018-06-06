package basic.collections.vodesign;

import basic.collections.vodesign.common.SetupInfoDeviceSet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReportPerfClient {

    public static List<Map<String, Object>> subTitleList = new ArrayList<>();
    public static List<Map<String, Object>> mapList = new ArrayList<>();

    public static void main(String [] args){
        makeTestData();
        SetupInfoDeviceSet setupSet = new SetupInfoDeviceSet();
        List<SetupInfoDeviceSet> setupList = setupSet.build(subTitleList, mapList).getList();
        List<String> deviceList = setupSet.getDeviceList();

        List<DevicePerformanceSet> devicePerfList;

        // 각 디바이스마다의 responseList, cpuList, memoryList등에 dao 결과를 꽂아줄 것

        // ex)
        // 스위치 객체
        //  CPU : cpuList
        //  RESP_TIME : respList

        for(String device: deviceList){
            // DeviceType 수정 필요.
            // 손코딩한 내용 반영
            // Type(enum)에 따라 밖에서 디바이스 객체를 꽂아 주고, 각 디바이스는 indicatorsMap을 세팅하도록
            // 디바이스 객체를 각각 따로 생성해서 다른 동작을 하도록 하기 위함.
            ////// 이 부분과 DeviceType.java의 buildPerformanceSet() 코드 재 수정 필요
            /// 1. 밖에서 각 디바이스의 XXXType.build( 디바이스객체, ..., dao객체) 하고
            /// 2.
//            DeviceType.valueOf(device).buildPerformanceSet()
        }
//        for(SetupInfoDeviceSet set : setupList){
//            String indicNM = set.getINDIC_NM();
////            String deviceType
//            switch (indicNM){
//                case "CPU":
//                    // mapperList = mapper.selectCpuTable();
//                    break;
//                case "RESP_TIME":
//                    // mapperList = mapper.selectMchTable();
//                    break;
//                case "SWAP":
//                    // mapperList = mapper.selectSwapTable();
//                    break;
//                case "DISK":
//                    // mapperList = mapper.selectDiskTable();
//                    break;
//                case "PROCS_CPU":
//                    // mapperList = mapper.selectMchTable();
//                    break;
//                case "PROCS_MEM":
//                    // mapperList = mapper.selectProcTable();
//
//                    break;
//            }
//        }
    }

    public static void makeTestData(){
        Map<String, Object> subTitleMap1 = new HashMap<>();
        subTitleMap1.put("DEVICE_TYPE_CD", "1");
        subTitleMap1.put("SUBTITLE", "라우터");

        Map<String, Object> subTitleMap2 = new HashMap<>();
        subTitleMap2.put("DEVICE_TYPE_CD", "2");
        subTitleMap2.put("SUBTITLE", "스위치");

        Map<String, Object> subTitleMap3 = new HashMap<>();
        subTitleMap3.put("DEVICE_TYPE_CD", "2");
        subTitleMap3.put("SUBTITLE", "스위치");

        Map<String, Object> subTitleMap4 = new HashMap<>();
        subTitleMap4.put("DEVICE_TYPE_CD", "2");
        subTitleMap4.put("SUBTITLE", "스위치");

        Map<String, Object> subTitleMap5 = new HashMap<>();
        subTitleMap5.put("DEVICE_TYPE_CD", "2");
        subTitleMap5.put("SUBTITLE", "스위치");

        Map<String, Object> subTitleMap6 = new HashMap<>();
        subTitleMap6.put("DEVICE_TYPE_CD", "2");
        subTitleMap6.put("SUBTITLE", "스위치");

        subTitleList.add(subTitleMap1);
        subTitleList.add(subTitleMap2);
        subTitleList.add(subTitleMap3);
        subTitleList.add(subTitleMap4);
        subTitleList.add(subTitleMap5);
        subTitleList.add(subTitleMap6);

        Map<String, Object> setupMap1 = new HashMap<>();
        setupMap1.put("DEVICE_TYPE_CD", "2");
        setupMap1.put("INDIC_NM", "CPU");
        setupMap1.put("CHECK_YN", "Y");

        Map<String, Object> setupMap2 = new HashMap<>();
        setupMap2.put("DEVICE_TYPE_CD", "2");
        setupMap2.put("INDIC_NM", "RESP_TIME");
        setupMap2.put("CHECK_YN", "Y");

        Map<String, Object> setupMap3 = new HashMap<>();
        setupMap3.put("DEVICE_TYPE_CD", "5");
        setupMap3.put("INDIC_NM", "CPU");
        setupMap3.put("CHECK_YN", "Y");

        Map<String, Object> setupMap4 = new HashMap<>();
        setupMap4.put("DEVICE_TYPE_CD", "5");
        setupMap4.put("INDIC_NM", "RESP_TIME");
        setupMap4.put("CHECK_YN", "Y");

        Map<String, Object> setupMap5 = new HashMap<>();
        setupMap5.put("DEVICE_TYPE_CD", "5");
        setupMap5.put("INDIC_NM", "SWAP");
        setupMap5.put("CHECK_YN", "Y");

        Map<String, Object> setupMap6 = new HashMap<>();
        setupMap6.put("DEVICE_TYPE_CD", "5");
        setupMap6.put("INDIC_NM", "DISK");
        setupMap6.put("CHECK_YN", "Y");

        Map<String, Object> setupMap7 = new HashMap<>();
        setupMap7.put("DEVICE_TYPE_CD", "5");
        setupMap7.put("INDIC_NM", "PROCS_CPU");
        setupMap7.put("CHECK_YN", "Y");

        Map<String, Object> setupMap8 = new HashMap<>();
        setupMap8.put("DEVICE_TYPE_CD", "5");
        setupMap8.put("INDIC_NM", "PROCS_MEM");
        setupMap8.put("CHECK_YN", "Y");

        mapList.add(setupMap1);
        mapList.add(setupMap2);
        mapList.add(setupMap3);
        mapList.add(setupMap4);
        mapList.add(setupMap5);
        mapList.add(setupMap6);
        mapList.add(setupMap7);
        mapList.add(setupMap8);
    }
}
