package basic.collections.vodesign;

import basic.collections.vodesign.dao.SampleMapper;

import java.util.HashMap;
import java.util.Map;

public enum DeviceType {
    SWITCH(1, "Switch"){
        public DevicePerformanceSet initPerformanceSet(DevicePerformanceSet performanceSet){
            performanceSet.setIndicatorsMap(new HashMap<>());
            performanceSet.getIndicatorsMap().put("CPU", null);
            performanceSet.getIndicatorsMap().put("RESP_TIME", null);
            return performanceSet;
        }

        public DevicePerformanceSet buildPerformanceSet(DevicePerformanceSet perfSet, String deviceTypeName, Map<String,Object> parameterMap, SampleMapper mapper){
//            parameterMap settings..
            perfSet.getIndicatorsMap().put(getDeviceTypeName() ,mapper.selectCpuTable());
            perfSet.getIndicatorsMap().put(getDeviceTypeName() ,mapper.selectCpuTable());
            return null;
        }
    },
    L4(2, "L4"){
        public DevicePerformanceSet initPerformanceSet(DevicePerformanceSet performanceSet){
            performanceSet.setIndicatorsMap(new HashMap<>());
            performanceSet.getIndicatorsMap().put("CPU", null);
            performanceSet.getIndicatorsMap().put("RESP_TIME", null);
            performanceSet.getIndicatorsMap().put("SWAP", null);
            //etc
            return performanceSet;
        }

        public DevicePerformanceSet buildPerformanceSet(DevicePerformanceSet perfSet, String deviceTypeName, Map<String,Object> parameterMap, SampleMapper mapper){
            return null;
        }
    },
    SERVER(3, "Server"){
        public DevicePerformanceSet initPerformanceSet(DevicePerformanceSet performanceSet){
            performanceSet.setIndicatorsMap(new HashMap<>());
            performanceSet.getIndicatorsMap().put("CPU", null);
            performanceSet.getIndicatorsMap().put("RESP_TIME", null);
            performanceSet.getIndicatorsMap().put("SWAP", null);
            performanceSet.getIndicatorsMap().put("DISK", null);
            performanceSet.getIndicatorsMap().put("PROCS_CPU", null);
            performanceSet.getIndicatorsMap().put("PROCS_MEM", null);
            return performanceSet;
        }

        public DevicePerformanceSet buildPerformanceSet(DevicePerformanceSet perfSet, String deviceTypeName, Map<String,Object> parameterMap, SampleMapper mapper){
            return null;
        }
    };

    private String deviceTypeName;
    private int deviceTypeCode;
    private static Map<Integer, DeviceType> typeMap = new HashMap<>();

    DeviceType(int deviceTypeCode, String deviceTypeName){
        this.deviceTypeCode = deviceTypeCode;
        this.deviceTypeName = deviceTypeName;
    }

    static{
        for(DeviceType deviceType : DeviceType.values()){
            typeMap.put(deviceType.getDeviceTypeCode(), deviceType);
        }
    }

    public static DeviceType valueOf(int deviceTypeCd){
        return (DeviceType)typeMap.get(deviceTypeCd);
    }

    public String getDeviceTypeName(){
        return this.deviceTypeName;
    }
    public void setDeviceTypeName(String deviceTypeName){
        this.deviceTypeName = deviceTypeName;
    }

    public int getDeviceTypeCode(){
        return this.deviceTypeCode;
    }
    public void setDeviceTypeCode(int deviceTypeCode){
        this.deviceTypeCode = deviceTypeCode;
    }

    public abstract DevicePerformanceSet initPerformanceSet(DevicePerformanceSet performanceSet);
    public abstract DevicePerformanceSet buildPerformanceSet(DevicePerformanceSet perfSet, String deviceTypeName, Map<String,Object> parameterMap, SampleMapper mapper);

//    public DevicePerformanceSet buildPerformanceSet(String deviceTypeName){
//
//        return null;
//    }
}
