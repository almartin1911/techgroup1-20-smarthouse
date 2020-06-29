package jalasoft.training.mcallejash.smarthouse.core;

import jalasoft.training.mcallejash.smarthouse.core.impl.Device;

public interface IManager{
    void linkDevice(Device device);
    void unlinkDevice(Device device);
    void setDevicesStatuses(boolean value);
}
