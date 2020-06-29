package jalasoft.training.mcallejash.smarthouse.core.impl;

import io.jsondb.annotation.Document;
import jalasoft.training.mcallejash.smarthouse.core.BaseEntity;
import jalasoft.training.mcallejash.smarthouse.core.DeviceType;
import jalasoft.training.mcallejash.smarthouse.core.IDevice;

@Document(collection = "devices", schemaVersion = "1.0")
public class Device extends BaseEntity implements IDevice {
    private DeviceType deviceType;

    public Device(){
        super();
    }

    public DeviceType getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(DeviceType deviceType) {
        this.deviceType = deviceType;
    }

    @Override
    public void updateStatus(boolean value) {
        this.setOn(value);
    }

    @Override
    public String toString() {
        String isOnStr = "ON";
        if (!this.isOn()) isOnStr = "OFF";
        return String.format("%s:%s is turned %s", this.deviceType.toString(), this.getName(), isOnStr);
    }
}
