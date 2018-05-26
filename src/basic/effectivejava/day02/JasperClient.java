package basic.effectivejava.day02;

public class JasperClient {
    public static void main (String [] args){
        ExcelJasperReport excelReport = new ExcelJasperReport.Builder(ExcelJasperReport.Ext.XLS)
                .addDevice(JasperReport.Device.CPU)
                .addDevice(JasperReport.Device.MEMORY)
                .build();


    }
}
