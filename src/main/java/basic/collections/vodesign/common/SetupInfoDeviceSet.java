package basic.collections.vodesign.common;

import basic.collections.vodesign.DevicePerformanceSet;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SetupInfoDeviceSet {
    private String DEVICE_TYPE;
    private String DEVICE_TYPE_CD;
    private String INDIC_NM;
    private String CHECK_YN;
    private String PERF_TYPE;
    private List<SetupInfoDeviceSet> setupInfoList = null;
    private Map<String,SetupInfoDeviceSet> deviceMap = null;

    public SetupInfoDeviceSet(){
        setupInfoList = new ArrayList<>();
    }

    public SetupInfoDeviceSet build(List<Map<String, Object>> subTitleList, List<Map<String, Object>> mapList){
        for(int i=0; i<subTitleList.size(); i++){
            for(int j=0; j<mapList.size(); j++){
                Map<String, Object> setupItem = mapList.get(j);

                Map<String, Object> subTitleMap = subTitleList.get(i);
                String deviceTypeCd = setupItem.get("DEVICE_TYPE_CD").toString();
                String checkYN = setupItem.get("CHECK_YN").toString();
                String indicNM = setupItem.get("INDIC_NM").toString();
                String deviceType = setupItem.get("DEVICE_TYPE_CD").toString();
                String perfType = setupItem.get("INDIC_NM").toString();
                //parameterMap.put("PERF_TYPE", setupItem.get("INDIC_NM"));

                if( subTitleMap.get("DEVICE_TYPE_CD").toString().equals(deviceTypeCd) &&
                    checkYN.equals("Y") ){
                    SetupInfoDeviceSet set = new SetupInfoDeviceSet();
                    set.setCHECK_YN(checkYN);
                    set.setDEVICE_TYPE_CD(deviceTypeCd);
                    set.setINDIC_NM(indicNM);
                    set.setDEVICE_TYPE(deviceType);
                    set.setPERF_TYPE(perfType);

                    setupInfoList.add(set);
                }
            }
        }
        return this;
    }

    public List<String> getDeviceList(){
        String deviceTypeName;
        List<String> deviceList = new ArrayList<>();
        deviceList.add(setupInfoList.get(0).getDEVICE_TYPE());
        for(int i=0; i<setupInfoList.size(); i++){
            deviceTypeName = setupInfoList.get(i).getDEVICE_TYPE();
            if(i<setupInfoList.size()-1){
                String nextDeviceName = setupInfoList.get(i+1).getDEVICE_TYPE();
                if(!deviceTypeName.equals(nextDeviceName)){
                    deviceList.add(nextDeviceName);
                }
            }
        }
//
//        for(SetupInfoDeviceSet set : this.setupInfoList){
//            if(deviceTypeName.equals(set.getDEVICE_TYPE())){
//
//            }
//
//        }
        return null;
    }

//    public List<DevicePerformanceSet> buildDeviceList(){
//
//    }

    public String getDEVICE_TYPE() {
        return DEVICE_TYPE;
    }

    public void setDEVICE_TYPE(String DEVICE_TYPE) {
        this.DEVICE_TYPE = DEVICE_TYPE;
    }

    public String getDEVICE_TYPE_CD() {
        return DEVICE_TYPE_CD;
    }

    public void setDEVICE_TYPE_CD(String DEVICE_TYPE_CD) {
        this.DEVICE_TYPE_CD = DEVICE_TYPE_CD;
    }

    public String getINDIC_NM() {
        return INDIC_NM;
    }

    public void setINDIC_NM(String INDIC_NM) {
        this.INDIC_NM = INDIC_NM;
    }

    public String getCHECK_YN() {
        return CHECK_YN;
    }

    public void setCHECK_YN(String CHECK_YN) {
        this.CHECK_YN = CHECK_YN;
    }

    public List<SetupInfoDeviceSet> getList() {
        return setupInfoList;
    }

    public void setList(List<SetupInfoDeviceSet> list) {
        this.setupInfoList = list;
    }

    public String getPERF_TYPE() {
        return PERF_TYPE;
    }

    public void setPERF_TYPE(String PERF_TYPE) {
        this.PERF_TYPE = PERF_TYPE;
    }
}
