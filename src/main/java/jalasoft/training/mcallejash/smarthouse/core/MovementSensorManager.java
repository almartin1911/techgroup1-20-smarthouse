package jalasoft.training.mcallejash.smarthouse.core;

import java.util.ArrayList;

public class MovementSensorManager extends BaseManager implements IDevice {

    public MovementSensorManager(String name) {
        super(name, false);
        this.linkedDevices = new ArrayList<IDevice>();
    }

    @Override
    public void updateState(boolean value) {
        this.setPowered(value);
        System.out.println(this);
        this.linkedDevices.forEach((device -> {
            device.updateState(value);
        }));
    }

    @Override
    public String toString() {
        if (this.isPowered() && linkedDevices.size() > 0) {
            return (this.getName() + " detected movement. Notifying devices...");
        }
        return "";
    }
}
