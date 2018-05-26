package basic.effectivejava.day02;

import java.util.EnumSet;
import java.util.Objects;

public abstract class JasperReport {

    public enum Device {
        CPU, MEMORY, HDD
    }

    public EnumSet<Device> devices;

    abstract static class Builder<T extends Builder<T>> {
        EnumSet<Device> devices = EnumSet.noneOf(Device.class);

        public T addDevice(Device device){
            devices.add(Objects.requireNonNull(device));
            return self();
        }

        abstract JasperReport build();

        protected abstract T self();
    }

    JasperReport(Builder<?> builder){
        devices = builder.devices;
    }
}
