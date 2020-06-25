package jalasoft.training.mcallejash.smarthouse.core;

import java.util.LinkedList;

public class SmartphoneManager extends BaseManager implements IDevice {
    private float appVersion;
    private float minimumAppVersion = (float) 3.1;

    public SmartphoneManager(String name, float appVersion) {
        super(name, false);
        this.linkedDevices = new LinkedList<IDevice>();
        this.appVersion = appVersion;
    }

    @Override
    public void updateState(boolean value) {
        if (this.appVersion >= this.minimumAppVersion) {
            this.setPowered(value);
            System.out.println(this);
            this.linkedDevices.forEach((device) -> {
                device.updateState(value);
            });
        } else {
            System.out.println("Non-compatible app version. Please upgrade.");
        }

    }

    @Override
    public String toString() {
        if (this.isPowered() && linkedDevices.size() > 0) {
            return (this.getName() + " AppVersion" + this.appVersion + " event detected. Notifying devices...");
        }
        return "";
    }
}
