package jalasoft.training.mcallejash.smarthouse.core.impl;

import io.jsondb.annotation.Document;
import jalasoft.training.mcallejash.smarthouse.core.BaseEntity;
import jalasoft.training.mcallejash.smarthouse.core.IDevice;
import jalasoft.training.mcallejash.smarthouse.core.IManager;
import jalasoft.training.mcallejash.smarthouse.core.ManagerType;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "managers", schemaVersion = "1.0")
public class Manager extends BaseEntity implements IManager, IDevice {
    private ManagerType managerType;
    private List<Device> devices;

    public Manager() {
        this.devices = new ArrayList<Device>();
    }

    public List<Device> getDevices() {
        return devices;
    }

    public void setDevices(List<Device> devices) {
        this.devices = devices;
    }

    public ManagerType getManagerType() {
        return managerType;
    }

    public void setManagerType(ManagerType managerType) {
        this.managerType = managerType;
    }

    @Override
    public void linkDevice(Device device) {
        this.devices.add(device);
    }

    @Override
    public void unlinkDevice(Device device) {
        this.devices.remove(device);
    }

    @Override
    public void setDevicesStatuses(boolean value) {
        this.devices.forEach((device) -> {
            device.updateStatus(value);
        });
    }

    @Override
    public void updateStatus(boolean value) {
        this.setOn(value);
        this.setDevicesStatuses(value);
    }

    @Override
    public String toString() {
        String isOnStr = "ON";
        if (!this.isOn()) isOnStr = "OFF";

        String message = String.format("%s:%s manager is turned %s. It has %s linked devices",
                                        this.managerType.toString(), this.getName(), isOnStr, this.devices.size());
        if (this.devices.size() == 0) {
            message += ".";
        } else {
            message += "...\n";
            for (Device device : this.devices) {
                message += device.toString();
                message += "\n";
            }
        }
        return message;
    }
}
