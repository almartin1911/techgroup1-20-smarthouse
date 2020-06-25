package jalasoft.training.mcallejash.smarthouse.core;

import java.util.List;

public abstract class BaseManager extends BaseEntity implements IManager{
    List<IDevice> linkedDevices;

    protected BaseManager(String name, boolean powered) {
        super(name, powered);
    }

    @Override
    public void linkDevice(IDevice device) {
        this.linkedDevices.add(device);
    }

    @Override
    public void unlinkDevice(IDevice device){
        this.linkedDevices.remove(device);
    }

    @Override
    public void power(boolean value) {
        this.linkedDevices.forEach((device) -> {
            device.updateState(value);
        });
    }

}
