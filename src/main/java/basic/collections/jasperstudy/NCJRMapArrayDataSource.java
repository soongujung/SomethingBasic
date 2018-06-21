package basic.collections.jasperstudy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;
import net.sf.jasperreports.engine.JRRewindableDataSource;
import net.sf.jasperreports.engine.data.JRMapArrayDataSource;

public class NCJRMapArrayDataSource implements JRRewindableDataSource {

    private Object[] records;
    private int index = -1;

    /**
     *
     * getData()를 오버로딩한다고 해결되는게 아니었다.
     * getFieldValue, moveFirst를 해결해야 한다....
     * getData(String)내부에서도 자료를 수정하는 작업이 필요하다.
     * Map<?,?> 등의 자료를 필요에 따라 멤버필드로 선언하자.
     *
     * */
    private String indicNM = "";
    private String deviceName = "";
    private Map<String, Object> dataMap = null;
    private Map<String, Integer> indexMap = null;

    public NCJRMapArrayDataSource(Object[] array)
    {
        records = array;
        dataMap = new HashMap<>();
        indexMap = new HashMap<>();
    }

    public NCJRMapArrayDataSource(Object[] array, String deviceName){
        records = array;
        dataMap = new HashMap<>();
        indexMap = new HashMap<>();
        this.deviceName = deviceName;

        int startIndex = 0;
        int endIndex = 0;
        boolean find = false;

        if(deviceName != null && !deviceName.equals("")){
            String currIndicNM = "";
            String nextIndicNM = "";

            for(int i=0; i<records.length; i++){
                Map<String,?> currentRecord = (Map<String, ?>)records[i];
                currIndicNM = currentRecord.get("INDIC_NM").toString();
                if(i<records.length-1){
                    nextIndicNM = ((Map<String,?>)records[i+1]).get("INDIC_NM").toString();
                    if(!nextIndicNM.equalsIgnoreCase(currIndicNM)){
                        find = true;
                        endIndex = i+1;
                        dataMap.put(currIndicNM, Arrays.copyOfRange(records, startIndex, endIndex));
                        startIndex = endIndex;
                    }
                }
                else{ // 가장 마지막 요소이고, 이전 인덱스와 값이 다른 경우는 insert
                    String prevIndicNM = ((Map<String,?>)records[i-1]).get("INDIC_NM").toString();
                    if(!currIndicNM.equalsIgnoreCase(prevIndicNM)){
                        endIndex = i+1;
                        dataMap.put(currIndicNM, Arrays.copyOfRange(records, i, endIndex));
                    }
                }
            }
        }
//		if(indicNM!=null && !indicNM.equals("") &&!dataMap.containsKey(indicNM)){
//			indexMap.put(indicNM, -1);
//			for(int i=0; i<records.length; i++){
//
//				Map<String, ?> currentRecord = (Map<String, ?>)records[i];
//
//				if ( find==false && currentRecord.get("INDIC_NM").toString().equals(indicNM) ){
//					startIndex = i;
//					endIndex = startIndex;
//					find = true;
//				}
//				if ( find ){
//					if(!currentRecord.get("INDIC_NM").toString().equals(indicNM)){
//						endIndex = i;
//						find = false;
//						break;
//					}
//				}
//			}
//			dataMap.put(indicNM, Arrays.copyOfRange(records, startIndex, endIndex)); // dataMap 값 찍어보기
//		}
    }

    public NCJRMapArrayDataSource(Object [] array, String deviceName, String indicNM){

    }

    @Override
    public boolean next() throws JRException {
        if(!indicNM.equals("")&&indicNM!=null){
            // TODO
            Object[] objArr = (Object [])dataMap.get(indicNM);

            // 각 지표마다의 index 관리 어떻게 ?
            int indicIndex = indexMap.get(indicNM);
            indicIndex++;
            indexMap.put(indicNM, indicIndex);

            if(objArr != null){
                return (indicIndex < objArr.length);
            }
            return false;
        }
//        else if(!deviceName.equals("")&&deviceName!=null){
//            Object[] objArr = (Object [])dataMap.get(indicNM);
//
//            //////////////////////////////////////
//            int indicIndex = indexMap.get(indicNM);
//            indicIndex++;
//            //////////////////////////////////////
//
//            indexMap.put(indicNM, indicIndex);
//
//            if(objArr != null){
//                return (indicIndex < objArr.length);
//            }
//            return false;
//        }
        else{
            index++;

            if (records != null)
            {
                return (index < records.length);
            }
            return false;
        }
    }

