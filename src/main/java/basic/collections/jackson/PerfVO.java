package basic.collections.jackson;

public class PerfVO {
    private double PERF_MAX;
    private int rnum;
    private String MCH_IP;

    public double getPERF_MAX() {
        return PERF_MAX;
    }

    public void setPERF_MAX(double PERF_MAX) {
        this.PERF_MAX = PERF_MAX;
    }

    public int getRnum() {
        return rnum;
    }

    public void setRnum(int rnum) {
        this.rnum = rnum;
    }

    public String getMCH_IP() {
        return MCH_IP;
    }

    public void setMCH_IP(String MCH_IP) {
        this.MCH_IP = MCH_IP;
    }

    @Override
    public String toString() {
        return "PerfVO{" +
                "PERF_MAX=" + PERF_MAX +
                ", rnum=" + rnum +
                ", MCH_IP='" + MCH_IP + '\'' +
                '}';
    }
}
