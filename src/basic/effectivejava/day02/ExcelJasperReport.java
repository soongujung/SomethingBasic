package basic.effectivejava.day02;

import java.util.Objects;

public class ExcelJasperReport extends JasperReport{

    public enum Ext {
        XLS, XLSX
    }

    private final Ext ext;

    public static class Builder extends JasperReport.Builder<Builder>{
        private final Ext ext;

        public Builder(Ext ext){
            this.ext = Objects.requireNonNull(ext);
        }

        @Override
        public ExcelJasperReport build() {
            return new ExcelJasperReport(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }

    private ExcelJasperReport(Builder builder){
        super(builder);
        ext = builder.ext;
    }

}
