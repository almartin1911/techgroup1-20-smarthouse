package jalasoft.training.mcallejash.smarthouse.core;

public enum DeviceType {
    Lightbulb (1),
    Speaker (2),
    TV (3),
    Curtain (4);

    private final int deviceTypeCode;

    private DeviceType(int deviceTypeCode) {
        this.deviceTypeCode = deviceTypeCode;
    }

}
