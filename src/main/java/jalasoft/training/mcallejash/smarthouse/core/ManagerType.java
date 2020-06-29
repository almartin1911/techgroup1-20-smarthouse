package jalasoft.training.mcallejash.smarthouse.core;

public enum ManagerType {
    Sensor(1),
    Smartphone(2);

    private final int managerTypeCode;

    private ManagerType(int managerTypeCode) {
        this.managerTypeCode = managerTypeCode;
    }
}
