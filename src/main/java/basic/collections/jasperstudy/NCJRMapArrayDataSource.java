package basic.collections.jasperstudy;

import java.util.Arrays;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;
import net.sf.jasperreports.engine.JRRewindableDataSource;
import net.sf.jasperreports.engine.data.JRMapArrayDataSource;

public class NCJRMapArrayDataSource implements JRRewindableDataSource{
    private Object[] records;
    private int index = -1;

    public NCJRMapArrayDataSource(Object[] array)
    {
        records = array;
    }

    @Override
    public boolean next() throws JRException {
        index++;

        if (records != null)
        {
            return (index < records.length);
        }

        return false;
    }

    @Override
    public Object getFieldValue(JRField field) throws JRException {
        Object value = null;

        Map<String,?> currentRecord = (Map<String,?>)records[index];

        if (currentRecord != null)
        {
            value = currentRecord.get(field.getName());
        }

        return value;
    }

    @Override
    public void moveFirst() throws JRException {
        this.index = -1;
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

//		int nextIndicIndex = 0;
        int startIndex = 0;
        int endIndex = 0;
        boolean find = false;

        for(int i=0; i<records.length; i++){

            Map<String, ?> currentRecord = (Map<String, ?>)records[i];

            if ( find==false && currentRecord.get("INDIC_NM").toString().equals(indicNM) ){
                startIndex = i;
                endIndex = startIndex;
                find = true;
            }
            if ( find ){
                if(!currentRecord.get("INDIC_NM").toString().equals(indicNM)){
//					nextIndicIndex = i;
                    endIndex = i;
                    find = false;
                    break;
                }
//				endIndex++;
            }
        }

        return Arrays.copyOfRange(records, startIndex, endIndex);
        // https://docs.oracle.com/javase/7/docs/api/java/util/Arrays.html
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
}
