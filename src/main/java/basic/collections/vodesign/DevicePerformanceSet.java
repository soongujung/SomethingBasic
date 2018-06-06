package basic.collections.vodesign;

import java.util.List;
import java.util.Map;

public class DevicePerformanceSet {

    Map<String, List<Map<String, Object>>> indicatorsMap = null;

    private String indicatorType;
    private String deviceTypeName;

    public DevicePerformanceSet(String deviceTypeName){
        this.deviceTypeName = deviceTypeName;
    }

    public Map<String, List<Map<String, Object>>> getIndicatorsMap() {
        return indicatorsMap;
    }

    public void setIndicatorsMap(Map<String, List<Map<String, Object>>> indicatorsMap) {
        this.indicatorsMap = indicatorsMap;
    }

    public String getIndicatorType() {
        return indicatorType;
    }

    public void setIndicatorType(String indicatorType) {
        this.indicatorType = indicatorType;
    }

    public String getDeviceTypeName() {
        return deviceTypeName;
    }

    public void setDeviceTypeName(String deviceTypeName) {
        this.deviceTypeName = deviceTypeName;
    }
}