    @Override
    public Object getFieldValue(JRField field) throws JRException {
        Object value = null;

        if(!indicNM.equals("") || indicNM != null ){
//			Map<String,?> currentRecord = (Map<String,?>)dataMap.get(indicNM);
            Object[] objArr = (Object[])dataMap.get(indicNM);
            Map<String,?> currentRecord = (Map<String,?>)objArr[indexMap.get(indicNM)];

            if (currentRecord != null){
                value = currentRecord.get(field.getName());
            }
        }
        else{
            Map<String,?> currentRecord = (Map<String,?>)records[index];

            if (currentRecord != null)
            {
                value = currentRecord.get(field.getName());
            }
        }

        return value;
    }

    @Override
    public void moveFirst() throws JRException {
        if(!indicNM.equals("") || indicNM != null ){
            this.indexMap.put(indicNM, -1);
        }
        else{
            this.index = -1;
        }
    }

    /**
     * Returns the underlying map array used by this data source.
     *
     * @return the underlying map array
     */
    public Object[] getData()
    {
        return records;
    }

    /**
     * DB DATA(즉, records에 저장된 데이터) example :
     * { INDIC_NM : 'CPU', PERF_MAX: 0.XXXX, PERF_MXA: 0.XXXX, rnum: 1, .....},
     * { INDIC_NM : 'CPU', PERF_MAX: 0.XXXX, PERF_MXA: 0.XXXX, rnum: 2, .....},
     * { INDIC_NM : 'CPU', PERF_MAX: 0.XXXX, PERF_MXA: 0.XXXX, rnum: 3, .....},
     * 		...
     * { INDIC_NM : 'CPU', PERF_MAX: 0.XXXX, PERF_MXA: 0.XXXX, rnum: n, .....}
     *
     * input 	: 지표 이름
     * output 	: 특정 구간대의 데이터
     *
     * ex) indicNM이 CPU일 경우
     * 		CPU(1), 	CPU(2), ...... 	,CPU(n)
     * 		MEMORY(1), 	MEMORY(2), ... 	,MEMORY(n)
     */
    public Object[] getData(String indicNM){
        int startIndex = 0;
        int endIndex = 0;
        boolean find = false;
        this.indicNM = indicNM;

        if(indicNM!=null && !indicNM.equals("") &&!dataMap.containsKey(indicNM)){
            indexMap.put(indicNM, -1);
            for(int i=0; i<records.length; i++){

                Map<String, ?> currentRecord = (Map<String, ?>)records[i];

                if ( find==false && currentRecord.get("INDIC_NM").toString().equals(indicNM) ){
                    startIndex = i;
                    endIndex = startIndex;
                    find = true;
                }
                if ( find ){
                    if(!currentRecord.get("INDIC_NM").toString().equals(indicNM)){
                        endIndex = i;
                        find = false;
                        break;
                    }
                }
            }
            dataMap.put(indicNM, Arrays.copyOfRange(records, startIndex, endIndex)); // dataMap 값 찍어보기
        }
        return records;
    }

    /**
     * Returns the total number of records/maps that this data source
     * contains.
     *
     * @return the total number of records of this data source
     */
    public int getRecordCount()
    {
        return records == null ? 0 : records.length;
    }

    /**
     * Clones this data source by creating a new instance that reuses the same
     * underlying map array.
     *
     * @return a clone of this data source
     */
    public NCJRMapArrayDataSource cloneDataSource()
    {
        return new NCJRMapArrayDataSource(records);
    }

    public NCJRMapArrayDataSource cloneDataSource(String indicNM){
        Object[] resultArr = (Object [])dataMap.get(indicNM);
        return new NCJRMapArrayDataSource(resultArr);
    }

}
